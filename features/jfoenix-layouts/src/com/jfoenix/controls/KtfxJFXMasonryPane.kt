@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXMasonryPane
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import ktfx.layouts.NodeManager

/**
 * [JFXMasonryPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXMasonryPane : JFXMasonryPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }
}
