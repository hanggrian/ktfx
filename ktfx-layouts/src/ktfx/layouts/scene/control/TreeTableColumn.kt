@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import ktfx.internal.KtfxManager

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

@PublishedApi
internal class _TreeTableColumnsBuilder<S> : TreeTableColumnsBuilder<S>, KtfxManager<TreeTableColumn<S, *>> {

    val cols: MutableList<TreeTableColumn<S, *>> = mutableListOf()

    override fun <R : TreeTableColumn<S, *>> R.invoke(): R = also { cols += it }

    override fun <T> column(text: String?, init: (TreeTableColumn<S, T>.() -> Unit)?): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { init?.invoke(it) }()
}

/** Invokes a [TreeTableColumn] DSL builder. */
inline fun <S> TreeTableView<S>.columns(init: TreeTableColumnsBuilder<S>.() -> Unit) {
    columns += _TreeTableColumnsBuilder<S>().apply(init).cols
}