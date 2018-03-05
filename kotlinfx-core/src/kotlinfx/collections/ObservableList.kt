@file:Suppress("NOTHING_TO_INLINE")

package kotlinfx.collections

import javafx.beans.binding.Binding
import javafx.beans.binding.Bindings.bindContent
import javafx.beans.binding.Bindings.bindContentBidirectional
import javafx.beans.binding.Bindings.booleanValueAt
import javafx.beans.binding.Bindings.doubleValueAt
import javafx.beans.binding.Bindings.floatValueAt
import javafx.beans.binding.Bindings.integerValueAt
import javafx.beans.binding.Bindings.isEmpty
import javafx.beans.binding.Bindings.isNotEmpty
import javafx.beans.binding.Bindings.longValueAt
import javafx.beans.binding.Bindings.size
import javafx.beans.binding.Bindings.stringValueAt
import javafx.beans.binding.Bindings.unbindContent
import javafx.beans.binding.Bindings.unbindContentBidirectional
import javafx.beans.binding.Bindings.valueAt
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
import javafx.collections.FXCollections.copy
import javafx.collections.FXCollections.fill
import javafx.collections.FXCollections.observableArrayList
import javafx.collections.FXCollections.observableSet
import javafx.collections.FXCollections.replaceAll
import javafx.collections.FXCollections.reverse
import javafx.collections.FXCollections.rotate
import javafx.collections.FXCollections.shuffle
import javafx.collections.FXCollections.singletonObservableList
import javafx.collections.FXCollections.sort
import javafx.collections.FXCollections.unmodifiableObservableList
import javafx.collections.FXCollections.unmodifiableObservableSet
import javafx.collections.ObservableList
import javafx.collections.ObservableSet
import java.util.Comparator
import java.util.LinkedHashSet
import java.util.Random

/** Returns an empty immutable [ObservableList]. */
inline fun <T> emptyObservableList(): ObservableList<T> = FXCollections.emptyObservableList()

/** Returns an empty immutable [ObservableList]. */
inline fun <T> observableListOf(): ObservableList<T> = emptyObservableList()

/** Returns an immutable [ObservableList] of one [element]. */
inline fun <T> observableListOf(element: T): ObservableList<T> = singletonObservableList(element)

/** Returns an immutable [ObservableList] containing all [elements]. */
inline fun <T> observableListOf(vararg elements: T): ObservableList<T> = elements.toObservableList()

/** Returns an empty [ObservableList]. */
inline fun <T> mutableObservableListOf(): ObservableList<T> = observableArrayList()

/** Returns an [ObservableList] containing all [elements]. */
inline fun <T> mutableObservableListOf(vararg elements: T): ObservableList<T> = elements.toMutableObservableList()

/** Converts this collection to immutable [ObservableList]. */
inline fun <T> Iterable<T>.toObservableList(): ObservableList<T> = unmodifiableObservableList(toMutableObservableList())

/** Converts this collection to [ObservableList]. */
fun <T> Iterable<T>.toMutableObservableList(): ObservableList<T> = observableArrayList(this as? Collection
    ?: toCollection(ArrayList()))

/** Converts this collection to immutable [ObservableSet]. */
inline fun <T> Iterable<T>.toObservableSet(): ObservableSet<T> = unmodifiableObservableSet(toMutableObservableSet())

/** Converts this collection to [ObservableSet]. */
fun <T> Iterable<T>.toMutableObservableSet(): ObservableSet<T> = observableSet(this as? Set
    ?: toCollection(LinkedHashSet()))

/** Copies elements from src to list, firing change notification once. */
inline fun <T> ObservableList<T>.copy(src: List<T>) = copy(this, src)

/** Fills the list with obj, firing change notification once. */
inline fun <T> ObservableList<T>.fill(obj: T) = fill(this, obj)

/** Replace all oldVal elements in the list with newVal element, firing change notification once. */
inline fun <T> ObservableList<T>.replaceAll(oldVal: T, newVal: T): Boolean = replaceAll(this, oldVal, newVal)

/** Reverse the order in the list, firing change notification once. */
inline fun ObservableList<*>.reverse() = reverse(this)

/** Rotates the list by distance, firing change notification once. */
inline fun ObservableList<*>.rotate(distance: Int) = rotate(this, distance)

/** Shuffles all elements in the observable list, firing change notification once. */
inline fun ObservableList<*>.shuffle(rnd: Random? = null) = if (rnd == null) shuffle(this) else shuffle(this, rnd)

/** Sorts the provided observable list, firing change notification once. */
inline fun <T : Comparable<T>> ObservableList<T>.sort() = sort(this)

/** Sorts the provided observable list using the c comparator, firing change notification once. */
inline infix fun <T> ObservableList<T>.sort(c: Comparator<T>) = sort(this, c)

inline fun <E> ObservableList<E>.bindContentBidirectional(other: ObservableList<E>) = bindContentBidirectional(this, other)

inline fun <E> ObservableList<E>.unbindContentBidirectional(other: ObservableList<E>) = unbindContentBidirectional(this, other)

inline fun <E> List<E>.bindContent(other: ObservableList<E>) = bindContent(this, other)

inline fun <E> List<E>.unbindContent(other: ObservableList<E>) = unbindContent(this, other)

inline fun <E> ObservableList<E>.sizeBinding(): IntegerBinding = size(this)

inline fun <E> ObservableList<E>.emptyBinding(): BooleanBinding = isEmpty(this)

inline fun <E> ObservableList<E>.notEmptyBinding(): BooleanBinding = isNotEmpty(this)

inline fun <E> ObservableList<E>.getBinding(index: Int): ObjectBinding<E> = valueAt(this, index)
inline fun <E> ObservableList<E>.getBinding(index: ObservableIntegerValue): ObjectBinding<E> = valueAt(this, index)
inline fun <E> ObservableList<E>.getBinding(index: ObservableNumberValue): ObjectBinding<E> = valueAt(this, index)

inline fun ObservableList<Boolean>.getBinding(index: Int): BooleanBinding = booleanValueAt(this, index)
inline fun ObservableList<Boolean>.getBinding(index: ObservableIntegerValue): BooleanBinding = booleanValueAt(this, index)
inline fun ObservableList<Boolean>.getBinding(index: ObservableNumberValue): BooleanBinding = booleanValueAt(this, index)

inline fun ObservableList<Double>.getBinding(index: Int): DoubleBinding = doubleValueAt(this, index)
inline fun ObservableList<Double>.getBinding(index: ObservableIntegerValue): DoubleBinding = doubleValueAt(this, index)
inline fun ObservableList<Double>.getBinding(index: ObservableNumberValue): DoubleBinding = doubleValueAt(this, index)

inline fun ObservableList<Float>.getBinding(index: Int): FloatBinding = floatValueAt(this, index)
inline fun ObservableList<Float>.getBinding(index: ObservableIntegerValue): FloatBinding = floatValueAt(this, index)
inline fun ObservableList<Float>.getBinding(index: ObservableNumberValue): FloatBinding = floatValueAt(this, index)

inline fun ObservableList<Int>.getBinding(index: Int): IntegerBinding = integerValueAt(this, index)
inline fun ObservableList<Int>.getBinding(index: ObservableIntegerValue): IntegerBinding = integerValueAt(this, index)
inline fun ObservableList<Int>.getBinding(index: ObservableNumberValue): IntegerBinding = integerValueAt(this, index)

inline fun ObservableList<Long>.getBinding(index: Int): LongBinding = longValueAt(this, index)
inline fun ObservableList<Long>.getBinding(index: ObservableIntegerValue): LongBinding = longValueAt(this, index)
inline fun ObservableList<Long>.getBinding(index: ObservableNumberValue): LongBinding = longValueAt(this, index)

inline fun ObservableList<String>.getBinding(index: Int): StringBinding = stringValueAt(this, index)
inline fun ObservableList<String>.getBinding(index: ObservableIntegerValue): StringBinding = stringValueAt(this, index)
inline fun ObservableList<String>.getBinding(index: ObservableNumberValue): StringBinding = stringValueAt(this, index)

inline fun <E> ObservableList<E>.forEachBinding(action: (value: Binding<E>) -> Unit) {
    for (index in 0 until size) action(getBinding(index))
}

inline fun <E> ObservableList<E>.forEachBindingIndexed(action: (index: Int, value: Binding<E>) -> Unit) {
    for (index in 0 until size) action(index, getBinding(index))
}