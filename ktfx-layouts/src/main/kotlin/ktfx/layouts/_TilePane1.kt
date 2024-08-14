@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.layout.TilePane
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [TilePane] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.tilePane(orientation: Orientation = HORIZONTAL, gap: Double = 0.0):
        TilePane = tilePane(orientation = orientation, gap = gap) { }

/**
 * Create a [TilePane] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun tilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker KtfxTilePane).() -> Unit,
): TilePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTilePane(orientation, gap)
    child.configuration()
    return child
}

/**
 * Add a [TilePane] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.tilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker KtfxTilePane).() -> Unit,
): TilePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTilePane(orientation, gap)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [TilePane].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledTilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): TilePane = styledTilePane(orientation = orientation, gap = gap, styleClass = styleClass, id = id)
        { }

/**
 * Add a styled [TilePane] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledTilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): TilePane = styledTilePane(orientation = orientation, gap = gap, styleClass = styleClass, id = id)
        { }

/**
 * Create a styled [TilePane] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledTilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxTilePane).() -> Unit,
): TilePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTilePane(orientation, gap)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [TilePane] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledTilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxTilePane).() -> Unit,
): TilePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTilePane(orientation, gap)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
