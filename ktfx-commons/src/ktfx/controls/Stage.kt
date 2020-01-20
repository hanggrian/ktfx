package ktfx.controls

import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.StageStyle.DECORATED
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals

/** Get window as [Stage]. */
inline val Scene.stage: Stage get() = window as Stage

/** Convenient method for overriding the stage's computed minimum width and height. */
fun Stage.setMinSize(width: Double, height: Double) {
    minWidth = width; minHeight = height
}

/** Convenient method for overriding the stage's computed minimum width and height. */
var Stage.minSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    inline set(value) = setMinSize(value, value)

/** Convenient method for overriding the stage's computed width and height. */
fun Stage.setSize(width: Double, height: Double) {
    this.width = width; this.height = height
}

/** Convenient method for overriding the stage's computed width and height. */
var Stage.size: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    inline set(value) = setSize(value, value)

/** Convenient method for overriding the stage's computed maximum width and height. */
fun Stage.setMaxSize(width: Double, height: Double) {
    maxWidth = width; maxHeight = height
}

/** Convenient method for overriding the stage's computed maximum width and height. */
var Stage.maxSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    inline set(value) = setMaxSize(value, value)

/** Removes old icons and set a new one to this stage. */
var Stage.icon: Image
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    inline set(value) {
        icons.setAll(value)
    }

/** Creates a stage with options. */
inline fun stage(
    title: String? = null,
    icon: Image? = null,
    style: StageStyle = DECORATED,
    configuration: Stage.() -> Unit
): Stage = Stage(style).also {
    if (title != null) it.title = title
    if (icon != null) it.icon = icon
    it.configuration()
}

/** Creates a stage with options. */
inline fun stage(
    style: StageStyle = DECORATED,
    configuration: Stage.() -> Unit
): Stage = stage(null, null, style, configuration)
