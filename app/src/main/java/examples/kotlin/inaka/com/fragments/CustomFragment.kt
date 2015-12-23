package examples.kotlin.inaka.com.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import examples.kotlin.inaka.com.R

/**
 * Created by inaka on 12/23/15.
 */
class CustomFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_custom, container, false)
        val message = arguments.getString("message")
        (view.findViewById(R.id.textViewFragmentMessage) as TextView).text = message
        return view
    }

    companion object {

        fun newInstance(message: String): CustomFragment {

            val args = Bundle()
            args.putString("message", message)

            val fragment = CustomFragment()
            fragment.arguments = args

            return fragment
        }
    }
}
