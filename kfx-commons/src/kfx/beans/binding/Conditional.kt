@file:Suppress("NOTHING_TO_INLINE")

package kfx.beans.binding

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

inline fun `if`(condition: ObservableBooleanValue): When = `when`(condition)

inline infix fun When.then(thenValue: ObservableNumberValue): NumberConditionBuilder = then(thenValue)
inline infix fun When.then(thenValue: Double): NumberConditionBuilder = then(thenValue)
inline infix fun When.then(thenValue: Float): NumberConditionBuilder = then(thenValue)
inline infix fun When.then(thenValue: Long): NumberConditionBuilder = then(thenValue)
inline infix fun When.then(thenValue: Int): NumberConditionBuilder = then(thenValue)

inline infix fun NumberConditionBuilder.`else`(otherwiseValue: ObservableNumberValue): NumberBinding = otherwise(otherwiseValue)
inline infix fun NumberConditionBuilder.`else`(otherwiseValue: Double): DoubleBinding = otherwise(otherwiseValue)
inline infix fun NumberConditionBuilder.`else`(otherwiseValue: Float): NumberBinding = otherwise(otherwiseValue)
inline infix fun NumberConditionBuilder.`else`(otherwiseValue: Long): NumberBinding = otherwise(otherwiseValue)
inline infix fun NumberConditionBuilder.`else`(otherwiseValue: Int): NumberBinding = otherwise(otherwiseValue)

inline infix fun When.then(thenValue: ObservableBooleanValue): BooleanConditionBuilder = then(thenValue)
inline infix fun When.then(thenValue: Boolean): BooleanConditionBuilder = then(thenValue)

inline infix fun BooleanConditionBuilder.`else`(otherwiseValue: ObservableBooleanValue): BooleanBinding = otherwise(otherwiseValue)
inline infix fun BooleanConditionBuilder.`else`(otherwiseValue: Boolean): BooleanBinding = otherwise(otherwiseValue)

inline infix fun When.then(thenValue: ObservableStringValue): StringConditionBuilder = then(thenValue)
inline infix fun When.then(thenValue: String): StringConditionBuilder = then(thenValue)

inline infix fun StringConditionBuilder.`else`(otherwiseValue: ObservableStringValue): StringBinding = otherwise(otherwiseValue)
inline infix fun StringConditionBuilder.`else`(otherwiseValue: String): StringBinding = otherwise(otherwiseValue)

inline infix fun <T> When.then(thenValue: ObservableObjectValue<T>): ObjectConditionBuilder<T> = then(thenValue)
inline infix fun <T> When.then(thenValue: T?): ObjectConditionBuilder<T> = then(thenValue)

inline infix fun <T> ObjectConditionBuilder<T>.`else`(otherwiseValue: ObservableObjectValue<T>): ObjectBinding<T> = otherwise(otherwiseValue)
inline infix fun <T> ObjectConditionBuilder<T>.`else`(otherwiseValue: T?): ObjectBinding<T> = otherwise(otherwiseValue)