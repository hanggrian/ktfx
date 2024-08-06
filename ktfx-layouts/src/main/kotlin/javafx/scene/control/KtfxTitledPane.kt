@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane
import kotlin.contracts.ExperimentalContracts

/**
 * [TitledPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxTitledPane(title: String?) :
    TitledPane(title, null),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { content = it }
}
