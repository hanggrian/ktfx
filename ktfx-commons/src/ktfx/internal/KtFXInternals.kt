package ktfx.internal

import javafx.beans.Observable
import javafx.beans.binding.BooleanBinding
import javafx.collections.ObservableList
import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.valueOf
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import ktfx.collections.observableListOf

@Suppress("NOTHING_TO_INLINE")
object KtFXInternals {

    const val NO_GETTER: String = "Property does not have a getter"

    /** Some mutable backing fields are only used to set value. */
    inline fun noGetter(): Nothing = fail { NO_GETTER }

    /** Equivalent to [error] but throws [UnsupportedOperationException] instead. */
    inline fun fail(
        lazyMessage: () -> Any = { "Fatal error" }
    ): Nothing = throw UnsupportedOperationException(lazyMessage().toString())

    @PublishedApi
    internal fun <T : Observable> newBooleanBinding(
        op: T,
        computeValue: T.() -> Boolean
    ): BooleanBinding = object : BooleanBinding() {
        init {
            super.bind(op)
        }

        override fun dispose() = super.unbind(op)
        override fun computeValue(): Boolean = op.computeValue()
        override fun getDependencies(): ObservableList<*> = observableListOf(op)
    }

    internal fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let {
        if (it == "CENTER_CENTER") CENTER else valueOf(it)
    }

    /** Invokes DSL to create a button in dialog, returning a Node. */
    @PublishedApi
    internal fun Dialog<*>.addButton(type: ButtonType, init: Node.() -> Unit): Node = dialogPane.run {
        buttonTypes += type
        return lookupButton(type).apply(init)
    }
}