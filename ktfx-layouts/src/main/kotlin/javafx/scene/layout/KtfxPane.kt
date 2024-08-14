@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane
import kotlin.contracts.ExperimentalContracts

/**
 * [Pane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxPane :
    Pane(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }
}
