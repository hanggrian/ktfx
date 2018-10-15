package ktfx.internal

/** Base interface for all layout managers. */
interface KtfxManager<T> {

    /** Actual collection that this manager holds. */
    val collection: MutableCollection<T>

    /** Add child, returning the child added. */
    operator fun <R : T> R.invoke(): R = also { collection += it }
}