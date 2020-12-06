@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXMasonryPane
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
 * Add a [JFXMasonryPane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.jfxMasonryPane(): JFXMasonryPane = jfxMasonryPane() { }

/**
 * Create a [JFXMasonryPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxMasonryPane(
    configuration: (@KtfxLayoutDslMarker KtfxJFXMasonryPane).() ->
    Unit
): JFXMasonryPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXMasonryPane()
    child.configuration()
    return child
}

/**
 * Add a [JFXMasonryPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.jfxMasonryPane(
    configuration: (
        @KtfxLayoutDslMarker
        KtfxJFXMasonryPane
    ).() -> Unit
): JFXMasonryPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXMasonryPane()
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
public fun styledJFXMasonryPane(vararg styleClass: String, id: String? = null): JFXMasonryPane =
    styledJFXMasonryPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXMasonryPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledJFXMasonryPane(vararg styleClass: String, id: String? = null):
    JFXMasonryPane = styledJFXMasonryPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXMasonryPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJFXMasonryPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJFXMasonryPane).() -> Unit
): JFXMasonryPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXMasonryPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXMasonryPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledJFXMasonryPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJFXMasonryPane).() -> Unit
): JFXMasonryPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXMasonryPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
