@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.animations

import javafx.animation.KeyFrame
import javafx.animation.Timeline

inline fun timelineOf(vararg keyFrames: KeyFrame): Timeline = Timeline(*keyFrames)