@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.stage

import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.StageStyle.DECORATED
import ktfx.internal.NO_GETTER
import ktfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Removes old icons and set a new one to this stage. */
var Stage.icon: Image
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = when (icons.size) {
        0 -> icons += value
        1 -> icons[0] = value
        else -> {
            icons.clear()
            icons += value
        }
    }

/** Creates a stage with options. */
fun stage(
    title: String? = null,
    style: StageStyle = DECORATED,
    init: (Stage.() -> Unit)? = null
): Stage = Stage(style).apply {
    if (title != null) setTitle(title)
    init?.invoke(this)
}