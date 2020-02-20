@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Label
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Label] with configuration block. */
inline fun label(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Label).() -> Unit
): Label {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Label(text, graphic).apply(configuration)
}

/** Add a [Label] to this manager. */
fun NodeManager.label(
    text: String? = null,
    graphic: Node? = null
): Label = addChild(Label(text, graphic))

/** Add a [Label] with configuration block to this manager. */
inline fun NodeManager.label(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Label).() -> Unit
): Label {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Label(text, graphic), configuration)
}
