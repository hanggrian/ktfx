@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Path
import javafx.scene.shape.PathElement
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [Path] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxPath : Path(), PathElementManager {

    final override fun <T : PathElement> addElement(element: T): T =
        element.also { elements += it }
}

/** Create a [Path] with initialization block. */
inline fun path(
    init: KtfxPath.() -> Unit
): Path {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxPath().apply(init)
}

/** Add a [Path] to this manager. */
fun NodeManager.path(): Path =
    addNode(KtfxPath())

/** Add a [Path] with initialization block to this manager. */
inline fun NodeManager.path(
    init: KtfxPath.() -> Unit
): Path {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxPath(), init)
}
