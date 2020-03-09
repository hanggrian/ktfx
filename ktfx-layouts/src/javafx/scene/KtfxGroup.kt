@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Scene
import kotlin.contracts.ExperimentalContracts

/**
 * [Scene] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxGroup : Group(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }
}
