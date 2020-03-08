@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TitledPane
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [TitledPane] to this manager.
 */
fun NodeManager.titledPane(title: String? = null): TitledPane = titledPane(title = title) { }

/**
 * Add a [TitledPane] to this manager.
 */
fun TitledPaneManager.titledPane(title: String? = null): TitledPane = titledPane(title = title) { }

/**
 * Create a [TitledPane] with configuration block.
 */
inline fun titledPane(
    title: String? = null,
    configuration: (@LayoutDslMarker KtfxTitledPane).() ->    
            Unit
): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxTitledPane(title), configuration = configuration)
}

/**
 * Add a [TitledPane] with configuration block to this manager.
 */
inline fun NodeManager.titledPane(
    title: String? = null,
    configuration: (@LayoutDslMarker    
            KtfxTitledPane).() -> Unit
): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxTitledPane(title), configuration = configuration))
}

/**
 * Add a [TitledPane] with configuration block to this manager.
 */
inline fun TitledPaneManager.titledPane(
    title: String? = null,
    configuration: (@LayoutDslMarker    
            KtfxTitledPane).() -> Unit
): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxTitledPane(title), configuration = configuration))
}

/**
 * Create a styled [TitledPane].
 */
fun styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null
): TitledPane = styledTitledPane(title = title, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TitledPane] to this manager.
 */
fun NodeManager.styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null
): TitledPane = styledTitledPane(title = title, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TitledPane] to this manager.
 */
fun TitledPaneManager.styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null
): TitledPane = styledTitledPane(title = title, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TitledPane] with configuration block.
 */
inline fun styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTitledPane).() -> Unit
): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxTitledPane(title), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [TitledPane] with configuration block to this manager.
 */
inline fun NodeManager.styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTitledPane).() -> Unit
): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxTitledPane(title), styleClass = *styleClass, id = id, configuration =
            configuration))
}

/**
 * Add a styled [TitledPane] with configuration block to this manager.
 */
inline fun TitledPaneManager.styledTitledPane(
    title: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTitledPane).() -> Unit
): TitledPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxTitledPane(title), styleClass = *styleClass, id = id, configuration =
            configuration))
}
