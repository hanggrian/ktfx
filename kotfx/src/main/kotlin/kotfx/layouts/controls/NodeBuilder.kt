package kotfx.layouts.controls

import javafx.beans.property.*
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.event.Event
import javafx.event.EventDispatcher
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.geometry.*
import javafx.scene.*
import javafx.scene.effect.BlendMode
import javafx.scene.effect.Effect
import javafx.scene.input.*
import javafx.scene.transform.Transform
import kotfx.internal.Instanced

interface NodeBuilder<out T : Node> : Instanced<T> {

    val properties: ObservableMap<Any, Any> get() = t.properties
    val hasProperties: Boolean get() = t.hasProperties()

    var data: Any
        get() = t.userData
        set(value) = t.setUserData(value)

    val parentProperty: ReadOnlyObjectProperty<Parent> get() = t.parentProperty()
    val parent: Parent get() = t.parent

    val sceneProperty: ReadOnlyObjectProperty<Scene> get() = t.sceneProperty()
    val scene: Scene get() = t.scene

    val idProperty: StringProperty get() = t.idProperty()
    var id: String
        get() = t.id
        set(value) = t.setId(value)

    val styleProperty: StringProperty get() = t.styleProperty()
    var style: String
        get() = t.style
        set(value) = t.setStyle(value)

    val visibleProperty: BooleanProperty get() = t.visibleProperty()
    var isVisible: Boolean
        get() = t.isVisible
        set(value) = t.setVisible(value)

    val cursorProperty: ObjectProperty<Cursor> get() = t.cursorProperty()
    var cursor: Cursor
        get() = t.cursor
        set(value) = t.setCursor(value)

    val opacityProperty: DoubleProperty get() = t.opacityProperty()
    var opacity: Double
        get() = t.opacity
        set(value) = t.setOpacity(value)

    val blendProperty: ObjectProperty<BlendMode> get() = t.blendModeProperty()
    var blend: BlendMode
        get() = t.blendMode
        set(value) = t.setBlendMode(value)

    val clipProperty: ObjectProperty<Node> get() = t.clipProperty()
    var clip: Node
        get() = t.clip
        set(value) = t.setClip(value)

    val cacheProperty: BooleanProperty get() = t.cacheProperty()
    var isCache: Boolean
        get() = t.isCache
        set(value) = t.setCache(value)

    val cacheHintProperty: ObjectProperty<CacheHint> get() = t.cacheHintProperty()
    var cacheHint: CacheHint
        get() = t.cacheHint
        set(value) = t.setCacheHint(value)

    val effectProperty: ObjectProperty<Effect> get() = t.effectProperty()
    var effect: Effect
        get() = t.effect
        set(value) = t.setEffect(value)

    val depthTestProperty: ObjectProperty<DepthTest> get() = t.depthTestProperty()
    var depthTest: DepthTest
        get() = t.depthTest
        set(value) = t.setDepthTest(value)

    val disableProperty: BooleanProperty get() = t.disableProperty()
    var isDisable: Boolean
        get() = t.isDisable
        set(value) = t.setDisable(value)

    val pickOnBoundsProperty: BooleanProperty get() = t.pickOnBoundsProperty()
    var isPickOnBounds: Boolean
        get() = t.isPickOnBounds
        set(value) = t.setPickOnBounds(value)

    val disabledProperty: ReadOnlyBooleanProperty get() = t.disabledProperty()
    val isDisabled: Boolean get() = t.isDisabled

    fun lookup(selector: String): Node = t.lookup(selector)
    fun lookupAll(selector: String): Set<Node> = t.lookupAll(selector)

    fun toBack() = t.toBack()
    fun toFront() = t.toBack()

    val onDragEnteredProperty: ObjectProperty<EventHandler<in DragEvent>> get() = t.onDragEnteredProperty()
    val onDragEntered: EventHandler<in DragEvent> get() = t.onDragEntered
    fun onDragEntered(action: (DragEvent) -> Unit) = t.setOnDragEntered(action)

    val onDragExitedProperty: ObjectProperty<EventHandler<in DragEvent>> get() = t.onDragExitedProperty()
    val onDragExited: EventHandler<in DragEvent> get() = t.onDragExited
    fun onDragExited(action: (DragEvent) -> Unit) = t.setOnDragExited(action)

    val onDragOverProperty: ObjectProperty<EventHandler<in DragEvent>> get() = t.onDragOverProperty()
    val onDragOver: EventHandler<in DragEvent> get() = t.onDragOver
    fun onDragOver(action: (DragEvent) -> Unit) = t.setOnDragOver(action)

    val onDragDroppedProperty: ObjectProperty<EventHandler<in DragEvent>> get() = t.onDragDroppedProperty()
    val onDragDropped: EventHandler<in DragEvent> get() = t.onDragDropped
    fun onDragDropped(action: (DragEvent) -> Unit) = t.setOnDragDropped(action)

    val onDragDoneProperty: ObjectProperty<EventHandler<in DragEvent>> get() = t.onDragDoneProperty()
    val onDragDone: EventHandler<in DragEvent> get() = t.onDragDone
    fun onDragDone(action: (DragEvent) -> Unit) = t.setOnDragDone(action)

    fun dragAndDrop(vararg modes: TransferMode) = t.startDragAndDrop(*modes)
    fun fullDrag() = t.startFullDrag()

    val managedProperty: BooleanProperty get() = t.managedProperty()
    var isManaged: Boolean
        get() = t.isManaged
        set(value) = t.setManaged(value)

    val layoutXProperty: DoubleProperty get() = t.layoutXProperty()
    var layoutX: Double
        get() = t.layoutX
        set(value) = t.setLayoutX(value)

    val layoutYProperty: DoubleProperty get() = t.layoutYProperty()
    var layoutY: Double
        get() = t.layoutY
        set(value) = t.setLayoutY(value)

    fun position(x: Double, y: Double) {
        layoutX = x
        layoutY = y
    }

    val isResizable: Boolean get() = t.isResizable
    val contentBias: Orientation? get() = t.contentBias

    fun minWidth(width: Double) = t.minWidth(width)
    fun minHeight(height: Double) = t.minHeight(height)

    fun prefWidth(width: Double) = t.prefWidth(width)
    fun prefHeight(height: Double) = t.prefHeight(height)

    fun maxWidth(width: Double) = t.maxWidth(width)
    fun maxHeight(height: Double) = t.maxHeight(height)

    fun resize(width: Double, height: Double) = t.resize(width, height)
    fun autoSize() = t.autosize()

    fun resizeRelocate(x: Double, y: Double, width: Double, height: Double) = t.resizeRelocate(x, y, width, height)
    val baselineOffset: Double get() = t.baselineOffset
    fun computeAreaInScreen() = t.computeAreaInScreen()

    val boundsInParentProperty: ReadOnlyObjectProperty<Bounds> get() = t.boundsInParentProperty()
    val boundsInParent: Bounds get() = t.boundsInParent

    val boundsInLocalProperty: ReadOnlyObjectProperty<Bounds> get() = t.boundsInLocalProperty()
    val boundsInLocal: Bounds get() = t.boundsInLocal

    val layoutBoundsProperty: ReadOnlyObjectProperty<Bounds> get() = t.layoutBoundsProperty()
    val layoutBounds: Bounds get() = t.layoutBounds

    fun contains(localPoint: Point2D): Boolean = t.contains(localPoint)

    fun intersects(localX: Double, localY: Double, localWidth: Double, localHeight: Double): Boolean = t.intersects(localX, localY, localWidth, localHeight)
    fun intersects(localBounds: Bounds): Boolean = t.intersects(localBounds)

    fun screenToLocal(screenX: Double, screenY: Double): Point2D = t.screenToLocal(screenX, screenY)
    fun screenToLocal(screenPoint: Point2D): Point2D = t.screenToLocal(screenPoint)
    fun screenToLocal(screenBounds: Bounds): Bounds = t.screenToLocal(screenBounds)

    fun sceneToLocal(x: Double, y: Double, rootScene: Boolean): Point2D = t.sceneToLocal(x, y, rootScene)
    fun sceneToLocal(point: Point2D, rootScene: Boolean): Point2D = t.sceneToLocal(point, rootScene)
    fun sceneToLocal(bounds: Bounds, rootScene: Boolean): Bounds = t.sceneToLocal(bounds, rootScene)
    fun sceneToLocal(sceneX: Double, sceneY: Double): Point2D = t.sceneToLocal(sceneX, sceneY)
    fun sceneToLocal(scenePoint: Point2D): Point2D = t.sceneToLocal(scenePoint)
    fun sceneToLocal(scenePoint: Point3D): Point3D = t.sceneToLocal(scenePoint)
    fun sceneToLocal(sceneX: Double, sceneY: Double, sceneZ: Double): Point3D = t.sceneToLocal(sceneX, sceneY, sceneZ)
    fun sceneToLocal(bounds: Bounds): Bounds = t.sceneToLocal(bounds)

    fun localToScreen(localX: Double, localY: Double): Point2D = t.localToScreen(localX, localY)
    fun localToScreen(localPoint: Point2D): Point2D = t.localToScreen(localPoint)
    fun localToScreen(localX: Double, localY: Double, localZ: Double): Point2D = t.localToScreen(localX, localY, localZ)
    fun localToScreen(localPoint: Point3D): Point2D = t.localToScreen(localPoint)
    fun localToScreen(localBounds: Bounds): Bounds = t.localToScreen(localBounds)

    fun localToScene(localX: Double, localY: Double): Point2D = t.localToScene(localX, localY)
    fun localToScene(localPoint: Point2D): Point2D = t.localToScene(localPoint)
    fun localToScene(localPoint: Point3D): Point3D = t.localToScene(localPoint)
    fun localToScene(x: Double, y: Double, z: Double): Point3D = t.localToScene(x, y, z)
    fun localToScene(localPoint: Point3D, rootScene: Boolean): Point3D = t.localToScene(localPoint, rootScene)
    fun localToScene(x: Double, y: Double, z: Double, rootScene: Boolean): Point3D = t.localToScene(x, y, z, rootScene)
    fun localToScene(localPoint: Point2D, rootScene: Boolean): Point2D = t.localToScene(localPoint, rootScene)
    fun localToScene(x: Double, y: Double, rootScene: Boolean): Point2D = t.localToScene(x, y, rootScene)
    fun localToScene(localBounds: Bounds, rootScene: Boolean): Bounds = t.localToScene(localBounds, rootScene)
    fun localToScene(localBounds: Bounds): Bounds = t.localToScene(localBounds)

    fun parentToLocal(parentX: Double, parentY: Double): Point2D = t.parentToLocal(parentX, parentY)
    fun parentToLocal(parentPoint: Point2D): Point2D = t.parentToLocal(parentPoint)
    fun parentToLocal(parentPoint: Point3D): Point3D = t.parentToLocal(parentPoint)
    fun parentToLocal(parentX: Double, parentY: Double, parentZ: Double): Point3D = t.parentToLocal(parentX, parentY, parentZ)
    fun parentToLocal(parentBounds: Bounds): Bounds = t.parentToLocal(parentBounds)

    fun localToParent(localX: Double, localY: Double): Point2D = t.localToParent(localX, localY)
    fun localToParent(localPoint: Point2D): Point2D = t.localToParent(localPoint)
    fun localToParent(localPoint: Point3D): Point3D = t.localToParent(localPoint)
    fun localToParent(x: Double, y: Double, z: Double): Point3D = t.localToParent(x, y, z)
    fun localToParent(localBounds: Bounds): Bounds = t.localToParent(localBounds)

    val transforms: ObservableList<Transform> get() = t.transforms

    val translateXProperty: DoubleProperty get() = t.translateXProperty()
    var translateX: Double
        get() = t.translateX
        set(value) = t.setTranslateX(value)

    val translateYProperty: DoubleProperty get() = t.translateYProperty()
    var translateY: Double
        get() = t.translateY
        set(value) = t.setTranslateY(value)

    val translateZProperty: DoubleProperty get() = t.translateZProperty()
    var translateZ: Double
        get() = t.translateZ
        set(value) = t.setTranslateZ(value)

    val scaleXProperty: DoubleProperty get() = t.scaleXProperty()
    var scaleX: Double
        get() = t.scaleX
        set(value) = t.setScaleX(value)

    val scaleYProperty: DoubleProperty get() = t.scaleYProperty()
    var scaleY: Double
        get() = t.scaleY
        set(value) = t.setScaleY(value)

    val scaleZProperty: DoubleProperty get() = t.scaleZProperty()
    var scaleZ: Double
        get() = t.scaleZ
        set(value) = t.setScaleZ(value)

    val rotateProperty: DoubleProperty get() = t.rotateProperty()
    var rotate: Double
        get() = t.rotate
        set(value) = t.setRotate(value)

    val rotationAxisProperty: ObjectProperty<Point3D> get() = t.rotationAxisProperty()
    var rotationAxis: Point3D
        get() = t.rotationAxis
        set(value) = t.setRotationAxis(value)

    val localToParentTransformProperty: ReadOnlyObjectProperty<Transform> get() = t.localToParentTransformProperty()
    val localToParentTransform: Transform get() = t.localToParentTransform

    val localToSceneTransformProperty: ReadOnlyObjectProperty<Transform> get() = t.localToSceneTransformProperty()
    val localToSceneTransform: Transform get() = t.localToSceneTransform

    val nodeOrientationProperty: ObjectProperty<NodeOrientation> get() = t.nodeOrientationProperty()
    var nodeOrientation: NodeOrientation
        get() = t.nodeOrientation
        set(value) = t.setNodeOrientation(value)

    val effectiveNodeOrientationProperty: ReadOnlyObjectProperty<NodeOrientation> get() = t.effectiveNodeOrientationProperty()
    val effectiveNodeOrientation: NodeOrientation get() = t.effectiveNodeOrientation

    val usesMirroring: Boolean get() = t.usesMirroring()

    val mouseTransparentProperty: BooleanProperty get() = t.mouseTransparentProperty()
    var isMouseTransparent: Boolean
        get() = t.isMouseTransparent
        set(value) = t.setMouseTransparent(value)

    val hoverProperty: ReadOnlyBooleanProperty get() = t.hoverProperty()
    val isHover: Boolean get() = t.isHover

    val pressedProperty: ReadOnlyBooleanProperty get() = t.pressedProperty()
    val isPressed: Boolean get() = t.isPressed

    val onContextMenuRequestedProperty: ObjectProperty<EventHandler<in ContextMenuEvent>> get() = t.onContextMenuRequestedProperty()
    val onContextMenuRequested: EventHandler<in ContextMenuEvent> get() = t.onContextMenuRequested
    fun onContextMenuRequested(action: (ContextMenuEvent) -> Unit) = t.setOnContextMenuRequested(action)

    val onMouseClickedProperty: ObjectProperty<EventHandler<in MouseEvent>> get() = t.onMouseClickedProperty()
    val onMouseClicked: EventHandler<in MouseEvent> get() = t.onMouseClicked
    fun onMouseClicked(action: (MouseEvent) -> Unit) = t.setOnMouseClicked(action)

    val onMouseDraggedProperty: ObjectProperty<EventHandler<in MouseEvent>> get() = t.onMouseDraggedProperty()
    val onMouseDragged: EventHandler<in MouseEvent> get() = t.onMouseDragged
    fun onMouseDragged(action: (MouseEvent) -> Unit) = t.setOnMouseDragged(action)

    val onMouseEnteredProperty: ObjectProperty<EventHandler<in MouseEvent>> get() = t.onMouseEnteredProperty()
    val onMouseEntered: EventHandler<in MouseEvent> get() = t.onMouseEntered
    fun onMouseEntered(action: (MouseEvent) -> Unit) = t.setOnMouseEntered(action)

    val onMouseExitedProperty: ObjectProperty<EventHandler<in MouseEvent>> get() = t.onMouseExitedProperty()
    val onMouseExited: EventHandler<in MouseEvent> get() = t.onMouseExited
    fun onMouseExited(action: (MouseEvent) -> Unit) = t.setOnMouseExited(action)

    val onMouseMovedProperty: ObjectProperty<EventHandler<in MouseEvent>> get() = t.onMouseMovedProperty()
    val onMouseMoved: EventHandler<in MouseEvent> get() = t.onMouseMoved
    fun onMouseMoved(action: (MouseEvent) -> Unit) = t.setOnMouseMoved(action)

    val onMousePressedProperty: ObjectProperty<EventHandler<in MouseEvent>> get() = t.onMousePressedProperty()
    val onMousePressed: EventHandler<in MouseEvent> get() = t.onMousePressed
    fun onMousePressed(action: (MouseEvent) -> Unit) = t.setOnMousePressed(action)

    val onMouseReleasedProperty: ObjectProperty<EventHandler<in MouseEvent>> get() = t.onMouseReleasedProperty()
    val onMouseReleased: EventHandler<in MouseEvent> get() = t.onMouseReleased
    fun onMouseReleased(action: (MouseEvent) -> Unit) = t.setOnMouseReleased(action)

    val onDragDetectedProperty: ObjectProperty<EventHandler<in MouseEvent>> get() = t.onDragDetectedProperty()
    val onDragDetected: EventHandler<in MouseEvent> get() = t.onDragDetected
    fun onDragDetected(action: (MouseEvent) -> Unit) = t.setOnDragDetected(action)

    val onMouseDragOverProperty: ObjectProperty<EventHandler<in MouseDragEvent>> get() = t.onMouseDragOverProperty()
    val onMouseDragOver: EventHandler<in MouseDragEvent> get() = t.onMouseDragOver
    fun onMouseDragOver(action: (MouseDragEvent) -> Unit) = t.setOnMouseDragOver(action)

    val onMouseDragReleasedProperty: ObjectProperty<EventHandler<in MouseDragEvent>> get() = t.onMouseDragReleasedProperty()
    val onMouseDragReleased: EventHandler<in MouseDragEvent> get() = t.onMouseDragReleased
    fun onMouseDragReleased(action: (MouseDragEvent) -> Unit) = t.setOnMouseDragReleased(action)

    val onMouseDragEnteredProperty: ObjectProperty<EventHandler<in MouseDragEvent>> get() = t.onMouseDragEnteredProperty()
    val onMouseDragEntered: EventHandler<in MouseDragEvent> get() = t.onMouseDragEntered
    fun onMouseDragEntered(action: (MouseDragEvent) -> Unit) = t.setOnMouseDragEntered(action)

    val onMouseDragExitedProperty: ObjectProperty<EventHandler<in MouseDragEvent>> get() = t.onMouseDragExitedProperty()
    val onMouseDragExited: EventHandler<in MouseDragEvent> get() = t.onMouseDragExited
    fun onMouseDragExited(action: (MouseDragEvent) -> Unit) = t.setOnMouseDragExited(action)

    val onScrollStartedProperty: ObjectProperty<EventHandler<in ScrollEvent>> get() = t.onScrollStartedProperty()
    val onScrollStarted: EventHandler<in ScrollEvent> get() = t.onScrollStarted
    fun onScrollStarted(action: (ScrollEvent) -> Unit) = t.setOnScrollStarted(action)

    val onScrollProperty: ObjectProperty<EventHandler<in ScrollEvent>> get() = t.onScrollProperty()
    val onScroll: EventHandler<in ScrollEvent> get() = t.onScroll
    fun onScroll(action: (ScrollEvent) -> Unit) = t.setOnScroll(action)

    val onScrollFinishedProperty: ObjectProperty<EventHandler<in ScrollEvent>> get() = t.onScrollFinishedProperty()
    val onScrollFinished: EventHandler<in ScrollEvent> get() = t.onScrollFinished
    fun onScrollFinished(action: (ScrollEvent) -> Unit) = t.setOnScrollFinished(action)

    val onRotationStartedProperty: ObjectProperty<EventHandler<in RotateEvent>> get() = t.onRotationStartedProperty()
    val onRotationStarted: EventHandler<in RotateEvent> get() = t.onRotationStarted
    fun onRotationStarted(action: (RotateEvent) -> Unit) = t.setOnRotationStarted(action)

    val onRotateProperty: ObjectProperty<EventHandler<in RotateEvent>> get() = t.onRotateProperty()
    val onRotate: EventHandler<in RotateEvent> get() = t.onRotate
    fun onRotate(action: (RotateEvent) -> Unit) = t.setOnRotate(action)

    val onRotationFinishedProperty: ObjectProperty<EventHandler<in RotateEvent>> get() = t.onRotationFinishedProperty()
    val onRotationFinished: EventHandler<in RotateEvent> get() = t.onRotationFinished
    fun onRotationFinished(action: (RotateEvent) -> Unit) = t.setOnRotationFinished(action)

    val onZoomStartedProperty: ObjectProperty<EventHandler<in ZoomEvent>> get() = t.onZoomStartedProperty()
    val onZoomStarted: EventHandler<in ZoomEvent> get() = t.onZoomStarted
    fun onZoomStarted(action: (ZoomEvent) -> Unit) = t.setOnZoomStarted(action)

    val onZoomProperty: ObjectProperty<EventHandler<in ZoomEvent>> get() = t.onZoomProperty()
    val onZoom: EventHandler<in ZoomEvent> get() = t.onZoom
    fun onZoom(action: (ZoomEvent) -> Unit) = t.setOnZoom(action)

    val onZoomFinishedProperty: ObjectProperty<EventHandler<in ZoomEvent>> get() = t.onZoomFinishedProperty()
    val onZoomFinished: EventHandler<in ZoomEvent> get() = t.onZoomFinished
    fun onZoomFinished(action: (ZoomEvent) -> Unit) = t.setOnZoomFinished(action)

    val onSwipeUpProperty: ObjectProperty<EventHandler<in SwipeEvent>> get() = t.onSwipeUpProperty()
    val onSwipeUp: EventHandler<in SwipeEvent> get() = t.onSwipeUp
    fun onSwipeUp(action: (SwipeEvent) -> Unit) = t.setOnSwipeUp(action)

    val onSwipeDownProperty: ObjectProperty<EventHandler<in SwipeEvent>> get() = t.onSwipeDownProperty()
    val onSwipeDown: EventHandler<in SwipeEvent> get() = t.onSwipeDown
    fun onSwipeDown(action: (SwipeEvent) -> Unit) = t.setOnSwipeDown(action)

    val onSwipeLeftProperty: ObjectProperty<EventHandler<in SwipeEvent>> get() = t.onSwipeLeftProperty()
    val onSwipeLeft: EventHandler<in SwipeEvent> get() = t.onSwipeLeft
    fun onSwipeLeft(action: (SwipeEvent) -> Unit) = t.setOnSwipeLeft(action)

    val onSwipeRightProperty: ObjectProperty<EventHandler<in SwipeEvent>> get() = t.onSwipeRightProperty()
    val onSwipeRight: EventHandler<in SwipeEvent> get() = t.onSwipeRight
    fun onSwipeRight(action: (SwipeEvent) -> Unit) = t.setOnSwipeRight(action)

    val onTouchPressedProperty: ObjectProperty<EventHandler<in TouchEvent>> get() = t.onTouchPressedProperty()
    val onTouchPressed: EventHandler<in TouchEvent> get() = t.onTouchPressed
    fun onTouchPressed(action: (TouchEvent) -> Unit) = t.setOnTouchPressed(action)

    val onTouchMovedProperty: ObjectProperty<EventHandler<in TouchEvent>> get() = t.onTouchMovedProperty()
    val onTouchMoved: EventHandler<in TouchEvent> get() = t.onTouchMoved
    fun onTouchMoved(action: (TouchEvent) -> Unit) = t.setOnTouchMoved(action)

    val onTouchReleasedProperty: ObjectProperty<EventHandler<in TouchEvent>> get() = t.onTouchReleasedProperty()
    val onTouchReleased: EventHandler<in TouchEvent> get() = t.onTouchReleased
    fun onTouchReleased(action: (TouchEvent) -> Unit) = t.setOnTouchReleased(action)

    val onTouchStationaryProperty: ObjectProperty<EventHandler<in TouchEvent>> get() = t.onTouchStationaryProperty()
    val onTouchStationary: EventHandler<in TouchEvent> get() = t.onTouchStationary
    fun onTouchStationary(action: (TouchEvent) -> Unit) = t.setOnTouchStationary(action)

    val onKeyPressedProperty: ObjectProperty<EventHandler<in KeyEvent>> get() = t.onKeyPressedProperty()
    val onKeyPressed: EventHandler<in KeyEvent> get() = t.onKeyPressed
    fun onKeyPressed(action: (KeyEvent) -> Unit) = t.setOnKeyPressed(action)

    val onKeyReleasedProperty: ObjectProperty<EventHandler<in KeyEvent>> get() = t.onKeyReleasedProperty()
    val onKeyReleased: EventHandler<in KeyEvent> get() = t.onKeyReleased
    fun onKeyReleased(action: (KeyEvent) -> Unit) = t.setOnKeyReleased(action)

    val onKeyTypedProperty: ObjectProperty<EventHandler<in KeyEvent>> get() = t.onKeyTypedProperty()
    val onKeyTyped: EventHandler<in KeyEvent> get() = t.onKeyTyped
    fun onKeyTyped(action: (KeyEvent) -> Unit) = t.setOnKeyTyped(action)

    val onInputMethodTextChangedProperty: ObjectProperty<EventHandler<in InputMethodEvent>> get() = t.onInputMethodTextChangedProperty()
    val onInputMethodTextChanged: EventHandler<in InputMethodEvent> get() = t.onInputMethodTextChanged
    fun onInputMethodTextChanged(action: (InputMethodEvent) -> Unit) = t.setOnInputMethodTextChanged(action)

    val inputMethodRequestsProperty: ObjectProperty<InputMethodRequests> get() = t.inputMethodRequestsProperty()
    var inputMethodRequests: InputMethodRequests
        get() = t.inputMethodRequests
        set(value) = t.setInputMethodRequests(value)

    val focusedProperty: ReadOnlyBooleanProperty get() = t.focusedProperty()
    val isFocused: Boolean get() = t.isFocused

    val focusedTraversableProperty: BooleanProperty get() = t.focusTraversableProperty()
    var isFocusTraversable: Boolean
        get() = t.isFocusTraversable
        set(value) = t.setFocusTraversable(value)

    fun requestFocus() = t.requestFocus()

    val eventDispatcherProperty: ObjectProperty<EventDispatcher> get() = t.eventDispatcherProperty()
    var eventDispatcher: EventDispatcher
        get() = t.eventDispatcher
        set(value) = t.setEventDispatcher(value)

    fun <T : Event> addEventHandler(eventType: EventType<T>, eventHandler: EventHandler<in T>) = t.addEventHandler(eventType, eventHandler)
    fun <T : Event> removeEventHandler(eventType: EventType<T>, eventHandler: EventHandler<in T>) = t.addEventHandler(eventType, eventHandler)

    fun <T : Event> addEventFilter(eventType: EventType<T>, eventFilter: EventHandler<in T>) = t.addEventFilter(eventType, eventFilter)
    fun <T : Event> removeEventFilter(eventType: EventType<T>, eventFilter: EventHandler<in T>) = t.removeEventFilter(eventType, eventFilter)

    fun fireEvent(event: Event) = t.fireEvent(event)

    fun applyCss() = t.applyCss()

    val accessibleRoleProperty: ObjectProperty<AccessibleRole> get() = t.accessibleRoleProperty()
    var accessibleRole: AccessibleRole
        get() = t.accessibleRole
        set(value) = t.setAccessibleRole(value)

    val accessibleRoleDescriptionProperty: ObjectProperty<String> get() = t.accessibleRoleDescriptionProperty()
    var accessibleRoleDescription: String
        get() = t.accessibleRoleDescription
        set(value) = t.setAccessibleRoleDescription(value)

    val accessibleTextProperty: ObjectProperty<String> get() = t.accessibleTextProperty()
    var accessibleText: String
        get() = t.accessibleText
        set(value) = t.setAccessibleText(value)

    val accessibleHelpProperty: ObjectProperty<String> get() = t.accessibleHelpProperty()
    var accessibleHelp: String
        get() = t.accessibleHelp
        set(value) = t.setAccessibleHelp(value)

    fun queryAccessibleAttribute(attribute: AccessibleAttribute, vararg parameters: Any): Any? = t.queryAccessibleAttribute(attribute, *parameters)
    fun executeAccessibleAction(action: AccessibleAction, vararg parameters: Any) = t.executeAccessibleAction(action, *parameters)
    fun notifyAccessibleAttributeChanged(attribute: AccessibleAttribute) = t.notifyAccessibleAttributeChanged(attribute)
}