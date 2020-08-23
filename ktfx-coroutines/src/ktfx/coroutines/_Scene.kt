@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.Scene
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
 * @see Scene.setOnMouseClicked
 */
fun Scene.onMouseClicked(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseClicked { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnMouseDragged
 */
fun Scene.onMouseDragged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseDragged { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnMouseEntered
 */
fun Scene.onMouseEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseEntered { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnMouseExited
 */
fun Scene.onMouseExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseExited { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnMouseMoved
 */
fun Scene.onMouseMoved(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseMoved { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnMousePressed
 */
fun Scene.onMousePressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMousePressed { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnMouseReleased
 */
fun Scene.onMouseReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnMouseReleased { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnDragDetected
 */
fun Scene.onDragDetected(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseEvent) -> Unit
) {
    return setOnDragDetected { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnMouseDragOver
 */
fun Scene.onMouseDragOver(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
) {
    return setOnMouseDragOver { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnMouseDragReleased
 */
fun Scene.onMouseDragReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
) {
    return setOnMouseDragReleased { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnMouseDragEntered
 */
fun Scene.onMouseDragEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
) {
    return setOnMouseDragEntered { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnMouseDragExited
 */
fun Scene.onMouseDragExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MouseDragEvent) -> Unit
) {
    return setOnMouseDragExited { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnScrollStarted
 */
fun Scene.onScrollStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ScrollEvent) -> Unit
) {
    return setOnScrollStarted { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnScroll
 */
fun Scene.onScroll(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ScrollEvent) -> Unit
) {
    return setOnScroll { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnScrollFinished
 */
fun Scene.onScrollFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ScrollEvent) -> Unit
) {
    return setOnScrollFinished { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnRotationStarted
 */
fun Scene.onRotationStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(RotateEvent) -> Unit
) {
    return setOnRotationStarted { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnRotate
 */
fun Scene.onRotate(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(RotateEvent) -> Unit
) {
    return setOnRotate { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnRotationFinished
 */
fun Scene.onRotationFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(RotateEvent) -> Unit
) {
    return setOnRotationFinished { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnZoomStarted
 */
fun Scene.onZoomStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ZoomEvent) -> Unit
) {
    return setOnZoomStarted { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnZoom
 */
fun Scene.onZoom(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ZoomEvent) -> Unit
) {
    return setOnZoom { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnZoomFinished
 */
fun Scene.onZoomFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ZoomEvent) -> Unit
) {
    return setOnZoomFinished { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnSwipeUp
 */
fun Scene.onSwipeUp(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
) {
    return setOnSwipeUp { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnSwipeDown
 */
fun Scene.onSwipeDown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
) {
    return setOnSwipeDown { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnSwipeLeft
 */
fun Scene.onSwipeLeft(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
) {
    return setOnSwipeLeft { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnSwipeRight
 */
fun Scene.onSwipeRight(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(SwipeEvent) -> Unit
) {
    return setOnSwipeRight { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnTouchPressed
 */
fun Scene.onTouchPressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
) {
    return setOnTouchPressed { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnTouchMoved
 */
fun Scene.onTouchMoved(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
) {
    return setOnTouchMoved { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnTouchReleased
 */
fun Scene.onTouchReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
) {
    return setOnTouchReleased { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnTouchStationary
 */
fun Scene.onTouchStationary(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(TouchEvent) -> Unit
) {
    return setOnTouchStationary { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnDragEntered
 */
fun Scene.onDragEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
) {
    return setOnDragEntered { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnDragExited
 */
fun Scene.onDragExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
) {
    return setOnDragExited { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnDragOver
 */
fun Scene.onDragOver(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
) {
    return setOnDragOver { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnDragDropped
 */
fun Scene.onDragDropped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
) {
    return setOnDragDropped { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnDragDone
 */
fun Scene.onDragDone(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DragEvent) -> Unit
) {
    return setOnDragDone { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnKeyPressed
 */
fun Scene.onKeyPressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(KeyEvent) -> Unit
) {
    return setOnKeyPressed { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnKeyReleased
 */
fun Scene.onKeyReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(KeyEvent) -> Unit
) {
    return setOnKeyReleased { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnKeyTyped
 */
fun Scene.onKeyTyped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(KeyEvent) -> Unit
) {
    return setOnKeyTyped { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnInputMethodTextChanged
 */
fun Scene.onInputMethodTextChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(InputMethodEvent) -> Unit
) {
    return setOnInputMethodTextChanged { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Scene.setOnContextMenuRequested
 */
fun Scene.onContextMenuRequested(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ContextMenuEvent) -> Unit
) {
    return setOnContextMenuRequested { event -> GlobalScope.launch(context) { action(event) } }
}
