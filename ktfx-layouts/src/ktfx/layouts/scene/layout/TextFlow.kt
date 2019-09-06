@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow

open class _TextFlow : TextFlow(), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { children += it }

    /** Call [NodeManager.text] by string invocation. */
    inline operator fun String.invoke(
        init: (@LayoutDslMarker Text).() -> Unit
    ): Text = text(this, init)

    /** Append a new line to this flow. */
    fun newLine(): Text = text(System.lineSeparator())
}

/** Create a [TextFlow] with initialization block. */
inline fun textFlow(
    init: (@LayoutDslMarker _TextFlow).() -> Unit
): TextFlow = _TextFlow().apply(init)

/** Add a [TextFlow] to this manager. */
fun NodeManager.textFlow(): TextFlow =
    addNode(ktfx.layouts.textFlow { })

/** Add a [TextFlow] with initialization block to this manager. */
inline fun NodeManager.textFlow(
    init: (@LayoutDslMarker _TextFlow).() -> Unit
): TextFlow = addNode(ktfx.layouts.textFlow(init))
