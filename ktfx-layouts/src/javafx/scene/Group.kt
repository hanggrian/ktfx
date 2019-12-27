@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Scene
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [Scene] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxGroup : Group(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size
}

/** Create a [Group] with initialization block. */
inline fun group(
    configuration: (@LayoutsDslMarker KtfxGroup).() -> Unit
): Group {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxGroup().apply(configuration)
}

/** Add a [Group] to this manager. */
fun NodeManager.group(): Group = addChild(KtfxGroup())

/** Add a [Group] with initialization block to this manager. */
inline fun NodeManager.group(
    configuration: (@LayoutsDslMarker KtfxGroup).() -> Unit
): Group {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxGroup(), configuration)
}
