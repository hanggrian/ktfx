@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane
import kotlin.contracts.ExperimentalContracts

/**
 * [TitledPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxTitledPane(title: String?) : TitledPane(title, null), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }
}
