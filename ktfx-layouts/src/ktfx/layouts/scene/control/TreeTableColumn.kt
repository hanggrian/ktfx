@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView

/** Interface to build [TreeTableColumn] with Kotlin DSL. */
interface TreeTableColumnsBuilder<S> {

    fun <T> column(
        text: String? = null,
        init: (TreeTableColumn<S, T>.() -> Unit)? = null
    ): TreeTableColumn<S, T>

    operator fun <T> String.invoke(
        init: (TreeTableColumn<S, T>.() -> Unit)? = null
    ): TreeTableColumn<S, T> = column(this, init)
}

private class _TreeTableColumnsBuilder<S> : TreeTableColumnsBuilder<S>, LayoutManager<TreeTableColumn<S, *>> {

    val collection: MutableCollection<TreeTableColumn<S, *>> = mutableListOf()

    override fun <R : TreeTableColumn<S, *>> R.add(): R = also { collection += it }

    override fun <T> column(text: String?, init: (TreeTableColumn<S, T>.() -> Unit)?): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { init?.invoke(it) }.add()
}

/** Invokes a [TreeTableColumn] DSL builder. */
fun <S> TreeTableView<S>.columns(init: TreeTableColumnsBuilder<S>.() -> Unit) {
    columns += _TreeTableColumnsBuilder<S>().apply(init).collection
}
