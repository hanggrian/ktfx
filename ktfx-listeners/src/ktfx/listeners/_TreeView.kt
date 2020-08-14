@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
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
inline fun <T> TreeView<T>.onEditStart(noinline action: (TreeView.EditEvent<T>) -> Unit): Unit =
    setOnEditStart(action)

/**
 * @see TreeView.setOnEditCommit
 */
inline fun <T> TreeView<T>.onEditCommit(noinline action: (TreeView.EditEvent<T>) -> Unit): Unit =
    setOnEditCommit(action)

/**
 * @see TreeView.setOnEditCancel
 */
inline fun <T> TreeView<T>.onEditCancel(noinline action: (TreeView.EditEvent<T>) -> Unit): Unit =
    setOnEditCancel(action)

/**
 * @see TreeView.setOnScrollTo
 */
inline fun <T> TreeView<T>.onScrollTo(noinline action: (ScrollToEvent<Int>) -> Unit): Unit =
    setOnScrollTo(action)
