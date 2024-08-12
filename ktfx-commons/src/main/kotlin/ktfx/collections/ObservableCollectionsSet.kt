@file:JvmMultifileClass
@file:JvmName("ObservableCollectionsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableSet
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Returns an empty read-only [ObservableSet].
 *
 * @see emptySet
 */
inline fun <T> emptyObservableSet(): ObservableSet<T> = FXCollections.emptyObservableSet()

/**
 * Returns a new read-only [ObservableSet] of given elements.
 *
 * @see setOf
 */
fun <T> observableSetOf(vararg elements: T): ObservableSet<T> =
    if (elements.isNotEmpty()) {
        FXCollections.unmodifiableObservableSet(elements.toMutableObservableSet())
    } else {
        emptyObservableSet()
    }

/**
 * Returns an empty read-only [ObservableSet].
 *
 * @see setOf
 */
inline fun <T> observableSetOf(): ObservableSet<T> = emptyObservableSet()

/**
 * Returns an empty [ObservableSet].
 *
 * @see mutableSetOf
 */
inline fun <T> mutableObservableSetOf(): ObservableSet<T> = FXCollections.observableSet()

/**
 * Returns a new [ObservableSet] with the given elements.
 *
 * @see mutableSetOf
 */
fun <T> mutableObservableSetOf(vararg elements: T): ObservableSet<T> =
    if (elements.isEmpty()) mutableObservableSetOf() else FXCollections.observableSet(*elements)

/**
 * Returns a new read-only [ObservableSet] either of single given element, if it is not null, or
 * empty list if the element is null.
 *
 * @see setOfNotNull
 */
fun <T : Any> observableSetOfNotNull(element: T?): ObservableSet<T> =
    if (element != null) observableSetOf(element) else emptyObservableSet()

/**
 * Returns a new read-only [ObservableSet] only of those given elements, that are not null.
 *
 * @see setOfNotNull
 */
fun <T : Any> observableSetOfNotNull(vararg elements: T?): ObservableSet<T> =
    elements.filterNotNullTo(mutableObservableSetOf())

/**
 * Builds a new read-only [ObservableSet] by populating a [MutableSet] using the
 * given [builderAction] and returning a read-only set with the same elements.
 *
 * @see buildSet
 */
@ExperimentalStdlibApi
inline fun <T> buildObservableSet(builderAction: MutableSet<T>.() -> Unit): Set<T> {
    contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
    return buildSet(builderAction).toObservableSet()
}

/**
 * Returns an [ObservableSet] containing all elements.
 *
 * @see Array.toSet
 */
fun <T> Array<out T>.toObservableSet(): ObservableSet<T> =
    when (size) {
        0 -> emptyObservableSet()
        else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
    }

/**
 * Returns an [ObservableSet] of [Byte] containing all elements.
 *
 * @see Array.toSet
 */
fun ByteArray.toObservableSet(): ObservableSet<Byte> =
    when (size) {
        0 -> emptyObservableSet()
        1 -> observableSetOf(this[0])
        else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
    }

/**
 * Returns an [ObservableSet] of [Char] containing all elements.
 *
 * @see Array.toSet
 */
fun CharArray.toObservableSet(): ObservableSet<Char> =
    when (size) {
        0 -> emptyObservableSet()
        1 -> observableSetOf(this[0])
        else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
    }

/**
 * Returns an [ObservableSet] of [Short] containing all elements.
 *
 * @see Array.toSet
 */
fun ShortArray.toObservableSet(): ObservableSet<Short> =
    when (size) {
        0 -> emptyObservableSet()
        1 -> observableSetOf(this[0])
        else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
    }

/**
 * Returns an [ObservableSet] of [Int] containing all elements.
 *
 * @see Array.toSet
 */
fun IntArray.toObservableSet(): ObservableSet<Int> =
    when (size) {
        0 -> emptyObservableSet()
        1 -> observableSetOf(this[0])
        else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
    }

/**
 * Returns an [ObservableSet] of [Long] containing all elements.
 *
 * @see Array.toSet
 */
fun LongArray.toObservableSet(): ObservableSet<Long> =
    when (size) {
        0 -> emptyObservableSet()
        1 -> observableSetOf(this[0])
        else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
    }

/**
 * Returns an [ObservableSet] of [Float] containing all elements.
 *
 * @see Array.toSet
 */
fun FloatArray.toObservableSet(): ObservableSet<Float> =
    when (size) {
        0 -> emptyObservableSet()
        1 -> observableSetOf(this[0])
        else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
    }

/**
 * Returns an [ObservableSet] of [Double] containing all elements.
 *
 * @see Array.toSet
 */
fun DoubleArray.toObservableSet(): ObservableSet<Double> =
    when (size) {
        0 -> emptyObservableSet()
        1 -> observableSetOf(this[0])
        else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
    }

/**
 * Returns an [ObservableSet] of [Boolean] containing all elements.
 *
 * @see Array.toSet
 */
fun BooleanArray.toObservableSet(): ObservableSet<Boolean> =
    when (size) {
        0 -> emptyObservableSet()
        1 -> observableSetOf(this[0])
        else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
    }

/**
 * Returns a new [ObservableSet] filled with all elements of this array.
 *
 * @see Array.toMutableSet
 */
inline fun <T> Array<out T>.toMutableObservableSet(): ObservableSet<T> =
    FXCollections.observableSet(*this)

/**
 * Returns a new [ObservableSet] of [Byte] filled with all elements of this array.
 *
 * @see Array.toMutableSet
 */
inline fun ByteArray.toMutableObservableSet(): ObservableSet<Byte> =
    FXCollections.observableSet(*this.toTypedArray())

/**
 * Returns a new [ObservableSet] of [Char] filled with all elements of this array.
 *
 * @see Array.toMutableSet
 */
inline fun CharArray.toMutableObservableSet(): ObservableSet<Char> =
    FXCollections.observableSet(*this.toTypedArray())

/**
 * Returns a new [ObservableSet] of [Short] filled with all elements of this array.
 *
 * @see Array.toMutableSet
 */
inline fun ShortArray.toMutableObservableSet(): ObservableSet<Short> =
    FXCollections.observableSet(*this.toTypedArray())

/**
 * Returns a new [ObservableSet] of [Int] filled with all elements of this array.
 *
 * @see Array.toMutableSet
 */
inline fun IntArray.toMutableObservableSet(): ObservableSet<Int> =
    FXCollections.observableSet(*this.toTypedArray())

/**
 * Returns a new [ObservableSet] of [Long] filled with all elements of this array.
 *
 * @see Array.toMutableSet
 */
inline fun LongArray.toMutableObservableSet(): ObservableSet<Long> =
    FXCollections.observableSet(*this.toTypedArray())

/**
 * Returns a new [ObservableSet] of [Float] filled with all elements of this array.
 *
 * @see Array.toMutableSet
 */
inline fun FloatArray.toMutableObservableSet(): ObservableSet<Float> =
    FXCollections.observableSet(*this.toTypedArray())

/**
 * Returns a new [ObservableSet] of [Double] filled with all elements of this array.
 *
 * @see Array.toMutableSet
 */
inline fun DoubleArray.toMutableObservableSet(): ObservableSet<Double> =
    FXCollections.observableSet(*this.toTypedArray())

/**
 * Returns a new [ObservableSet] of [Boolean] filled with all elements of this array.
 *
 * @see Array.toMutableSet
 */
inline fun BooleanArray.toMutableObservableSet(): ObservableSet<Boolean> =
    FXCollections.observableSet(*this.toTypedArray())

/**
 * Returns an [ObservableSet] containing all elements.
 *
 * @see Iterable.toSet
 */
fun <T> Iterable<T>.toObservableSet(): ObservableSet<T> {
    if (this is Collection) {
        return when (size) {
            0 -> emptyObservableSet()
            else -> FXCollections.unmodifiableObservableSet(this.toMutableObservableSet())
        }
    }
    return toCollection(FXCollections.observableSet()).optimizeReadOnlySet()
}

/**
 * Returns a new [ObservableSet] filled with all elements of this collection.
 *
 * @see Iterable.toMutableSet
 */
fun <T> Iterable<T>.toMutableObservableSet(): ObservableSet<T> =
    when (this) {
        is Set<T> -> FXCollections.observableSet(this)
        else -> toCollection(FXCollections.observableSet())
    }

/**
 * Returns a [ObservableSet] containing all elements.
 *
 * @see Sequence.toSet
 */
fun <T> Sequence<T>.toObservableSet(): ObservableSet<T> =
    toMutableObservableSet().optimizeReadOnlySet()

/**
 * Returns a new [ObservableSet] filled with all elements of this sequence.
 *
 * @see Sequence.toMutableSet
 */
fun <T> Sequence<T>.toMutableObservableSet(): ObservableSet<T> =
    toCollection(FXCollections.observableSet())
