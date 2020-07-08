@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.layout.TilePane
import ktfx.internal.KtfxInternals.newChild
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
 */
fun NodeManager.tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double
): TilePane = tilePane(orientation = orientation, hgap = hgap, vgap = vgap) { }

/**
 * Create a [TilePane] with configuration block.
 */
inline fun tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    configuration: (@LayoutDslMarker KtfxTilePane).() -> Unit
): TilePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxTilePane(orientation, hgap, vgap), configuration = configuration)
}

/**
 * Add a [TilePane] with configuration block to this manager.
 */
inline fun NodeManager.tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    configuration: (@LayoutDslMarker KtfxTilePane).() -> Unit
): TilePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxTilePane(orientation, hgap, vgap), configuration = configuration))
}

/**
 * Create a styled [TilePane].
 */
fun styledTilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null
): TilePane = styledTilePane(
    orientation = orientation, hgap = hgap, vgap = vgap,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [TilePane] to this manager.
 */
fun NodeManager.styledTilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null
): TilePane = styledTilePane(
    orientation = orientation, hgap = hgap, vgap = vgap,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Create a styled [TilePane] with configuration block.
 */
inline fun styledTilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTilePane).() -> Unit
): TilePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxTilePane(orientation, hgap, vgap), styleClass = *styleClass, id = id,
        configuration = configuration
    )
}

/**
 * Add a styled [TilePane] with configuration block to this manager.
 */
inline fun NodeManager.styledTilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTilePane).() -> Unit
): TilePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxTilePane(orientation, hgap, vgap), styleClass = *styleClass,
            id =
                id,
            configuration = configuration
        )
    )
}
