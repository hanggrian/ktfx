@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToolBar
import kotlin.contracts.ExperimentalContracts

/**
 * [ToolBar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxToolBar : ToolBar(), NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { items += it }
}
