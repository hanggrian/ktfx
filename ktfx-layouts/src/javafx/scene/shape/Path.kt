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

    final override fun <C : PathElement> addChild(child: C): C = child.also { elements += it }

    final override val childCount: Int get() = elements.size
}

/** Create a [Path] with initialization block. */
inline fun path(
    init: (@LayoutsDslMarker KtfxPath).() -> Unit
): Path {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxPath().apply(init)
}

/** Add a [Path] to this manager. */
fun NodeManager.path(): Path = addChild(KtfxPath())

/** Add a [Path] with initialization block to this manager. */
inline fun NodeManager.path(
    init: (@LayoutsDslMarker KtfxPath).() -> Unit
): Path {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxPath(), init)
}
