@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.layout.Region
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Region] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.region(): Region = region() { }

/**
 * Create a [Region] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun region(configuration: (@KtfxLayoutDslMarker Region).() -> Unit): Region {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Region()
    child.configuration()
    return child
}

/**
 * Add a [Region] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.region(configuration: (@KtfxLayoutDslMarker Region).() -> Unit):
        Region {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Region()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Region].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledRegion(vararg styleClass: String, id: String? = null): Region =
        styledRegion(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Region] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledRegion(vararg styleClass: String, id: String? = null): Region =
        styledRegion(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Region] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledRegion(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Region).() -> Unit,
): Region {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Region()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Region] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledRegion(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Region).() -> Unit,
): Region {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Region()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
