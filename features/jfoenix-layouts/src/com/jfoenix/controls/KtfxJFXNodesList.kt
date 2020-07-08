@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXNodesList
import javafx.scene.Node
import ktfx.layouts.NodeManager
import kotlin.contracts.ExperimentalContracts

/**
 * [JFXNodesList] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXNodesList : JFXNodesList(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }
}
