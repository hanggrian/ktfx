@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.TilePane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [TilePane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxTilePane(orientation: Orientation, hgap: Double, vgap: Double) : TilePane(orientation, hgap, vgap),
    NodeManager, AlignmentConstraintable, MarginConstraintable {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Constraints.clear(): Unit =
        clearConstraints(node)

    final override var Constraints.alignment: Pos?
        get() = getAlignment(node)
        set(value) = setAlignment(node, value)

    final override var Constraints.margin: Insets?
        get() = getMargin(node)
        set(value) = setMargin(node, value)
}

/** Create a [TilePane] with initialization block. */
inline fun tilePane(
    orientation: Orientation = Orientation.HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap,
    init: KtfxTilePane.() -> Unit
): TilePane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxTilePane(orientation, hgap, vgap).apply(init)
}

/** Add a [TilePane] to this manager. */
fun NodeManager.tilePane(
    orientation: Orientation = Orientation.HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap
): TilePane = addNode(KtfxTilePane(orientation, hgap, vgap))

/** Add a [TilePane] with initialization block to this manager. */
inline fun NodeManager.tilePane(
    orientation: Orientation = Orientation.HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    init: KtfxTilePane.() -> Unit
): TilePane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxTilePane(orientation, hgap, vgap), init)
}
