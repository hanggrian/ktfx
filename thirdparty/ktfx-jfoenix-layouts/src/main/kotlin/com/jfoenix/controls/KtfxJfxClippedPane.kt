@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXClippedPane
import javafx.scene.Node
import ktfx.layouts.NodeContainer

/** [JFXClippedPane] with dynamic-layout dsl support. Invoking dsl will add its children. */
open class KtfxJfxClippedPane :
    JFXClippedPane(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }
}
