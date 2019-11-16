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
fun <T> emptyObservableList(): ObservableList<T> =
    FXCollections.emptyObservableList()

/**
 * Alias of [emptyObservableList].
 *
 * @see listOf
 */
inline fun <T> observableListOf(): ObservableList<T> =
    emptyObservableList()

/**
 * Returns an immutable [ObservableList] of one [element].
 *
 * @see listOf
 */
fun <T> observableListOf(element: T): ObservableList<T> =
    FXCollections.singletonObservableList(element)

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
fun <T> mutableObservableListOf(): ObservableList<T> =
    FXCollections.observableArrayList()

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
fun <T> Array<out T>.toMutableObservableList(): ObservableList<T> =
    FXCollections.observableArrayList(*this)

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
fun <T> Collection<T>.toMutableObservableList(): ObservableList<T> =
    FXCollections.observableArrayList(this)

/**
 * Converts this sequence to immutable [ObservableList].
 *
 * @see Sequence.toList
 */
fun <T> Sequence<T>.toObservableList(): ObservableList<T> =
    toMutableObservableList().optimizeReadOnlyList()

/**
 * Converts this sequence to [ObservableList].
 *
 * @see Sequence.toMutableList
 */
fun <T> Sequence<T>.toMutableObservableList(): ObservableList<T> =
    toCollection(FXCollections.observableArrayList())

/** Copies elements from src to list, firing change notification once. */
fun <T> ObservableList<T>.copy(src: List<T>): Unit =
    FXCollections.copy(this, src)

/** Fills the list with obj, firing change notification once. */
fun <T> ObservableList<T>.fill(obj: T): Unit =
    FXCollections.fill(this, obj)

/** Replace all oldVal elements in the list with newVal element, firing change notification once. */
fun <T> ObservableList<T>.replaceAll(oldVal: T, newVal: T): Boolean =
    FXCollections.replaceAll(this, oldVal, newVal)

/** Reverse the order in the list, firing change notification once. */
fun ObservableList<*>.reverse(): Unit =
    FXCollections.reverse(this)

/** Rotates the list by distance, firing change notification once. */
fun ObservableList<*>.rotate(distance: Int): Unit =
    FXCollections.rotate(this, distance)

/** Shuffles all elements in the observable list, firing change notification once. */
fun ObservableList<*>.shuffle(rnd: Random? = null): Unit =
    when (rnd) {
        null -> FXCollections.shuffle(this)
        else -> FXCollections.shuffle(this, rnd)
    }

/** Sorts the provided observable list, firing change notification once. */
fun <T : Comparable<T>> ObservableList<T>.sort(): Unit =
    FXCollections.sort(this)

/** Sorts the provided observable list using the c comparator, firing change notification once. */
infix fun <T> ObservableList<T>.sort(c: Comparator<T>): Unit =
    FXCollections.sort(this, c)

fun <E> ObservableList<E>.bindContentBidirectional(other: ObservableList<E>): Unit =
    Bindings.bindContentBidirectional(this, other)

fun <E> ObservableList<E>.unbindContentBidirectional(other: ObservableList<E>): Unit =
    Bindings.unbindContentBidirectional(this, other)

fun <E> List<E>.bindContent(other: ObservableList<E>): Unit =
    Bindings.bindContent(this, other)

fun <E> List<E>.unbindContent(other: ObservableList<E>): Unit =
    Bindings.unbindContent(this, other)

val <E> ObservableList<E>.sizeBinding: IntegerBinding
    get() = Bindings.size(this)

val <E> ObservableList<E>.isEmptyBinding: BooleanBinding
    get() = Bindings.isEmpty(this)

val <E> ObservableList<E>.isNotEmptyBinding: BooleanBinding
    get() = Bindings.isNotEmpty(this)

fun <E> ObservableList<E>.getBinding(index: Int): ObjectBinding<E> =
    Bindings.valueAt(this, index)

fun <E> ObservableList<E>.getBinding(index: ObservableIntegerValue): ObjectBinding<E> =
    Bindings.valueAt(this, index)

fun <E> ObservableList<E>.getBinding(index: ObservableNumberValue): ObjectBinding<E> =
    Bindings.valueAt(this, index)

fun ObservableList<Boolean>.getBinding(index: Int): BooleanBinding =
    Bindings.booleanValueAt(this, index)

fun ObservableList<Boolean>.getBinding(index: ObservableIntegerValue): BooleanBinding =
    Bindings.booleanValueAt(this, index)

fun ObservableList<Boolean>.getBinding(index: ObservableNumberValue): BooleanBinding =
    Bindings.booleanValueAt(this, index)

fun ObservableList<Double>.getBinding(index: Int): DoubleBinding =
    Bindings.doubleValueAt(this, index)

fun ObservableList<Double>.getBinding(index: ObservableIntegerValue): DoubleBinding =
    Bindings.doubleValueAt(this, index)

fun ObservableList<Double>.getBinding(index: ObservableNumberValue): DoubleBinding =
    Bindings.doubleValueAt(this, index)

fun ObservableList<Float>.getBinding(index: Int): FloatBinding =
    Bindings.floatValueAt(this, index)

fun ObservableList<Float>.getBinding(index: ObservableIntegerValue): FloatBinding =
    Bindings.floatValueAt(this, index)

fun ObservableList<Float>.getBinding(index: ObservableNumberValue): FloatBinding =
    Bindings.floatValueAt(this, index)

fun ObservableList<Int>.getBinding(index: Int): IntegerBinding =
    Bindings.integerValueAt(this, index)

fun ObservableList<Int>.getBinding(index: ObservableIntegerValue): IntegerBinding =
    Bindings.integerValueAt(this, index)

fun ObservableList<Int>.getBinding(index: ObservableNumberValue): IntegerBinding =
    Bindings.integerValueAt(this, index)

fun ObservableList<Long>.getBinding(index: Int): LongBinding =
    Bindings.longValueAt(this, index)

fun ObservableList<Long>.getBinding(index: ObservableIntegerValue): LongBinding =
    Bindings.longValueAt(this, index)

fun ObservableList<Long>.getBinding(index: ObservableNumberValue): LongBinding =
    Bindings.longValueAt(this, index)

fun ObservableList<String>.getBinding(index: Int): StringBinding =
    Bindings.stringValueAt(this, index)

fun ObservableList<String>.getBinding(index: ObservableIntegerValue): StringBinding =
    Bindings.stringValueAt(this, index)

fun ObservableList<String>.getBinding(index: ObservableNumberValue): StringBinding =
    Bindings.stringValueAt(this, index)

inline fun <E> ObservableList<E>.forEachBinding(action: (value: Binding<E>) -> Unit) {
    for (index in 0 until size) {
        action(getBinding(index))
    }
}

inline fun <E> ObservableList<E>.forEachBindingIndexed(action: (index: Int, value: Binding<E>) -> Unit) {
    for (index in 0 until size) {
        action(index, getBinding(index))
    }
}
