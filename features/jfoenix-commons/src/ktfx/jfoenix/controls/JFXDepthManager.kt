package ktfx.jfoenix.controls

import com.jfoenix.effects.JFXDepthManager
import javafx.scene.Node
import ktfx.internal.KtfxInternals

/** This method is used to add shadow effect to the [Node]. */
var Node.depth: Int
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = JFXDepthManager.setDepth(this, value)

/**
 * This method will generate a new container node that prevent
 * control transformation to be applied to the shadow effect.
 */
fun Node.wrapDepth(level: Int): Node = JFXDepthManager.createMaterialNode(this, level)

/** Display drop shadow to this [Node]. */
fun Node.popDepth(): Unit = JFXDepthManager.pop(this)
