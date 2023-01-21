@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTogglePane
import javafx.scene.Node
import ktfx.layouts.NodeManager

/** [JFXTogglePane] with dynamic-layout dsl support. Invoking dsl will only set its content. */
open class KtfxJfxTogglePane : JFXTogglePane(), NodeManager {
    final override fun <C : Node> addChild(child: C): C = child.also { contentNode = it }
}
