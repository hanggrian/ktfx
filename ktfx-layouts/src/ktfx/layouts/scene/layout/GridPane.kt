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

open class _GridPane : GridPane(), LayoutManager<Node>, MarginedPane, HAlignedPane, VAlignedPane, HGrowedPane,
    VGrowedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.clear() = clearConstraints(this)

    infix fun <N : Node> N.row(value: Int?): N = apply { row = value }

    infix fun <N : Node> N.col(value: Int?): N = apply { col = value }

    infix fun <N : Node> N.rowStretch(value: Int?): N = apply { rowStretch = value }

    infix fun <N : Node> N.colStretch(value: Int?): N = apply { colStretch = value }

    var Node.row: Int?
        get() = getRowIndex(this)
        set(value) = setRowIndex(this, value)

    var Node.col: Int?
        get() = getColumnIndex(this)
        set(value) = setColumnIndex(this, value)

    var Node.rowStretch: Int?
        get() = getRowSpan(this)
        set(value) = setRowSpan(this, value)

    var Node.colStretch: Int?
        get() = getColumnSpan(this)
        set(value) = setColumnSpan(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)

    override var Node.vpos: VPos?
        get() = getValignment(this)
        set(value) = setValignment(this, value)

    override var Node.hpos: HPos?
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

inline fun gridPane(): GridPane = gridPane { }

inline fun gridPane(
    init: (@LayoutDsl _GridPane).() -> Unit
): GridPane = _GridPane().apply(init)

inline fun LayoutManager<Node>.gridPane(): GridPane = gridPane { }

inline fun LayoutManager<Node>.gridPane(
    init: (@LayoutDsl _GridPane).() -> Unit
): GridPane = ktfx.layouts.gridPane(init).add()

/** Interface to build [GridPane] row and column constraints with Kotlin DSL. */
interface ConstraintsBuilder<out T : ConstraintsBase> {

    fun constraints(init: T.() -> Unit): T

    fun constraints(size: Double, init: T.() -> Unit): T

    fun constraints(minSize: Double, prefSize: Double, maxSize: Double, init: T.() -> Unit): T
}

inline fun <T : ConstraintsBase> ConstraintsBuilder<T>.constraints(): T = constraints { }

inline fun <T : ConstraintsBase> ConstraintsBuilder<T>.constraints(size: Double): T = constraints(size) { }

inline fun <T : ConstraintsBase> ConstraintsBuilder<T>.constraints(
    minSize: Double,
    prefSize: Double,
    maxSize: Double
): T = constraints(minSize, prefSize, maxSize) { }

@PublishedApi
internal abstract class _ConstraintsBuilder<T : ConstraintsBase> : ConstraintsBuilder<T> {
    val constraints: MutableList<T> = mutableListOf()

    internal abstract fun newInstance(): T

    internal abstract fun newInstance(width: Double): T

    internal abstract fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): T

    override fun constraints(init: T.() -> Unit): T =
        newInstance().apply(init).also { constraints += it }

    override fun constraints(size: Double, init: T.() -> Unit): T =
        newInstance(size).apply(init).also { constraints += it }

    override fun constraints(minSize: Double, prefSize: Double, maxSize: Double, init: T.() -> Unit): T =
        newInstance(minSize, prefSize, maxSize).apply(init).also { constraints += it }
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