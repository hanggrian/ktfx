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

fun stage(
        title: String? = null,
        style: StageStyle = DECORATED,
        init: (Stage.() -> Unit)? = null
): Stage = Stage(style).apply {
    title?.let { setTitle(it) }
    init?.invoke(this)
}