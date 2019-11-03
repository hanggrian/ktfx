@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXDrawersStack
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXDrawersStack] with initialization block. */
inline fun jfxDrawersStack(
    init: (@LayoutDslMarker JFXDrawersStack).() -> Unit
): JFXDrawersStack = JFXDrawersStack().apply(init)

/** Add a [JFXDrawersStack] to this manager. */
fun NodeManager.jfxDrawersStack(): JFXDrawersStack =
    addNode(JFXDrawersStack())

/** Add a [JFXDrawersStack] with initialization block to this manager. */
inline fun NodeManager.jfxDrawersStack(
    init: (@LayoutDslMarker JFXDrawersStack).() -> Unit
): JFXDrawersStack = addNode(JFXDrawersStack(), init)
