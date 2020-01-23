@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.controls

import com.jfoenix.controls.JFXTreeTableColumn
import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeTableColumn
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.controls.TableColumnDslMarker

/** Invokes a [TreeTableColumn] DSL builder. */
inline fun <S : RecursiveTreeObject<S>> JFXTreeTableView<S>.columns(configuration: JFXTreeTableColumnsBuilder<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    JFXTreeTableColumnsBuilder<S>(columns).configuration()
}

/** Invokes a [TreeTableColumn] DSL builder. */
inline fun <S : RecursiveTreeObject<S>, T> JFXTreeTableColumn<S, T>.columns(configuration: JFXTreeTableColumnsBuilder<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    JFXTreeTableColumnsBuilder<S>(columns).configuration()
}

/** Interface to build [JFXTreeTableColumn] with Kotlin DSL. */
@TableColumnDslMarker
class JFXTreeTableColumnsBuilder<S : RecursiveTreeObject<S>> @PublishedApi internal constructor(
    private val columns: MutableCollection<TreeTableColumn<S, *>>
) {

    fun <T> column(
        text: String? = null
    ): JFXTreeTableColumn<S, T> = JFXTreeTableColumn<S, T>(text).also { columns += it }

    inline fun <T> column(
        text: String? = null,
        init: JFXTreeTableColumn<S, T>.() -> Unit
    ): JFXTreeTableColumn<S, T> = column<T>(text).apply(init)

    inline operator fun <T> String.invoke(
        init: JFXTreeTableColumn<S, T>.() -> Unit
    ): JFXTreeTableColumn<S, T> = column(this, init)
}
