@file:JvmMultifileClass
@file:JvmName("UtilsKt")

package kotfx.coroutines

import javafx.beans.binding.Bindings.bindBidirectional
import javafx.beans.property.Property
import javafx.beans.property.StringProperty
import kotlin.coroutines.experimental.CoroutineContext

fun <T> Property<String>.bindBidirectional(
    context: CoroutineContext = FX,
    property: Property<T>,
    converter: _StringConverter<T>.() -> Unit
) = bindBidirectional(this, property, _StringConverter<T>(context).apply(converter))

fun <T> StringProperty.bindBidirectional(
    context: CoroutineContext = FX,
    property: Property<T>,
    converter: _StringConverter<T>.() -> Unit
) = bindBidirectional(property, _StringConverter<T>(context).apply(converter))