package ktfx.internal

import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.scene.layout.Region

object KtfxInternals {

    const val NO_GETTER: String = "Property does not have a getter."

    /** Some mutable backing fields are only used to set value. */
    fun noGetter(): Nothing = fail { NO_GETTER }

    /** Equivalent to [error] but throws [UnsupportedOperationException] instead. */
    fun fail(lazyMessage: () -> Any = { "Unsupported operation." }): Nothing =
        throw UnsupportedOperationException(lazyMessage().toString())

    fun asRegion(node: Node): Region = node as? Region ?: Pane(node)
}