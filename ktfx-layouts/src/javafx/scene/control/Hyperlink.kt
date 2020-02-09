@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Hyperlink
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Hyperlink] with configurationialization block. */
inline fun hyperlink(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Hyperlink(text, graphic).apply(configuration)
}

/** Add a [Hyperlink] to this manager. */
fun NodeManager.hyperlink(
    text: String? = null,
    graphic: Node? = null
): Hyperlink = addChild(Hyperlink(text, graphic))

/** Add a [Hyperlink] with configurationialization block to this manager. */
inline fun NodeManager.hyperlink(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Hyperlink(text, graphic), configuration)
}
