@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow

/**
 * [TextFlow] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxTextFlow :
    TextFlow(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }

    /** Call [NodeContainer.text] by string invocation. */
    public inline operator fun String.invoke(
        noinline configuration: (@KtfxLayoutDslMarker Text).() -> Unit,
    ): Text = text(this, configuration)
}
