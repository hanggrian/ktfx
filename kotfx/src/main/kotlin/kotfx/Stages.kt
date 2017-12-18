@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.StageStyle.DECORATED
import javafx.stage.Window

inline var Stage.icon: Image?
    get() = icons[0]
    set(value) {
        if (!icons.isEmpty()) icons.clear()
        value?.let { icons.add(it) }
    }

inline fun stage(
        title: String,
        style: StageStyle = DECORATED,
        noinline init: (Stage.() -> Unit)? = null
): Stage = Stage(style).apply {
    setTitle(title)
    init?.invoke(this)
}

inline fun Window.stage(
        title: String,
        style: StageStyle = DECORATED,
        noinline init: (Stage.() -> Unit)? = null
): Stage = Stage(style).apply {
    initOwner(this@stage)
    setTitle(title)
    init?.invoke(this)
}