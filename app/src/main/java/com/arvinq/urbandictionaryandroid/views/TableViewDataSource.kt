package com.arvinq.urbandictionaryandroid.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arvinq.urbandictionaryandroid.models.Term
import com.arvinq.urbandictionaryandroid.R

//conform tp recyclerView adapter / protocol and the generic adapter is going to expect a TermCell
class TableViewDataSource: RecyclerView.Adapter<TermCell>()  {

    //empty list with type Terms
    var terms = emptyList<Term>()

    // number of rows
    override fun getItemCount(): Int {
        return terms.size
    }

    // dequeueReuseIdentifier
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermCell {
        val termView = LayoutInflater.from(parent.context).inflate(R.layout.term_cell, parent, false)
        return TermCell(termView)
    }

    // cellForRowAtIndexPath
    override fun onBindViewHolder(holder: TermCell, position: Int) {
        val term = terms[position]
        holder.wordLabel.text = term.word
        holder.definitionLabel.text = term.htmlDefinition
        holder.term = term
    }

    //possibly a utility function that gets called to populate the local terms list.
    //then notifying our recycler view that the data has been changed
    fun update(terms: List<Term>) {
        this.terms = terms
        notifyDataSetChanged()
    }
}