@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

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
}

/** Create a [Path] with configuration block. */
inline fun path(
    configuration: (@LayoutDslMarker KtfxPath).() -> Unit
): Path {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxPath().apply(configuration)
}

/** Add a [Path] to this manager. */
fun NodeManager.path(): Path = addChild(KtfxPath())

/** Add a [Path] with configuration block to this manager. */
inline fun NodeManager.path(
    configuration: (@LayoutDslMarker KtfxPath).() -> Unit
): Path {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxPath(), configuration)
}
