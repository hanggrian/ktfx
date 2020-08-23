@file:Suppress("NOTHING_TO_INLINE")

package ktfx.windows

import javafx.scene.input.ContextMenuEvent
import javafx.scene.input.DragEvent
import javafx.scene.input.GestureEvent
import javafx.scene.input.MouseEvent
import javafx.scene.input.TouchPoint
import javafx.stage.Window

/** Move [Window] to specified location. */
fun Window.moveTo(x: Number, y: Number) {
    this.x = x.toDouble()
    this.y = y.toDouble()
}

/** Move [Window] to specified location using [ContextMenuEvent]. */
inline fun Window.moveTo(event: ContextMenuEvent): Unit = moveTo(event.screenX, event.screenY)

/** Move [Window] to specified location using [DragEvent]. */
inline fun Window.moveTo(event: DragEvent): Unit = moveTo(event.screenX, event.screenY)

/** Move [Window] to specified location using [GestureEvent]. */
inline fun Window.moveTo(event: GestureEvent): Unit = moveTo(event.screenX, event.screenY)

/** Move [Window] to specified location using [MouseEvent]. */
inline fun Window.moveTo(event: MouseEvent): Unit = moveTo(event.screenX, event.screenY)

/** Move [Window] to specified location using [TouchPoint]. */
inline fun Window.moveTo(event: TouchPoint): Unit = moveTo(event.screenX, event.screenY)
