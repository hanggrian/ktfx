@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane

/**
 * [Pane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxPane :
    Pane(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }
}
