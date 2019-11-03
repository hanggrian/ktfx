@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXRadioButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXRadioButton] with initialization block. */
inline fun jfxRadioButton(
    text: String? = null,
    init: (@LayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton = JFXRadioButton(text).apply(init)

/** Add a [JFXRadioButton] to this manager. */
fun NodeManager.jfxRadioButton(
    text: String? = null
): JFXRadioButton = addNode(JFXRadioButton(text))

/** Add a [JFXRadioButton] with initialization block to this manager. */
inline fun NodeManager.jfxRadioButton(
    text: String? = null,
    init: (@LayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton = addNode(JFXRadioButton(text), init)
