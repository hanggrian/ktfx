@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.bindings

import javafx.beans.binding.Bindings.*
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.collections.ObservableSet

inline fun <E> ObservableSet<E>.bindContentBidirectional(other: ObservableSet<E>) = bindContentBidirectional(this, other)

inline fun <E> ObservableSet<E>.unbindContentBidirectional(other: ObservableSet<E>) = unbindContentBidirectional(this, other)

inline fun <E> Set<E>.bindContent(other: ObservableSet<E>) = bindContent(this, other)

inline fun <E> Set<E>.unbindContent(other: ObservableSet<E>) = unbindContent(this, other)

inline val <E> ObservableSet<E>.size2: IntegerBinding get() = size(this)

inline val <E> ObservableSet<E>.isEmpty: BooleanBinding get() = isEmpty(this)

inline val <E> ObservableSet<E>.isNotEmpty: BooleanBinding get() = isNotEmpty(this)