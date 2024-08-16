@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.shape.Path
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Path] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.path(): Path = path() { }

/**
 * Create a [Path] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun path(configuration: (@KtfxLayoutDslMarker KtfxPath).() -> Unit): Path {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxPath()
    child.configuration()
    return child
}

/**
 * Add a [Path] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.path(configuration: (@KtfxLayoutDslMarker KtfxPath).() -> Unit):
        Path {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxPath()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Path].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledPath(vararg styleClass: String, id: String? = null): Path =
        styledPath(styleClass = styleClass, id = id) { }

/**
 * Add a styled [Path] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledPath(vararg styleClass: String, id: String? = null): Path =
        styledPath(styleClass = styleClass, id = id) { }

/**
 * Create a styled [Path] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledPath(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxPath).() -> Unit,
): Path {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxPath()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Path] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledPath(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxPath).() -> Unit,
): Path {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxPath()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
