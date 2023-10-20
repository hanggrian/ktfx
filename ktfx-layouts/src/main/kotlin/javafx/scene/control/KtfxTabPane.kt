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
open class KtfxTabPane : TabPane(), TabContainer {
    final override fun <T : Tab> addChild(child: T): T = child.also { tabs += it }

    /** Call [TabContainer.tab] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker KtfxTab).() -> Unit,
    ): Tab = tab(this, graphic, configuration)
}
