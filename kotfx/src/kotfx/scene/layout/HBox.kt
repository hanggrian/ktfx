@file:Suppress("UsePropertyAccessSyntax")

package kotfx.scene.layout

import javafx.scene.layout.HBox
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter

var HBox.spacings: Number
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setSpacing(value.toDouble())