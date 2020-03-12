@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import ktfx.layouts.NodeManager
import org.controlsfx.control.HiddenSidesPane

/**
 * [HiddenSidesPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxHiddenSidesPane : HiddenSidesPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }
}
