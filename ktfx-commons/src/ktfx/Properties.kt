@file:JvmMultifileClass
@file:JvmName("PropertiesKt")

package ktfx

import javafx.beans.property.ObjectProperty
import javafx.beans.property.ReadOnlyObjectProperty
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.ReadOnlyStringProperty
import javafx.beans.property.ReadOnlyStringWrapper
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

/** Wrap this object in modifiable property. */
fun <E> E?.asProperty(): ObjectProperty<E> =
    SimpleObjectProperty(this)

/** Wrap this object in unmodifiable property. */
fun <E> E?.asFinalProperty(): ReadOnlyObjectProperty<E> =
    ReadOnlyObjectWrapper(this)

/** Wrap this string in modifiable property. */
fun String?.asProperty(): StringProperty =
    SimpleStringProperty(this)

/** Wrap this string in unmodifiable property. */
fun String?.asFinalProperty(): ReadOnlyStringProperty =
    ReadOnlyStringWrapper(this)
