@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToolBar
import kotlin.contracts.ExperimentalContracts

/**
 * [ToolBar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxToolBar : ToolBar(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { items += it }
}
