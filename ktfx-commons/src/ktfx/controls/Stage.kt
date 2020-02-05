package ktfx.controls

import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/** Get window as [Stage]. */
inline val Scene.stage: Stage get() = window as Stage

/** Removes old icons and set a new one to this stage. */
inline var Stage.icon: Image
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        icons.setAll(value)
    }

/** Creates a stage with options. */
inline fun stage(
    title: String? = null,
    icon: Image? = null,
    style: StageStyle = StageStyle.DECORATED,
    configuration: Stage.() -> Unit
): Stage = Stage(style).also {
    if (title != null) it.title = title
    if (icon != null) it.icon = icon
    it.configuration()
}

/** Creates a stage with options. */
inline fun stage(
    style: StageStyle = StageStyle.DECORATED,
    configuration: Stage.() -> Unit
): Stage = stage(null, null, style, configuration)
