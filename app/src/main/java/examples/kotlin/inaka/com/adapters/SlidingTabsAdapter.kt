package examples.kotlin.inaka.com.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import examples.kotlin.inaka.com.fragments.CustomFragment

/**
 * Created by inaka on 12/23/15
 */
class SlidingTabsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val titles = arrayOf("Fragment1", "Fragment2", "Fragment3", "Fragment4", "Fragment5")

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun getItem(position: Int): Fragment {
        return CustomFragment.newInstance(titles[position])
    }

}
