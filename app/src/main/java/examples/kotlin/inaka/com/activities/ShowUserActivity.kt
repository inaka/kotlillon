package examples.kotlin.inaka.com.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import examples.kotlin.inaka.com.R
import examples.kotlin.inaka.com.models.User

import kotlinx.android.synthetic.main.activity_show_user.*
import kotlinx.android.synthetic.main.content_show_user.*

class ShowUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_show_user)

        setSupportActionBar(toolbar)

        val user = intent.extras.getParcelable<User>("user")
        textViewUserName.text = user.name
        textViewUserAge.text = user.age.toString()

    }

}
