package com.hendraanggrian.ktfx.codegen.coroutines

import com.hendraanggrian.kotlinpoet.name
import com.hendraanggrian.ktfx.codegen.S
import com.hendraanggrian.ktfx.codegen.T
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.STAR
import javafx.animation.Animation
import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.geometry.Rectangle2D
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.ButtonBase
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ComboBoxBase
import javafx.scene.control.ContextMenu
import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import javafx.scene.control.ListView
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.Tab
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import javafx.scene.control.TreeView
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
import javafx.scene.media.Media
import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import javafx.scene.transform.Transform
import javafx.scene.transform.TransformChangedEvent
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import javafx.stage.PopupWindow
import javafx.stage.Window
import javafx.stage.WindowEvent

val CoroutinesFactory.Companion.JavaFx: CoroutinesFactory
    get() =
        CoroutinesFactory(
            "ktfx-coroutines/src/main/kotlin",
            "ktfx.coroutines",
            "KtfxCoroutinesKt",
        ).apply { initJavaFx() }

private fun ListenerFactory.initJavaFx() {
    // javafx.animation
    Animation::class { "setOnFinished" { action<ActionEvent>() } }
    // javafx.concurrent
    (Service::class.name.parameterizedBy(STAR)) {
        "setOnReady" { action<WorkerStateEvent>() }
        "setOnScheduled" { action<WorkerStateEvent>() }
        "setOnRunning" { action<WorkerStateEvent>() }
        "setOnSucceeded" { action<WorkerStateEvent>() }
        "setOnCancelled" { action<WorkerStateEvent>() }
        "setOnFailed" { action<WorkerStateEvent>() }
    }
    (Task::class.name.parameterizedBy(STAR)) {
        "setOnScheduled" { action<WorkerStateEvent>() }
        "setOnRunning" { action<WorkerStateEvent>() }
        "setOnSucceeded" { action<WorkerStateEvent>() }
        "setOnCancelled" { action<WorkerStateEvent>() }
        "setOnFailed" { action<WorkerStateEvent>() }
    }
    // javafx.scene
    Node::class {
        "setOnDragEntered" { action<DragEvent>() }
        "setOnDragExited" { action<DragEvent>() }
        "setOnDragOver" { action<DragEvent>() }
        "setOnDragDropped" { action<DragEvent>() }
        "setOnDragDone" { action<DragEvent>() }
        "setOnContextMenuRequested" { action<ContextMenuEvent>() }
        "setOnMouseClicked" { action<MouseEvent>() }
        "setOnMouseDragged" { action<MouseEvent>() }
        "setOnMouseEntered" { action<MouseEvent>() }
        "setOnMouseExited" { action<MouseEvent>() }
        "setOnMouseMoved" { action<MouseEvent>() }
        "setOnMousePressed" { action<MouseEvent>() }
        "setOnMouseReleased" { action<MouseEvent>() }
        "setOnDragDetected" { action<MouseEvent>() }
        "setOnMouseDragOver" { action<MouseDragEvent>() }
        "setOnMouseDragReleased" { action<MouseDragEvent>() }
        "setOnMouseDragEntered" { action<MouseDragEvent>() }
        "setOnMouseDragExited" { action<MouseDragEvent>() }
        "setOnScrollStarted" { action<ScrollEvent>() }
        "setOnScroll" { action<ScrollEvent>() }
        "setOnScrollFinished" { action<ScrollEvent>() }
        "setOnRotationStarted" { action<RotateEvent>() }
        "setOnRotate" { action<RotateEvent>() }
        "setOnRotationFinished" { action<RotateEvent>() }
        "setOnZoomStarted" { action<ZoomEvent>() }
        "setOnZoom" { action<ZoomEvent>() }
        "setOnZoomFinished" { action<ZoomEvent>() }
        "setOnSwipeUp" { action<SwipeEvent>() }
        "setOnSwipeDown" { action<SwipeEvent>() }
        "setOnSwipeLeft" { action<SwipeEvent>() }
        "setOnSwipeRight" { action<SwipeEvent>() }
        "setOnTouchPressed" { action<TouchEvent>() }
        "setOnTouchMoved" { action<TouchEvent>() }
        "setOnTouchReleased" { action<TouchEvent>() }
        "setOnTouchStationary" { action<TouchEvent>() }
        "setOnKeyPressed" { action<KeyEvent>() }
        "setOnKeyReleased" { action<KeyEvent>() }
        "setOnKeyTyped" { action<KeyEvent>() }
        "setOnInputMethodTextChanged" { action<InputMethodEvent>() }
    }
    Scene::class {
        "setOnMouseClicked" { action<MouseEvent>() }
        "setOnMouseDragged" { action<MouseEvent>() }
        "setOnMouseEntered" { action<MouseEvent>() }
        "setOnMouseExited" { action<MouseEvent>() }
        "setOnMouseMoved" { action<MouseEvent>() }
        "setOnMousePressed" { action<MouseEvent>() }
        "setOnMouseReleased" { action<MouseEvent>() }
        "setOnDragDetected" { action<MouseEvent>() }
        "setOnMouseDragOver" { action<MouseDragEvent>() }
        "setOnMouseDragReleased" { action<MouseDragEvent>() }
        "setOnMouseDragEntered" { action<MouseDragEvent>() }
        "setOnMouseDragExited" { action<MouseDragEvent>() }
        "setOnScrollStarted" { action<ScrollEvent>() }
        "setOnScroll" { action<ScrollEvent>() }
        "setOnScrollFinished" { action<ScrollEvent>() }
        "setOnRotationStarted" { action<RotateEvent>() }
        "setOnRotate" { action<RotateEvent>() }
        "setOnRotationFinished" { action<RotateEvent>() }
        "setOnZoomStarted" { action<ZoomEvent>() }
        "setOnZoom" { action<ZoomEvent>() }
        "setOnZoomFinished" { action<ZoomEvent>() }
        "setOnSwipeUp" { action<SwipeEvent>() }
        "setOnSwipeDown" { action<SwipeEvent>() }
        "setOnSwipeLeft" { action<SwipeEvent>() }
        "setOnSwipeRight" { action<SwipeEvent>() }
        "setOnTouchPressed" { action<TouchEvent>() }
        "setOnTouchMoved" { action<TouchEvent>() }
        "setOnTouchReleased" { action<TouchEvent>() }
        "setOnTouchStationary" { action<TouchEvent>() }
        "setOnDragEntered" { action<DragEvent>() }
        "setOnDragExited" { action<DragEvent>() }
        "setOnDragOver" { action<DragEvent>() }
        "setOnDragDropped" { action<DragEvent>() }
        "setOnDragDone" { action<DragEvent>() }
        "setOnKeyPressed" { action<KeyEvent>() }
        "setOnKeyReleased" { action<KeyEvent>() }
        "setOnKeyTyped" { action<KeyEvent>() }
        "setOnInputMethodTextChanged" { action<InputMethodEvent>() }
        "setOnContextMenuRequested" { action<ContextMenuEvent>() }
    }
    // javafx.scene.control
    ButtonBase::class { "setOnAction" { action<ActionEvent>() } }
    (ChoiceBox::class.name.parameterizedBy(STAR)) {
        "setOnAction" { action<ActionEvent>() }
        "setOnShowing" { action<Event>() }
        "setOnShown" { action<Event>() }
        "setOnHiding" { action<Event>() }
        "setOnHidden" { action<Event>() }
    }
    (ComboBoxBase::class.name.parameterizedBy(STAR)) {
        "setOnAction" { action<ActionEvent>() }
        "setOnShowing" { action<Event>() }
        "setOnShown" { action<Event>() }
        "setOnHiding" { action<Event>() }
        "setOnHidden" { action<Event>() }
    }
    ContextMenu::class { "setOnAction" { action<ActionEvent>() } }
    (Dialog::class.name.parameterizedBy(STAR)) {
        "setOnShowing" { action<DialogEvent>() }
        "setOnShown" { action<DialogEvent>() }
        "setOnHiding" { action<DialogEvent>() }
        "setOnHidden" { action<DialogEvent>() }
        "setOnCloseRequest" { action<DialogEvent>() }
    }
    (ListView::class.name.parameterizedBy(T)) {
        val event = ListView.EditEvent::class.name.parameterizedBy(T)
        "setOnEditStart" { action(event) }
        "setOnEditCommit" { action(event) }
        "setOnEditCancel" { action(event) }
        "setOnScrollTo" { action(ScrollToEvent::class.parameterizedBy(Int::class)) }
    }
    Menu::class {
        "setOnShowing" { action<Event>() }
        "setOnShown" { action<Event>() }
        "setOnHiding" { action<Event>() }
        "setOnHidden" { action<Event>() }
    }
    MenuItem::class {
        "setOnAction" { action<ActionEvent>() }
        "setOnMenuValidation" { action<Event>() }
    }
    Tab::class {
        "setOnSelectionChanged" { action<Event>() }
        "setOnClosed" { action<Event>() }
        "setOnCloseRequest" { action<Event>() }
    }
    (TableColumn::class.name.parameterizedBy(S, T)) {
        val event = TableColumn.CellEditEvent::class.name.parameterizedBy(S, T)
        "setOnEditStart" { action(event) }
        "setOnEditCommit" { action(event) }
        "setOnEditCancel" { action(event) }
    }
    (TableView::class.name.parameterizedBy(S)) {
        "setOnSort" {
            action(
                SortEvent::class.name
                    .parameterizedBy(TableView::class.name.parameterizedBy(S)),
            )
        }
        "setOnScrollTo" { action(ScrollToEvent::class.parameterizedBy(Int::class)) }
        "setOnScrollToColumn" {
            action(
                ScrollToEvent::class.name
                    .parameterizedBy(TableColumn::class.name.parameterizedBy(S, STAR)),
            )
        }
    }
    TextField::class { "setOnAction" { action<ActionEvent>() } }
    (TreeTableColumn::class.name.parameterizedBy(S, T)) {
        val event = TreeTableColumn.CellEditEvent::class.name.parameterizedBy(S, T)
        "setOnEditStart" { action(event) }
        "setOnEditCommit" { action(event) }
        "setOnEditCancel" { action(event) }
    }
    (TreeTableView::class.name.parameterizedBy(T)) {
        "setOnSort" {
            action(
                SortEvent::class.name
                    .parameterizedBy(TreeTableView::class.name.parameterizedBy(T)),
            )
        }
        "setOnScrollTo" { action(ScrollToEvent::class.parameterizedBy(Int::class)) }
        "setOnScrollToColumn" {
            action(
                ScrollToEvent::class.name
                    .parameterizedBy(TreeTableColumn::class.name.parameterizedBy(T, STAR)),
            )
        }
    }
    (TreeView::class.name.parameterizedBy(T)) {
        val event = TreeView.EditEvent::class.name.parameterizedBy(T)
        "setOnEditStart" { action(event) }
        "setOnEditCommit" { action(event) }
        "setOnEditCancel" { action(event) }
        "setOnScrollTo" { action(ScrollToEvent::class.parameterizedBy(Int::class)) }
    }
    // javafx.scene.media
    Media::class { "setOnError" { action(*emptyArray()) } }
    MediaPlayer::class {
        "setOnError" { action(*emptyArray()) }
        "setOnMarker" { action<MediaMarkerEvent>() }
        "setOnEndOfMedia" { action(*emptyArray()) }
        "setOnReady" { action(*emptyArray()) }
        "setOnPlaying" { action(*emptyArray()) }
        "setOnPaused" { action(*emptyArray()) }
        "setOnStopped" { action(*emptyArray()) }
        "setOnHalted" { action(*emptyArray()) }
        "setOnRepeat" { action(*emptyArray()) }
        "setOnStalled" { action(*emptyArray()) }
    }
    MediaView::class { "setOnError" { action<MediaErrorEvent>() } }
    // javafx.scene.web
    WebEngine::class {
        "setOnAlert" { action(WebEvent::class.parameterizedBy(String::class)) }
        "setOnStatusChanged" { action(WebEvent::class.parameterizedBy(String::class)) }
        "setOnResized" { action(WebEvent::class.parameterizedBy(Rectangle2D::class)) }
        "setOnVisibilityChanged" { action(WebEvent::class.parameterizedBy(Boolean::class)) }
        "setOnError" { action<WebErrorEvent>() }
    }
    // javafx.scene.transform
    Transform::class { "setOnTransformChanged" { action<TransformChangedEvent>() } }
    // javafx.stage
    PopupWindow::class { "setOnAutoHide" { action<Event>() } }
    Window::class {
        "setOnCloseRequest" { action<WindowEvent>() }
        "setOnShowing" { action<WindowEvent>() }
        "setOnShown" { action<WindowEvent>() }
        "setOnHiding" { action<WindowEvent>() }
        "setOnHidden" { action<WindowEvent>() }
    }
}
