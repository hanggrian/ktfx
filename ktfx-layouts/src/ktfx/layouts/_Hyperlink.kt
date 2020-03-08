@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Hyperlink
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Hyperlink] to this manager.
 */
fun NodeManager.hyperlink(text: String? = null, graphic: Node? = null): Hyperlink = hyperlink(text =
        text, graphic = graphic) { }

/**
 * Create a [Hyperlink] with configuration block.
 */
inline fun hyperlink(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Hyperlink(text, graphic), configuration = configuration)
}

/**
 * Add a [Hyperlink] with configuration block to this manager.
 */
inline fun NodeManager.hyperlink(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Hyperlink(text, graphic), configuration = configuration))
}

/**
 * Create a styled [Hyperlink].
 */
fun styledHyperlink(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): Hyperlink = styledHyperlink(text = text, graphic = graphic, styleClass = *styleClass, id = id) {
        }

/**
 * Add a styled [Hyperlink] to this manager.
 */
fun NodeManager.styledHyperlink(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): Hyperlink = styledHyperlink(text = text, graphic = graphic, styleClass = *styleClass, id = id) {
        }

/**
 * Create a styled [Hyperlink] with configuration block.
 */
inline fun styledHyperlink(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Hyperlink(text, graphic), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [Hyperlink] with configuration block to this manager.
 */
inline fun NodeManager.styledHyperlink(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Hyperlink(text, graphic), styleClass = *styleClass, id = id,
            configuration = configuration))
}
