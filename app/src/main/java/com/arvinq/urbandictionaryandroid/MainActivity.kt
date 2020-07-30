package com.arvinq.urbandictionaryandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // viewDidLoad equivalent
    // only called once but when app is rotated,
    // activity is reloaded again which in turn calls this onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //like loadView()

        searchButton.setOnClickListener {
            println("${textField.text}") //prints the text in textfield
            println("$textField") //prints the textfield object

            navigateToSearchResultsForWord(textField.text.toString())
        }
    }

    private fun navigateToSearchResultsForWord(word: String) {
        // let intent = Intent(self, SearchResultsActivity.self) //swift equivalent
        val intent = Intent(this, SearchResultsActivity::class.java)
        intent.putExtra(termKey, word) //one way of passing in values across multiple activity
        startActivity(intent)
    }

    companion object {
        //static let termKey = "termKey"
        const val termKey = "termKey"
    }
}