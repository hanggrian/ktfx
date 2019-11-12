@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class KtfxStackPane : StackPane(), NodeManager, AlignConstraints, MarginConstraints {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Node.removeConstraints(): Unit =
        clearConstraints(this)

    final override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    final override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Create a [StackPane] with initialization block. */
inline fun stackPane(
    init: KtfxStackPane.() -> Unit
): StackPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxStackPane().apply(init)
}
/** Add a [StackPane] to this manager. */
fun NodeManager.stackPane(): StackPane =
    addNode(KtfxStackPane())

/** Add a [StackPane] with initialization block to this manager. */
inline fun NodeManager.stackPane(
    init: KtfxStackPane.() -> Unit
): StackPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxStackPane(), init)
}
