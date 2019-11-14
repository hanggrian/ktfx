@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [BorderPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content. There is currently no way to configure other areas (top, left, right, bottom) with dsl.
 * Instead, create an instance and set it manually (e.g: `left = ktfx.layouts.label()`).
 */
open class KtfxBorderPane : BorderPane(), AlignConstraints, MarginConstraints, NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { center = it }

    final override fun Node.removeConstraints(): Unit =
        clearConstraints(this)

    final override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    final override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Create a [BorderPane] with initialization block. */
inline fun borderPane(
    init: KtfxBorderPane.() -> Unit
): BorderPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxBorderPane().apply(init)
}

/** Add a [BorderPane] to this manager. */
fun NodeManager.borderPane(): BorderPane =
    addNode(KtfxBorderPane())

/** Add a [BorderPane] with initialization block to this manager. */
inline fun NodeManager.borderPane(
    init: KtfxBorderPane.() -> Unit
): BorderPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxBorderPane(), init)
}
