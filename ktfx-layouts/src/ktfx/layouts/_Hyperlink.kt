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
fun NodeManager.hyperlink(text: String, graphic: Node): Hyperlink = hyperlink(text = text, graphic =
        graphic) { }

/**
 * Create a [Hyperlink] with configuration block.
 */
inline fun hyperlink(
    text: String,
    graphic: Node,
    configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Hyperlink(text, graphic), configuration = configuration)
}

/**
 * Add a [Hyperlink] with configuration block to this manager.
 */
inline fun NodeManager.hyperlink(
    text: String,
    graphic: Node,
    configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Hyperlink(text, graphic), configuration = configuration))
}

/**
 * Create a styled [Hyperlink].
 */
fun styledHyperlink(
    text: String,
    graphic: Node,
    vararg styleClass: String
): Hyperlink = styledHyperlink(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Add a styled [Hyperlink] to this manager.
 */
fun NodeManager.styledHyperlink(
    text: String,
    graphic: Node,
    vararg styleClass: String
): Hyperlink = styledHyperlink(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Create a styled [Hyperlink] with configuration block.
 */
inline fun styledHyperlink(
    text: String,
    graphic: Node,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Hyperlink(text, graphic), styleClass = *styleClass, configuration =
            configuration)
}

/**
 * Add a styled [Hyperlink] with configuration block to this manager.
 */
inline fun NodeManager.styledHyperlink(
    text: String,
    graphic: Node,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Hyperlink(text, graphic), styleClass = *styleClass, configuration =
            configuration))
}
