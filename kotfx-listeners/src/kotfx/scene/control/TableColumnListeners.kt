@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.control.TableColumn
import javafx.scene.control.TableColumnBase

inline fun <S, T> TableColumn<S, T>.onEditCancel(
    noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCancel(EventHandler(action))

inline fun <S, T> TableColumn<S, T>.onEditCommit(
    noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCommit(EventHandler(action))

inline fun <S, T> TableColumn<S, T>.onEditStart(
    noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditStart(EventHandler(action))

inline fun <S, T, E : Event> TableColumnBase<S, T>.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))