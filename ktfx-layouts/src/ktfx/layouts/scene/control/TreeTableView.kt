@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView

inline fun <S> treeTableView(root: TreeItem<S>? = null, noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }
inline fun <S> ChildManager.treeTableView(root: TreeItem<S>? = null, noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = ktfx.layouts.treeTableView(root, init).add()
inline fun <S> ItemManager.treeTableView(root: TreeItem<S>? = null, noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = ktfx.layouts.treeTableView(root, init).add()
inline fun <S> ButtonManager.treeTableView(root: TreeItem<S>? = null, noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = ktfx.layouts.treeTableView(root, init).add()

/** Interface to build [TreeTableColumn] with Kotlin DSL. */
interface TreeTableColumnsBuilder<S> {

    fun <T> column(text: String? = null, init: (TreeTableColumn<S, T>.() -> Unit)? = null)
}

@PublishedApi
@Suppress("ClassName")
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