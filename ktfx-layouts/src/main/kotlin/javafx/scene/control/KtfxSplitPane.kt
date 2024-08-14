@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane

/**
 * [SplitPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxSplitPane :
    SplitPane(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { items += it }
}
