@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotlinfx.listeners

import javafx.scene.control.ComboBox

inline fun <T> ComboBox<T>.converter(
    converter: StringConverterBuilder<T>.() -> Unit
) = setConverter(converter.build())

inline fun <T> ComboBox<T>.cellFactory(
    noinline cellFactory: ListCellBuilder<T>.() -> Unit
) = setCellFactory { cellFactory.build() }