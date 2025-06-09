package com.deepkverma.search

import com.deepkverma.core.data.repository.TestNetworkRepository
import com.deepkverma.core.viewmodel.UiState
import com.deepkverma.domain.usecase.GetSearchNewsUseCase
import com.deepkverma.search.viewmodel.SearchViewModel
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.Dispatcher
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test


class SearchViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun test_viewmodel_init_state() = runTest {
        val testNewsRepo = TestNetworkRepository()
        val searchUserCase = GetSearchNewsUseCase(testNewsRepo)
        val viewmodelTest = SearchViewModel(searchUserCase)

        viewmodelTest.searchNews("Top Headlines")

        assertTrue(viewmodelTest.uiState.value is UiState.Loading)

        advanceTimeBy(600) // to by pass debounce
        advanceUntilIdle()//start the emit flow
        val state = viewmodelTest.uiState.value

        println("UI state: ${viewmodelTest.uiState.value}")

        assertTrue(viewmodelTest.uiState.value is UiState.Success)

    }

    @Test
    fun test_viewmodel_init_state_V1() = runTest {
        val testNewsRepo = TestNetworkRepository()
        val searchUserCase = GetSearchNewsUseCase(testNewsRepo)
        val viewmodelTest = SearchViewModel(searchUserCase)

        viewmodelTest.searchNews("Top Headline")

        // Give time for debounce (300ms) to process
        advanceTimeBy(400)  // Important for debounce to emit
        advanceUntilIdle()  // Ensures all coroutines complete

        val state = viewmodelTest.uiState.value
        println("UI state: $state")

        assertTrue(state is UiState.Success)
    }
    }
