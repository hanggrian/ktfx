package ktfx.internal

/** Base interface for all layout managers. */
interface KtfxManager<T> {

    /** Add child, returning the child added. */
    operator fun <R : T> R.invoke(): R
}