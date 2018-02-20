@file:JvmMultifileClass
@file:JvmName("ConvertersKt")
@file:Suppress("UsePropertyAccessSyntax")

package kotfx.coroutines

import javafx.scene.control.ChoiceBox
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.Slider
import javafx.scene.control.SpinnerValueFactory
import kotlinx.coroutines.experimental.javafx.JavaFx
import java.time.LocalDate
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ChoiceBox<T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun <T> ComboBox<T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun DatePicker.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<LocalDate>.() -> Unit
) = setConverter(_StringConverter<LocalDate>(context).apply(converter))

fun Slider.labelFormatter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<Double>.() -> Unit
) = setLabelFormatter(_StringConverter<Double>(context).apply(converter))

fun <T> SpinnerValueFactory<T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))