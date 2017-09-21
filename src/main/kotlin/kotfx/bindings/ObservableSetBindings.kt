@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.collections.ObservableSet

inline fun <E> ObservableSet<E>.bindContentBidirectional(other: ObservableSet<E>) = Bindings.bindContentBidirectional(this, other)

inline fun <E> ObservableSet<E>.unbindContentBidirectional(other: ObservableSet<E>) = Bindings.unbindContentBidirectional(this, other)

inline fun <E> Set<E>.bindContent(other: ObservableSet<E>) = Bindings.bindContent(this, other)

inline fun <E> Set<E>.unbindContent(other: ObservableSet<E>) = Bindings.unbindContent(this, other)

inline val <E> ObservableSet<E>.size2: IntegerBinding get() = Bindings.size(this)

inline val <E> ObservableSet<E>.isEmpty: BooleanBinding get() = Bindings.isEmpty(this)

inline val <E> ObservableSet<E>.isNotEmpty: BooleanBinding get() = Bindings.isNotEmpty(this)