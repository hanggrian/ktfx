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

fun Region.updateBackground(
    newBackground: Background,
    paint: Paint = Color.BLACK
): Unit = JFXNodeUtils.updateBackground(newBackground, this, paint)

fun Color.toHex(): String = JFXNodeUtils.colorToHex(this)

fun Node.pressAndHoldHandler(
    holdTime: Duration,
    handler: (MouseEvent) -> Unit
): Unit = JFXNodeUtils.addPressAndHoldHandler(this, holdTime, handler)

fun Node.pressAndHoldFilter(
    holdTime: Duration,
    handler: (MouseEvent) -> Unit
): Unit = JFXNodeUtils.addPressAndHoldFilter(this, holdTime, handler)

fun <T> ObservableValue<T>.delayedPropertyInvalidationListener(
    delayTime: Duration,
    consumer: (T) -> Unit
): InvalidationListener = JFXNodeUtils.addDelayedPropertyInvalidationListener(this, delayTime, consumer)

fun <T> ObservableValue<T>.delayedPropertyInvalidationListener(
    delayTime: Duration,
    justInTimeConsumer: (T) -> Unit,
    consumer: (T) -> Unit
): InvalidationListener =
    JFXNodeUtils.addDelayedPropertyInvalidationListener(this, delayTime, justInTimeConsumer, consumer)

fun <T : Event> Node.delayedEventHandler(
    delayTime: Duration,
    eventType: EventType<T>,
    handler: (T) -> Unit
): EventHandler<in T> = JFXNodeUtils.addDelayedEventHandler(this, delayTime, eventType, handler)
