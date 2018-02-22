@file:JvmMultifileClass
@file:JvmName("ScenesKt")
@file:Suppress("UsePropertyAccessSyntax")

package kotfx

import javafx.scene.control.ChoiceBox
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.Slider
import javafx.scene.control.SpinnerValueFactory
import kotfx.internal.asConverter
import java.time.LocalDate

fun <T> ChoiceBox<T>.converter(
    converter: _StringConverter<T>.() -> Unit
) = setConverter(converter.asConverter())

fun <T> ComboBox<T>.converter(
    converter: _StringConverter<T>.() -> Unit
) = setConverter(converter.asConverter())

fun DatePicker.converter(
    converter: _StringConverter<LocalDate>.() -> Unit
) = setConverter(converter.asConverter())

fun Slider.labelFormatter(
    converter: _StringConverter<Double>.() -> Unit
) = setLabelFormatter(converter.asConverter())

fun <T> SpinnerValueFactory<T>.converter(
    converter: _StringConverter<T>.() -> Unit
) = setConverter(converter.asConverter())