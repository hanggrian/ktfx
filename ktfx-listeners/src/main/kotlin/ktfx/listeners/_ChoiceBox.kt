@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.listeners

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see ChoiceBox.setOnAction
 */
public inline fun ChoiceBox<*>.onAction(noinline action: (ActionEvent) -> Unit): Unit =
        setOnAction(action)

/**
 * @see ChoiceBox.setOnShowing
 */
public inline fun ChoiceBox<*>.onShowing(noinline action: (Event) -> Unit): Unit =
        setOnShowing(action)

/**
 * @see ChoiceBox.setOnShown
 */
public inline fun ChoiceBox<*>.onShown(noinline action: (Event) -> Unit): Unit = setOnShown(action)

/**
 * @see ChoiceBox.setOnHiding
 */
public inline fun ChoiceBox<*>.onHiding(noinline action: (Event) -> Unit): Unit =
        setOnHiding(action)

/**
 * @see ChoiceBox.setOnHidden
 */
public inline fun ChoiceBox<*>.onHidden(noinline action: (Event) -> Unit): Unit =
        setOnHidden(action)
