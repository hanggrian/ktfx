@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import kotlin.contracts.ExperimentalContracts

/**
 * [Tab] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxTab(title: String?, content: Node?) :
    Tab(title, content),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { content = it }
}
