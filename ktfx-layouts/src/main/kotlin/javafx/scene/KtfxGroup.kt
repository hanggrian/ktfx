@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
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
open class KtfxGroup :
    Group(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }
}
