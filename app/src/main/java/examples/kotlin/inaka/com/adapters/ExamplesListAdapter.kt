package examples.kotlin.inaka.com.adapters

import android.app.Dialog
import android.content.Context
import android.preference.PreferenceManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import examples.kotlin.inaka.com.R
import examples.kotlin.inaka.com.activities.BrowseUrlActivity
import examples.kotlin.inaka.com.activities.ShowSavedUsersActivity
import examples.kotlin.inaka.com.activities.ShowUserActivity
import examples.kotlin.inaka.com.activities.SlidingTabsActivity
import examples.kotlin.inaka.com.models.User
import kotlinx.android.synthetic.main.view_example_item.view.*
import org.jetbrains.anko.*
import rx.lang.kotlin.fold
import rx.lang.kotlin.observable

/**
 * Created by inaka on 12/23/15.
 */
internal class ExamplesListAdapter(context: Context, examples: List<String>) : RecyclerView.Adapter<ExamplesListAdapter.ViewHolder>() {

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView = itemView.textViewExampleTitle
    }

    private val examples: List<String>
    private val context: Context
    private var counter: Int = 0

    init {
        this.examples = examples
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamplesListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_example_item, parent, false))
    }

    override fun onBindViewHolder(holder: ExamplesListAdapter.ViewHolder, position: Int) {
        val exampleItemString = examples[position]

        holder.textView.text = exampleItemString

        holder.itemView.setOnClickListener({
            view ->
            when (position) {
                0 -> context.startActivity<SlidingTabsActivity>()
                1 -> openAlertDialog()
                2 -> displaySelector()
                3 -> {
                    counter++
                    rxUsage()
                }
                4 -> makeNewUser()
                5 -> saveNewUser()
                6 -> browseURL()
                7 -> share()
                8 -> sendEmail()
                9 -> wifiStatus()
                else -> {
                    // this is the else statement ...
                }
            }
        })
    }

    override fun getItemCount(): Int {
        return this.examples.size
    }

    private fun openAlertDialog() {
        // Using Anko
        context.alert("Want to display an example of a toast?", "Test alert dialog") {
            positiveButton("Yes") { context.longToast("This is a toast!") }
            negativeButton("No") { }
        }.show()

        // Kotlin not using Anko
        /*  AlertDialog.Builder(context).setTitle("Test alert dialog")
                  ?.setMessage("Want to display an example of a toast?")
                  ?.setPositiveButton("Yes", { dialog, which -> context.longToast("This is a toast!") })
                  ?.setNegativeButton("No", { dialog, which -> })
                  ?.create()
                  ?.show()
          */
    }

    private fun saveNewUser() {
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

            var prefs = PreferenceManager.getDefaultSharedPreferences(context)

            var editor = prefs.edit()
            editor.putString("usrName", user.name)
            editor.putInt("usrAge", user.age)
            editor.apply();

            context.startActivity<ShowSavedUsersActivity>()
        }

        dialog.show()
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

            context.startActivity<ShowUserActivity>("name" to user.name, "age" to user.age)
        }

        dialog.show()
    }

    private fun rxUsage() {

        observable<String> { subscriber ->

            subscriber.onStart() // start subscriber (optional)

            // receive data
            subscriber.onNext("H")
            subscriber.onNext("el")
            subscriber.onNext("")
            subscriber.onNext("l")
            subscriber.onNext("o")

            if (counter > 1) {
                subscriber.onNext(" again! (" + counter.toString() + " times)")
            }

            subscriber.onCompleted() // finish receiving data

        }.filter { it.isNotEmpty() }
                .fold (StringBuilder()) { sb, e -> sb.append(e) }
                .map { it.toString() }
                .subscribe { result -> context.toast(result) }
    }

    private fun browseURL() {
        context.startActivity<BrowseUrlActivity>()
    }

    private fun displaySelector() {
        val reponses = listOf(
                "Those examples are really awesome!",
                "Yes, they are good",
                "Well, it seems that you didn't make so much effort",
                "I don't like this at all",
                "The answer is Japan")
        context.selector("Do you like those examples?", reponses) {
            i ->
            when (i) {
                0, 1 -> context.toast("Thanks!")
                2, 3 -> context.toast("It's open source, feel free to colaborate")
                4 -> context.toast("That's the answer I was waiting for")
            }
        }
    }

    private fun share() {
        context.share("Sharing from Kotlillon")
    }

    private fun sendEmail() {
        context.email("", "E-mail sent from Kotlillon", "Content ...")
    }

    private fun wifiStatus() {
        if (!context.wifiManager.isWifiEnabled) {
            context.vibrator.vibrate(400)
            context.toast("Wifi is disabled!!")
        } else {
            context.toast("Wifi is enabled :)")
        }
    }
}
