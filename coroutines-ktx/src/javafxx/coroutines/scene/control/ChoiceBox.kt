@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** The ChoiceBox action, which is invoked whenever the [ChoiceBox.valueProperty] is changed. */
fun ChoiceBox<*>.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [ChoiceBox] popup has been hidden. */
fun ChoiceBox<*>.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [ChoiceBox] popup being hidden. */
fun ChoiceBox<*>.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the {@code ChoiceBox} popup being shown. */
fun ChoiceBox<*>.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [ChoiceBox] popup is shown. */
fun ChoiceBox<*>.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> GlobalScope.launch(context) { action(event) } }