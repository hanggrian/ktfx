@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView

/** Interface to build [TreeTableColumn] with Kotlin DSL. */
sealed class TreeTableColumnsBuilder<S> {

    abstract fun <T> column(
        text: String? = null
    ): TreeTableColumn<S, T>

    inline fun <T> column(
        text: String? = null,
        init: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> = column<T>(text).apply(init)

    inline operator fun <T> String.invoke(
        init: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> = column(this, init)
}

private class _TreeTableColumnsBuilder<S> : TreeTableColumnsBuilder<S>() {

    val collection: MutableCollection<TreeTableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { collection += it }
}

/** Invokes a [TreeTableColumn] DSL builder. */
fun <S> TreeTableView<S>.columns(init: TreeTableColumnsBuilder<S>.() -> Unit) {
    columns += _TreeTableColumnsBuilder<S>().apply(init).collection
}
