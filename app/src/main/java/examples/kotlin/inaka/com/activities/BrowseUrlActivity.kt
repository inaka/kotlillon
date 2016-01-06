package examples.kotlin.inaka.com.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*

import examples.kotlin.inaka.com.R

/**
 * Created by inaka on 1/6/16.
 */
class BrowseUrlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BrowseUrlActivityUI<AppCompatActivity>().setContentView(this)
    }

    class BrowseUrlActivityUI<AppCompatActivity> : AnkoComponent<AppCompatActivity> {
        override fun createView(ui: AnkoContext<AppCompatActivity>) = with(ui) {
            verticalLayout {
                toolbar{
                    title = "Browse URL"
                }.style {
                    backgroundColor = resources.getColor(R.color.colorPrimary, null)
                }

                val urlText = editText()
                urlText.hint = "Enter URL including 'http://' or 'https://'"

                button("Browse") {
                    onClick {
                        browse("${urlText.text}")
                    }
                }
            }
        }
    }
}

