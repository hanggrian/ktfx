@file:Suppress("NOTHING_TO_INLINE")

package kotfx.scene

import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.SceneAntialiasing
import javafx.scene.SceneAntialiasing.DISABLED
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint

@JvmOverloads
inline fun Parent.toScene(
        fill: Paint = WHITE
): Scene = Scene(this, fill)

@JvmOverloads
inline fun Parent.toScene(
        width: Double,
        height: Double,
        fill: Paint = WHITE
): Scene = Scene(this, width, height, fill)

@JvmOverloads
inline fun Parent.toScene(
        width: Double,
        height: Double,
        depthBuffer: Boolean,
        antiAliasing: SceneAntialiasing = DISABLED
): Scene = Scene(this, width, height, depthBuffer, antiAliasing)