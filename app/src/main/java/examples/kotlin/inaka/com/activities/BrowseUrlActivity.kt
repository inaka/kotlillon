package examples.kotlin.inaka.com.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import org.jetbrains.anko.*

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

                relativeLayout {

                    val httpText = textView("http://") {
                        id = Ids.httpText
                        textSize = 20f
                    }.lparams {
                        width = wrapContent
                        height = dip(40)
                        gravity = Gravity.CENTER_VERTICAL
                    }

                    val urlText = editText {
                        id = Ids.urlText
                        hint = "www.example.com"
                        textSize = 20f
                        inputType = android.text.InputType.TYPE_TEXT_VARIATION_URI
                        lparams {
                            rightOf(httpText)
                            width = matchParent
                            height = dip(40)
                            gravity = Gravity.CENTER_VERTICAL
                        }
                    }

                    button("Browse") {
                        onClick { browse("${httpText.text}" + "${urlText.text}") }
                        lparams {
                            width = matchParent
                            height = wrapContent
                            below(urlText)
                        }
                    }
                }.lparams {
                    margin = dip(10)
                }

            }
        }
    }

    public object Ids {
        val httpText = 100
        val urlText = 101
    }
}

