package examples.kotlin.inaka.com.models

import android.os.Parcel
import android.os.Parcelable
import com.mcxiaoke.koi.ext.createParcel

class User(val map: Map<String, Any?>) : Parcelable {

    val name: String by map
    val age: Int     by map

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(age)
    }

    override fun describeContents(): Int = 0

    protected constructor(p: Parcel) : this(mapOf(
            "name" to p.readString(),
            "age"  to p.readInt()))

    companion object {
        @JvmField val CREATOR = createParcel { User(it) }
    }
}