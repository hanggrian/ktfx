package kotfx.bindings

import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.IntegerExpression
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.ObjectExpression
import javafx.beans.binding.When.ObjectConditionBuilder

typealias AnyBinding<T> = ObjectBinding<T>
typealias AnyExpression<T> = ObjectExpression<T>

typealias IntBinding = IntegerBinding
typealias IntExpression = IntegerExpression

typealias AnyConditionBuilder<T> = ObjectConditionBuilder<T>