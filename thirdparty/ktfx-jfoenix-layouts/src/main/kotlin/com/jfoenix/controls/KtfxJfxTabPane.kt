@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTabPane
import javafx.scene.Node
import javafx.scene.control.Tab
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.KtfxTab
import ktfx.layouts.TabContainer
import ktfx.layouts.tab

/** [JFXTabPane] with dynamic-layout dsl support. Invoking dsl will add its children. */
public open class KtfxJfxTabPane :
    JFXTabPane(),
    TabContainer {
    final override fun <T : Tab> addChild(child: T): T = child.also { tabs += it }

    /** Call [TabContainer.tab] by string invocation. */
    public inline operator fun String.invoke(
        graphic: Node? = null,
        noinline configuration: (@KtfxLayoutDslMarker KtfxTab).() -> Unit,
    ): Tab = tab(this, graphic, configuration)
}
