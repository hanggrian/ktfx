package javafxx.internal

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.valueOf
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog

@Suppress("NOTHING_TO_INLINE")
object Internals {

    const val NO_GETTER: String = "Property does not have a getter"

    /** Some mutable backing fields are only used to set value. */
    inline fun noGetter(): Nothing = fail { NO_GETTER }

    /** Equivalent to [error] but throws [UnsupportedOperationException] instead. */
    inline fun fail(
        lazyMessage: () -> Any = { "Fatal error" }
    ): Nothing = throw UnsupportedOperationException(lazyMessage().toString())

    @PublishedApi
    internal fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let {
        if (it == "CENTER_CENTER") CENTER else valueOf(it)
    }

    /** Invokes DSL to create a button in dialog, returning a Node. */
    @PublishedApi
    internal fun Dialog<*>.addButton(type: ButtonType, init: (Node.() -> Unit)?): Node = dialogPane.run {
        buttonTypes += type
        return lookupButton(type).also { init?.invoke(it) }
    }
}