@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.HiddenSidesPane

/**
 * [HiddenSidesPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxHiddenSidesPane : HiddenSidesPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }
}

/** Create a [HiddenSidesPane] with configurationialization block. */
inline fun hiddenSidesPane(
    configuration: (@LayoutDslMarker KtfxHiddenSidesPane).() -> Unit
): HiddenSidesPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxHiddenSidesPane().apply(configuration)
}

/** Add a [HiddenSidesPane] to this manager. */
fun NodeManager.hiddenSidesPane(): HiddenSidesPane = addChild(KtfxHiddenSidesPane())

/** Add a [HiddenSidesPane] with configurationialization block to this manager. */
inline fun NodeManager.hiddenSidesPane(
    configuration: (@LayoutDslMarker KtfxHiddenSidesPane).() -> Unit
): HiddenSidesPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxHiddenSidesPane(), configuration)
}
