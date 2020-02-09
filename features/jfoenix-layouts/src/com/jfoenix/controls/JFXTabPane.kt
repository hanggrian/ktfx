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
import ktfx.layouts.LayoutDslMarker
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

    /** Call [TabManager.tab] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@LayoutDslMarker KtfxTab).() -> Unit
    ): Tab = tab(this, graphic, configuration)
}

/** Create a [JFXTabPane] with configurationialization block. */
inline fun jfxTabPane(
    configuration: (@LayoutDslMarker KtfxJFXTabPane).() -> Unit
): JFXTabPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXTabPane().apply(configuration)
}

/** Add a [JFXTabPane] to this manager. */
fun NodeManager.jfxTabPane(): JFXTabPane =
    addChild(KtfxJFXTabPane())

/** Add a [JFXTabPane] with configurationialization block to this manager. */
inline fun NodeManager.jfxTabPane(
    configuration: (@LayoutDslMarker KtfxJFXTabPane).() -> Unit
): JFXTabPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXTabPane(), configuration)
}
