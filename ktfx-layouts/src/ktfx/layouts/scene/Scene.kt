@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint
import javafx.stage.Stage
import ktfx.internal.KtfxInternals

open class _Scene(root: Parent, width: Double, height: Double, fill: Paint) :
    Scene(root, width, height, fill), NodeManager {

    override fun <T : Node> T.add(): T = also { root = KtfxInternals.asPane(it) }
}

/** Add a [Scene] to this window. */
fun Stage.scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = WHITE
): Scene = _Scene(Pane(), width, height, fill).also { scene = it }

/** Add a [Scene] with initialization block to this window. */
inline fun Stage.scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = WHITE,
    init: (@LayoutDslMarker _Scene).() -> Unit
): Scene = (scene(width, height, fill) as _Scene).apply(init)
