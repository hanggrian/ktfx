@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeView
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see TreeView.setOnEditStart
 */
public inline fun <T> TreeView<T>.onEditStart(noinline action: (TreeView.EditEvent<T>) -> Unit) {
    return setOnEditStart(action)
}

/**
 * @see TreeView.setOnEditCommit
 */
public inline fun <T> TreeView<T>.onEditCommit(noinline action: (TreeView.EditEvent<T>) -> Unit) {
    return setOnEditCommit(action)
}

/**
 * @see TreeView.setOnEditCancel
 */
public inline fun <T> TreeView<T>.onEditCancel(noinline action: (TreeView.EditEvent<T>) -> Unit) {
    return setOnEditCancel(action)
}

/**
 * @see TreeView.setOnScrollTo
 */
public inline fun <T> TreeView<T>.onScrollTo(noinline action: (ScrollToEvent<Int>) -> Unit) {
    return setOnScrollTo(action)
}
