package kotfx.layouts.nodes

import javafx.beans.property.*
import javafx.event.EventHandler
import javafx.geometry.Orientation
import javafx.scene.*
import javafx.scene.effect.BlendMode
import javafx.scene.effect.Effect
import javafx.scene.input.DragEvent
import javafx.scene.input.TransferMode
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

    val layoutXProperty: ReadOnlyDoubleProperty get() = t.layoutXProperty()
    var layoutX: Double
        get() = t.layoutX
        set(value) = t.setLayoutX(value)

    val layoutYProperty: ReadOnlyDoubleProperty get() = t.layoutYProperty()
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


}