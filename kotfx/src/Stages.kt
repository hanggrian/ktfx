@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.StageStyle.DECORATED

inline var Stage.icon: Image?
    get() = icons[0]
    set(value) {
        if (!icons.isEmpty()) icons.clear()
        value?.let { icons.add(it) }
    }

inline fun stage(
        title: String? = null,
        style: StageStyle = DECORATED,
        noinline init: (Stage.() -> Unit)? = null
): Stage = Stage(style).apply {
    title?.let { setTitle(it) }
    init?.invoke(this)
}