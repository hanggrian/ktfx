@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTextField
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutMarker

/** Creates a [JFXTextField]. */
fun jfxTextField(
    text: String? = null,
    init: ((@LayoutMarker JFXTextField).() -> Unit)? = null
): JFXTextField = JFXTextField(text.orEmpty()).also { init?.invoke(it) }

/** Creates a [JFXTextField] and add it to this manager. */
inline fun NodeManager.jfxTextField(
    text: String? = null,
    noinline init: ((@LayoutMarker JFXTextField).() -> Unit)? = null
): JFXTextField = ktfx.jfoenix.jfxTextField(text, init).add()