@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox

/** The ChoiceBox action, which is invoked whenever the [ChoiceBox.valueProperty] is changed. */
inline fun ChoiceBox<*>.onAction(
    noinline action: (ActionEvent) -> Unit
): Unit = setOnAction(action)

/** Called just prior to the {@code ChoiceBox} popup being shown. */
inline fun ChoiceBox<*>.onShowing(
    noinline action: (Event) -> Unit
): Unit = setOnShowing(action)

/** Called just after the [ChoiceBox] popup is shown. */
inline fun ChoiceBox<*>.onShown(
    noinline action: (Event) -> Unit
): Unit = setOnShown(action)

/** Called just prior to the [ChoiceBox] popup being hidden. */
inline fun ChoiceBox<*>.onHiding(
    noinline action: (Event) -> Unit
): Unit = setOnHiding(action)

/** Called just after the [ChoiceBox] popup has been hidden. */
inline fun ChoiceBox<*>.onHidden(
    noinline action: (Event) -> Unit
): Unit = setOnHidden(action)
