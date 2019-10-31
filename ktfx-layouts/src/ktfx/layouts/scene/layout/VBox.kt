@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox

open class KtfxVBox(spacing: Double) : VBox(spacing), NodeManager, VGrowConstraints, MarginConstraints {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Node.reset(): Unit =
        clearConstraints(this)

    final override var Node.vpriority: Priority?
        get() = getVgrow(this)
        set(value) = setVgrow(this, value)

    final override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Create a [VBox] with initialization block. */
inline fun vbox(
    spacing: Double = 0.0,
    init: (@LayoutDslMarker KtfxVBox).() -> Unit
): VBox = KtfxVBox(spacing).apply(init)

/** Add a [VBox] to this manager. */
fun NodeManager.vbox(
    spacing: Double = 0.0
): VBox = addNode(KtfxVBox(spacing))

/** Add a [VBox] with initialization block to this manager. */
inline fun NodeManager.vbox(
    spacing: Double = 0.0,
    init: (@LayoutDslMarker KtfxVBox).() -> Unit
): VBox = addNode(KtfxVBox(spacing), init)
