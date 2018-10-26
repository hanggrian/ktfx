@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import ktfx.internal.KtfxInternals

open class _Scene(
    root: Parent,
    width: Double,
    height: Double,
    fill: Paint
) : Scene(root, width, height, fill), NodeManager by NodeManager.invokableOnly() {

    override operator fun <T : Node> T.invoke(): T = also { root = KtfxInternals.asPane(it) }
}

/** Create a [Scene] with initialization. */
fun scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = WHITE,
    init: ((@LayoutDsl _Scene).() -> Unit)? = null
): Scene = _Scene(Pane(), width, height, fill).also { init?.invoke(it) }