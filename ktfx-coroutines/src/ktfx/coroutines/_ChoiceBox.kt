@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see ChoiceBox.setOnAction
 */
fun ChoiceBox<*>.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see ChoiceBox.setOnShowing
 */
fun ChoiceBox<*>.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
): Unit = setOnShowing { event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see ChoiceBox.setOnShown
 */
fun ChoiceBox<*>.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
): Unit = setOnShown { event ->
    GlobalScope.launch(context) {
        action(event)
    }
}

/**
 * @see ChoiceBox.setOnHiding
 */
fun ChoiceBox<*>.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
): Unit = setOnHiding { event ->
    GlobalScope.launch(context) {
        action(event)
    }
}

/**
 * @see ChoiceBox.setOnHidden
 */
fun ChoiceBox<*>.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
): Unit = setOnHidden { event ->
    GlobalScope.launch(context) {
        action(event)
    }
}
