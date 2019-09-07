@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeTableColumn
import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeTableColumn

/** Interface to build [JFXTreeTableColumn] with Kotlin DSL. */
sealed class JFXTreeTableColumnsBuilder<S : RecursiveTreeObject<S>> {

    abstract fun <T> column(
        text: String? = null
    ): JFXTreeTableColumn<S, T>

    inline fun <T> column(
        text: String? = null,
        init: JFXTreeTableColumn<S, T>.() -> Unit
    ): JFXTreeTableColumn<S, T> = column<T>(text).apply(init)

    inline operator fun <T> String.invoke(
        init: JFXTreeTableColumn<S, T>.() -> Unit
    ): JFXTreeTableColumn<S, T> = column(this, init)
}

private class _JFXTreeTableColumnsBuilder<S : RecursiveTreeObject<S>> : JFXTreeTableColumnsBuilder<S>() {

    val collection: MutableCollection<JFXTreeTableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?): JFXTreeTableColumn<S, T> =
        JFXTreeTableColumn<S, T>(text).also { collection += it }
}

/** Invokes a [TreeTableColumn] DSL builder. */
fun <S : RecursiveTreeObject<S>> JFXTreeTableView<S>.columns(init: JFXTreeTableColumnsBuilder<S>.() -> Unit) {
    columns += _JFXTreeTableColumnsBuilder<S>().apply(init).collection
}
