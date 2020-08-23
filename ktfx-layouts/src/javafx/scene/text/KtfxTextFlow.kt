@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import kotlin.contracts.ExperimentalContracts

/**
 * [TextFlow] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxTextFlow : TextFlow(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    /** Call [NodeManager.text] by string invocation. */
    inline operator fun String.invoke(
        configuration: (@KtfxLayoutDslMarker Text).() -> Unit
    ): Text = text(this, configuration)
}
