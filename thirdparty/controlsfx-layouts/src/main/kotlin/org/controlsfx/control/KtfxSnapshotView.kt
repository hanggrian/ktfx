@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")

package ktfx.controlsfx.layouts

import javafx.scene.Node
import ktfx.layouts.NodeManager
import org.controlsfx.control.SnapshotView

/** [SnapshotView] with dynamic-layout dsl support. Invoking dsl will only set its node. */
open class KtfxSnapshotView : SnapshotView(), NodeManager {
    final override fun <C : Node> addChild(child: C): C = child.also { this.node = it }
}
