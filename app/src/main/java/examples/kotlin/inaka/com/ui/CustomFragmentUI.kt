package examples.kotlin.inaka.com.ui

import android.view.Gravity
import android.widget.LinearLayout
import org.jetbrains.anko.*

class CustomFragmentUI<Fragment> : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
        linearLayout {
            gravity = Gravity.CENTER
            orientation = LinearLayout.VERTICAL

            textView {
                gravity = Gravity.CENTER
                id = Ids.textViewFragmentMessage
                textSize = 20f
            }.lparams(width = wrapContent, height = wrapContent)
        }
    }

    object Ids {
        val textViewFragmentMessage = 1
    }
}