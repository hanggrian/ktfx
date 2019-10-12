@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint
import javafx.stage.Stage

open class KtfxScene(root: Parent, width: Double, height: Double, fill: Paint) :
    Scene(root, width, height, fill), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { root = it as? Pane ?: Pane(it) }
}

/** Create a [Scene] with initialization block. */
inline fun scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = WHITE,
    init: (@LayoutDslMarker KtfxScene).() -> Unit
): Scene = KtfxScene(Pane(), width, height, fill).apply(init)

/** Add a [Scene] to this window. */
fun Stage.scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = WHITE
): Scene = ktfx.layouts.scene(width, height, fill) { }.also { scene = it }

/** Add a [Scene] with initialization block to this window. */
inline fun Stage.scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = WHITE,
    init: (@LayoutDslMarker KtfxScene).() -> Unit
): Scene = ktfx.layouts.scene(width, height, fill, init).also { scene = it }
