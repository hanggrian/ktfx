@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTabPane
import javafx.scene.Node
import javafx.scene.control.Tab
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.KtfxTab
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.TabManager
import ktfx.layouts.addChild
import ktfx.layouts.tab

/**
 * [JFXTabPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXTabPane : JFXTabPane(), TabManager {

    final override fun <C : Tab> addChild(child: C): C = child.also { tabs += it }

    final override val childCount: Int get() = tabs.size

    /** Call [TabManager.tab] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutsDslMarker KtfxTab).() -> Unit
    ): Tab = tab(this, graphic, init)
}

/** Create a [JFXTabPane] with initialization block. */
inline fun jfxTabPane(
    init: (@LayoutsDslMarker KtfxJFXTabPane).() -> Unit
): JFXTabPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXTabPane().apply(init)
}

/** Add a [JFXTabPane] to this manager. */
fun NodeManager.jfxTabPane(): JFXTabPane =
    addChild(KtfxJFXTabPane())

/** Add a [JFXTabPane] with initialization block to this manager. */
inline fun NodeManager.jfxTabPane(
    init: (@LayoutsDslMarker KtfxJFXTabPane).() -> Unit
): JFXTabPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXTabPane(), init)
}
