@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXMasonryPane
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer

/**
 * Add a [JFXMasonryPane] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxMasonryPane(): JFXMasonryPane = jfxMasonryPane() { }

/**
 * Create a [JFXMasonryPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxMasonryPane(configuration: (@KtfxLayoutDslMarker
        KtfxJfxMasonryPane).() -> Unit): JFXMasonryPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxMasonryPane()
    child.configuration()
    return child
}

/**
 * Add a [JFXMasonryPane] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.jfxMasonryPane(configuration: (@KtfxLayoutDslMarker
        KtfxJfxMasonryPane).() -> Unit): JFXMasonryPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxMasonryPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXMasonryPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledJfxMasonryPane(vararg styleClass: String, id: String? = null):
        JFXMasonryPane = styledJfxMasonryPane(styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXMasonryPane] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxMasonryPane(vararg styleClass: String, id: String? = null):
        JFXMasonryPane = styledJfxMasonryPane(styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXMasonryPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJfxMasonryPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxMasonryPane).() -> Unit,
): JFXMasonryPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxMasonryPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXMasonryPane] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxMasonryPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxMasonryPane).() -> Unit,
): JFXMasonryPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxMasonryPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
