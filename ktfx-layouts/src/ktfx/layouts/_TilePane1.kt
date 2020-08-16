@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.layout.TilePane
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [TilePane] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.tilePane(orientation: Orientation = HORIZONTAL, gap: Double = 0.0): TilePane =
    tilePane(orientation = orientation, gap = gap) { }

/**
 * Create a [TilePane] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun tilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    configuration: (@LayoutDslMarker KtfxTilePane).() -> Unit
): TilePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTilePane(orientation, gap)
    child.configuration()
    return child
}

/**
 * Add a [TilePane] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.tilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    configuration: (@LayoutDslMarker KtfxTilePane).() -> Unit
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
fun styledTilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): TilePane = styledTilePane(
    orientation = orientation, gap = gap, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Add a styled [TilePane] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledTilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): TilePane = styledTilePane(
    orientation = orientation, gap = gap, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Create a styled [TilePane] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledTilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTilePane).() -> Unit
): TilePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTilePane(orientation, gap)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [TilePane] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledTilePane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTilePane).() -> Unit
): TilePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTilePane(orientation, gap)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
