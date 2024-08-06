@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import kotlin.contracts.ExperimentalContracts

/**
 * [ButtonBar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxButtonBar(buttonOrder: String?) :
    ButtonBar(buttonOrder),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { buttons += it }

    /** Call [NodeContainer.button] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker Button).() -> Unit,
    ): Button = button(this, graphic, configuration)
}
