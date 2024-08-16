@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.control.ToolBar
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ToolBar] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.toolBar(): ToolBar = toolBar() { }

/**
 * Create a [ToolBar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun toolBar(configuration: (@KtfxLayoutDslMarker KtfxToolBar).() -> Unit): ToolBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxToolBar()
    child.configuration()
    return child
}

/**
 * Add a [ToolBar] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.toolBar(configuration: (@KtfxLayoutDslMarker
        KtfxToolBar).() -> Unit): ToolBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxToolBar()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ToolBar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledToolBar(vararg styleClass: String, id: String? = null): ToolBar =
        styledToolBar(styleClass = styleClass, id = id) { }

/**
 * Add a styled [ToolBar] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledToolBar(vararg styleClass: String, id: String? = null):
        ToolBar = styledToolBar(styleClass = styleClass, id = id) { }

/**
 * Create a styled [ToolBar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledToolBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxToolBar).() -> Unit,
): ToolBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxToolBar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ToolBar] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledToolBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxToolBar).() -> Unit,
): ToolBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxToolBar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
