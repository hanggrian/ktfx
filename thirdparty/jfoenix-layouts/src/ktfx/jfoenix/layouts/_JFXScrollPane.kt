@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXScrollPane
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXScrollPane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.jfxScrollPane(): JFXScrollPane = jfxScrollPane() { }

/**
 * Create a [JFXScrollPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxScrollPane(configuration: (@KtfxLayoutDslMarker KtfxJFXScrollPane).() -> Unit):
    JFXScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXScrollPane()
    child.configuration()
    return child
}

/**
 * Add a [JFXScrollPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.jfxScrollPane(
    configuration: (
        @KtfxLayoutDslMarker
        KtfxJFXScrollPane
    ).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXScrollPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXScrollPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledJFXScrollPane(vararg styleClass: String, id: String? = null): JFXScrollPane =
    styledJFXScrollPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXScrollPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledJFXScrollPane(vararg styleClass: String, id: String? = null):
    JFXScrollPane = styledJFXScrollPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXScrollPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJFXScrollPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXScrollPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXScrollPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledJFXScrollPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXScrollPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
