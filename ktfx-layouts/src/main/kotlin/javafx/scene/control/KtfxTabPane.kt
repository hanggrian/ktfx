@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import kotlin.contracts.ExperimentalContracts

/**
 * [TabPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxTabPane : TabPane(), TabManager {
    final override fun <C : Tab> addChild(child: C): C = child.also { tabs += it }

    /** Call [TabManager.tab] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker KtfxTab).() -> Unit
    ): Tab = tab(this, graphic, configuration)
}
