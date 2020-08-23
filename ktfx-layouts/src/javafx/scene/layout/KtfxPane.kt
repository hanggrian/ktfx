@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane
import kotlin.contracts.ExperimentalContracts

/**
 * [Pane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxPane : Pane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }
}
