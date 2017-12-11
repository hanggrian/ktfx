package kotfx.layouts.nodes

import javafx.beans.property.*
import javafx.collections.ObservableList
import javafx.event.EventHandler
import javafx.geometry.Bounds
import javafx.geometry.Orientation
import javafx.geometry.Point2D
import javafx.geometry.Point3D
import javafx.scene.*
import javafx.scene.effect.BlendMode
import javafx.scene.effect.Effect
import javafx.scene.input.DragEvent
import javafx.scene.input.TransferMode
import javafx.scene.transform.Transform
import kotfx.internal.Instanced

interface NodeBuilder<out T : Node> : Instanced<T> {

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
    fun onDragEntered(action: (DragEvent) -> Unit) = t.setOnDragEntered(action)

    val onDragExitedProperty: ObjectProperty<EventHandler<in DragEvent>> get() = t.onDragExitedProperty()
    fun onDragExited(action: (DragEvent) -> Unit) = t.setOnDragExited(action)

    val onDragOverProperty: ObjectProperty<EventHandler<in DragEvent>> get() = t.onDragOverProperty()
    fun onDragOver(action: (DragEvent) -> Unit) = t.setOnDragOver(action)

    val onDragDroppedProperty: ObjectProperty<EventHandler<in DragEvent>> get() = t.onDragDroppedProperty()
    fun onDragDropped(action: (DragEvent) -> Unit) = t.setOnDragDropped(action)

    val onDragDoneProperty: ObjectProperty<EventHandler<in DragEvent>> get() = t.onDragDoneProperty()
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



}