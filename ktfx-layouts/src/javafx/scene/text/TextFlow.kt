@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [TextFlow] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxTextFlow : TextFlow(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    /** Call [NodeManager.text] by string invocation. */
    inline operator fun String.invoke(
        configuration: (@LayoutDslMarker Text).() -> Unit
    ): Text = text(this, configuration)
}

/** Create a [TextFlow] with configurationialization block. */
inline fun textFlow(
    configuration: (@LayoutDslMarker KtfxTextFlow).() -> Unit
): TextFlow {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxTextFlow().apply(configuration)
}

/** Add a [TextFlow] to this manager. */
fun NodeManager.textFlow(): TextFlow = addChild(KtfxTextFlow())

/** Add a [TextFlow] with configurationialization block to this manager. */
inline fun NodeManager.textFlow(
    configuration: (@LayoutDslMarker KtfxTextFlow).() -> Unit
): TextFlow {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxTextFlow(), configuration)
}
