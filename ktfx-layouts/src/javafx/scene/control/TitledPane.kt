@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [TitledPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxTitledPane(title: String?) : TitledPane(title, null), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }

    final override val childCount: Int get() = if (content != null) 1 else 0
}

/** Create a [TitledPane] with initialization block. */
inline fun titledPane(
    title: String? = null,
    configuration: (@LayoutsDslMarker KtfxTitledPane).() -> Unit
): TitledPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxTitledPane(title).apply(configuration)
}

/** Add a [TitledPane] to this manager. */
fun NodeManager.titledPane(
    title: String? = null
): TitledPane = addChild(KtfxTitledPane(title))

/** Add a [TitledPane] with initialization block to this manager. */
inline fun NodeManager.titledPane(
    title: String? = null,
    configuration: (@LayoutsDslMarker KtfxTitledPane).() -> Unit
): TitledPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxTitledPane(title), configuration)
}

/** Add a [TitledPane] to this manager. */
fun TitledPaneManager.titledPane(
    title: String? = null
): TitledPane = addChild(KtfxTitledPane(title))

/** Add a [TitledPane] with initialization block to this manager. */
inline fun TitledPaneManager.titledPane(
    title: String? = null,
    configuration: (@LayoutsDslMarker KtfxTitledPane).() -> Unit
): TitledPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxTitledPane(title), configuration)
}
