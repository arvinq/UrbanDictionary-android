package com.arvinq.urbandictionaryandroid.views

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arvinq.urbandictionaryandroid.models.Term
import com.arvinq.urbandictionaryandroid.WordDefinitionActivity
import kotlinx.android.synthetic.main.term_cell.view.*

//what type of view or what layout is being passed into this termCell when this is initialized.
//then we need to make it conform to RecyclerView type object. And as we create the instance of viewHolder,
//we pass in the termView passed when this termCell is initialized.
class TermCell(termView: View, var term: Term? = null): RecyclerView.ViewHolder(termView) {
    val wordLabel: TextView = termView.wordLabel
    val definitionLabel: TextView = termView.definitionLabel

    //if the class file corresponds to the view it is representing from the layout,
    //we init it like this and define the events inside
    init {
        termView.setOnClickListener {
            //if let it = self.term
            term?.let {
                val intent = Intent(termView.context, WordDefinitionActivity::class.java)
                //it as the term object is named inside this closure should conform to Serializable,
                //else we won't be able to use it in putExtra method
                intent.putExtra(TermCell.termKey, it)
                termView.context.startActivity(intent)
            }
        }
    }

    companion object {
        const val termKey = "termKey"
    }
}