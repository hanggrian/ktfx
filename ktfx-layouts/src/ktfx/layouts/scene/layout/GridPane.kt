@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.ConstraintsBase
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import javafx.scene.layout.RowConstraints
import ktfx.layouts.internal.HAlignedPane
import ktfx.layouts.internal.HGrowedPane
import ktfx.layouts.internal.MarginedPane
import ktfx.layouts.internal.VAlignedPane
import ktfx.layouts.internal.VGrowedPane
import ktfx.layouts.internal._ConstraintsBuilder

open class _GridPane : GridPane(), LayoutManager<Node>, MarginedPane, HAlignedPane, VAlignedPane, HGrowedPane,
    VGrowedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    infix fun <N : Node> N.row(row: Int?): N = also { it.row = row }

    infix fun <N : Node> N.col(col: Int?): N = also { it.col = col }

    infix fun <N : Node> N.rowSpans(rowSpans: Int?): N = also { it.rowSpans = rowSpans }

    infix fun <N : Node> N.colSpans(colSpans: Int?): N = also { it.colSpans = colSpans }

    var Node.row: Int?
        get() = getRowIndex(this)
        set(value) = setRowIndex(this, value)

    var Node.col: Int?
        get() = getColumnIndex(this)
        set(value) = setColumnIndex(this, value)

    var Node.rowSpans: Int? // alias for reserved variable `rowSpan`
        get() = getRowSpan(this)
        set(value) = setRowSpan(this, value)

    var Node.colSpans: Int?
        get() = getColumnSpan(this)
        set(value) = setColumnSpan(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)

    override var Node.valign: VPos?
        get() = getValignment(this)
        set(value) = setValignment(this, value)

    override var Node.halign: HPos?
        get() = getHalignment(this)
        set(value) = setHalignment(this, value)

    infix fun <N : Node> N.hfill(value: Boolean): N = apply { hfill = value }

    infix fun <N : Node> N.vfill(value: Boolean): N = apply { vfill = value }

    var Node.hfill: Boolean?
        get() = isFillWidth(this)
        set(value) = setFillWidth(this, value)

    var Node.vfill: Boolean?
        get() = isFillHeight(this)
        set(value) = setFillHeight(this, value)

    override var Node.hpriority: Priority?
        get() = getHgrow(this)
        set(value) = setHgrow(this, value)

    override var Node.vpriority: Priority?
        get() = getVgrow(this)
        set(value) = setVgrow(this, value)
}

/** Create a [GridPane]. */
inline fun gridPane(): GridPane = gridPane { }

/** Create a [GridPane] with initialization. */
inline fun gridPane(
    init: (@LayoutDsl _GridPane).() -> Unit
): GridPane = _GridPane().apply(init)

/** Create a [GridPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.gridPane(): GridPane = gridPane { }

/** Create a [GridPane] with initialization and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.gridPane(
    init: (@LayoutDsl _GridPane).() -> Unit
): GridPane = ktfx.layouts.gridPane(init).add()

/** Interface to build [GridPane] row and column constraints with Kotlin DSL. */
interface ConstraintsBuilder<out T : ConstraintsBase> {

    fun constraints(): T = constraints { }

    fun constraints(init: T.() -> Unit): T

    fun constraints(size: Double): T = constraints(size) { }

    fun constraints(size: Double, init: T.() -> Unit): T

    fun constraints(minSize: Double, prefSize: Double, maxSize: Double): T = constraints(minSize, prefSize, maxSize) { }

    fun constraints(minSize: Double, prefSize: Double, maxSize: Double, init: T.() -> Unit): T
}

/** Invokes a row constraints DSL builder. */
inline fun GridPane.rowConstraints(init: ConstraintsBuilder<RowConstraints>.() -> Unit) {
    rowConstraints += object : _ConstraintsBuilder<RowConstraints>() {
        override fun newInstance(): RowConstraints = RowConstraints()
        override fun newInstance(width: Double): RowConstraints = RowConstraints(width)
        override fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): RowConstraints =
            RowConstraints(width, prefWidth, maxWidth)
    }.apply(init).constraints
}

/** Invokes a column constraints DSL builder. */
inline fun GridPane.columnConstraints(init: ConstraintsBuilder<ColumnConstraints>.() -> Unit) {
    columnConstraints += object : _ConstraintsBuilder<ColumnConstraints>() {
        override fun newInstance(): ColumnConstraints = ColumnConstraints()
        override fun newInstance(width: Double): ColumnConstraints = ColumnConstraints(width)
        override fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): ColumnConstraints =
            ColumnConstraints(width, prefWidth, maxWidth)
    }.apply(init).constraints
}