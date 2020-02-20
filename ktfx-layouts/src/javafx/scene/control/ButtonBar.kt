@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [ButtonBar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxButtonBar(buttonOrder: String?) : ButtonBar(buttonOrder), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { buttons += it }

    /** Call [NodeManager.button] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@LayoutDslMarker Button).() -> Unit
    ): Button = button(this, graphic, configuration)
}

/** Create a [ButtonBar] with configuration block. */
inline fun buttonBar(
    buttonOrder: String? = null,
    configuration: (@LayoutDslMarker KtfxButtonBar).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxButtonBar(buttonOrder).apply(configuration)
}

/** Add a [ButtonBar] to this manager. */
fun NodeManager.buttonBar(
    buttonOrder: String? = null
): ButtonBar = addChild(KtfxButtonBar(buttonOrder))

/** Add a [ButtonBar] with configuration block to this manager. */
inline fun NodeManager.buttonBar(
    buttonOrder: String? = null,
    configuration: (@LayoutDslMarker KtfxButtonBar).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxButtonBar(buttonOrder), configuration)
}
