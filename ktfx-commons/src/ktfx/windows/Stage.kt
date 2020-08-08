@file:Suppress("NOTHING_TO_INLINE")

package ktfx.windows

import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter
import kotlin.DeprecationLevel.ERROR

/** Get window as [Stage]. */
inline val Scene.stage: Stage get() = window as Stage

/** Removes old icons and set a new one to this stage. */
inline var Stage.icon: Image
    get() = icons.first()
    set(value) {
        icons.setAll(value)
    }

/**
 * Sets minimum width and height of this [Stage].
 * @param width width value.
 * @param height height value.
 */
inline fun Stage.setMinSize(width: Double, height: Double) {
    minWidth = width
    minHeight = height
}

/** Sets minimum width and height of this [Stage] to the same value. */
inline var Stage.minSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMinSize(value, value)

/**
 * Sets width and height of this [Stage].
 * @param width width value.
 * @param height height value.
 */
inline fun Stage.setSize(width: Double, height: Double) {
    setWidth(width)
    setHeight(height)
}

/** Sets width and height of this [Stage] to the same value. */
inline var Stage.size: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSize(value, value)

/**
 * Sets maximum width and height of this [Stage].
 * @param width width value.
 * @param height height value.
 */
inline fun Stage.setMaxSize(width: Double, height: Double) {
    maxWidth = width
    maxHeight = height
}

/** Sets maximum width and height of this [Stage] to the same value. */
inline var Stage.maxSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMaxSize(value, value)

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
