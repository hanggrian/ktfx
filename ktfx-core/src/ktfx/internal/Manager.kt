package ktfx.internal

/** Base interface for all layout managers. */
interface Manager<T> {

    /** Actual collection that this manager holds. */
    val collection: MutableCollection<T>

    /** Allows item to be added dynamically with Kotlin DSL. */
    operator fun <R : T> R.invoke(): R = also { collection += it }

    /** Default implementation of manager where the items are newly created empty modifiable list. */
    class Empty<T> : Manager<T> {

        override val collection: MutableCollection<T> = mutableListOf()
    }
}