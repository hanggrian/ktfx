@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class KtfxVBox(spacing: Double) : VBox(spacing), NodeManager, VGrowConstraints, MarginConstraints {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Node.reset(): Unit =
        clearConstraints(this)

    final override var Node.vgrows: Priority?
        get() = getVgrow(this)
        set(value) = setVgrow(this, value)

    final override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Create a [VBox] with initialization block. */
inline fun vbox(
    spacing: Double = 0.0,
    init: KtfxVBox.() -> Unit
): VBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxVBox(spacing).apply(init)
}
/** Add a [VBox] to this manager. */
fun NodeManager.vbox(
    spacing: Double = 0.0
): VBox = addNode(KtfxVBox(spacing))

/** Add a [VBox] with initialization block to this manager. */
inline fun NodeManager.vbox(
    spacing: Double = 0.0,
    init: KtfxVBox.() -> Unit
): VBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxVBox(spacing), init)
}
