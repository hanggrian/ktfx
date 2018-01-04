@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.beans.binding.Bindings.*
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.collections.ObservableSet

inline infix fun <E> ObservableSet<E>.bindContentBidirectional(other: ObservableSet<E>) = bindContentBidirectional(this, other)

inline infix fun <E> ObservableSet<E>.unbindContentBidirectional(other: ObservableSet<E>) = unbindContentBidirectional(this, other)

inline infix fun <E> Set<E>.bindContent(other: ObservableSet<E>) = bindContent(this, other)

inline infix fun <E> Set<E>.unbindContent(other: ObservableSet<E>) = unbindContent(this, other)

inline val <E> ObservableSet<E>.sizeBinding: IntegerBinding get() = size(this)

inline val <E> ObservableSet<E>.isEmpty: BooleanBinding get() = isEmpty(this)

inline val <E> ObservableSet<E>.isNotEmpty: BooleanBinding get() = isNotEmpty(this)