@file:Suppress("NOTHING_TO_INLINE")

package kotfx

import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.StageStyle.DECORATED
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

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

inline fun Stage.setMinSize(minWidth: Number, minHeight: Number = minWidth) {
    setMinWidth(minWidth.toDouble())
    setMinHeight(minHeight.toDouble())
}

inline fun Stage.setMaxSize(maxWidth: Number, maxHeight: Number = maxWidth) {
    setMaxWidth(maxWidth.toDouble())
    setMaxHeight(maxHeight.toDouble())
}

fun stage(
    title: String? = null,
    style: StageStyle = DECORATED,
    init: (Stage.() -> Unit)? = null
): Stage = Stage(style).apply {
    if (title != null) setTitle(title)
    init?.invoke(this)
}