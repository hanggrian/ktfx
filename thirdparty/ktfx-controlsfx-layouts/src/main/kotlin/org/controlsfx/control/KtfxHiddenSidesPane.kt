@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")

package ktfx.controlsfx.layouts

import javafx.scene.Node
import ktfx.layouts.NodeContainer
import org.controlsfx.control.HiddenSidesPane

/**
 * [HiddenSidesPane] with dynamic-layout dsl support. Invoking dsl will only set its content.
 */
open class KtfxHiddenSidesPane :
    HiddenSidesPane(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { content = it }
}
