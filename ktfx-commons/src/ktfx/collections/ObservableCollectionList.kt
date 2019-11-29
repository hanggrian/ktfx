@file:JvmMultifileClass
@file:JvmName("ObservableCollectionKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import java.util.Comparator
import java.util.Random
import javafx.beans.binding.Binding
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableNumberValue
import javafx.collections.FXCollections
import javafx.collections.ObservableList

/**
 * Returns an empty immutable [ObservableList].
 *
 * @see emptyList
 */
fun <T> emptyObservableList(): ObservableList<T> = FXCollections.emptyObservableList()

/**
 * Alias of [emptyObservableList].
 *
 * @see listOf
 */
inline fun <T> observableListOf(): ObservableList<T> = emptyObservableList()

/**
 * Returns an immutable [ObservableList] of one [element].
 *
 * @see listOf
 */
fun <T> observableListOf(element: T): ObservableList<T> = FXCollections.singletonObservableList(element)

/**
 * Returns an immutable [ObservableList] containing all [elements].
 *
 * @see listOf
 */
fun <T> observableListOf(vararg elements: T): ObservableList<T> =
    if (elements.isNotEmpty()) FXCollections.unmodifiableObservableList(elements.toMutableObservableList()) else emptyObservableList()

/**
 * Returns an empty [ObservableList].
 *
 * @see mutableListOf
 */
fun <T> mutableObservableListOf(): ObservableList<T> = FXCollections.observableArrayList()

/**
 * Returns an [ObservableList] containing all [elements].
 *
 * @see mutableListOf
 */
fun <T> mutableObservableListOf(vararg elements: T): ObservableList<T> =
    if (elements.isEmpty()) mutableObservableListOf() else FXCollections.observableArrayList(*elements)

/**
 * Converts this array to immutable [ObservableList].
 *
 * @see Array.toList
 */
fun <T> Array<out T>.toObservableList(): ObservableList<T> {
    return when (size) {
        0 -> emptyObservableList()
        1 -> observableListOf(this[0])
        else -> FXCollections.unmodifiableObservableList(this.toMutableObservableList())
    }
}

/**
 * Converts this array to [ObservableList].
 *
 * @see Array.toMutableList
 */
fun <T> Array<out T>.toMutableObservableList(): ObservableList<T> = FXCollections.observableArrayList(*this)

/**
 * Converts this iterable to immutable [ObservableList].
 *
 * @see Iterable.toList
 */
fun <T> Iterable<T>.toObservableList(): ObservableList<T> {
    if (this is Collection) {
        return when (size) {
            0 -> emptyObservableList()
            1 -> observableListOf(if (this is List) get(0) else iterator().next())
            else -> FXCollections.unmodifiableObservableList(this.toMutableObservableList())
        }
    }
    return this.toMutableObservableList().optimizeReadOnlyList()
}

/**
 * Converts this iterable to [ObservableList].
 *
 * @see Iterable.toMutableList
 */
fun <T> Iterable<T>.toMutableObservableList(): ObservableList<T> {
    if (this is Collection)
        return this.toMutableObservableList()
    return toCollection(FXCollections.observableArrayList())
}

/**
 * Converts this collection to [ObservableList].
 *
 * @see Collection.toMutableList
 */
fun <T> Collection<T>.toMutableObservableList(): ObservableList<T> = FXCollections.observableArrayList(this)

/**
 * Converts this sequence to immutable [ObservableList].
 *
 * @see Sequence.toList
 */
fun <T> Sequence<T>.toObservableList(): ObservableList<T> = toMutableObservableList().optimizeReadOnlyList()

/**
 * Converts this sequence to [ObservableList].
 *
 * @see Sequence.toMutableList
 */
fun <T> Sequence<T>.toMutableObservableList(): ObservableList<T> = toCollection(FXCollections.observableArrayList())

/** Copies elements from src to list, firing change notification once. */
fun <T> ObservableList<T>.copy(src: List<T>): Unit = FXCollections.copy(this, src)

/** Fills the list with obj, firing change notification once. */
fun <T> ObservableList<T>.fill(obj: T): Unit = FXCollections.fill(this, obj)

/** Replace all oldVal elements in the list with newVal element, firing change notification once. */
fun <T> ObservableList<T>.replaceAll(oldVal: T, newVal: T): Boolean = FXCollections.replaceAll(this, oldVal, newVal)

/** Reverse the order in the list, firing change notification once. */
fun ObservableList<*>.reverse(): Unit = FXCollections.reverse(this)

/** Rotates the list by distance, firing change notification once. */
fun ObservableList<*>.rotate(distance: Int): Unit = FXCollections.rotate(this, distance)

/** Shuffles all elements in the observable list, firing change notification once. */
fun ObservableList<*>.shuffle(rnd: Random? = null): Unit = when (rnd) {
    null -> FXCollections.shuffle(this)
    else -> FXCollections.shuffle(this, rnd)
}

/** Sorts the provided observable list, firing change notification once. */
fun <T : Comparable<T>> ObservableList<T>.sort(): Unit = FXCollections.sort(this)

/** Sorts the provided observable list using the c comparator, firing change notification once. */
infix fun <T> ObservableList<T>.sort(c: Comparator<T>): Unit = FXCollections.sort(this, c)

/** Generates a bidirectional binding between two instances of [ObservableList]. */
fun <E> ObservableList<E>.bindContentBidirectional(other: ObservableList<E>): Unit =
    Bindings.bindContentBidirectional(this, other)

/** Remove a bidirectional binding between two instances of [ObservableList]. */
fun <E> ObservableList<E>.unbindContentBidirectional(other: ObservableList<E>): Unit =
    Bindings.unbindContentBidirectional(this, other)

/** Generates a bidirectional binding between an [ObservableList] and a [List]. */
fun <E> List<E>.bindContent(other: ObservableList<E>): Unit = Bindings.bindContent(this, other)

/** Remove a bidirectional binding between an [ObservableList] and a [List]. */
fun <E> List<E>.unbindContent(other: ObservableList<E>): Unit = Bindings.unbindContent(this, other)

/** Creates a new [IntegerBinding] that contains the size [ObservableList]. */
val <E> ObservableList<E>.sizeBinding: IntegerBinding get() = Bindings.size(this)

/** Creates a new [BooleanBinding] that holds `true` if a given [ObservableList] is empty. */
val <E> ObservableList<E>.emptyBinding: BooleanBinding get() = Bindings.isEmpty(this)

/** Creates a new [BooleanBinding] that holds `true` if a given [ObservableList] is not empty. */
val <E> ObservableList<E>.notEmptyBinding: BooleanBinding get() = Bindings.isNotEmpty(this)

/** Creates a new [ObjectBinding] that contains the element of an [ObservableList] at the specified position. */
fun <E> ObservableList<E>.getBinding(index: Int): ObjectBinding<E> = Bindings.valueAt(this, index)

/** Creates a new [ObjectBinding] that contains the element of an [ObservableList] at the specified position. */
fun <E> ObservableList<E>.getBinding(index: ObservableNumberValue): ObjectBinding<E> = Bindings.valueAt(this, index)

/** Creates a new [ObjectBinding] that contains the element of an [ObservableList] at the specified position. */
inline fun <E> ObservableList<E>.getBinding(index: ObservableIntegerValue): ObjectBinding<E> =
    getBinding(index as ObservableNumberValue)

/** Creates a new [BooleanBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<Boolean>.getBinding(index: Int): BooleanBinding = Bindings.booleanValueAt(this, index)

/** Creates a new [BooleanBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<Boolean>.getBinding(index: ObservableNumberValue): BooleanBinding =
    Bindings.booleanValueAt(this, index)

/** Creates a new [BooleanBinding] that contains the element of an [ObservableList] at the specified position. */
inline fun ObservableList<Boolean>.getBinding(index: ObservableIntegerValue): BooleanBinding =
    getBinding(index as ObservableNumberValue)

/** Creates a new [DoubleBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<Double>.getBinding(index: Int): DoubleBinding = Bindings.doubleValueAt(this, index)

/** Creates a new [DoubleBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<Double>.getBinding(index: ObservableNumberValue): DoubleBinding =
    Bindings.doubleValueAt(this, index)

/** Creates a new [DoubleBinding] that contains the element of an [ObservableList] at the specified position. */
inline fun ObservableList<Double>.getBinding(index: ObservableIntegerValue): DoubleBinding =
    getBinding(index as ObservableNumberValue)

/** Creates a new [FloatBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<Float>.getBinding(index: Int): FloatBinding = Bindings.floatValueAt(this, index)

/** Creates a new [FloatBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<Float>.getBinding(index: ObservableNumberValue): FloatBinding = Bindings.floatValueAt(this, index)

/** Creates a new [FloatBinding] that contains the element of an [ObservableList] at the specified position. */
inline fun ObservableList<Float>.getBinding(index: ObservableIntegerValue): FloatBinding =
    getBinding(index as ObservableNumberValue)

/** Creates a new [IntegerBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<Int>.getBinding(index: Int): IntegerBinding = Bindings.integerValueAt(this, index)

/** Creates a new [IntegerBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<Int>.getBinding(index: ObservableNumberValue): IntegerBinding = Bindings.integerValueAt(this, index)

/** Creates a new [IntegerBinding] that contains the element of an [ObservableList] at the specified position. */
inline fun ObservableList<Int>.getBinding(index: ObservableIntegerValue): IntegerBinding =
    getBinding(index as ObservableNumberValue)

/** Creates a new [LongBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<Long>.getBinding(index: Int): LongBinding = Bindings.longValueAt(this, index)

/** Creates a new [LongBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<Long>.getBinding(index: ObservableNumberValue): LongBinding = Bindings.longValueAt(this, index)

/** Creates a new [LongBinding] that contains the element of an [ObservableList] at the specified position. */
inline fun ObservableList<Long>.getBinding(index: ObservableIntegerValue): LongBinding =
    getBinding(index as ObservableNumberValue)

/** Creates a new [StringBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<String>.getBinding(index: Int): StringBinding = Bindings.stringValueAt(this, index)

/** Creates a new [StringBinding] that contains the element of an [ObservableList] at the specified position. */
fun ObservableList<String>.getBinding(index: ObservableNumberValue): StringBinding = Bindings.stringValueAt(this, index)

/** Creates a new [StringBinding] that contains the element of an [ObservableList] at the specified position. */
inline fun ObservableList<String>.getBinding(index: ObservableIntegerValue): StringBinding =
    getBinding(index as ObservableNumberValue)

/**
 * Performs the given [action] on each element.
 *
 * @see List.forEach
 */
inline fun <E> ObservableList<E>.forEachBinding(action: (Binding<E>) -> Unit) {
    for (index in 0 until size) {
        action(getBinding(index))
    }
}

/**
 * Performs the given [action] on each element, providing sequential index with the element.
 *
 * @see List.forEachIndexed
 */
inline fun <E> ObservableList<E>.forEachBindingIndexed(action: (index: Int, Binding<E>) -> Unit) {
    for (index in 0 until size) {
        action(index, getBinding(index))
    }
}
