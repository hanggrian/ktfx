@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [ScrollPane] to this manager.
 */
fun NodeManager.scrollPane(content: Node? = null): ScrollPane = scrollPane(content = content) { }

/**
 * Create a [ScrollPane] with configuration block.
 */
inline fun scrollPane(
    content: Node? = null,
    configuration: (@LayoutDslMarker KtfxScrollPane).() ->    
            Unit
): ScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxScrollPane(content), configuration = configuration)
}

/**
 * Add a [ScrollPane] with configuration block to this manager.
 */
inline fun NodeManager.scrollPane(
    content: Node? = null,
    configuration: (@LayoutDslMarker    
            KtfxScrollPane).() -> Unit
): ScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxScrollPane(content), configuration = configuration))
}

/**
 * Create a styled [ScrollPane].
 */
fun styledScrollPane(content: Node? = null, vararg styleClass: String): ScrollPane =
        styledScrollPane(content = content, styleClass = *styleClass) { }

/**
 * Add a styled [ScrollPane] to this manager.
 */
fun NodeManager.styledScrollPane(content: Node? = null, vararg styleClass: String): ScrollPane =
        styledScrollPane(content = content, styleClass = *styleClass) { }

/**
 * Create a styled [ScrollPane] with configuration block.
 */
inline fun styledScrollPane(
    content: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker KtfxScrollPane).() -> Unit
): ScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxScrollPane(content), styleClass = *styleClass, configuration =
            configuration)
}

/**
 * Add a styled [ScrollPane] with configuration block to this manager.
 */
inline fun NodeManager.styledScrollPane(
    content: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker KtfxScrollPane).() -> Unit
): ScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxScrollPane(content), styleClass = *styleClass, configuration =
            configuration))
}
