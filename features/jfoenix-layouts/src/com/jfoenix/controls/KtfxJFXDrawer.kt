@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import ktfx.layouts.NodeManager

/**
 * [JFXDrawer] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXDrawer : JFXDrawer(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content += it }
}
