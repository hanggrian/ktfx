@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTogglePane
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/**
 * [JFXTogglePane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxJFXTogglePane : JFXTogglePane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { contentNode = it }
}

/** Create a [JFXTogglePane] with configuration block. */
inline fun jfxTogglePane(
    configuration: (@LayoutDslMarker KtfxJFXTogglePane).() -> Unit
): JFXTogglePane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXTogglePane().apply(configuration)
}

/** Add a [JFXTogglePane] to this manager. */
fun NodeManager.jfxTogglePane(): JFXTogglePane = addChild(JFXTogglePane())

/** Add a [JFXTogglePane] with configuration block to this manager. */
inline fun NodeManager.jfxTogglePane(
    configuration: (@LayoutDslMarker KtfxJFXTogglePane).() -> Unit
): JFXTogglePane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXTogglePane(), configuration)
}
