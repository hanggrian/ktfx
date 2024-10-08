@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.SubScene
import javafx.scene.layout.Pane

/**
 * [SubScene] with dynamic-layout dsl support.
 * Invoking dsl will only set its root.
 */
public open class KtfxSubScene(root: Parent, width: Double, height: Double) :
    SubScene(root, width, height),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T =
        child.also {
            root = it as? Pane ?: Pane(it)
        }
}
