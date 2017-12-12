package kotfx.layouts

import javafx.beans.property.*
import javafx.geometry.Insets
import javafx.scene.layout.Background
import javafx.scene.layout.Border
import javafx.scene.layout.Region
import javafx.scene.shape.Shape

interface RegionBuilder<out T : Region> : ParentBuilder<T> {

    val snapToPixelProperty: BooleanProperty get() = t.snapToPixelProperty()
    var isSnapToPixel: Boolean
        get() = t.isSnapToPixel
        set(value) = t.setSnapToPixel(value)

    val paddingProperty: ObjectProperty<Insets> get() = t.paddingProperty()
    var padding: Insets
        get() = t.padding
        set(value) = t.setPadding(value)

    val backgroundProperty: ObjectProperty<Background> get() = t.backgroundProperty()
    var background: Background
        get() = t.background
        set(value) = t.setBackground(value)

    val borderProperty: ObjectProperty<Border> get() = t.borderProperty()
    var border: Border
        get() = t.border
        set(value) = t.setBorder(value)

    val opaqueInsetsProperty: ObjectProperty<Insets> get() = t.opaqueInsetsProperty()
    var opaqueInsets: Insets
        get() = t.opaqueInsets
        set(value) = t.setOpaqueInsets(value)

    val insetsProperty: ReadOnlyObjectProperty<Insets> get() = t.insetsProperty()
    val insets: Insets get() = t.insets

    val widthProperty: ReadOnlyDoubleProperty get() = t.widthProperty()
    val width: Double get() = t.width

    val heightProperty: ReadOnlyDoubleProperty get() = t.heightProperty()
    val height: Double get() = t.height

    val minWidthProperty: DoubleProperty get() = t.minWidthProperty()
    var minWidth: Double
        get() = t.minWidth
        set(value) = t.setMinWidth(value)

    val minHeightProperty: DoubleProperty get() = t.minHeightProperty()
    var minHeight: Double
        get() = t.minHeight
        set(value) = t.setMinHeight(value)

    fun setMinSize(minWidth: Double, minHeight: Double) = t.setMinSize(minWidth, minHeight)

    val prefWidthProperty: DoubleProperty get() = t.prefWidthProperty()
    var prefWidth: Double
        get() = t.prefWidth
        set(value) = t.setPrefWidth(value)

    val prefHeightProperty: DoubleProperty get() = t.prefHeightProperty()
    var prefHeight: Double
        get() = t.prefHeight
        set(value) = t.setPrefHeight(value)

    fun setPrefSize(prefWidth: Double, prefHeight: Double) = t.setPrefSize(prefWidth, prefHeight)

    val maxWidthProperty: DoubleProperty get() = t.maxWidthProperty()
    var maxWidth: Double
        get() = t.maxWidth
        set(value) = t.setMaxWidth(value)

    val maxHeightProperty: DoubleProperty get() = t.maxHeightProperty()
    var maxHeight: Double
        get() = t.maxHeight
        set(value) = t.setMaxHeight(value)

    fun setMaxSize(maxWidth: Double, maxHeight: Double) = t.setMinSize(maxWidth, maxHeight)

    val shapeProperty: ObjectProperty<Shape> get() = t.shapeProperty()
    var shape: Shape
        get() = t.shape
        set(value) = t.setShape(value)

    val scaleShapeProperty: BooleanProperty get() = t.scaleShapeProperty()
    var scaleShape: Boolean
        get() = t.isScaleShape
        set(value) = t.setScaleShape(value)

    val centerShapeProperty: BooleanProperty get() = t.centerShapeProperty()
    var centerShape: Boolean
        get() = t.isCenterShape
        set(value) = t.setCenterShape(value)

    val cacheShapeProperty: BooleanProperty get() = t.cacheShapeProperty()
    var cacheShape: Boolean
        get() = t.isCacheShape
        set(value) = t.setCacheShape(value)

    val snappedTopInset: Double get() = t.snappedTopInset()
    val snappedBottomInset: Double get() = t.snappedBottomInset()
    val snappedLeftInset: Double get() = t.snappedLeftInset()
    val snappedRightInset: Double get() = t.snappedRightInset()
}