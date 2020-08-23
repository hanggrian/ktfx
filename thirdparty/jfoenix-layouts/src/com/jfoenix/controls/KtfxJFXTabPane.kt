@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTabPane
import javafx.scene.Node
import javafx.scene.control.Tab
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.KtfxTab
import ktfx.layouts.TabManager
import ktfx.layouts.tab
import kotlin.contracts.ExperimentalContracts

/**
 * [JFXTabPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXTabPane : JFXTabPane(), TabManager {

    final override fun <C : Tab> addChild(child: C): C = child.also { tabs += it }

    /** Call [TabManager.tab] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker KtfxTab).() -> Unit
    ): Tab = tab(this, graphic, configuration)
}
