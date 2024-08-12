package ktfx.controls

import com.hanggrian.ktfx.test.initToolkit
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
import javafx.scene.layout.Region
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertIs

class EffectsTest {
    private lateinit var region: Region

    @BeforeTest
    fun start() {
        initToolkit()
        region = Region()
    }

    @Test
    fun blend() {
        region.blendEffect {}
        assertIs<Blend>(region.effect)
    }

    @Test
    fun bloom() {
        region.bloomEffect {}
        assertIs<Bloom>(region.effect)
    }

    @Test
    fun boxBlur() {
        region.boxBlurEffect {}
        assertIs<BoxBlur>(region.effect)
    }

    @Test
    fun colorAdjustEffect() {
        region.colorAdjustEffect {}
        assertIs<ColorAdjust>(region.effect)
    }

    @Test
    fun colorInputEffect() {
        region.colorInputEffect {}
        assertIs<ColorInput>(region.effect)
    }

    @Test
    fun displacementMapEffect() {
        region.displacementMapEffect {}
        assertIs<DisplacementMap>(region.effect)
    }

    @Test
    fun dropShadowEffect() {
        region.dropShadowEffect {}
        assertIs<DropShadow>(region.effect)
    }

    @Test
    fun gaussianBlurEffect() {
        region.gaussianBlurEffect {}
        assertIs<GaussianBlur>(region.effect)
    }

    @Test
    fun glowEffect() {
        region.glowEffect {}
        assertIs<Glow>(region.effect)
    }

    @Test
    fun imageInputEffect() {
        region.imageInputEffect {}
        assertIs<ImageInput>(region.effect)
    }

    @Test
    fun innerShadowEffect() {
        region.innerShadowEffect {}
        assertIs<InnerShadow>(region.effect)
    }

    @Test
    fun lightingEffect() {
        region.lightingEffect {}
        assertIs<Lighting>(region.effect)
    }

    @Test
    fun motionBlurEffect() {
        region.motionBlurEffect {}
        assertIs<MotionBlur>(region.effect)
    }

    @Test
    fun perspectiveTransformEffect() {
        region.perspectiveTransformEffect {}
        assertIs<PerspectiveTransform>(region.effect)
    }

    @Test
    fun reflectionEffect() {
        region.reflectionEffect {}
        assertIs<Reflection>(region.effect)
    }

    @Test
    fun sepiaToneEffect() {
        region.sepiaToneEffect {}
        assertIs<SepiaTone>(region.effect)
    }

    @Test
    fun shadowEffect() {
        region.shadowEffect {}
        assertIs<Shadow>(region.effect)
    }
}
