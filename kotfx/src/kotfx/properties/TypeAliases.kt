package kotfx.properties

import javafx.beans.property.*
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableObjectValue
import javafx.beans.value.WritableIntegerValue
import javafx.beans.value.WritableObjectValue

typealias AnyProperty<T> = ObjectProperty<T>
typealias AnyPropertyBase<T> = ObjectPropertyBase<T>
typealias ReadOnlyAnyProperty<T> = ReadOnlyObjectProperty<T>
typealias ReadOnlyAnyPropertyBase<T> = ReadOnlyObjectPropertyBase<T>
typealias ReadOnlyAnyWrapper<T> = ReadOnlyObjectWrapper<T>
typealias SimpleAnyProperty<T> = SimpleObjectProperty<T>

typealias IntProperty = IntegerProperty
typealias IntPropertyBase = IntegerPropertyBase
typealias ReadOnlyIntProperty = ReadOnlyIntegerProperty
typealias ReadOnlyIntPropertyBase = ReadOnlyIntegerPropertyBase
typealias ReadOnlyIntWrapper = ReadOnlyIntegerWrapper
typealias SimpleIntProperty = SimpleIntegerProperty

typealias ObservableAnyValue<T> = ObservableObjectValue<T>
typealias WritableAnyValue<T> = WritableObjectValue<T>

typealias ObservableIntValue = ObservableIntegerValue
typealias WritableIntValue = WritableIntegerValue