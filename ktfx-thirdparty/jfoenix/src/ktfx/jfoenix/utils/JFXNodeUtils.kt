@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.utils.JFXNodeUtils
import javafx.beans.InvalidationListener
import javafx.beans.value.ObservableValue
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.Node
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Background
import javafx.scene.layout.Region
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.util.Duration

inline fun Region.updateBackground(
    newBackground: Background,
    paint: Paint = Color.BLACK
): Unit = JFXNodeUtils.updateBackground(newBackground, this, paint)

inline fun Color.toHex(): String = JFXNodeUtils.colorToHex(this)

inline fun Node.pressAndHoldHandler(
    holdTime: Duration,
    noinline handler: (MouseEvent) -> Unit
): Unit = JFXNodeUtils.addPressAndHoldHandler(this, holdTime, handler)

inline fun Node.pressAndHoldFilter(
    holdTime: Duration,
    noinline handler: (MouseEvent) -> Unit
): Unit = JFXNodeUtils.addPressAndHoldFilter(this, holdTime, handler)

inline fun <T> ObservableValue<T>.delayedPropertyInvalidationListener(
    delayTime: Duration,
    noinline consumer: (T) -> Unit
): InvalidationListener = JFXNodeUtils.addDelayedPropertyInvalidationListener(this, delayTime, consumer)

inline fun <T> ObservableValue<T>.delayedPropertyInvalidationListener(
    delayTime: Duration,
    noinline justInTimeConsumer: (T) -> Unit,
    noinline consumer: (T) -> Unit
): InvalidationListener =
    JFXNodeUtils.addDelayedPropertyInvalidationListener(this, delayTime, justInTimeConsumer, consumer)

inline fun <T : Event> Node.delayedEventHandler(
    delayTime: Duration,
    eventType: EventType<T>,
    noinline handler: (T) -> Unit
): EventHandler<in T> = JFXNodeUtils.addDelayedEventHandler(this, delayTime, eventType, handler)
