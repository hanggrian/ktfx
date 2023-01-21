@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXNodesList
import javafx.scene.Node
import ktfx.layouts.NodeManager

/** [JFXNodesList] with dynamic-layout dsl support. Invoking dsl will add its children. */
open class KtfxJfxNodesList : JFXNodesList(), NodeManager {
    final override fun <C : Node> addChild(child: C): C = child.also { children += it }
}
