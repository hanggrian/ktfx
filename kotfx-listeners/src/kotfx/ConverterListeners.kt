@file:Suppress("UsePropertyAccessSyntax")

package kotfx

import javafx.scene.control.ChoiceBox
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.Slider
import javafx.scene.control.SpinnerValueFactory
import kotfx.internal.asConverter
import kotfx.util._StringConverter
import java.time.LocalDate

inline fun <T> ChoiceBox<T>.converter(
    converter: _StringConverter<T>.() -> Unit
) = setConverter(converter.asConverter())

inline fun <T> ComboBox<T>.converter(
    converter: _StringConverter<T>.() -> Unit
) = setConverter(converter.asConverter())

inline fun DatePicker.converter(
    converter: _StringConverter<LocalDate>.() -> Unit
) = setConverter(converter.asConverter())

inline fun Slider.labelFormatter(
    converter: _StringConverter<Double>.() -> Unit
) = setLabelFormatter(converter.asConverter())

inline fun <T> SpinnerValueFactory<T>.converter(
    converter: _StringConverter<T>.() -> Unit
) = setConverter(converter.asConverter())