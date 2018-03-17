package kfx.stage

import javafx.stage.Window
import kfx.NO_GETTER
import kfx.noGetter
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