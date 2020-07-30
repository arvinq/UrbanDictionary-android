package com.arvinq.urbandictionaryandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.arvinq.urbandictionaryandroid.controllers.NetworkingService
import com.arvinq.urbandictionaryandroid.views.TableViewDataSource
import kotlinx.android.synthetic.main.activity_search_results.*

class SearchResultsActivity : AppCompatActivity() {

    //val is like a let
    private val networkingService =
        NetworkingService()
    private val dataSource =
        TableViewDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)

        tableView.layoutManager = LinearLayoutManager(this)
        tableView.adapter = dataSource


        //intent is a given property in every activity
        var term = ""
        intent.getStringExtra(MainActivity.termKey)?.let {
            term = it
        }

        supportActionBar?.title = term
        getSearchResultsForTerm(term)
    }

    private fun getSearchResultsForTerm(term: String) {
        println("term ${term} ")
                                                    //observing what comes back which is terms
        networkingService.defineTerm(term).observe(this, Observer { terms -> //assigning a name in the closure
            terms.forEach { println(it) } //then using the name and accessing its values using for each then print it
            //it is like a $0 when it comes to closure in kotlin

            dataSource.update(terms)
        })
    }
}