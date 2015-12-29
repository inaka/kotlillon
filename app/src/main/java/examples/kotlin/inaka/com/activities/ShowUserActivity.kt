package examples.kotlin.inaka.com.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import examples.kotlin.inaka.com.R
import kotlinx.android.synthetic.main.activity_show_user.*
import kotlinx.android.synthetic.main.content_show_user.*

class ShowUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_show_user)

        setSupportActionBar(toolbar)

        textViewUserName.text = intent.extras.getString("name")
        textViewUserAge.text = intent.extras.getInt("age").toString()

    }

}
