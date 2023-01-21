@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.listeners

import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see ListView.setOnEditStart
 */
public inline fun <T> ListView<T>.onEditStart(noinline action: (ListView.EditEvent<T>) -> Unit):
        Unit = setOnEditStart(action)

/**
 * @see ListView.setOnEditCommit
 */
public inline fun <T> ListView<T>.onEditCommit(noinline action: (ListView.EditEvent<T>) -> Unit):
        Unit = setOnEditCommit(action)

/**
 * @see ListView.setOnEditCancel
 */
public inline fun <T> ListView<T>.onEditCancel(noinline action: (ListView.EditEvent<T>) -> Unit):
        Unit = setOnEditCancel(action)

/**
 * @see ListView.setOnScrollTo
 */
public inline fun <T> ListView<T>.onScrollTo(noinline action: (ScrollToEvent<Int>) -> Unit): Unit =
        setOnScrollTo(action)
