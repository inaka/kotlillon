package examples.kotlin.inaka.com.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import examples.kotlin.inaka.com.R
import examples.kotlin.inaka.com.activities.SlidingTabsActivity
import kotlinx.android.synthetic.main.view_example_item.view.*
import java.util.*

/**
 * Created by inaka on 12/23/15.
 */
internal class ExamplesListAdapter(context: Context, examples: ArrayList<String>) : RecyclerView.Adapter<ExamplesListAdapter.ViewHolder>() {

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView = itemView.textViewExampleTitle
    }

    private val examples: MutableList<String>
    private val context: Context

    init{
        this.examples = examples
        this.context = context
    }

    fun clear() {
        examples.clear()
    }

    fun addExample(item: String) {
        examples.add(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamplesListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_example_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ExamplesListAdapter.ViewHolder, position: Int) {
        val exampleItemString = examples[position]

        holder.textView.text = exampleItemString

        holder.itemView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {

                when(position){
                    0 -> context.startActivity(Intent(context, SlidingTabsActivity::class.java))
                    else -> {

                    }
                }

            }
        })
    }

    override fun getItemCount(): Int {
        return this.examples.size
    }
}
