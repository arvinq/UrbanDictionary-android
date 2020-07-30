package com.arvinq.urbandictionaryandroid.models

import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.google.gson.annotations.SerializedName
import java.io.Serializable

//struct if data is included
data class Term(
    @SerializedName("word")
    val word: String,
    @SerializedName("definition")
    val definition: String,
    @SerializedName("thumbs_up")
    val likes: String,
    @SerializedName("thumbs_down")
    val dislikes: String
): Serializable {
    //computed property
    val htmlDefinition: Spanned
        get() {
            val replacedBracesDefinition = this.definition
                .replace("[", "<b>")
                .replace("]", "</b>")

            return HtmlCompat.fromHtml(
                replacedBracesDefinition,
                HtmlCompat.FROM_HTML_MODE_COMPACT
            )
        }
}