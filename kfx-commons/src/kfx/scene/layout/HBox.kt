@file:Suppress("UsePropertyAccessSyntax")

package kfx.scene.layout

import javafx.scene.layout.HBox
import kfx.NO_GETTER
import kfx.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets spacing of each child. */
var HBox.spacings: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSpacing(value.toDouble())