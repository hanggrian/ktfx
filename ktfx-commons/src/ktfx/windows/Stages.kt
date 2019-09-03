@file:Suppress("NOTHING_TO_INLINE")

package ktfx.windows

import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.StageStyle.DECORATED
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals

/** Get window as [Stage]. */
inline val Scene.stage get() = window as Stage

/** Convenient method for overriding the stage's computed minimum width and height. */
inline var Stage.minSize: Number
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) = value.toDouble().let { setMinSize(it, it) }

/** Convenient method for overriding the stage's computed minimum width and height. */
inline fun Stage.setMinSize(width: Number, height: Number) {
    minWidth = width.toDouble()
    minHeight = height.toDouble()
}

/** Convenient method for overriding the stage's computed width and height. */
inline var Stage.size: Number
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) = value.toDouble().let { setSize(it, it) }

/** Convenient method for overriding the stage's computed width and height. */
inline fun Stage.setSize(width: Number, height: Number) {
    this.width = width.toDouble()
    this.height = height.toDouble()
}

/** Convenient method for overriding the stage's computed maximum width and height. */
inline var Stage.maxSize: Number
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) = value.toDouble().let { setMaxSize(it, it) }

/** Convenient method for overriding the stage's computed maximum width and height. */
inline fun Stage.setMaxSize(width: Number, height: Number) {
    maxWidth = width.toDouble()
    maxHeight = height.toDouble()
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
