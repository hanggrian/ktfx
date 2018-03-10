@file:Suppress("UsePropertyAccessSyntax")

package kfx.scene.layout

import javafx.scene.layout.HBox
import kfx.internal.NO_GETTER
import kfx.internal.noGetter

var HBox.spacings: Number
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setSpacing(value.toDouble())