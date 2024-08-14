@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToolBar

/**
 * [ToolBar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxToolBar :
    ToolBar(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { items += it }
}
