package examples.kotlin.inaka.com.adapters

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import examples.kotlin.inaka.com.R
import examples.kotlin.inaka.com.activities.ShowUserActivity
import examples.kotlin.inaka.com.activities.SlidingTabsActivity
import examples.kotlin.inaka.com.models.User
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

    init {
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

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View): Unit {

                when (position) {
                    0 -> context.startActivity(Intent(context, SlidingTabsActivity::class.java))
                    1 -> openAlertDialog()
                    2 -> makeNewUser()
                    else -> {
                        // this is the else statement ...
                    }
                }

            }

        })
    }

    override fun getItemCount(): Int {
        return this.examples.size
    }

    private fun openAlertDialog() {
        var toast = Toast.makeText(context, "This is a toast!", Toast.LENGTH_LONG)
        AlertDialog.Builder(context).setTitle("Test alert dialog")
                ?.setMessage("Want to display an example of a toast?")
                ?.setPositiveButton("Yes", { dialog, which -> toast.show() })
                ?.setNegativeButton("No", { dialog, which -> /* no toast displayed */ })
                ?.create()
                ?.show()
    }

    private fun makeNewUser() {
        var dialog = Dialog(context)
        dialog.setContentView(R.layout.view_create_user)
        dialog.setTitle("Create user")

        var textName = dialog.findViewById(R.id.editTextUserName) as EditText
        var textAge = dialog.findViewById(R.id.editTextUserAge) as EditText

        var buttonCancel = dialog.findViewById(R.id.buttonCancelUser) as Button
        buttonCancel.setOnClickListener { dialog.dismiss() }

        var buttonShowUser = dialog.findViewById(R.id.buttonShowUser) as Button

        buttonShowUser.setOnClickListener {
            var name = textName.text.toString()
            var ageString = textAge.text.toString()

            var age: Int = 0
            if (!ageString.equals("")) {
                age = ageString.toInt()
            }

            var user = User(mapOf(
                    "name" to name,
                    "age"  to age
            ))

            var intent: Intent = Intent(context, ShowUserActivity::class.java)
            var bundle = Bundle()
            bundle.putString("name", user.name)
            bundle.putInt("age", user.age)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }

        dialog.show()
    }
}
