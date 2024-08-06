@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTogglePane
import javafx.scene.Node
import ktfx.layouts.NodeContainer

/** [JFXTogglePane] with dynamic-layout dsl support. Invoking dsl will only set its content. */
open class KtfxJfxTogglePane :
    JFXTogglePane(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { contentNode = it }
}
