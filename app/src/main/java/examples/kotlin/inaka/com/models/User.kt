package examples.kotlin.inaka.com.models

import kotlin.collections.getValue

/**
 * Created by inaka on 12/23/15.
 */
class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}