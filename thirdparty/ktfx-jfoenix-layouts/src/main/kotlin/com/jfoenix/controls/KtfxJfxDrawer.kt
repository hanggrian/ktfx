@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
import javafx.scene.Node
import ktfx.layouts.NodeContainer

/** [JFXDrawer] with dynamic-layout dsl support. Invoking dsl will add its children. */
public open class KtfxJfxDrawer :
    JFXDrawer(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { content += it }
}
