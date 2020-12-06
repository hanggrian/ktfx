@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

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
public fun Node.onDragEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
) {
    return setOnDragEntered { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnDragExited
 */
public fun Node.onDragExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
) {
    return setOnDragExited { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnDragOver
 */
public fun Node.onDragOver(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
) {
    return setOnDragOver { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnDragDropped
 */
public fun Node.onDragDropped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
) {
    return setOnDragDropped { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnDragDone
 */
public fun Node.onDragDone(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
) {
    return setOnDragDone { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnContextMenuRequested
 */
public fun Node.onContextMenuRequested(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ContextMenuEvent) -> Unit
) {
    return setOnContextMenuRequested { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnMouseClicked
 */
public fun Node.onMouseClicked(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseClicked { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnMouseDragged
 */
public fun Node.onMouseDragged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseDragged { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnMouseEntered
 */
public fun Node.onMouseEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseEntered { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnMouseExited
 */
public fun Node.onMouseExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseExited { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnMouseMoved
 */
public fun Node.onMouseMoved(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseMoved { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnMousePressed
 */
public fun Node.onMousePressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMousePressed { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnMouseReleased
 */
public fun Node.onMouseReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseReleased { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnDragDetected
 */
public fun Node.onDragDetected(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnDragDetected { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnMouseDragOver
 */
public fun Node.onMouseDragOver(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
) {
    return setOnMouseDragOver { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnMouseDragReleased
 */
public fun Node.onMouseDragReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
) {
    return setOnMouseDragReleased { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnMouseDragEntered
 */
public fun Node.onMouseDragEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
) {
    return setOnMouseDragEntered { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnMouseDragExited
 */
public fun Node.onMouseDragExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
) {
    return setOnMouseDragExited { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnScrollStarted
 */
public fun Node.onScrollStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ScrollEvent) -> Unit
) {
    return setOnScrollStarted { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnScroll
 */
public fun Node.onScroll(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ScrollEvent) -> Unit
) {
    return setOnScroll { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnScrollFinished
 */
public fun Node.onScrollFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ScrollEvent) -> Unit
) {
    return setOnScrollFinished { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnRotationStarted
 */
public fun Node.onRotationStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(RotateEvent) -> Unit
) {
    return setOnRotationStarted { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnRotate
 */
public fun Node.onRotate(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(RotateEvent) -> Unit
) {
    return setOnRotate { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnRotationFinished
 */
public fun Node.onRotationFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(RotateEvent) -> Unit
) {
    return setOnRotationFinished { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnZoomStarted
 */
public fun Node.onZoomStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ZoomEvent) -> Unit
) {
    return setOnZoomStarted { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnZoom
 */
public fun Node.onZoom(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ZoomEvent) -> Unit
) {
    return setOnZoom { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnZoomFinished
 */
public fun Node.onZoomFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ZoomEvent) -> Unit
) {
    return setOnZoomFinished { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnSwipeUp
 */
public fun Node.onSwipeUp(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
) {
    return setOnSwipeUp { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnSwipeDown
 */
public fun Node.onSwipeDown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
) {
    return setOnSwipeDown { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnSwipeLeft
 */
public fun Node.onSwipeLeft(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
) {
    return setOnSwipeLeft { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnSwipeRight
 */
public fun Node.onSwipeRight(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
) {
    return setOnSwipeRight { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnTouchPressed
 */
public fun Node.onTouchPressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
) {
    return setOnTouchPressed { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnTouchMoved
 */
public fun Node.onTouchMoved(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
) {
    return setOnTouchMoved { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnTouchReleased
 */
public fun Node.onTouchReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
) {
    return setOnTouchReleased { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnTouchStationary
 */
public fun Node.onTouchStationary(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
) {
    return setOnTouchStationary { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnKeyPressed
 */
public fun Node.onKeyPressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(KeyEvent) -> Unit
) {
    return setOnKeyPressed { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnKeyReleased
 */
public fun Node.onKeyReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(KeyEvent) -> Unit
) {
    return setOnKeyReleased { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnKeyTyped
 */
public fun Node.onKeyTyped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(KeyEvent) -> Unit
) {
    return setOnKeyTyped { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Node.setOnInputMethodTextChanged
 */
public fun Node.onInputMethodTextChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(InputMethodEvent) -> Unit
) {
    return setOnInputMethodTextChanged { event -> GlobalScope.launch(context) { action(event) } }
}
