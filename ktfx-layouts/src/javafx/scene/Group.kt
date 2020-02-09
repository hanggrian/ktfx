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
}

/** Create a [Group] with configurationialization block. */
inline fun group(
    configuration: (@LayoutDslMarker KtfxGroup).() -> Unit
): Group {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxGroup().apply(configuration)
}

/** Add a [Group] to this manager. */
fun NodeManager.group(): Group = addChild(KtfxGroup())

/** Add a [Group] with configurationialization block to this manager. */
inline fun NodeManager.group(
    configuration: (@LayoutDslMarker KtfxGroup).() -> Unit
): Group {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxGroup(), configuration)
}
