@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXBadge
import javafx.scene.Node
import ktfx.layouts.NodeContainer

/**
 * [JFXBadge] with dynamic-layout dsl support.
 * Invoking dsl will only set its control.
 */
open class KtfxJfxBadge : JFXBadge(), NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { control = it }
}
