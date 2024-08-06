@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import kotlin.contracts.ExperimentalContracts

/**
 * [TextFlow] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxTextFlow :
    TextFlow(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }

    /** Call [NodeContainer.text] by string invocation. */
    inline operator fun String.invoke(configuration: (@KtfxLayoutDslMarker Text).() -> Unit): Text =
        text(this, configuration)
}
