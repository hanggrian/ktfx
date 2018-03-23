@file:Suppress("ClassName")

package ktfx.layouts

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.ConstraintsBase
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import javafx.scene.layout.RowConstraints

open class _GridPane : GridPane(), ChildManager, MarginedPane, AlignedPane, HGrowedPane, VGrowedPane {

    infix fun <N : Node> N.row(value: Int): N = apply { setRowIndex(this, value) }
    infix fun <N : Node> N.col(value: Int): N = apply { setColumnIndex(this, value) }
    infix fun <N : Node> N.rowSpan(value: Int): N = apply { setRowSpan(this, value) }
    infix fun <N : Node> N.colSpan(value: Int): N = apply { setColumnSpan(this, value) }

    val Node.row: Int get() = getRowIndex(this) ?: -1
    val Node.col: Int get() = getColumnIndex(this) ?: -1
    val Node.rowSpan: Int get() = getRowSpan(this) ?: -1
    val Node.colSpan: Int get() = getColumnSpan(this) ?: -1

    override fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override infix fun <N : Node> N.hpos(value: HPos?): N = apply { setHalignment(this, value) }
    override infix fun <N : Node> N.vpos(value: VPos?): N = apply { setValignment(this, value) }
    override fun <N : Node> N.pos(value: Pos?): N = apply {
        setHalignment(this, value?.hpos)
        setValignment(this, value?.vpos)
    }

    override val Node.vpos: VPos get() = getValignment(this) ?: VPos.TOP
    override val Node.hpos: HPos get() = getHalignment(this) ?: HPos.LEFT
    override val Node.pos: Pos get() = posOf(vpos, hpos)

    infix fun <N : Node> N.hfill(value: Boolean): N = apply { setFillWidth(this, value) }
    infix fun <N : Node> N.vfill(value: Boolean): N = apply { setFillHeight(this, value) }
    infix fun <N : Node> N.fill(value: Boolean): N = apply {
        setFillWidth(this, value)
        setFillHeight(this, value)
    }

    val Node.hfill: Boolean get() = isFillWidth(this)
    val Node.vfill: Boolean get() = isFillHeight(this)
    val Node.fill: Boolean get() = hfill && vfill

    override infix fun <N : Node> N.hpriority(value: Priority?): N = apply { setHgrow(this, value) }
    override infix fun <N : Node> N.vpriority(value: Priority?): N = apply { setVgrow(this, value) }

    override val Node.hpriority: Priority get() = getHgrow(this) ?: Priority.NEVER
    override val Node.vpriority: Priority get() = getVgrow(this) ?: Priority.NEVER

    override fun Node.reset() = clearConstraints(this)
}

inline fun gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init)

inline fun Manager<Node>.gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = ktfx.layouts.gridPane(init).add()

/** Interface to build [GridPane] row and column constraints with Kotlin DSL. */
interface ConstraintsBuilder<out T : ConstraintsBase> {

    /** Create a constraints. */
    fun constraints(init: (T.() -> Unit)? = null)

    /** Create a constraints with pre-defined width. */
    fun constraints(size: Int, init: (T.() -> Unit)? = null)

    /** Create a constraints with pre-defined minimum, preferred, and maximum width. */
    fun constraints(minSize: Int, prefSize: Int, maxSize: Int, init: (T.() -> Unit)? = null)
}

@PublishedApi
internal sealed class _ConstraintsBuilder<T : ConstraintsBase> : ConstraintsBuilder<T> {

    val constraints: MutableList<T> = mutableListOf()

    override fun constraints(init: (T.() -> Unit)?) {
        constraints += newInstance().apply { init?.invoke(this) }
    }

    override fun constraints(size: Int, init: (T.() -> Unit)?) {
        constraints += newInstance(size).apply { init?.invoke(this) }
    }

    override fun constraints(minSize: Int, prefSize: Int, maxSize: Int, init: (T.() -> Unit)?) {
        constraints += newInstance(minSize, prefSize, maxSize).apply { init?.invoke(this) }
    }

    internal abstract fun newInstance(): T

    internal abstract fun newInstance(width: Int): T

    internal abstract fun newInstance(width: Int, prefWidth: Int, maxWidth: Int): T
}

@PublishedApi
internal class _RowConstraintsBuilder : _ConstraintsBuilder<RowConstraints>() {

    override fun newInstance(): RowConstraints = RowConstraints()

    override fun newInstance(width: Int): RowConstraints = RowConstraints(width.toDouble())

    override fun newInstance(width: Int, prefWidth: Int, maxWidth: Int): RowConstraints =
        RowConstraints(width.toDouble(), prefWidth.toDouble(), maxWidth.toDouble())
}

@PublishedApi
internal class _ColumnConstraintsBuilder : _ConstraintsBuilder<ColumnConstraints>() {

    override fun newInstance(): ColumnConstraints = ColumnConstraints()

    override fun newInstance(width: Int): ColumnConstraints = ColumnConstraints(width.toDouble())

    override fun newInstance(width: Int, prefWidth: Int, maxWidth: Int): ColumnConstraints =
        ColumnConstraints(width.toDouble(), prefWidth.toDouble(), maxWidth.toDouble())
}

/** Invokes a row constraints DSL builder. */
inline fun GridPane.row(init: ConstraintsBuilder<RowConstraints>.() -> Unit) {
    rowConstraints += _RowConstraintsBuilder().apply(init).constraints
}

/** Invokes a column constraints DSL builder. */
inline fun GridPane.column(init: ConstraintsBuilder<ColumnConstraints>.() -> Unit) {
    columnConstraints += _ColumnConstraintsBuilder().apply(init).constraints
}