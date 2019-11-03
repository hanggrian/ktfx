package ktfx.controls

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import ktfx.cells.TreeTableRowBuilder
import ktfx.cells.build

/** A function which produces a TreeTableRow. */
fun <S> TreeTableView<S>.rowFactory(
    rowFactory: TreeTableRowBuilder<S>.() -> Unit
): Unit = setRowFactory { rowFactory.build() }

/** Invokes a [TreeTableColumn] DSL builder. */
fun <S> TreeTableView<S>.columns(init: TreeTableColumnsBuilder<S>.() -> Unit) {
    columns += TreeTableColumnsBuilderImpl<S>().apply(init).collection
}

/** Interface to build [TreeTableColumn] with Kotlin DSL. */
interface TreeTableColumnsBuilder<S> {

    fun <T> column(
        text: String? = null
    ): TreeTableColumn<S, T>

    fun <T> column(
        text: String? = null,
        init: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> = column<T>(text).apply(init)

    operator fun <T> String.invoke(
        init: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> = column(this, init)
}

private class TreeTableColumnsBuilderImpl<S> : TreeTableColumnsBuilder<S> {

    val collection: MutableCollection<TreeTableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { collection += it }
}
