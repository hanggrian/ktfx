@file:Suppress("UsePropertyAccessSyntax")

package ktfx.scene.layout

import javafx.scene.layout.HBox
import ktfx.internal.NO_GETTER
import ktfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets spacing of each child. */
inline var HBox.spacings: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSpacing(value)