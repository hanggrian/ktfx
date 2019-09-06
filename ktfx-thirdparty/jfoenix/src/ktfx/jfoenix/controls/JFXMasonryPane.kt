@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXMasonryPane
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXMasonryPane] with initialization block. */
inline fun jfxMasonryPane(
    init: (@LayoutDslMarker JFXMasonryPane).() -> Unit
): JFXMasonryPane = JFXMasonryPane().apply(init)

/** Add a [JFXMasonryPane] to this manager. */
fun NodeManager.jfxMasonryPane(): JFXMasonryPane =
    addNode(ktfx.jfoenix.jfxMasonryPane { })

/** Add a [JFXMasonryPane] with initialization block to this manager. */
inline fun NodeManager.jfxMasonryPane(
    init: (@LayoutDslMarker JFXMasonryPane).() -> Unit
): JFXMasonryPane = addNode(ktfx.jfoenix.jfxMasonryPane(init))
