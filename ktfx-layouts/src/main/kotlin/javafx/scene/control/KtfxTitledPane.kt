@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane

/**
 * [TitledPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
public open class KtfxTitledPane(title: String?) :
    TitledPane(title, null),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { content = it }
}
