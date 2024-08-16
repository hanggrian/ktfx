@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.Group
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Group] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.group(): Group = group() { }

/**
 * Create a [Group] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun group(configuration: (@KtfxLayoutDslMarker KtfxGroup).() -> Unit): Group {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxGroup()
    child.configuration()
    return child
}

/**
 * Add a [Group] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.group(configuration: (@KtfxLayoutDslMarker KtfxGroup).() -> Unit):
        Group {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxGroup()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Group].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledGroup(vararg styleClass: String, id: String? = null): Group =
        styledGroup(styleClass = styleClass, id = id) { }

/**
 * Add a styled [Group] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledGroup(vararg styleClass: String, id: String? = null): Group =
        styledGroup(styleClass = styleClass, id = id) { }

/**
 * Create a styled [Group] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledGroup(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxGroup).() -> Unit,
): Group {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxGroup()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Group] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledGroup(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxGroup).() -> Unit,
): Group {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxGroup()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
