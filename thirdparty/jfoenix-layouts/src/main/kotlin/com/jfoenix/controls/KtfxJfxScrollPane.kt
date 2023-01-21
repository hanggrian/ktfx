@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXScrollPane
import javafx.scene.Node
import ktfx.layouts.NodeManager

/** [JFXScrollPane] with dynamic-layout dsl support. Invoking dsl will only set its content. */
open class KtfxJfxScrollPane : JFXScrollPane(), NodeManager {
    final override fun <C : Node> addChild(child: C): C = child.also { content = it }
}
