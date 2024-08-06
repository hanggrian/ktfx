@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXNodesList
import javafx.scene.Node
import ktfx.layouts.NodeContainer

/** [JFXNodesList] with dynamic-layout dsl support. Invoking dsl will add its children. */
open class KtfxJfxNodesList :
    JFXNodesList(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }
}
