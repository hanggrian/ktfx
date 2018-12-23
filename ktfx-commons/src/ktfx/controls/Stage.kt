@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.StageStyle.DECORATED
import ktfx.internal.KtfxInternals
import kotlin.DeprecationLevel.ERROR

/** Convenient method for overriding the stage's computed minimum width and height. */
inline var Stage.minSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) = setMinSize(value, value)

/** Convenient method for overriding the stage's computed minimum width and height. */
inline fun Stage.setMinSize(width: Double, height: Double) {
    minWidth = width
    minHeight = height
}

/** Convenient method for overriding the stage's computed width and height. */
inline var Stage.size: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) = setSize(value, value)

/** Convenient method for overriding the stage's computed width and height. */
inline fun Stage.setSize(width: Double, height: Double) {
    this.width = width
    this.height = height
}

/** Convenient method for overriding the stage's computed maximum width and height. */
inline var Stage.maxSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) = setMaxSize(value, value)

/** Convenient method for overriding the stage's computed maximum width and height. */
inline fun Stage.setMaxSize(width: Double, height: Double) {
    maxWidth = width
    maxHeight = height
}

/** Removes old icons and set a new one to this stage. */
inline var Stage.icon: Image
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        icons.setAll(value)
    }

/** Creates a stage with options. */
fun stage(
    title: String? = null,
    icon: Image? = null,
    style: StageStyle = DECORATED,
    init: (Stage.() -> Unit)? = null
): Stage = Stage(style).also {
    if (title != null) it.title = title
    if (icon != null) it.icon = icon
    init?.invoke(it)
}

/** Creates a stage with options. */
inline fun stage(
    style: StageStyle = DECORATED,
    noinline init: (Stage.() -> Unit)? = null
): Stage = stage(null, null, style, init)