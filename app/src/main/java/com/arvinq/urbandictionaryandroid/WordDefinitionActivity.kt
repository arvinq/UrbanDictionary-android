package com.arvinq.urbandictionaryandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arvinq.urbandictionaryandroid.models.Term
import com.arvinq.urbandictionaryandroid.views.TermCell
import kotlinx.android.synthetic.main.activity_word_definition.*

class WordDefinitionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_definition)

        val term = intent.getSerializableExtra(TermCell.termKey) as? Term
        term?.let {
            supportActionBar?.title = it.word
            definitionLabel.text = it.htmlDefinition
            likesLabel.text = "Likes: ${it.likes}"
            dislikesLabel.text = "Dislikes: ${it.dislikes}"
        }

    }
}