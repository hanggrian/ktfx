@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRippler
import javafx.scene.Node
import ktfx.layouts.NodeManager

/** [JFXRippler] with dynamic-layout dsl support. Invoking dsl will only set its children. */
open class KtfxJfxRippler : JFXRippler(), NodeManager {
    final override fun <C : Node> addChild(child: C): C = child.also { control = it }
}
