@file:Suppress("UsePropertyAccessSyntax")

package kotfx.scene.layout

import javafx.scene.layout.VBox
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter

var VBox.spacings: Number
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setSpacing(value.toDouble())