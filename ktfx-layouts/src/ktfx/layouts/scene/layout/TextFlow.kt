@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow

open class _TextFlow : TextFlow(), NodeManager {

    override fun <R : Node> R.add(): R = also { children += it }

    /** Call [NodeManager.text] by string invocation. */
    inline operator fun String.invoke(
        init: (@LayoutDslMarker Text).() -> Unit
    ): Text = text(this, init)

    /** Append a new line to this flow. */
    fun newLine(): Text = text(System.lineSeparator())
}

/** Add a [TextFlow] to this manager. */
fun NodeManager.textFlow(): TextFlow =
    TextFlow().add()

/** Add a [TextFlow] with initialization block to this manager. */
inline fun NodeManager.textFlow(
    init: (@LayoutDslMarker _TextFlow).() -> Unit
): TextFlow = (textFlow() as _TextFlow).apply(init)
