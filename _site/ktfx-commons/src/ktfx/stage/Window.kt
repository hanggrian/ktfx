package ktfx.stage

import javafx.stage.Window
import ktfx.NO_GETTER
import ktfx.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets width and height in integer. */
fun Window.setSize(width: Int, height: Int) {
    this.width = width.toDouble()
    this.height = height.toDouble()
}

/** Sets width and height in integer. */
inline var Window.size: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSize(value, value)