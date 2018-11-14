@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow

open class _TextFlow : TextFlow(), NodeInvokable {

    override fun <R : Node> R.invoke(): R = also { children += it }

    /** Creates a [Text] and add it to this manager. */
    inline operator fun String.invoke(
        noinline init: ((@LayoutDsl Text).() -> Unit)? = null
    ): Text = text(this, init)

    inline fun newLine(): Text = text(System.lineSeparator())
}

/** Creates a [TextFlow]. */
fun textFlow(
    init: ((@LayoutDsl _TextFlow).() -> Unit)? = null
): TextFlow = _TextFlow().also { init?.invoke(it) }

/** Creates a [TextFlow] and add it to this manager. */
inline fun NodeInvokable.textFlow(
    noinline init: ((@LayoutDsl _TextFlow).() -> Unit)? = null
): TextFlow = ktfx.layouts.textFlow(init)()