@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** The ChoiceBox action, which is invoked whenever the [ChoiceBox.valueProperty] is changed. */
fun ChoiceBox<*>.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [ChoiceBox] popup has been hidden. */
fun ChoiceBox<*>.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnHidden { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [ChoiceBox] popup being hidden. */
fun ChoiceBox<*>.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnHiding { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the {@code ChoiceBox} popup being shown. */
fun ChoiceBox<*>.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnShowing { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [ChoiceBox] popup is shown. */
fun ChoiceBox<*>.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnShown { event -> GlobalScope.launch(context) { action(event) } }
