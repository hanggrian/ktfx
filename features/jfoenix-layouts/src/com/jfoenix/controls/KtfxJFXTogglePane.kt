@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTogglePane
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import ktfx.layouts.NodeManager

/**
 * [JFXTogglePane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxJFXTogglePane : JFXTogglePane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { contentNode = it }
}
