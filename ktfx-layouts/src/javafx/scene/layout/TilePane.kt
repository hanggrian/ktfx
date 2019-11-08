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

open class KtfxTilePane(orientation: Orientation, hgap: Double, vgap: Double) : TilePane(orientation, hgap, vgap),
    NodeManager, AlignConstraints, MarginConstraints {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Node.reset(): Unit =
        clearConstraints(this)

    final override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    final override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
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
