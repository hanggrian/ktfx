@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.shape.Path
import javafx.scene.shape.PathElement

open class KtfxPath : Path(), PathElementManager {

    final override fun <T : PathElement> addElement(element: T): T =
        element.also { elements += it }
}

/** Create a [Path] with initialization block. */
inline fun path(
    init: (@LayoutDslMarker KtfxPath).() -> Unit
): Path = KtfxPath().apply(init)

/** Add a [Path] to this manager. */
fun NodeManager.path(): Path =
    addNode(KtfxPath())

/** Add a [Path] with initialization block to this manager. */
inline fun NodeManager.path(
    init: (@LayoutDslMarker KtfxPath).() -> Unit
): Path = addNode(KtfxPath(), init)
