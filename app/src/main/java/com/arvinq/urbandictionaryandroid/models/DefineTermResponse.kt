package com.arvinq.urbandictionaryandroid.models

import com.google.gson.annotations.SerializedName

//struct if there's a data prepended in class declaration
data class DefineTermResponse(
    @SerializedName("list")
    val terms: List<Term>
) {
}