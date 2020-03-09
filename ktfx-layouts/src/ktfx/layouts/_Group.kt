@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Group
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Group] to this manager.
 */
fun NodeManager.group(): Group = group() { }

/**
 * Create a [Group] with configuration block.
 */
inline fun group(configuration: (@LayoutDslMarker KtfxGroup).() -> Unit): Group {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxGroup(), configuration = configuration)
}

/**
 * Add a [Group] with configuration block to this manager.
 */
inline fun NodeManager.group(configuration: (@LayoutDslMarker KtfxGroup).() -> Unit): Group {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxGroup(), configuration = configuration))
}

/**
 * Create a styled [Group].
 */
fun styledGroup(vararg styleClass: String, id: String? = null): Group = styledGroup(styleClass =
        *styleClass, id = id) { }

/**
 * Add a styled [Group] to this manager.
 */
fun NodeManager.styledGroup(vararg styleClass: String, id: String? = null): Group =
        styledGroup(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Group] with configuration block.
 */
inline fun styledGroup(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxGroup).() -> Unit
): Group {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxGroup(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Group] with configuration block to this manager.
 */
inline fun NodeManager.styledGroup(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxGroup).() -> Unit
): Group {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxGroup(), styleClass = *styleClass, id = id, configuration =
            configuration))
}
