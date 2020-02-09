@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [SplitPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxSplitPane : SplitPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { items += it }
}

/** Create a [SplitPane] with configurationialization block. */
inline fun splitPane(
    configuration: (@LayoutDslMarker KtfxSplitPane).() -> Unit
): SplitPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxSplitPane().apply(configuration)
}

/** Add a [SplitPane] to this manager. */
fun NodeManager.splitPane(): SplitPane = addChild(KtfxSplitPane())

/** Add a [SplitPane] with configurationialization block to this manager. */
inline fun NodeManager.splitPane(
    configuration: (@LayoutDslMarker KtfxSplitPane).() -> Unit
): SplitPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxSplitPane(), configuration)
}
