@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXMasonryPane
import javafx.scene.Node
import ktfx.layouts.NodeContainer

/** [JFXMasonryPane] with dynamic-layout dsl support. Invoking dsl will add its children. */
open class KtfxJfxMasonryPane :
    JFXMasonryPane(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }
}
