package kotfx.layouts.controls

import javafx.scene.control.Labeled
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

internal interface _Labeled<out T : Labeled> : _Region<T> {

    fun font(font: Font) = instance.setFont(font)
    fun font(family: String?, weight: FontWeight?, posture: FontPosture?, size: Number?) = font(Font.font(family, weight, posture, size?.toDouble() ?: -1.0))
    fun font(family: String?, weight: FontWeight?, size: Number?) = font(Font.font(family, weight, size?.toDouble() ?: -1.0))
    fun font(family: String?, posture: FontPosture?, size: Number?) = font(Font.font(family, posture, size?.toDouble() ?: -1.0))
    fun font(family: String?, size: Number?) = font(Font.font(family, size?.toDouble() ?: -1.0))
    fun font(family: String?) = font(Font.font(family))
    fun font(size: Number?) = font(Font.font(size?.toDouble() ?: -1.0))
}