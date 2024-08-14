@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRippler
import javafx.scene.Node
import ktfx.layouts.NodeContainer

/** [JFXRippler] with dynamic-layout dsl support. Invoking dsl will only set its children. */
public open class KtfxJfxRippler :
    JFXRippler(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { control = it }
}
