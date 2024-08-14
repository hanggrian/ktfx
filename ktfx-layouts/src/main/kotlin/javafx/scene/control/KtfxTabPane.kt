@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

/**
 * [TabPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxTabPane :
    TabPane(),
    TabContainer {
    final override fun <T : Tab> addChild(child: T): T = child.also { tabs += it }

    /** Call [TabContainer.tab] by string invocation. */
    public inline operator fun String.invoke(
        graphic: Node? = null,
        noinline configuration: (@KtfxLayoutDslMarker KtfxTab).() -> Unit,
    ): Tab = tab(this, graphic, configuration)
}
