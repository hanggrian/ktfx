@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXTabPane
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXTabPane]. */
fun jfxTabPane(
    init: ((@LayoutDsl JFXTabPane).() -> Unit)? = null
): JFXTabPane = JFXTabPane().also { init?.invoke(it) }

/** Creates a [JFXTabPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxTabPane(
    noinline init: ((@LayoutDsl JFXTabPane).() -> Unit)? = null
): JFXTabPane = ktfx.jfoenix.jfxTabPane(init)()