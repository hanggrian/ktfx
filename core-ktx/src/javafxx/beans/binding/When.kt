@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.binding

import javafx.beans.binding.Bindings.`when`
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.NumberBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding
import javafx.beans.binding.When
import javafx.beans.binding.When.BooleanConditionBuilder
import javafx.beans.binding.When.NumberConditionBuilder
import javafx.beans.binding.When.ObjectConditionBuilder
import javafx.beans.binding.When.StringConditionBuilder
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableNumberValue
import javafx.beans.value.ObservableObjectValue
import javafx.beans.value.ObservableStringValue

/** Start a conditional if else binding. */
inline fun `when`(condition: ObservableBooleanValue): When = `when`(condition)

inline infix fun When.then(value: ObservableNumberValue): NumberConditionBuilder = then(value)
inline infix fun When.then(value: Double): NumberConditionBuilder = then(value)
inline infix fun When.then(value: Float): NumberConditionBuilder = then(value)
inline infix fun When.then(value: Long): NumberConditionBuilder = then(value)
inline infix fun When.then(value: Int): NumberConditionBuilder = then(value)

inline infix fun NumberConditionBuilder.otherwise(value: ObservableNumberValue): NumberBinding = otherwise(value)
inline infix fun NumberConditionBuilder.otherwise(value: Double): DoubleBinding = otherwise(value)
inline infix fun NumberConditionBuilder.otherwise(value: Float): NumberBinding = otherwise(value)
inline infix fun NumberConditionBuilder.otherwise(value: Long): NumberBinding = otherwise(value)
inline infix fun NumberConditionBuilder.otherwise(value: Int): NumberBinding = otherwise(value)

inline infix fun When.then(value: ObservableBooleanValue): BooleanConditionBuilder = then(value)
inline infix fun When.then(value: Boolean): BooleanConditionBuilder = then(value)

inline infix fun BooleanConditionBuilder.otherwise(value: ObservableBooleanValue): BooleanBinding = otherwise(value)
inline infix fun BooleanConditionBuilder.otherwise(value: Boolean): BooleanBinding = otherwise(value)

inline infix fun When.then(value: ObservableStringValue): StringConditionBuilder = then(value)
inline infix fun When.then(value: String): StringConditionBuilder = then(value)

inline infix fun StringConditionBuilder.otherwise(value: ObservableStringValue): StringBinding = otherwise(value)
inline infix fun StringConditionBuilder.otherwise(value: String): StringBinding = otherwise(value)

inline infix fun <T> When.then(value: ObservableObjectValue<T>): ObjectConditionBuilder<T> = then(value)
inline infix fun <T> When.then(value: T?): ObjectConditionBuilder<T> = then(value)

inline infix fun <T> ObjectConditionBuilder<T>.otherwise(value: ObservableObjectValue<T>): ObjectBinding<T> = otherwise(value)
inline infix fun <T> ObjectConditionBuilder<T>.otherwise(value: T?): ObjectBinding<T> = otherwise(value)