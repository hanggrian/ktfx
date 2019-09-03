@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.NumberBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.beans.binding.When
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableNumberValue
import javafx.beans.value.ObservableObjectValue
import javafx.beans.value.ObservableStringValue

/** Opens up conditional binding. */
inline fun conditional(condition: ObservableBooleanValue): When =
    Bindings.`when`(condition)

/** Public alias for infix typing. */
inline infix fun When.then(value: ObservableNumberValue): When.NumberConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: Double): When.NumberConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: Float): When.NumberConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: Long): When.NumberConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: Int): When.NumberConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.NumberConditionBuilder.otherwise(value: ObservableNumberValue): NumberBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.NumberConditionBuilder.otherwise(value: Double): DoubleBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.NumberConditionBuilder.otherwise(value: Float): NumberBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.NumberConditionBuilder.otherwise(value: Long): NumberBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.NumberConditionBuilder.otherwise(value: Int): NumberBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: ObservableBooleanValue): When.BooleanConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: Boolean): When.BooleanConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.BooleanConditionBuilder.otherwise(value: ObservableBooleanValue): BooleanBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.BooleanConditionBuilder.otherwise(value: Boolean): BooleanBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: ObservableStringValue): When.StringConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.then(value: String): When.StringConditionBuilder =
    then(value)

/** Public alias for infix typing. */
inline infix fun When.StringConditionBuilder.otherwise(value: ObservableStringValue): StringBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun When.StringConditionBuilder.otherwise(value: String): StringBinding =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun <T> When.then(value: ObservableObjectValue<T>): When.ObjectConditionBuilder<T> =
    then(value)

/** Public alias for infix typing. */
inline infix fun <T> When.then(value: T?): When.ObjectConditionBuilder<T> =
    then(value)

/** Public alias for infix typing. */
inline infix fun <T> When.ObjectConditionBuilder<T>.otherwise(value: ObservableObjectValue<T>): ObjectBinding<T> =
    otherwise(value)

/** Public alias for infix typing. */
inline infix fun <T> When.ObjectConditionBuilder<T>.otherwise(value: T?): ObjectBinding<T> =
    otherwise(value)
