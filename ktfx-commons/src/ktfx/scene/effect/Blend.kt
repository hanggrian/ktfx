@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.Blend
import javafx.scene.effect.Effect

/** The bottom input for this [Blend] operation. */
inline operator fun Blend.component1(): Effect? = bottomInput

/** The top input for this [Blend] operation. */
inline operator fun Blend.component2(): Effect? = topInput