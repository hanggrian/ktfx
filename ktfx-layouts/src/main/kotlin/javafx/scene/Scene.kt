@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.stage.Stage
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Scene] with configuration block. */
public inline fun scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = Color.WHITE,
    configuration: (@KtfxLayoutDslMarker KtfxScene).() -> Unit,
): Scene {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxScene(Pane(), width, height, fill).apply(configuration)
}

/** Add a [Scene] to this window. */
public fun Stage.scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = Color.WHITE,
): Scene = KtfxScene(Pane(), width, height, fill).also { scene = it }

/** Add a [Scene] with configuration block to this window. */
public inline fun Stage.scene(
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = Color.WHITE,
    configuration: (@KtfxLayoutDslMarker KtfxScene).() -> Unit,
): Scene {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.scene(width, height, fill, configuration).also { scene = it }
}
