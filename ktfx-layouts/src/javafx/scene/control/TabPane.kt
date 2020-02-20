@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [TabPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxTabPane : TabPane(), TabManager {

    final override fun <C : Tab> addChild(child: C): C = child.also { tabs += it }

    /** Call [TabManager.tab] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@LayoutDslMarker KtfxTab).() -> Unit
    ): Tab = tab(this, graphic, configuration)
}

/** Create a [TabPane] with configuration block. */
inline fun tabPane(
    configuration: (@LayoutDslMarker KtfxTabPane).() -> Unit
): TabPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxTabPane().apply(configuration)
}

/** Add a [TabPane] to this manager. */
fun NodeManager.tabPane(): TabPane = addChild(KtfxTabPane())

/** Add a [TabPane] with configuration block to this manager. */
inline fun NodeManager.tabPane(
    configuration: (@LayoutDslMarker KtfxTabPane).() -> Unit
): TabPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxTabPane(), configuration)
}
