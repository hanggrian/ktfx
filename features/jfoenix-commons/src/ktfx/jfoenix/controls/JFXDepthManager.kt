@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.controls

import com.jfoenix.effects.JFXDepthManager
import javafx.scene.Node
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/** This method is used to add shadow effect to the [Node]. */
inline var Node.depth: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = JFXDepthManager.setDepth(this, value)

/**
 * This method will generate a new container node that prevent
 * control transformation to be applied to the shadow effect.
 */
inline fun Node.wrapDepth(level: Int): Node = JFXDepthManager.createMaterialNode(this, level)

/** Display drop shadow to this [Node]. */
inline fun Node.popDepth(): Unit = JFXDepthManager.pop(this)
