@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab

/**
 * [Tab] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
public open class KtfxTab(title: String?, content: Node?) :
    Tab(title, content),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { content = it }
}
