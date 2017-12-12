@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint

inline fun Parent.toScene(): Scene = Scene(this)

@JvmOverloads
inline fun Parent.toScene(width: Double, height: Double, fill: Paint = WHITE): Scene = Scene(this, width, height, fill)

inline fun Parent.toScene(fill: Paint): Scene = Scene(this, fill)