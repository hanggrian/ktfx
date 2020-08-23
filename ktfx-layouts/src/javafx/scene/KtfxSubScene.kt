@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.SubScene
import javafx.scene.layout.Pane
import kotlin.contracts.ExperimentalContracts

/**
 * [SubScene] with dynamic-layout dsl support.
 * Invoking dsl will only set its root.
 */
open class KtfxSubScene(root: Parent, width: Double, height: Double) : SubScene(root, width, height), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { root = it as? Pane ?: Pane(it) }
}
