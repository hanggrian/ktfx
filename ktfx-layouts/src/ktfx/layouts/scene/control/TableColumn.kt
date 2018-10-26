@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import ktfx.internal.KtfxManager

/** Interface to build [TableColumn] with Kotlin DSL. */
interface TableColumnsBuilder<S> {

    fun <T> column(
        text: String? = null,
        init: (TableColumn<S, T>.() -> Unit)? = null
    ): TableColumn<S, T>

    operator fun <T> String.invoke(
        init: (TableColumn<S, T>.() -> Unit)? = null
    ): TableColumn<S, T> = column(this, init)
}

@PublishedApi
internal class _TableColumnsBuilder<S> : TableColumnsBuilder<S>, KtfxManager<TableColumn<S, *>> by KtfxManager.empty() {

    override fun <T> column(text: String?, init: (TableColumn<S, T>.() -> Unit)?): TableColumn<S, T> =
        TableColumn<S, T>(text).also { init?.invoke(it) }()
}

/** Invokes a [TableColumn] DSL builder. */
inline fun <S> TableView<S>.columns(init: TableColumnsBuilder<S>.() -> Unit) {
    columns += _TableColumnsBuilder<S>().apply(init).collection
}