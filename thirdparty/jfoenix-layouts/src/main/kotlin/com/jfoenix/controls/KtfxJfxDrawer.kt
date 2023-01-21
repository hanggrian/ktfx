@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
import javafx.scene.Node
import ktfx.layouts.NodeManager

/** [JFXDrawer] with dynamic-layout dsl support. Invoking dsl will add its children. */
open class KtfxJfxDrawer : JFXDrawer(), NodeManager {
    final override fun <C : Node> addChild(child: C): C = child.also { content += it }
}
