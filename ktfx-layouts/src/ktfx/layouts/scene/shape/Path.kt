@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.shape.Path
import javafx.scene.shape.PathElement
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [Path]. */
fun path(
    vararg elements: PathElement,
    init: ((@LayoutDsl Path).() -> Unit)? = null
): Path = Path(*elements).also { init?.invoke(it) }

/** Creates a [Path] and add it to this manager. */
inline fun NodeManager.path(
    vararg elements: PathElement,
    noinline init: ((@LayoutDsl Path).() -> Unit)? = null
): Path = ktfx.layouts.path(*elements, init = init)()