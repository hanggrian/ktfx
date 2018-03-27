@file:Suppress("UsePropertyAccessSyntax")

package ktfx.scene.layout

import javafx.scene.layout.HBox
import ktfx.internal.NO_GETTER
import ktfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets spacing of each child. */
var HBox.spacings: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSpacing(value.toDouble())