@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.MenuBar
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [MenuBar] to this manager.
 */
fun NodeManager.menuBar(): MenuBar = menuBar() { }

/**
 * Create a [MenuBar] with configuration block.
 */
inline fun menuBar(configuration: (@LayoutDslMarker KtfxMenuBar).() -> Unit): MenuBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxMenuBar(), configuration = configuration)
}

/**
 * Add a [MenuBar] with configuration block to this manager.
 */
inline fun NodeManager.menuBar(configuration: (@LayoutDslMarker KtfxMenuBar).() -> Unit): MenuBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxMenuBar(), configuration = configuration))
}

/**
 * Create a styled [MenuBar].
 */
fun styledMenuBar(vararg styleClass: String): MenuBar = styledMenuBar(styleClass = *styleClass) { }

/**
 * Add a styled [MenuBar] to this manager.
 */
fun NodeManager.styledMenuBar(vararg styleClass: String): MenuBar = styledMenuBar(styleClass =
        *styleClass) { }

/**
 * Create a styled [MenuBar] with configuration block.
 */
inline fun styledMenuBar(vararg styleClass: String, configuration: (@LayoutDslMarker
        KtfxMenuBar).() -> Unit): MenuBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxMenuBar(), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [MenuBar] with configuration block to this manager.
 */
inline fun NodeManager.styledMenuBar(vararg styleClass: String, configuration: (@LayoutDslMarker
        KtfxMenuBar).() -> Unit): MenuBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxMenuBar(), styleClass = *styleClass, configuration =
            configuration))
}
