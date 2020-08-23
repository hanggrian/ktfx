@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane
import kotlin.contracts.ExperimentalContracts

/**
 * [SplitPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxSplitPane : SplitPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { items += it }
}
