package examples.kotlin.inaka.com.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.content.SharedPreferences
import android.preference.PreferenceManager


import examples.kotlin.inaka.com.R
import kotlinx.android.synthetic.main.activity_show_user.*
import kotlinx.android.synthetic.main.content_show_user.*

class ShowSavedUsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_show_user)

        setSupportActionBar(toolbar)

        var prefs = PreferenceManager.getDefaultSharedPreferences(this)

        textViewUserName.text = prefs.getString("usrName","No name")
        textViewUserAge.text = prefs.getInt("usrAge",0).toString()
    }

}
