@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane
import kotlin.contracts.ExperimentalContracts

/**
 * [ScrollPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxScrollPane(content: Node?) : ScrollPane(content), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }
}
