@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.Bindings.`when`
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.NumberBinding
import javafx.beans.binding.StringBinding
import javafx.beans.binding.When
import javafx.beans.binding.When.BooleanConditionBuilder
import javafx.beans.binding.When.NumberConditionBuilder
import javafx.beans.binding.When.StringConditionBuilder
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableNumberValue
import javafx.beans.value.ObservableStringValue
import kotfx.properties.ObservableAnyValue

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

inline infix fun <T> When.then(thenValue: ObservableAnyValue<T>): AnyConditionBuilder<T> = then(thenValue)
inline infix fun <T> When.then(thenValue: T?): AnyConditionBuilder<T> = then(thenValue)

inline infix fun <T> AnyConditionBuilder<T>.`else`(otherwiseValue: ObservableAnyValue<T>): AnyBinding<T> = otherwise(otherwiseValue)
inline infix fun <T> AnyConditionBuilder<T>.`else`(otherwiseValue: T?): AnyBinding<T> = otherwise(otherwiseValue)