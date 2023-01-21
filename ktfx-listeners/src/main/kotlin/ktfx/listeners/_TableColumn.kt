@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.listeners

import javafx.scene.control.TableColumn
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see TableColumn.setOnEditStart
 */
public inline fun <S, T> TableColumn<S, T>.onEditStart(noinline
        action: (TableColumn.CellEditEvent<S, T>) -> Unit): Unit = setOnEditStart(action)

/**
 * @see TableColumn.setOnEditCommit
 */
public inline fun <S, T> TableColumn<S, T>.onEditCommit(noinline
        action: (TableColumn.CellEditEvent<S, T>) -> Unit): Unit = setOnEditCommit(action)

/**
 * @see TableColumn.setOnEditCancel
 */
public inline fun <S, T> TableColumn<S, T>.onEditCancel(noinline
        action: (TableColumn.CellEditEvent<S, T>) -> Unit): Unit = setOnEditCancel(action)
