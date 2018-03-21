@file:Suppress("ClassName")

package ktfx.layouts

import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.ConstraintsBase
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints

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