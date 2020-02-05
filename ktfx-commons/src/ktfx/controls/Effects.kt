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

/** Set [Blend] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.blendEffect(configuration: Blend.() -> Unit): Blend {
    val effect = Blend()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [Bloom] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.bloomEffect(configuration: Bloom.() -> Unit): Bloom {
    val effect = Bloom()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [BoxBlur] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.boxBlurEffect(configuration: BoxBlur.() -> Unit): BoxBlur {
    val effect = BoxBlur()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [ColorAdjust] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.colorAdjustEffect(configuration: ColorAdjust.() -> Unit): ColorAdjust {
    val effect = ColorAdjust()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [ColorInput] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.colorInputEffect(configuration: ColorInput.() -> Unit): ColorInput {
    val effect = ColorInput()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [DisplacementMap] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.displacementMapEffect(configuration: DisplacementMap.() -> Unit): DisplacementMap {
    val effect = DisplacementMap()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [DropShadow] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.dropShadowEffect(configuration: DropShadow.() -> Unit): DropShadow {
    val effect = DropShadow()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [GaussianBlur] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.gaussianBlurEffect(configuration: GaussianBlur.() -> Unit): GaussianBlur {
    val effect = GaussianBlur()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [Glow] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.glowEffect(configuration: Glow.() -> Unit): Glow {
    val effect = Glow()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [ImageInput] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.imageInputEffect(configuration: ImageInput.() -> Unit): ImageInput {
    val effect = ImageInput()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [InnerShadow] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.innerShadowEffect(configuration: InnerShadow.() -> Unit): InnerShadow {
    val effect = InnerShadow()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [Lighting] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.lightingEffect(configuration: Lighting.() -> Unit): Lighting {
    val effect = Lighting()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [MotionBlur] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.motionBlurEffect(configuration: MotionBlur.() -> Unit): MotionBlur {
    val effect = MotionBlur()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [PerspectiveTransform] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.perspectiveTransformEffect(configuration: PerspectiveTransform.() -> Unit): PerspectiveTransform {
    val effect = PerspectiveTransform()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [Reflection] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.reflectionEffect(configuration: Reflection.() -> Unit): Reflection {
    val effect = Reflection()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [SepiaTone] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.sepiaToneEffect(configuration: SepiaTone.() -> Unit): SepiaTone {
    val effect = SepiaTone()
    effect.configuration()
    setEffect(effect)
    return effect
}

/** Set [Shadow] effect with [configuration] block to this [Node], returning the effect added. */
inline fun Node.shadowEffect(configuration: Shadow.() -> Unit): Shadow {
    val effect = Shadow()
    effect.configuration()
    setEffect(effect)
    return effect
}
