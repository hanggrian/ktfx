@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** The ChoiceBox action, which is invoked whenever the [ChoiceBox.valueProperty] is changed. */
fun ChoiceBox<*>.onAction(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

/** Called just after the [ChoiceBox] popup has been hidden. */
fun ChoiceBox<*>.onHidden(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

/** Called just prior to the [ChoiceBox] popup being hidden. */
fun ChoiceBox<*>.onHiding(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

/** Called just prior to the {@code ChoiceBox} popup being shown. */
fun ChoiceBox<*>.onShowing(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

/** Called just after the [ChoiceBox] popup is shown. */
fun ChoiceBox<*>.onShown(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }