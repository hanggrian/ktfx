@file:JvmName("LabelsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.controls

import javafx.beans.property.StringProperty
import javafx.scene.control.PasswordField

inline val PasswordField.textProperty get() :StringProperty = textProperty()