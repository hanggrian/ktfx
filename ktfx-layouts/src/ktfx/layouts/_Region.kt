@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.Region
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Region] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.region(): Region = region() { }

/**
 * Create a [Region] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun region(configuration: (@LayoutDslMarker Region).() -> Unit): Region {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Region(), configuration = configuration)
}

/**
 * Add a [Region] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.region(configuration: (@LayoutDslMarker Region).() -> Unit): Region {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Region(), configuration = configuration))
}

/**
 * Create a styled [Region].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledRegion(vararg styleClass: String, id: String? = null): Region = styledRegion(
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [Region] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledRegion(vararg styleClass: String, id: String? = null): Region =
    styledRegion(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Region] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledRegion(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Region).() -> Unit
): Region {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Region(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Region] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledRegion(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Region).() -> Unit
): Region {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            Region(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}