@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")

package ktfx.controlsfx.layouts

import javafx.scene.Node
import ktfx.layouts.NodeContainer
import org.controlsfx.control.SnapshotView

/** [SnapshotView] with dynamic-layout dsl support. Invoking dsl will only set its node. */
public open class KtfxSnapshotView :
    SnapshotView(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { this.node = it }
}
