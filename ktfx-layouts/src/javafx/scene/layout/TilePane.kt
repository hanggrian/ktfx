@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")
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
    NodeManager {

    final override fun <T : Node> addNode(node: T): T = node.also { children += it }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clear(): Unit = clearConstraints(this)

    /** Children alignment in this layout. */
    inline var Node.alignment: Pos?
        @JvmName("getAlignment2") get() = getAlignment(this)
        @JvmName("setAlignment2") set(value) = setAlignment(this, value)

    /** Configure alignment fluidly using infix operator. */
    inline infix fun <T : Node> T.align(pos: Pos): T = apply { alignment = pos }

    /** Children margin in this layout. */
    inline var Node.margin: Insets?
        @JvmName("getMargin2") get() = getMargin(this)
        @JvmName("setMargin2") set(value) = setMargin(this, value)

    /** Configure children margin, taking account of current margin. */
    inline fun Node.updateMargin(
        top: Double? = margin?.top,
        right: Double? = margin?.right,
        bottom: Double? = margin?.bottom,
        left: Double? = margin?.left
    ) {
        margin = Insets(top ?: 0.0, right ?: 0.0, bottom ?: 0.0, left ?: 0.0)
    }

    /** Configure margin fluidly using infix operator. */
    inline infix fun <T : Node> T.margin(margin: Insets): T = apply { this.margin = margin }

    /** Configure all sides margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginAll(margin: Double): T = apply { this.margin = Insets(margin) }

    /** Configure top margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginTop(margin: Double): T = apply { updateMargin(top = margin) }

    /** Configure right margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginRight(margin: Double): T = apply { updateMargin(right = margin) }

    /** Configure bottom margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginBottom(margin: Double): T = apply { updateMargin(bottom = margin) }

    /** Configure left margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginLeft(margin: Double): T = apply { updateMargin(left = margin) }
}

/** Create a [TilePane] with initialization block. */
inline fun tilePane(
    orientation: Orientation = Orientation.HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap,
    init: (@KtfxLayoutsDslMarker KtfxTilePane).() -> Unit
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
    init: (@KtfxLayoutsDslMarker KtfxTilePane).() -> Unit
): TilePane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxTilePane(orientation, hgap, vgap), init)
}
