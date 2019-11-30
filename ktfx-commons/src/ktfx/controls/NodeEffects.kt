@file:JvmMultifileClass
@file:JvmName("NodeKt")

package ktfx.controls

import javafx.scene.Node
import javafx.scene.effect.Blend
import javafx.scene.effect.BlendMode
import javafx.scene.effect.Bloom
import javafx.scene.effect.BlurType
import javafx.scene.effect.BoxBlur
import javafx.scene.effect.ColorAdjust
import javafx.scene.effect.ColorInput
import javafx.scene.effect.DisplacementMap
import javafx.scene.effect.DropShadow
import javafx.scene.effect.Effect
import javafx.scene.effect.FloatMap
import javafx.scene.effect.GaussianBlur
import javafx.scene.effect.Glow
import javafx.scene.effect.ImageInput
import javafx.scene.effect.InnerShadow
import javafx.scene.effect.Light
import javafx.scene.effect.Lighting
import javafx.scene.effect.MotionBlur
import javafx.scene.effect.PerspectiveTransform
import javafx.scene.effect.Reflection
import javafx.scene.effect.SepiaTone
import javafx.scene.effect.Shadow
import javafx.scene.image.Image
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

/** Set [ColorInput] effect with [builderAction], returning the effect. */
inline fun Node.colorInput(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    paint: Paint = Color.RED,
    builderAction: ColorInput.() -> Unit
): ColorInput = colorInput(x, y, width, height, paint).apply(builderAction)

/** Set [DisplacementMap] effect, returning the effect. */
fun Node.displacementMap(
    mapData: FloatMap? = null,
    offsetX: Double = 0.0,
    offsetY: Double = 0.0,
    scaleX: Double = 1.0,
    scaleY: Double = 1.0
): DisplacementMap = DisplacementMap(mapData, offsetX, offsetY, scaleX, scaleY).also { effect = it }

/** Set [DisplacementMap] effect with [builderAction], returning the effect. */
inline fun Node.displacementMap(
    mapData: FloatMap? = null,
    offsetX: Double = 0.0,
    offsetY: Double = 0.0,
    scaleX: Double = 1.0,
    scaleY: Double = 1.0,
    builderAction: DisplacementMap.() -> Unit
): DisplacementMap = displacementMap(mapData, offsetX, offsetY, scaleX, scaleY).apply(builderAction)

/** Set [DropShadow] effect, returning the effect. */
fun Node.dropShadow(
    blurType: BlurType = BlurType.THREE_PASS_BOX,
    color: Color = Color.BLACK,
    radius: Double = 10.0,
    spread: Double = 0.0,
    offsetX: Double = 0.0,
    offsetY: Double = 0.0
): DropShadow = DropShadow(blurType, color, radius, spread, offsetX, offsetY).also { effect = it }

/** Set [DropShadow] effect with [builderAction], returning the effect. */
inline fun Node.dropShadow(
    blurType: BlurType = BlurType.THREE_PASS_BOX,
    color: Color = Color.BLACK,
    radius: Double = 10.0,
    spread: Double = 0.0,
    offsetX: Double = 0.0,
    offsetY: Double = 0.0,
    builderAction: DropShadow.() -> Unit
): DropShadow = dropShadow(blurType, color, radius, spread, offsetX, offsetY).apply(builderAction)

/** Set [GaussianBlur] effect, returning the effect. */
fun Node.gaussianBlur(radius: Double = 10.0): GaussianBlur = GaussianBlur(radius).also { effect = it }

/** Set [GaussianBlur] effect with [builderAction], returning the effect. */
inline fun Node.gaussianBlur(radius: Double = 10.0, builderAction: GaussianBlur.() -> Unit): GaussianBlur =
    gaussianBlur(radius).apply(builderAction)

/** Set [Glow] effect, returning the effect. */
fun Node.glow(level: Double = 0.3): Glow = glow(level).also { effect = it }

/** Set [Glow] effect with [builderAction], returning the effect. */
inline fun Node.glow(level: Double = 0.3, builderAction: Glow.() -> Unit): Glow = glow(level).apply(builderAction)

/** Set [ImageInput] effect, returning the effect. */
fun Node.imageInput(
    source: Image? = null,
    x: Double = 0.0,
    y: Double = 0.0
): ImageInput = ImageInput(source, x, y).also { effect = it }

/** Set [ImageInput] effect with [builderAction], returning the effect. */
inline fun Node.imageInput(
    source: Image? = null,
    x: Double = 0.0,
    y: Double = 0.0,
    builderAction: ImageInput.() -> Unit
): ImageInput = imageInput(source, x, y).apply(builderAction)

/** Set [InnerShadow] effect, returning the effect. */
fun Node.innerShadow(
    blurType: BlurType = BlurType.THREE_PASS_BOX,
    color: Color = Color.BLACK,
    radius: Double = 10.0,
    choke: Double = 0.0,
    offsetX: Double = 0.0,
    offsetY: Double = 0.0
): InnerShadow = InnerShadow(blurType, color, radius, choke, offsetX, offsetY).also { effect = it }

/** Set [InnerShadow] effect with [builderAction], returning the effect. */
inline fun Node.innerShadow(
    blurType: BlurType = BlurType.THREE_PASS_BOX,
    color: Color = Color.BLACK,
    radius: Double = 10.0,
    choke: Double = 0.0,
    offsetX: Double = 0.0,
    offsetY: Double = 0.0,
    builderAction: InnerShadow.() -> Unit
): InnerShadow = innerShadow(blurType, color, radius, choke, offsetX, offsetY).apply(builderAction)

/** Set [Lighting] effect, returning the effect. */
fun Node.lighting(light: Light = Light.Distant()): Lighting = Lighting(light).also { effect = it }

/** Set [Lighting] effect with [builderAction], returning the effect. */
inline fun Node.lighting(light: Light = Light.Distant(), builderAction: Lighting.() -> Unit): Lighting =
    lighting(light).apply(builderAction)

/** Set [MotionBlur] effect, returning the effect. */
fun Node.motionBlur(angle: Double = 0.0, radius: Double = 10.0): MotionBlur =
    MotionBlur(angle, radius).also { effect = it }

/** Set [MotionBlur] effect with [builderAction], returning the effect. */
inline fun Node.motionBlur(
    angle: Double = 0.0,
    radius: Double = 10.0,
    builderAction: MotionBlur.() -> Unit
): MotionBlur = motionBlur(angle, radius).apply(builderAction)

/** Set [PerspectiveTransform] effect, returning the effect. */
fun Node.perspectiveTransform(
    ulx: Double = 0.0,
    uly: Double = 0.0,
    urx: Double = 0.0,
    ury: Double = 0.0,
    lrx: Double = 0.0,
    lry: Double = 0.0,
    llx: Double = 0.0,
    lly: Double = 0.0
): PerspectiveTransform = PerspectiveTransform(ulx, uly, urx, ury, lrx, lry, llx, lly).also { effect = it }

/** Set [PerspectiveTransform] effect with [builderAction], returning the effect. */
inline fun Node.perspectiveTransform(
    ulx: Double = 0.0,
    uly: Double = 0.0,
    urx: Double = 0.0,
    ury: Double = 0.0,
    lrx: Double = 0.0,
    lry: Double = 0.0,
    llx: Double = 0.0,
    lly: Double = 0.0,
    builderAction: PerspectiveTransform.() -> Unit
): PerspectiveTransform = perspectiveTransform(ulx, uly, urx, ury, lrx, lry, llx, lly).apply(builderAction)

/** Set [Reflection] effect, returning the effect. */
fun Node.reflection(
    topOffset: Double = 0.0,
    fraction: Double = 0.0,
    topOpacity: Double = 0.5,
    bottomOpacity: Double = 0.75
): Reflection = Reflection(topOffset, fraction, topOpacity, bottomOpacity).also { effect = it }

/** Set [Reflection] effect with [builderAction], returning the effect. */
inline fun Node.reflection(
    topOffset: Double = 0.0,
    fraction: Double = 0.0,
    topOpacity: Double = 0.5,
    bottomOpacity: Double = 0.75,
    builderAction: Reflection.() -> Unit
): Reflection = reflection(topOffset, fraction, topOpacity, bottomOpacity).apply(builderAction)

/** Set [SepiaTone] effect, returning the effect. */
fun Node.sepiaTone(level: Double = 1.0): SepiaTone = SepiaTone(level).also { effect = it }

/** Set [SepiaTone] effect with [builderAction], returning the effect. */
inline fun Node.sepiaTone(level: Double = 1.0, builderAction: SepiaTone.() -> Unit): SepiaTone =
    sepiaTone(level).apply(builderAction)

/** Set [Shadow] effect, returning the effect. */
fun Node.shadow(
    blurType: BlurType = BlurType.THREE_PASS_BOX,
    color: Color = Color.BLACK,
    radius: Double = 10.0
): Shadow = Shadow(blurType, color, radius).also { effect = it }

/** Set [Shadow] effect with [builderAction], returning the effect. */
inline fun Node.shadow(
    blurType: BlurType = BlurType.THREE_PASS_BOX,
    color: Color = Color.BLACK,
    radius: Double = 10.0,
    builderAction: Shadow.() -> Unit
): Shadow = shadow(blurType, color, radius).apply(builderAction)
