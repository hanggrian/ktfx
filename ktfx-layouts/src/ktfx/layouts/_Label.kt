@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Label
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Create a styled [Label].
 */
fun styledLabel(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String
): Label = styledLabel(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Add a styled [Label] to this manager.
 */
fun NodeManager.styledLabel(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String
): Label = styledLabel(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Create a styled [Label] with configuration block.
 */
inline fun styledLabel(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker Label).() -> Unit
): Label {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Label(text, graphic), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [Label] with configuration block to this manager.
 */
inline fun NodeManager.styledLabel(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker Label).() -> Unit
): Label {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Label(text, graphic), styleClass = *styleClass, configuration =
            configuration))
}

/**
 * Add a [Label] to this manager.
 */
fun NodeManager.label(text: String? = null, graphic: Node? = null): Label = label(text = text,
        graphic = graphic) { }

/**
 * Create a [Label] with configuration block.
 */
inline fun label(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Label).() -> Unit
): Label {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Label(text, graphic), configuration = configuration)
}

/**
 * Add a [Label] with configuration block to this manager.
 */
inline fun NodeManager.label(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Label).() -> Unit
): Label {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Label(text, graphic), configuration = configuration))
}
