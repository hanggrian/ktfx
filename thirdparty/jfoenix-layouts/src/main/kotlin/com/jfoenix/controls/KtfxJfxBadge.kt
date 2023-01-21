@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXBadge
import javafx.scene.Node
import ktfx.layouts.NodeManager

/**
 * [JFXBadge] with dynamic-layout dsl support.
 * Invoking dsl will only set its control.
 */
open class KtfxJfxBadge : JFXBadge(), NodeManager {
    final override fun <C : Node> addChild(child: C): C = child.also { control = it }
}
