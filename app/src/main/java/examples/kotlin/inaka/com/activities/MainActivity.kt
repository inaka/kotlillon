package examples.kotlin.inaka.com.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import examples.kotlin.inaka.com.R
import examples.kotlin.inaka.com.adapters.ExamplesListAdapter

// Obtain every layout elements of content_main and activity_main
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import java.util.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            view ->
            Snackbar.make(view, "Enjoy those examples!", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

        // info log example
        info("init app")

        val examples: ArrayList<String> = ArrayList()
        examples.add("Sliding tabs example")
        examples.add("Alert dialog example")
        examples.add("Show info in other activity example")
        examples.add("ReactiveX Kotlin usage example with toast")
        examples.add("Browse URL example")
        examples.add("Selector example")

        var examplesAdapter = ExamplesListAdapter(this, examples);

        recyclerViewExamples.layoutManager = LinearLayoutManager(this)
        recyclerViewExamples.adapter = examplesAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
