@file:JvmMultifileClass
@file:JvmName("NodeKt")

package ktfx.controls

import javafx.scene.Node
import javafx.scene.effect.Blend
import javafx.scene.effect.BlendMode
import javafx.scene.effect.Bloom
import javafx.scene.effect.BoxBlur
import javafx.scene.effect.ColorAdjust
import javafx.scene.effect.ColorInput
import javafx.scene.effect.Effect
import javafx.scene.paint.Color
import javafx.scene.paint.Paint

/** Set [Blend] effect, returning the effect. */
fun Node.blend(
    mode: BlendMode = BlendMode.SRC_OVER,
    bottomInput: Effect? = null,
    topInput: Effect? = null
): Blend = Blend(mode, bottomInput, topInput).also { effect = it }

/** Set [Blend] effect with [builderAction], returning the effect. */
inline fun Node.blend(
    mode: BlendMode = BlendMode.SRC_OVER,
    bottomInput: Effect? = null,
    topInput: Effect? = null,
    builderAction: Blend.() -> Unit
): Blend = blend(mode, bottomInput, topInput).apply(builderAction)

/** Set [Bloom] effect, returning the effect. */
fun Node.bloom(threshold: Double = 0.3): Bloom = Bloom(threshold).also { effect = it }

/** Set [Bloom] effect with [builderAction], returning the effect. */
inline fun Node.bloom(threshold: Double = 0.3, builderAction: Bloom.() -> Unit): Bloom =
    bloom(threshold).apply(builderAction)

/** Set [BoxBlur] effect, returning the effect. */
fun Node.boxBlur(width: Double = 5.0, height: Double = 5.0, iterations: Int = 1): BoxBlur =
    BoxBlur(width, height, iterations).also { effect = it }

/** Set [BoxBlur] effect with [builderAction], returning the effect. */
inline fun Node.boxBlur(
    width: Double = 5.0,
    height: Double = 5.0,
    iterations: Int = 1,
    builderAction: BoxBlur.() -> Unit
): BoxBlur = boxBlur(width, height, iterations).apply(builderAction)

/** Set [ColorAdjust] effect, returning the effect. */
fun Node.colorAdjust(
    hue: Double = 0.0,
    saturation: Double = 0.0,
    brightness: Double = 0.0,
    contrast: Double = 0.0
): ColorAdjust = ColorAdjust(hue, saturation, brightness, contrast).also { effect = it }

/** Set [ColorAdjust] effect with [builderAction], returning the effect. */
inline fun Node.colorAdjust(
    hue: Double = 0.0,
    saturation: Double = 0.0,
    brightness: Double = 0.0,
    contrast: Double = 0.0,
    builderAction: ColorAdjust.() -> Unit
): ColorAdjust = colorAdjust(hue, saturation, brightness, contrast).apply(builderAction)

/** Set [ColorInput] effect, returning the effect. */
fun Node.colorInput(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    paint: Paint = Color.RED
): ColorInput = ColorInput(x, y, width, height, paint).also { effect = it }

/** Set [ColorInput] effect, returning the effect. */
inline fun Node.colorInput(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    paint: Paint = Color.RED,
    builderAction: ColorInput.() -> Unit
): ColorInput = colorInput(x, y, width, height, paint).apply(builderAction)
