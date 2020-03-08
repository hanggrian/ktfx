package ktfx.internal

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane

/** Ktfx internal class, ignore it. */
object KtfxInternals {

    const val NO_GETTER: String = "Property does not have a getter."

    /** Some mutable backing fields are only used to set value. */
    fun noGetter(): Nothing = throw UnsupportedOperationException(NO_GETTER)

    inline fun <T : MenuItem> newChild(
        child: T,
        vararg styleClass: String,
        id: String? = null,
        configuration: T.() -> Unit
    ): T {
        child.styleClass += styleClass
        child.id = id
        child.configuration()
        return child
    }

    inline fun <T : Node> newChild(
        child: T,
        vararg styleClass: String,
        id: String? = null,
        configuration: T.() -> Unit
    ): T {
        child.styleClass += styleClass
        child.id = id
        child.configuration()
        return child
    }

    inline fun <T : Tab> newChild(
        child: T,
        vararg styleClass: String,
        id: String? = null,
        configuration: T.() -> Unit
    ): T {
        child.styleClass += styleClass
        child.id = id
        child.configuration()
        return child
    }

    inline fun <T : TitledPane> newChild(
        child: T,
        vararg styleClass: String,
        id: String? = null,
        configuration: T.() -> Unit
    ): T {
        child.styleClass += styleClass
        child.id = id
        child.configuration()
        return child
    }
}
