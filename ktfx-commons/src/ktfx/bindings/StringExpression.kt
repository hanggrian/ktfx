package ktfx.bindings

import javafx.beans.binding.BooleanBinding
import javafx.beans.value.ObservableStringValue
import ktfx.toBooleanBinding

inline val ObservableStringValue.isBlank: BooleanBinding get() = toBooleanBinding { it.isBlank() }
