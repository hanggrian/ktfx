@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")

package ktfx.controlsfx.layouts

import javafx.scene.Node
import ktfx.layouts.NodeContainer
import org.controlsfx.control.InfoOverlay

/** [InfoOverlay] with dynamic-layout dsl support. Invoking dsl will only set its content. */
open class KtfxInfoOverlay(graphic: Node?, text: String?) :
    InfoOverlay(graphic, text), NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { content = it }
}
