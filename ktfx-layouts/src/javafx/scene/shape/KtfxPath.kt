@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Path
import javafx.scene.shape.PathElement
import kotlin.contracts.ExperimentalContracts

/**
 * [Path] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxPath : Path(), PathElementManager {

    final override fun <C : PathElement> addChild(child: C): C = child.also { elements += it }
}
