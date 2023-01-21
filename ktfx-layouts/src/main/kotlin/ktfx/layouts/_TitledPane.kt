@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.TitledPane
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
 * Add a [TitledPane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.titledPane(title: String? = null): TitledPane = titledPane(title = title) { }

/**
 * Add a [TitledPane] to this manager.
 *
 * @return the control added.
 */
public fun TitledPaneManager.titledPane(title: String? = null): TitledPane = titledPane(title =
        title) { }

/**
 * Create a [TitledPane] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun titledPane(title: String? = null, configuration: (@KtfxLayoutDslMarker
        KtfxTitledPane).() -> Unit): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTitledPane(title)
    child.configuration()
    return child
}

/**
 * Add a [TitledPane] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.titledPane(title: String? = null, configuration: (@KtfxLayoutDslMarker
        KtfxTitledPane).() -> Unit): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTitledPane(title)
    child.configuration()
    return addChild(child)
}

/**
 * Add a [TitledPane] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun TitledPaneManager.titledPane(title: String? = null,
        configuration: (@KtfxLayoutDslMarker KtfxTitledPane).() -> Unit): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTitledPane(title)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [TitledPane].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null,
): TitledPane = styledTitledPane(title = title, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TitledPane] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeManager.styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null,
): TitledPane = styledTitledPane(title = title, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TitledPane] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun TitledPaneManager.styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null,
): TitledPane = styledTitledPane(title = title, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TitledPane] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxTitledPane).() -> Unit,
): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTitledPane(title)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [TitledPane] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxTitledPane).() -> Unit,
): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTitledPane(title)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

/**
 * Add a styled [TitledPane] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun TitledPaneManager.styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxTitledPane).() -> Unit,
): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTitledPane(title)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
