@file:Suppress("NOTHING_TO_INLINE", "ClassName")

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
import ktfx.geometry.plus
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.HGrowedPane
import ktfx.layouts.internal.MarginedPane
import ktfx.layouts.internal.VGrowedPane

open class _GridPane : GridPane(), LayoutManager<Node>, MarginedPane, AlignedPane, HGrowedPane, VGrowedPane {

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
    override val Node.pos: Pos get() = vpos + hpos

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

    override fun <T : Node> T.add(): T = also { children += it }
}

inline fun gridPane(
    noinline init: ((@LayoutDsl _GridPane).() -> Unit)? = null
): GridPane = _GridPane().also { init?.invoke(it) }

inline fun LayoutManager<Node>.gridPane(
    noinline init: ((@LayoutDsl _GridPane).() -> Unit)? = null
): GridPane = ktfx.layouts.gridPane(init).add()

/** Interface to build [GridPane] row and column constraints with Kotlin DSL. */
interface ConstraintsBuilder<out T : ConstraintsBase> {

    /** Create a constraints. */
    fun constraints(init: (T.() -> Unit)? = null): T

    /** Create a constraints with pre-defined width. */
    fun constraints(size: Int, init: (T.() -> Unit)? = null): T

    /** Create a constraints with pre-defined minimum, preferred, and maximum width. */
    fun constraints(minSize: Int, prefSize: Int, maxSize: Int, init: (T.() -> Unit)? = null): T
}

@PublishedApi
internal abstract class _ConstraintsBuilder<T : ConstraintsBase> : ConstraintsBuilder<T> {
    val constraints: MutableList<T> = mutableListOf()

    internal abstract fun newInstance(): T
    internal abstract fun newInstance(width: Int): T
    internal abstract fun newInstance(width: Int, prefWidth: Int, maxWidth: Int): T

    override fun constraints(init: (T.() -> Unit)?): T =
        newInstance().also { init?.invoke(it) }.also { constraints += it }

    override fun constraints(size: Int, init: (T.() -> Unit)?): T =
        newInstance(size).also { init?.invoke(it) }.also { constraints += it }

    override fun constraints(minSize: Int, prefSize: Int, maxSize: Int, init: (T.() -> Unit)?): T =
        newInstance(minSize, prefSize, maxSize).also { init?.invoke(it) }.also { constraints += it }
}

/** Invokes a row constraints DSL builder. */
inline fun GridPane.row(init: ConstraintsBuilder<RowConstraints>.() -> Unit) {
    rowConstraints += object : _ConstraintsBuilder<RowConstraints>() {
        override fun newInstance(): RowConstraints = RowConstraints()
        override fun newInstance(width: Int): RowConstraints = RowConstraints(width.toDouble())
        override fun newInstance(width: Int, prefWidth: Int, maxWidth: Int): RowConstraints =
            RowConstraints(width.toDouble(), prefWidth.toDouble(), maxWidth.toDouble())
    }.apply(init).constraints
}

/** Invokes a column constraints DSL builder. */
inline fun GridPane.column(init: ConstraintsBuilder<ColumnConstraints>.() -> Unit) {
    columnConstraints += object : _ConstraintsBuilder<ColumnConstraints>() {
        override fun newInstance(): ColumnConstraints = ColumnConstraints()
        override fun newInstance(width: Int): ColumnConstraints = ColumnConstraints(width.toDouble())
        override fun newInstance(width: Int, prefWidth: Int, maxWidth: Int): ColumnConstraints =
            ColumnConstraints(width.toDouble(), prefWidth.toDouble(), maxWidth.toDouble())
    }.apply(init).constraints
}