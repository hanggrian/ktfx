@file:JvmMultifileClass
@file:JvmName("CollectionsBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

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
import javafx.collections.ObservableList

/** Generates a bidirectional binding between two instances of [ObservableList]. */
public inline fun <E> ObservableList<E>.bindContentBidirectional(other: ObservableList<E>): Unit =
    Bindings.bindContentBidirectional(this, other)

/** Remove a bidirectional binding between two instances of [ObservableList]. */
public inline fun <E> ObservableList<E>.unbindContentBidirectional(other: ObservableList<E>): Unit =
    Bindings.unbindContentBidirectional(this, other)

/** Generates a bidirectional binding between an [ObservableList] and a [List]. */
public inline fun <E> List<E>.bindContent(other: ObservableList<E>): Unit =
    Bindings.bindContent(this, other)

/** Remove a bidirectional binding between an [ObservableList] and a [List]. */
public inline fun <E> List<E>.unbindContent(other: ObservableList<E>): Unit =
    Bindings.unbindContent(this, other)

/** Creates a new [IntegerBinding] that contains the size [ObservableList]. */
public inline val <E> ObservableList<E>.sizeBinding: IntegerBinding get() = Bindings.size(this)

/** Creates a new [BooleanBinding] that holds `true` if a given [ObservableList] is empty. */
public inline val <E> ObservableList<E>.emptyBinding: BooleanBinding get() = Bindings.isEmpty(this)

/** Creates a new [BooleanBinding] that holds `true` if a given [ObservableList] is not empty. */
public inline val <E> ObservableList<E>.notEmptyBinding: BooleanBinding
    get() = Bindings.isNotEmpty(this)

/**
 * Creates a new [ObjectBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun <E> ObservableList<E>.getBinding(index: Int): ObjectBinding<E> =
    Bindings.valueAt(this, index)

/**
 * Creates a new [ObjectBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun <E> ObservableList<E>.getBinding(index: ObservableNumberValue): ObjectBinding<E> =
    Bindings.valueAt(this, index)

/**
 * Creates a new [ObjectBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun <E> ObservableList<E>.getBinding(
    index: ObservableIntegerValue,
): ObjectBinding<E> = Bindings.valueAt(this, index)

/**
 * Creates a new [BooleanBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Boolean>.getBinding(index: Int): BooleanBinding =
    Bindings.booleanValueAt(this, index)

/**
 * Creates a new [BooleanBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Boolean>.getBinding(index: ObservableNumberValue): BooleanBinding =
    Bindings.booleanValueAt(this, index)

/**
 * Creates a new [BooleanBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Boolean>.getBinding(
    index: ObservableIntegerValue,
): BooleanBinding = Bindings.booleanValueAt(this, index)

/**
 * Creates a new [DoubleBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Double>.getBinding(index: Int): DoubleBinding =
    Bindings.doubleValueAt(this, index)

/**
 * Creates a new [DoubleBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Double>.getBinding(index: ObservableNumberValue): DoubleBinding =
    Bindings.doubleValueAt(this, index)

/**
 * Creates a new [DoubleBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Double>.getBinding(index: ObservableIntegerValue): DoubleBinding =
    Bindings.doubleValueAt(this, index)

/**
 * Creates a new [FloatBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Float>.getBinding(index: Int): FloatBinding =
    Bindings.floatValueAt(this, index)

/**
 * Creates a new [FloatBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Float>.getBinding(index: ObservableNumberValue): FloatBinding =
    Bindings.floatValueAt(this, index)

/**
 * Creates a new [FloatBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Float>.getBinding(index: ObservableIntegerValue): FloatBinding =
    Bindings.floatValueAt(this, index)

/**
 * Creates a new [IntegerBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Int>.getBinding(index: Int): IntegerBinding =
    Bindings.integerValueAt(this, index)

/**
 * Creates a new [IntegerBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Int>.getBinding(index: ObservableNumberValue): IntegerBinding =
    Bindings.integerValueAt(this, index)

/**
 * Creates a new [IntegerBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Int>.getBinding(index: ObservableIntegerValue): IntegerBinding =
    Bindings.integerValueAt(this, index)

/**
 * Creates a new [LongBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Long>.getBinding(index: Int): LongBinding =
    Bindings.longValueAt(this, index)

/**
 * Creates a new [LongBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Long>.getBinding(index: ObservableNumberValue): LongBinding =
    Bindings.longValueAt(this, index)

/**
 * Creates a new [LongBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<Long>.getBinding(index: ObservableIntegerValue): LongBinding =
    Bindings.longValueAt(this, index)

/**
 * Creates a new [StringBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<String>.getBinding(index: Int): StringBinding =
    Bindings.stringValueAt(this, index)

/**
 * Creates a new [StringBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<String>.getBinding(index: ObservableNumberValue): StringBinding =
    Bindings.stringValueAt(this, index)

/**
 * Creates a new [StringBinding] that contains the element of an [ObservableList] at the specified
 * position.
 */
public inline fun ObservableList<String>.getBinding(index: ObservableIntegerValue): StringBinding =
    Bindings.stringValueAt(this, index)
