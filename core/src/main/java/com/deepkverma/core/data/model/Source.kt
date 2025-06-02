package com.deepkverma.core.data.model

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id") private val id: String? = null,
    @SerializedName("name") private val name: String? = null
)
