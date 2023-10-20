@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXScrollPane
import javafx.scene.Node
import ktfx.layouts.NodeContainer

/** [JFXScrollPane] with dynamic-layout dsl support. Invoking dsl will only set its content. */
open class KtfxJfxScrollPane : JFXScrollPane(), NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { content = it }
}
