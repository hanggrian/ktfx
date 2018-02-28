@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.event.EventHandler
import javafx.scene.control.TreeTableColumn

inline fun <S, T> TreeTableColumn<S, T>.onEditCancel(
    noinline action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCancel(EventHandler(action))

inline fun <S, T> TreeTableColumn<S, T>.onEditCommit(
    noinline action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCommit(EventHandler(action))

inline fun <S, T> TreeTableColumn<S, T>.onEditStart(
    noinline action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditStart(EventHandler(action))