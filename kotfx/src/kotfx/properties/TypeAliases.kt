package kotfx.properties

import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableObjectValue
import javafx.beans.value.WritableIntegerValue
import javafx.beans.value.WritableObjectValue

//region property typealiases

typealias MutableProperty<T> = javafx.beans.property.Property<T>
typealias Property<T> = javafx.beans.property.ReadOnlyProperty<T>

typealias MutableAnyProperty<T> = javafx.beans.property.ObjectProperty<T>
typealias MutableAnyPropertyBase<T> = javafx.beans.property.ObjectPropertyBase<T>
typealias AnyProperty<T> = javafx.beans.property.ReadOnlyObjectProperty<T>
typealias AnyPropertyBase<T> = javafx.beans.property.ReadOnlyObjectPropertyBase<T>
typealias AnyWrapper<T> = javafx.beans.property.ReadOnlyObjectWrapper<T>
typealias SimpleAnyProperty<T> = javafx.beans.property.SimpleObjectProperty<T>

typealias MutableStringProperty = javafx.beans.property.StringProperty
typealias MutableStringPropertyBase = javafx.beans.property.StringPropertyBase
typealias StringProperty = javafx.beans.property.ReadOnlyStringProperty
typealias StringPropertyBase = javafx.beans.property.ReadOnlyStringPropertyBase
typealias StringWrapper = javafx.beans.property.ReadOnlyStringWrapper

typealias MutableBooleanProperty = javafx.beans.property.BooleanProperty
typealias MutableBooleanPropertyBase = javafx.beans.property.BooleanPropertyBase
typealias BooleanProperty = javafx.beans.property.ReadOnlyBooleanProperty
typealias BooleanPropertyBase = javafx.beans.property.ReadOnlyBooleanPropertyBase
typealias BooleanWrapper = javafx.beans.property.ReadOnlyBooleanWrapper

typealias MutableDoubleProperty = javafx.beans.property.DoubleProperty
typealias MutableDoublePropertyBase = javafx.beans.property.DoublePropertyBase
typealias DoubleProperty = javafx.beans.property.ReadOnlyDoubleProperty
typealias DoublePropertyBase = javafx.beans.property.ReadOnlyDoublePropertyBase
typealias DoubleWrapper = javafx.beans.property.ReadOnlyDoubleWrapper

typealias MutableFloatProperty = javafx.beans.property.FloatProperty
typealias MutableFloatPropertyBase = javafx.beans.property.FloatPropertyBase
typealias FloatProperty = javafx.beans.property.ReadOnlyFloatProperty
typealias FloatPropertyBase = javafx.beans.property.ReadOnlyFloatPropertyBase
typealias FloatWrapper = javafx.beans.property.ReadOnlyFloatWrapper

typealias MutableLongProperty = javafx.beans.property.LongProperty
typealias MutableLongPropertyBase = javafx.beans.property.LongPropertyBase
typealias LongProperty = javafx.beans.property.ReadOnlyLongProperty
typealias LongPropertyBase = javafx.beans.property.ReadOnlyLongPropertyBase
typealias LongWrapper = javafx.beans.property.ReadOnlyLongWrapper

typealias MutableIntProperty = javafx.beans.property.IntegerProperty
typealias MutableIntPropertyBase = javafx.beans.property.IntegerPropertyBase
typealias IntProperty = javafx.beans.property.ReadOnlyIntegerProperty
typealias IntPropertyBase = javafx.beans.property.ReadOnlyIntegerPropertyBase
typealias IntWrapper = javafx.beans.property.ReadOnlyIntegerWrapper
typealias SimpleIntProperty = javafx.beans.property.SimpleIntegerProperty

typealias MutableListProperty<E> = javafx.beans.property.ListProperty<E>
typealias MutableListPropertyBase<E> = javafx.beans.property.ListPropertyBase<E>
typealias ListProperty<E> = javafx.beans.property.ReadOnlyListProperty<E>
typealias ListPropertyBase<E> = javafx.beans.property.ReadOnlyListPropertyBase<E>
typealias ListWrapper<E> = javafx.beans.property.ReadOnlyListWrapper<E>

typealias MutableSetProperty<E> = javafx.beans.property.SetProperty<E>
typealias MutableSetPropertyBase<E> = javafx.beans.property.SetPropertyBase<E>
typealias SetProperty<E> = javafx.beans.property.ReadOnlySetProperty<E>
typealias SetPropertyBase<E> = javafx.beans.property.ReadOnlySetPropertyBase<E>
typealias SetWrapper<E> = javafx.beans.property.ReadOnlySetWrapper<E>

typealias MutableMapProperty<K, V> = javafx.beans.property.MapProperty<K, V>
typealias MutableMapPropertyBase<K, V> = javafx.beans.property.MapPropertyBase<K, V>
typealias MapProperty<K, V> = javafx.beans.property.ReadOnlyMapProperty<K, V>
typealias MapPropertyBase<K, V> = javafx.beans.property.ReadOnlyMapPropertyBase<K, V>
typealias MapWrapper<K, V> = javafx.beans.property.ReadOnlyMapWrapper<K, V>
//endregion

//region value typealiases

typealias ObservableAnyValue<T> = ObservableObjectValue<T>
typealias WritableAnyValue<T> = WritableObjectValue<T>

typealias ObservableIntValue = ObservableIntegerValue
typealias WritableIntValue = WritableIntegerValue
//endregion