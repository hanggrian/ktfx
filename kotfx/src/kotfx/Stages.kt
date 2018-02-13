@file:Suppress("NOTHING_TO_INLINE")

package kotfx

import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.StageStyle.DECORATED
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Removes old icons and set a new one to this stage. */
var Stage.icon: Image
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        when (icons.size) {
            0 -> icons.add(value)
            1 -> icons[0] = value
            else -> {
                icons.clear()
                icons.add(value)
            }
        }
    }

inline var Stage.minSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMinSize(value, value)

inline fun Stage.setMinSize(minWidth: Double, minHeight: Double) {
    setMinWidth(minWidth)
    setMinHeight(minHeight)
}

inline var Stage.maxSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMaxSize(value, value)

inline fun Stage.setMaxSize(maxWidth: Double, maxHeight: Double) {
    setMaxWidth(maxWidth)
    setMaxHeight(maxHeight)
}

fun stage(
    title: String? = null,
    style: StageStyle = DECORATED,
    init: (Stage.() -> Unit)? = null
): Stage = Stage(style).apply {
    if (title != null) setTitle(title)
    init?.invoke(this)
}