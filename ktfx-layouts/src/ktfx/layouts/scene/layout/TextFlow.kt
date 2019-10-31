@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow

open class KtfxTextFlow : TextFlow(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    /** Call [NodeManager.text] by string invocation. */
    inline operator fun String.invoke(
        init: (@LayoutDslMarker Text).() -> Unit
    ): Text = text(this, init)

    /** Append a new line to this flow. */
    fun newLine(): Text =
        text(System.lineSeparator())
}

/** Create a [TextFlow] with initialization block. */
inline fun textFlow(
    init: (@LayoutDslMarker KtfxTextFlow).() -> Unit
): TextFlow = KtfxTextFlow().apply(init)

/** Add a [TextFlow] to this manager. */
fun NodeManager.textFlow(): TextFlow =
    addNode(KtfxTextFlow())

/** Add a [TextFlow] with initialization block to this manager. */
inline fun NodeManager.textFlow(
    init: (@LayoutDslMarker KtfxTextFlow).() -> Unit
): TextFlow = addNode(KtfxTextFlow(), init)
