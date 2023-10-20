@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.SubScene
import javafx.scene.layout.Pane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [SubScene] with configuration block. */
inline fun subScene(
    width: Double = -1.0,
    height: Double = -1.0,
    configuration: (@KtfxLayoutDslMarker KtfxSubScene).() -> Unit,
): SubScene {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxSubScene(Pane(), width, height).apply(configuration)
}
