@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.Node
import javafx.scene.input.ContextMenuEvent
import javafx.scene.input.DragEvent
import javafx.scene.input.InputMethodEvent
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseDragEvent
import javafx.scene.input.MouseEvent
import javafx.scene.input.RotateEvent
import javafx.scene.input.ScrollEvent
import javafx.scene.input.SwipeEvent
import javafx.scene.input.TouchEvent
import javafx.scene.input.ZoomEvent
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
 * @see Node.setOnDragEntered
 */
fun Node.onDragEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
): Unit = setOnDragEntered { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnDragExited
 */
fun Node.onDragExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
): Unit = setOnDragExited { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnDragOver
 */
fun Node.onDragOver(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
): Unit = setOnDragOver { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnDragDropped
 */
fun Node.onDragDropped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
): Unit = setOnDragDropped { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnDragDone
 */
fun Node.onDragDone(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
): Unit = setOnDragDone { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnContextMenuRequested
 */
fun Node.onContextMenuRequested(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ContextMenuEvent) -> Unit
): Unit = setOnContextMenuRequested { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnMouseClicked
 */
fun Node.onMouseClicked(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
): Unit = setOnMouseClicked { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnMouseDragged
 */
fun Node.onMouseDragged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
): Unit = setOnMouseDragged { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnMouseEntered
 */
fun Node.onMouseEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
): Unit = setOnMouseEntered { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnMouseExited
 */
fun Node.onMouseExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
): Unit = setOnMouseExited { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnMouseMoved
 */
fun Node.onMouseMoved(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
): Unit = setOnMouseMoved { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnMousePressed
 */
fun Node.onMousePressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
): Unit = setOnMousePressed { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnMouseReleased
 */
fun Node.onMouseReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
): Unit = setOnMouseReleased { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnDragDetected
 */
fun Node.onDragDetected(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
): Unit = setOnDragDetected { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnMouseDragOver
 */
fun Node.onMouseDragOver(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
): Unit = setOnMouseDragOver { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnMouseDragReleased
 */
fun Node.onMouseDragReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
): Unit = setOnMouseDragReleased { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnMouseDragEntered
 */
fun Node.onMouseDragEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
): Unit = setOnMouseDragEntered { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnMouseDragExited
 */
fun Node.onMouseDragExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
): Unit = setOnMouseDragExited { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnScrollStarted
 */
fun Node.onScrollStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ScrollEvent) -> Unit
): Unit = setOnScrollStarted { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnScroll
 */
fun Node.onScroll(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ScrollEvent) -> Unit
): Unit = setOnScroll { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnScrollFinished
 */
fun Node.onScrollFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ScrollEvent) -> Unit
): Unit = setOnScrollFinished { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnRotationStarted
 */
fun Node.onRotationStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(RotateEvent) -> Unit
): Unit = setOnRotationStarted { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnRotate
 */
fun Node.onRotate(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(RotateEvent) -> Unit
): Unit = setOnRotate { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnRotationFinished
 */
fun Node.onRotationFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(RotateEvent) -> Unit
): Unit = setOnRotationFinished { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnZoomStarted
 */
fun Node.onZoomStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ZoomEvent) -> Unit
): Unit = setOnZoomStarted { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnZoom
 */
fun Node.onZoom(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ZoomEvent) -> Unit
): Unit = setOnZoom { event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see Node.setOnZoomFinished
 */
fun Node.onZoomFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ZoomEvent) -> Unit
): Unit = setOnZoomFinished { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnSwipeUp
 */
fun Node.onSwipeUp(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
): Unit = setOnSwipeUp { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnSwipeDown
 */
fun Node.onSwipeDown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
): Unit = setOnSwipeDown { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnSwipeLeft
 */
fun Node.onSwipeLeft(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
): Unit = setOnSwipeLeft { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnSwipeRight
 */
fun Node.onSwipeRight(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
): Unit = setOnSwipeRight { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnTouchPressed
 */
fun Node.onTouchPressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
): Unit = setOnTouchPressed { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnTouchMoved
 */
fun Node.onTouchMoved(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
): Unit = setOnTouchMoved { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnTouchReleased
 */
fun Node.onTouchReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
): Unit = setOnTouchReleased { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnTouchStationary
 */
fun Node.onTouchStationary(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
): Unit = setOnTouchStationary { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnKeyPressed
 */
fun Node.onKeyPressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(KeyEvent) -> Unit
): Unit = setOnKeyPressed { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnKeyReleased
 */
fun Node.onKeyReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(KeyEvent) -> Unit
): Unit = setOnKeyReleased { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnKeyTyped
 */
fun Node.onKeyTyped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(KeyEvent) -> Unit
): Unit = setOnKeyTyped { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Node.setOnInputMethodTextChanged
 */
fun Node.onInputMethodTextChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(InputMethodEvent) -> Unit
): Unit = setOnInputMethodTextChanged { event ->
    GlobalScope.launch(context) { action(event) }
}
