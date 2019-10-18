@file:JvmMultifileClass
@file:JvmName("PropertiesKt")

package ktfx

import javafx.beans.property.ObjectProperty
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.ReadOnlyStringWrapper
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

/**
 * Wrap nullable object in a JavaFX property.
 *
 * @param readOnly true when this is a read-only property, default is false.
 * @see SimpleObjectProperty
 * @see ReadOnlyObjectWrapper
 */
fun <E> E?.asProperty(readOnly: Boolean = false): ObjectProperty<E> = when {
    readOnly -> ReadOnlyObjectWrapper(this)
    else -> SimpleObjectProperty(this)
}

/**
 * Wrap nullable string in a JavaFX property.
 *
 * @param readOnly true when this is a read-only property, default is false.
 * @see SimpleStringProperty
 * @see ReadOnlyStringWrapper
 */
fun String?.asProperty(readOnly: Boolean = false): StringProperty = when {
    readOnly -> ReadOnlyStringWrapper(this)
    else -> SimpleStringProperty(this)
}
