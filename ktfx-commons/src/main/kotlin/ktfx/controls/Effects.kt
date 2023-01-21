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

/**
 * Sets [Blend] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.blendEffect(configuration: Blend.() -> Unit): Blend = Blend().also {
    it.configuration()
    effect = it
}

/**
 * Sets [Bloom] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.bloomEffect(configuration: Bloom.() -> Unit): Bloom = Bloom().also {
    it.configuration()
    effect = it
}

/**
 * Sets [BoxBlur] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.boxBlurEffect(configuration: BoxBlur.() -> Unit): BoxBlur = BoxBlur().also {
    it.configuration()
    effect = it
}

/**
 * Sets [ColorAdjust] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.colorAdjustEffect(configuration: ColorAdjust.() -> Unit): ColorAdjust =
    ColorAdjust().also {
        it.configuration()
        effect = it
    }

/**
 * Sets [ColorInput] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.colorInputEffect(configuration: ColorInput.() -> Unit): ColorInput = ColorInput().also {
    it.configuration()
    effect = it
}

/**
 * Sets [DisplacementMap] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.displacementMapEffect(configuration: DisplacementMap.() -> Unit): DisplacementMap =
    DisplacementMap().also {
        it.configuration()
        effect = it
    }

/**
 * Sets [DropShadow] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.dropShadowEffect(configuration: DropShadow.() -> Unit): DropShadow = DropShadow().also {
    it.configuration()
    effect = it
}

/**
 * Sets [GaussianBlur] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.gaussianBlurEffect(configuration: GaussianBlur.() -> Unit): GaussianBlur =
    GaussianBlur().also {
        it.configuration()
        effect = it
    }

/**
 * Sets [Glow] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.glowEffect(configuration: Glow.() -> Unit): Glow = Glow().also {
    it.configuration()
    effect = it
}

/**
 * Sets [ImageInput] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.imageInputEffect(configuration: ImageInput.() -> Unit): ImageInput = ImageInput().also {
    it.configuration()
    effect = it
}

/**
 * Sets [InnerShadow] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.innerShadowEffect(configuration: InnerShadow.() -> Unit): InnerShadow =
    InnerShadow().also {
        it.configuration()
        effect = it
    }

/**
 * Sets [Lighting] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.lightingEffect(configuration: Lighting.() -> Unit): Lighting = Lighting().also {
    it.configuration()
    effect = it
}

/**
 * Sets [MotionBlur] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.motionBlurEffect(configuration: MotionBlur.() -> Unit): MotionBlur = MotionBlur().also {
    it.configuration()
    effect = it
}

/**
 * Sets [PerspectiveTransform] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.perspectiveTransformEffect(
    configuration: PerspectiveTransform.() -> Unit
): PerspectiveTransform = PerspectiveTransform().also {
    it.configuration()
    effect = it
}

/**
 * Sets [Reflection] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.reflectionEffect(configuration: Reflection.() -> Unit): Reflection = Reflection().also {
    it.configuration()
    effect = it
}

/**
 * Sets [SepiaTone] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.sepiaToneEffect(configuration: SepiaTone.() -> Unit): SepiaTone = SepiaTone().also {
    it.configuration()
    effect = it
}

/**
 * Sets [Shadow] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
fun Node.shadowEffect(configuration: Shadow.() -> Unit): Shadow = Shadow().also {
    it.configuration()
    effect = it
}
