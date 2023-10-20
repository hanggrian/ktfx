@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.shape.Path
import javafx.scene.shape.PathElement

/**
 * [Path] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxPath : Path(), PathElementContainer {
    final override fun <T : PathElement> addChild(child: T): T = child.also { elements += it }
}
