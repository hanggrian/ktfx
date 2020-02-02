@file:JvmMultifileClass
@file:JvmName("NodeKt")

package ktfx.controls

import javafx.scene.Node
import javafx.scene.effect.Blend
import javafx.scene.effect.Bloom
import javafx.scene.effect.BoxBlur
import javafx.scene.effect.ColorAdjust
import javafx.scene.effect.ColorInput
import javafx.scene.effect.DisplacementMap
import javafx.scene.effect.DropShadow
import javafx.scene.effect.GaussianBlur
import javafx.scene.effect.Glow
import javafx.scene.effect.ImageInput
import javafx.scene.effect.InnerShadow
import javafx.scene.effect.Lighting
import javafx.scene.effect.MotionBlur
import javafx.scene.effect.PerspectiveTransform
import javafx.scene.effect.Reflection
import javafx.scene.effect.SepiaTone
import javafx.scene.effect.Shadow

/** Set [Blend] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.blendEffect(effectAction: Blend.() -> Unit): Blend = Blend().also {
    it.effectAction()
    effect = it
}

/** Set [Bloom] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.bloomEffect(effectAction: Bloom.() -> Unit): Bloom = Bloom().also {
    it.effectAction()
    effect = it
}

/** Set [BoxBlur] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.boxBlurEffect(effectAction: BoxBlur.() -> Unit): BoxBlur = BoxBlur().also {
    it.effectAction()
    effect = it
}

/** Set [ColorAdjust] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.colorAdjustEffect(effectAction: ColorAdjust.() -> Unit): ColorAdjust = ColorAdjust().also {
    it.effectAction()
    effect = it
}

/** Set [ColorInput] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.colorInputEffect(effectAction: ColorInput.() -> Unit): ColorInput = ColorInput().also {
    it.effectAction()
    effect = it
}

/** Set [DisplacementMap] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.displacementMapEffect(effectAction: DisplacementMap.() -> Unit): DisplacementMap =
    DisplacementMap().also {
        it.effectAction()
        effect = it
    }

/** Set [DropShadow] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.dropShadowEffect(effectAction: DropShadow.() -> Unit): DropShadow = DropShadow().also {
    it.effectAction()
    effect = it
}

/** Set [GaussianBlur] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.gaussianBlurEffect(effectAction: GaussianBlur.() -> Unit): GaussianBlur = GaussianBlur().also {
    it.effectAction()
    effect = it
}

/** Set [Glow] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.glowEffect(effectAction: Glow.() -> Unit): Glow = Glow().also {
    it.effectAction()
    effect = it
}

/** Set [ImageInput] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.imageInputEffect(effectAction: ImageInput.() -> Unit): ImageInput = ImageInput().also {
    it.effectAction()
    effect = it
}

/** Set [InnerShadow] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.innerShadowEffect(effectAction: InnerShadow.() -> Unit): InnerShadow = InnerShadow().also {
    it.effectAction()
    effect = it
}

/** Set [Lighting] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.lightingEffect(effectAction: Lighting.() -> Unit): Lighting = Lighting().also {
    it.effectAction()
    effect = it
}

/** Set [MotionBlur] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.motionBlurEffect(effectAction: MotionBlur.() -> Unit): MotionBlur = MotionBlur().also {
    it.effectAction()
    effect = it
}

/** Set [PerspectiveTransform] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.perspectiveTransformEffect(effectAction: PerspectiveTransform.() -> Unit): PerspectiveTransform =
    PerspectiveTransform().also {
        it.effectAction()
        effect = it
    }

/** Set [Reflection] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.reflectionEffect(effectAction: Reflection.() -> Unit): Reflection = Reflection().also {
    it.effectAction()
    effect = it
}

/** Set [SepiaTone] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.sepiaToneEffect(effectAction: SepiaTone.() -> Unit): SepiaTone = SepiaTone().also {
    it.effectAction()
    effect = it
}

/** Set [Shadow] effect with [effectAction] to this node, returning the effect added. */
inline fun Node.shadowEffect(effectAction: Shadow.() -> Unit): Shadow = Shadow().also {
    it.effectAction()
    effect = it
}
