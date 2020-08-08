@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ScrollPane] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.scrollPane(content: Node? = null): ScrollPane = scrollPane(content = content) { }

/**
 * Create a [ScrollPane] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
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
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.scrollPane(
    content: Node? = null,
    configuration: (
        @LayoutDslMarker    
        KtfxScrollPane
    ).() -> Unit
): ScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxScrollPane(content), configuration = configuration))
}

/**
 * Create a styled [ScrollPane].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledScrollPane(
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null
): ScrollPane = styledScrollPane(content = content, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ScrollPane] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledScrollPane(
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null
): ScrollPane = styledScrollPane(content = content, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ScrollPane] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledScrollPane(
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxScrollPane).() -> Unit
): ScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxScrollPane(content), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [ScrollPane] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledScrollPane(
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxScrollPane).() -> Unit
): ScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxScrollPane(content), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}
