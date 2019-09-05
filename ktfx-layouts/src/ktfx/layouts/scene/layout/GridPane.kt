@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.ConstraintsBase
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import javafx.scene.layout.RowConstraints

open class _GridPane : GridPane(), NodeManager, MarginConstraints, HAlignConstraints, VAlignConstraints,
    HGrowConstraints, VGrowConstraints {

    override fun <R : Node> R.add(): R = also { children += it }

    override fun Node.reset(): Unit = clearConstraints(this)

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

/** Add a [GridPane] to this manager. */
fun NodeManager.gridPane(): GridPane =
    _GridPane().add()

/** Add a [GridPane] with initialization block to this manager. */
inline fun NodeManager.gridPane(
    init: (@LayoutDslMarker _GridPane).() -> Unit
): GridPane = (gridPane() as _GridPane).apply(init)

/** Interface to build [GridPane] row and column constraints with Kotlin DSL. */
interface ConstraintsBuilder<out T : ConstraintsBase> {

    fun constraints(init: (T.() -> Unit)? = null): T

    fun constraints(size: Double, init: (T.() -> Unit)? = null): T

    fun constraints(minSize: Double, prefSize: Double, maxSize: Double, init: (T.() -> Unit)? = null): T
}

private abstract class _ConstraintsBuilder<T : ConstraintsBase> : ConstraintsBuilder<T>, LayoutManager<T> {

    val collection: MutableCollection<T> = mutableListOf()

    override fun <R : T> R.add(): R = also { collection += it }

    abstract fun newInstance(): T

    abstract fun newInstance(width: Double): T

    abstract fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): T

    override fun constraints(init: (T.() -> Unit)?): T =
        newInstance().also { init?.invoke(it) }.add()

    override fun constraints(size: Double, init: (T.() -> Unit)?): T =
        newInstance(size).also { init?.invoke(it) }.add()

    override fun constraints(minSize: Double, prefSize: Double, maxSize: Double, init: (T.() -> Unit)?): T =
        newInstance(minSize, prefSize, maxSize).also { init?.invoke(it) }.add()
}

/** Invokes a row constraints DSL builder. */
fun GridPane.rowConstraints(init: ConstraintsBuilder<RowConstraints>.() -> Unit) {
    rowConstraints += object : _ConstraintsBuilder<RowConstraints>() {
        override fun newInstance(): RowConstraints = RowConstraints()
        override fun newInstance(width: Double): RowConstraints = RowConstraints(width)
        override fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): RowConstraints =
            RowConstraints(width, prefWidth, maxWidth)
    }.apply(init).collection
}

/** Invokes a column constraints DSL builder. */
fun GridPane.columnConstraints(init: ConstraintsBuilder<ColumnConstraints>.() -> Unit) {
    columnConstraints += object : _ConstraintsBuilder<ColumnConstraints>() {
        override fun newInstance(): ColumnConstraints = ColumnConstraints()
        override fun newInstance(width: Double): ColumnConstraints = ColumnConstraints(width)
        override fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): ColumnConstraints =
            ColumnConstraints(width, prefWidth, maxWidth)
    }.apply(init).collection
}
