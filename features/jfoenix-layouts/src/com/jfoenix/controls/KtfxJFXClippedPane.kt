@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXClippedPane
import javafx.scene.Node
import ktfx.layouts.NodeManager
import kotlin.contracts.ExperimentalContracts

/**
 * [JFXClippedPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXClippedPane : JFXClippedPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }
}
