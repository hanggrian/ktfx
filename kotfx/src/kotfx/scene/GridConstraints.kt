package kotfx.scene

import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.ConstraintsBase
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints

interface Constrained<T : ConstraintsBase> {

    val constraints: MutableList<T>
}

interface RowConstrained : Constrained<RowConstraints> {

    fun constraints(init: (RowConstraints.() -> Unit)? = null) {
        constraints.add(RowConstraints().apply { init?.invoke(this) })
    }

    fun constraints(width: Double, init: (RowConstraints.() -> Unit)? = null) {
        constraints.add(RowConstraints(width).apply { init?.invoke(this) })
    }

    fun constraints(minWidth: Double, prefWidth: Double, maxWidth: Double, init: (RowConstraints.() -> Unit)? = null) {
        constraints.add(RowConstraints(minWidth, prefWidth, maxWidth).apply { init?.invoke(this) })
    }
}

interface ColumnConstrained : Constrained<ColumnConstraints> {

    fun constraints(init: (ColumnConstraints.() -> Unit)? = null) {
        constraints.add(ColumnConstraints().apply { init?.invoke(this) })
    }

    fun constraints(width: Double, init: (ColumnConstraints.() -> Unit)? = null) {
        constraints.add(ColumnConstraints(width).apply { init?.invoke(this) })
    }

    fun constraints(minWidth: Double, prefWidth: Double, maxWidth: Double, init: (ColumnConstraints.() -> Unit)? = null) {
        constraints.add(ColumnConstraints(minWidth, prefWidth, maxWidth).apply { init?.invoke(this) })
    }
}

class _RowConstrained(override val constraints: MutableList<RowConstraints> = mutableListOf()) : RowConstrained

class _ColumnConstrained(override val constraints: MutableList<ColumnConstraints> = mutableListOf()) : ColumnConstrained

inline fun GridPane.rowConstraints(init: RowConstrained.() -> Unit) {
    rowConstraints.addAll(_RowConstrained().apply(init).constraints)
}

inline fun GridPane.columnConstraints(init: ColumnConstrained.() -> Unit) {
    columnConstraints.addAll(_ColumnConstrained().apply(init).constraints)
}