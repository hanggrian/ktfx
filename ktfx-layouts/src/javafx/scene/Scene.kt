@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.stage.Stage
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [Scene] with dynamic-layout dsl support.
 * Invoking dsl will only set its root.
 */
open class KtfxScene(root: Parent, width: Double, height: Double, fill: Paint) :
    Scene(root, width, height, fill), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { root = it as? Pane ?: Pane(it) }
}

/** Create a [Scene] with initialization block. */
inline fun scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = Color.WHITE,
    init: (@KtfxLayoutsDslMarker KtfxScene).() -> Unit
): Scene {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxScene(Pane(), width, height, fill).apply(init)
}

/** Add a [Scene] to this window. */
fun Stage.scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = Color.WHITE
): Scene = KtfxScene(Pane(), width, height, fill).also { scene = it }

/** Add a [Scene] with initialization block to this window. */
inline fun Stage.scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = Color.WHITE,
    init: (@KtfxLayoutsDslMarker KtfxScene).() -> Unit
): Scene {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.scene(width, height, fill, init).also { scene = it }
}
