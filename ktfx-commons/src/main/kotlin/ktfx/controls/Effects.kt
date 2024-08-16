@file:OptIn(ExperimentalContracts::class)

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
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Sets [Blend] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.blendEffect(configuration: Blend.() -> Unit): Blend {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Blend().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [Bloom] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.bloomEffect(configuration: Bloom.() -> Unit): Bloom {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Bloom().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [BoxBlur] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.boxBlurEffect(configuration: BoxBlur.() -> Unit): BoxBlur {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return BoxBlur().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [ColorAdjust] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.colorAdjustEffect(configuration: ColorAdjust.() -> Unit): ColorAdjust {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ColorAdjust().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [ColorInput] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.colorInputEffect(configuration: ColorInput.() -> Unit): ColorInput {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ColorInput().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [DisplacementMap] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.displacementMapEffect(
    configuration: DisplacementMap.() -> Unit,
): DisplacementMap {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return DisplacementMap().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [DropShadow] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.dropShadowEffect(configuration: DropShadow.() -> Unit): DropShadow {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return DropShadow().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [GaussianBlur] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.gaussianBlurEffect(configuration: GaussianBlur.() -> Unit): GaussianBlur {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return GaussianBlur().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [Glow] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.glowEffect(configuration: Glow.() -> Unit): Glow {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Glow().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [ImageInput] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.imageInputEffect(configuration: ImageInput.() -> Unit): ImageInput {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ImageInput().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [InnerShadow] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.innerShadowEffect(configuration: InnerShadow.() -> Unit): InnerShadow {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return InnerShadow().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [Lighting] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.lightingEffect(configuration: Lighting.() -> Unit): Lighting {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Lighting().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [MotionBlur] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.motionBlurEffect(configuration: MotionBlur.() -> Unit): MotionBlur {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return MotionBlur().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [PerspectiveTransform] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.perspectiveTransformEffect(
    configuration: PerspectiveTransform.() -> Unit,
): PerspectiveTransform {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return PerspectiveTransform().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [Reflection] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.reflectionEffect(configuration: Reflection.() -> Unit): Reflection {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Reflection().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [SepiaTone] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.sepiaToneEffect(configuration: SepiaTone.() -> Unit): SepiaTone {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return SepiaTone().also {
        it.configuration()
        effect = it
    }
}

/**
 * Sets [Shadow] effect.
 *
 * @param configuration the configuration block that customizes effect.
 * @return the effect applied.
 */
public inline fun Node.shadowEffect(configuration: Shadow.() -> Unit): Shadow {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Shadow().also {
        it.configuration()
        effect = it
    }
}
