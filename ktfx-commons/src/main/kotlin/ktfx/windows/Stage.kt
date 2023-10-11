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

/** Sets minimum width and height of this [Stage]. */
var Stage.minSize: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR)
    get() = noGetter()
    set(value) {
        minWidth = value.first.toDouble()
        minHeight = value.second.toDouble()
    }

/** Sets width and height of this [Stage]. */
var Stage.size2: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR)
    get() = noGetter()
    set(value) {
        width = value.first.toDouble()
        height = value.second.toDouble()
    }

/** Sets maximum width and height of this [Stage]. */
var Stage.maxSize: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR)
    get() = noGetter()
    set(value) {
        maxWidth = value.first.toDouble()
        maxHeight = value.second.toDouble()
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
