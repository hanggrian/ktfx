@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXNodesList
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXNodesList] with initialization block. */
inline fun jfxNodesList(
    init: (@LayoutDslMarker JFXNodesList).() -> Unit
): JFXNodesList = JFXNodesList().apply(init)

/** Add a [JFXNodesList] to this manager. */
fun NodeManager.jfxNodesList(): JFXNodesList =
    addNode(JFXNodesList())

/** Add a [JFXNodesList] with initialization block to this manager. */
inline fun NodeManager.jfxNodesList(
    init: (@LayoutDslMarker JFXNodesList).() -> Unit
): JFXNodesList = addNode(JFXNodesList(), init)
