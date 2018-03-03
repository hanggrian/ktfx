@file:Suppress("ClassName")

package kotfx.layouts

import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.ConstraintsBase
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints

sealed class Constrained<T : ConstraintsBase> {

    val constraints: MutableList<T> = mutableListOf()

    abstract val newInstance: T
    abstract fun newInstance(width: Double): T
    abstract fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): T

    fun constraints(init: (T.() -> Unit)? = null) {
        constraints += newInstance.apply { init?.invoke(this) }
    }

    fun constraints(width: Double, init: (T.() -> Unit)? = null) {
        constraints += newInstance(width).apply { init?.invoke(this) }
    }

    fun constraints(minWidth: Double, prefWidth: Double, maxWidth: Double, init: (T.() -> Unit)? = null) {
        constraints += newInstance(minWidth, prefWidth, maxWidth).apply { init?.invoke(this) }
    }
}

class _RowConstrained : Constrained<RowConstraints>() {

    override val newInstance: RowConstraints get() = RowConstraints()
    override fun newInstance(width: Double): RowConstraints = RowConstraints(width)
    override fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): RowConstraints = RowConstraints(width, prefWidth, maxWidth)
}

class _ColumnConstrained : Constrained<ColumnConstraints>() {

    override val newInstance: ColumnConstraints get() = ColumnConstraints()
    override fun newInstance(width: Double): ColumnConstraints = ColumnConstraints(width)
    override fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): ColumnConstraints = ColumnConstraints(width, prefWidth, maxWidth)
}

inline fun GridPane.row(init: Constrained<RowConstraints>.() -> Unit) {
    rowConstraints += _RowConstrained().apply(init).constraints
}

inline fun GridPane.column(init: Constrained<ColumnConstraints>.() -> Unit) {
    columnConstraints += _ColumnConstrained().apply(init).constraints
}