package ktfx.layouts

import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.ConstraintsBase
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints

/** Base class of row and column constrains builder DSL. */
sealed class ConstraintsBuilder<T : ConstraintsBase> {

    val constraints: MutableList<T> = mutableListOf()

    /** Create a constraints. */
    fun constraints(init: (T.() -> Unit)? = null) {
        constraints += newInstance().apply { init?.invoke(this) }
    }

    /** Create a constraints with pre-defined width. */
    fun constraints(width: Int, init: (T.() -> Unit)? = null) {
        constraints += newInstance(width).apply { init?.invoke(this) }
    }

    /** Create a constraints with pre-defined minimum, preferred, and maximum width. */
    fun constraints(minWidth: Int, prefWidth: Int, maxWidth: Int, init: (T.() -> Unit)? = null) {
        constraints += newInstance(minWidth, prefWidth, maxWidth).apply { init?.invoke(this) }
    }

    internal abstract fun newInstance(): T

    internal abstract fun newInstance(width: Int): T

    internal abstract fun newInstance(width: Int, prefWidth: Int, maxWidth: Int): T
}

class RowConstraintsBuilder : ConstraintsBuilder<RowConstraints>() {

    override fun newInstance(): RowConstraints = RowConstraints()

    override fun newInstance(width: Int): RowConstraints = RowConstraints(width.toDouble())

    override fun newInstance(width: Int, prefWidth: Int, maxWidth: Int): RowConstraints =
        RowConstraints(width.toDouble(), prefWidth.toDouble(), maxWidth.toDouble())
}

/** Invokes a row constraints DSL builder. */
inline fun GridPane.row(init: ConstraintsBuilder<RowConstraints>.() -> Unit) {
    rowConstraints += RowConstraintsBuilder().apply(init).constraints
}

class ColumnConstraintsBuilder : ConstraintsBuilder<ColumnConstraints>() {

    override fun newInstance(): ColumnConstraints = ColumnConstraints()

    override fun newInstance(width: Int): ColumnConstraints = ColumnConstraints(width.toDouble())

    override fun newInstance(width: Int, prefWidth: Int, maxWidth: Int): ColumnConstraints =
        ColumnConstraints(width.toDouble(), prefWidth.toDouble(), maxWidth.toDouble())
}

/** Invokes a column constraints DSL builder. */
inline fun GridPane.column(init: ConstraintsBuilder<ColumnConstraints>.() -> Unit) {
    columnConstraints += ColumnConstraintsBuilder().apply(init).constraints
}