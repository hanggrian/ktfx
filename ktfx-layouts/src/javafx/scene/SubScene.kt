@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.SubScene
import javafx.scene.layout.Pane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [SubScene] with dynamic-layout dsl support.
 * Invoking dsl will only set its root.
 */
open class KtfxSubScene(root: Parent, width: Double, height: Double) : SubScene(root, width, height), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { root = it as? Pane ?: Pane(it) }
}

/** Create a [SubScene] with configurationialization block. */
inline fun subScene(
    width: Double = -1.0,
    height: Double = -1.0,
    configuration: (@LayoutDslMarker KtfxSubScene).() -> Unit
): SubScene {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxSubScene(Pane(), width, height).apply(configuration)
}
