@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXMasonryPane
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXMasonryPane] to this manager. */
fun NodeManager.jfxMasonryPane(): JFXMasonryPane =
    JFXMasonryPane().add()

/** Add a [JFXMasonryPane] with initialization to this manager. */
inline fun NodeManager.jfxMasonryPane(
    init: (@LayoutDslMarker JFXMasonryPane).() -> Unit
): JFXMasonryPane = jfxMasonryPane().apply(init)
