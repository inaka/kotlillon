package examples.kotlin.inaka.com.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import examples.kotlin.inaka.com.R
import examples.kotlin.inaka.com.adapters.SlidingTabsAdapter
import kotlinx.android.synthetic.main.activity_sliding_tabs.*
import kotlinx.android.synthetic.main.content_sliding_tabs.*

class SlidingTabsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding_tabs)

        setSupportActionBar(toolbar)

        viewPagerSlidingTabs.adapter = SlidingTabsAdapter(supportFragmentManager)
        tabs.setViewPager(viewPagerSlidingTabs)
    }
}
