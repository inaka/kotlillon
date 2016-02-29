package examples.kotlin.inaka.com.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import examples.kotlin.inaka.com.ui.CustomFragmentUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.withArguments

class CustomFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = CustomFragmentUI<Fragment>().createView(AnkoContext.create(context, this))
        val message = arguments.getString("message")
        (view.findViewById(CustomFragmentUI.Ids.textViewFragmentMessage) as TextView).text = message
        return view
    }

    companion object {
        fun newInstance(message: String): CustomFragment {
            return CustomFragment().withArguments("message" to message)
        }
    }
}
