package ktfx.internal

import javafx.scene.Node

/** Ktfx internal class, ignore it. */
object KtfxInternals {

    const val NO_GETTER: String = "Property does not have a getter."

    /** Some mutable backing fields are only used to set value. */
    fun noGetter(): Nothing = throw UnsupportedOperationException(NO_GETTER)

    inline fun <T : Node> newChild(child: T, vararg styleClass: String, configuration: T.() -> Unit): T {
        child.styleClass += styleClass
        child.configuration()
        return child
    }
}
