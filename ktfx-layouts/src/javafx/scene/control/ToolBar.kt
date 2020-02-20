@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToolBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [ToolBar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxToolBar : ToolBar(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { items += it }
}

/** Create a [ToolBar] with configuration block. */
inline fun toolBar(
    configuration: (@LayoutDslMarker KtfxToolBar).() -> Unit
): ToolBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxToolBar().apply(configuration)
}

/** Add a [ToolBar] to this manager. */
fun NodeManager.toolBar(): ToolBar = addChild(KtfxToolBar())

/** Add a [ToolBar] with configuration block to this manager. */
inline fun NodeManager.toolBar(
    configuration: (@LayoutDslMarker KtfxToolBar).() -> Unit
): ToolBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxToolBar(), configuration)
}
