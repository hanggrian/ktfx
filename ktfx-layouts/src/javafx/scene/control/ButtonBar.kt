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

    final override val childCount: Int get() = childrenUnmodifiable.size

    /** Call [NodeManager.button] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@LayoutsDslMarker Button).() -> Unit
    ): Button = button(this, graphic, configuration)
}

/** Create a [ButtonBar] with initialization block. */
inline fun buttonBar(
    buttonOrder: String? = null,
    configuration: (@LayoutsDslMarker KtfxButtonBar).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxButtonBar(buttonOrder).apply(configuration)
}

/** Add a [ButtonBar] to this manager. */
fun NodeManager.buttonBar(
    buttonOrder: String? = null
): ButtonBar = addChild(KtfxButtonBar(buttonOrder))

/** Add a [ButtonBar] with initialization block to this manager. */
inline fun NodeManager.buttonBar(
    buttonOrder: String? = null,
    configuration: (@LayoutsDslMarker KtfxButtonBar).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxButtonBar(buttonOrder), configuration)
}
