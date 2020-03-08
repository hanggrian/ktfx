@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import kotlin.contracts.ExperimentalContracts

/**
 * [Tab] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxTab(title: String?, content: Node?) : Tab(title, content), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }
}
