package ktfx.internal

/** Base interface for all layout managers. */
interface KtfxManager<T> {

    /** Actual collection that this manager holds. */
    val collection: MutableCollection<T>

    /**
     * Allows item to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @receiver the item to add
     * @return the item added
     */
    operator fun <R : T> R.invoke(): R = also { collection += it }

    /** Implementation of manager where collection are newly created empty modifiable list. */
    class Empty<T> : KtfxManager<T> {
        override val collection: MutableCollection<T> = mutableListOf()
    }
}