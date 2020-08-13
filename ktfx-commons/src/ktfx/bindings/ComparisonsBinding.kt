@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.NumberBinding
import javafx.beans.value.ObservableNumberValue

/** @see kotlin.comparisons.maxOf */
inline fun maxOf(a: ObservableNumberValue, b: ObservableNumberValue): NumberBinding = Bindings.max(a, b)

/** @see kotlin.comparisons.maxOf */
inline fun maxOf(a: ObservableNumberValue, b: Double): DoubleBinding = Bindings.max(a, b)

/** @see kotlin.comparisons.maxOf */
inline fun maxOf(a: Double, b: ObservableNumberValue): DoubleBinding = Bindings.max(a, b)

/** @see kotlin.comparisons.maxOf */
inline fun maxOf(a: ObservableNumberValue, b: Float): NumberBinding = Bindings.max(a, b)

/** @see kotlin.comparisons.maxOf */
inline fun maxOf(a: Float, b: ObservableNumberValue): NumberBinding = Bindings.max(a, b)

/** @see kotlin.comparisons.maxOf */
inline fun maxOf(a: ObservableNumberValue, b: Long): NumberBinding = Bindings.max(a, b)

/** @see kotlin.comparisons.maxOf */
inline fun maxOf(a: Long, b: ObservableNumberValue): NumberBinding = Bindings.max(a, b)

/** @see kotlin.comparisons.maxOf */
inline fun maxOf(a: ObservableNumberValue, b: Int): NumberBinding = Bindings.max(a, b)

/** @see kotlin.comparisons.maxOf */
inline fun maxOf(a: Int, b: ObservableNumberValue): NumberBinding = Bindings.max(a, b)

/** @see kotlin.comparisons.minOf */
inline fun minOf(a: ObservableNumberValue, b: ObservableNumberValue): NumberBinding = Bindings.min(a, b)

/** @see kotlin.comparisons.minOf */
inline fun minOf(a: ObservableNumberValue, b: Double): DoubleBinding = Bindings.min(a, b)

/** @see kotlin.comparisons.minOf */
inline fun minOf(a: Double, b: ObservableNumberValue): DoubleBinding = Bindings.min(a, b)

/** @see kotlin.comparisons.minOf */
inline fun minOf(a: ObservableNumberValue, b: Float): NumberBinding = Bindings.min(a, b)

/** @see kotlin.comparisons.minOf */
inline fun minOf(a: Float, b: ObservableNumberValue): NumberBinding = Bindings.min(a, b)

/** @see kotlin.comparisons.minOf */
inline fun minOf(a: ObservableNumberValue, b: Long): NumberBinding = Bindings.min(a, b)

/** @see kotlin.comparisons.minOf */
inline fun minOf(a: Long, b: ObservableNumberValue): NumberBinding = Bindings.min(a, b)

/** @see kotlin.comparisons.minOf */
inline fun minOf(a: ObservableNumberValue, b: Int): NumberBinding = Bindings.min(a, b)

/** @see kotlin.comparisons.minOf */
inline fun minOf(a: Int, b: ObservableNumberValue): NumberBinding = Bindings.min(a, b)
