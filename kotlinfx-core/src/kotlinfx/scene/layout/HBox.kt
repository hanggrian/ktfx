@file:Suppress("UsePropertyAccessSyntax")

package kotlinfx.scene.layout

import javafx.scene.layout.HBox
import kotlinfx.internal.NO_GETTER
import kotlinfx.internal.noGetter

var HBox.spacings: Number
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setSpacing(value.toDouble())