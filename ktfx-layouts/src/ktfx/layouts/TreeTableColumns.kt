@file:Suppress("ClassName")

package ktfx.layouts

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView

/** Interface to build [TreeTableColumn] with Kotlin DSL. */
interface TreeTableColumnsBuilder<S> {

    fun <T> column(text: String? = null, init: (TreeTableColumn<S, T>.() -> Unit)? = null)
}

@PublishedApi
internal class _TreeTableColumnsBuilder<S> : TreeTableColumnsBuilder<S> {

    val columns: MutableList<TreeTableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?, init: (TreeTableColumn<S, T>.() -> Unit)?) {
        columns += TreeTableColumn<S, T>(text).apply { init?.invoke(this) }
    }
}

/** Invokes a [TreeTableColumn] DSL builder. */
inline fun <S> TreeTableView<S>.columns(init: TreeTableColumnsBuilder<S>.() -> Unit) {
    columns += _TreeTableColumnsBuilder<S>().apply(init).columns
}