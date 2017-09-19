@file:JvmMultifileClass
@file:JvmName("BindingsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.bindings

import javafx.beans.binding.Bindings
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet

/** Bind content of observable list bidirectionally to observable list. */
inline fun <E> ObservableList<E>.bindBidirectional(other: ObservableList<E>) = Bindings.bindContentBidirectional(this, other)

/** Bind content of observable set bidirectionally to observable set. */
inline fun <E> ObservableSet<E>.bindBidirectional(other: ObservableSet<E>) = Bindings.bindContentBidirectional(this, other)

/** Bind content of observable map bidirectionally to observable map. */
inline fun <K, V> ObservableMap<K, V>.bindBidirectional(other: ObservableMap<K, V>) = Bindings.bindContentBidirectional(this, other)

/** Unbind content of observable list bidirectionally to observable list. */
inline fun <E> ObservableList<E>.unbindBidirectional(other: ObservableList<E>) = Bindings.unbindContentBidirectional(this, other)

/** Unbind content of observable set bidirectionally to observable set. */
inline fun <E> ObservableSet<E>.unbindBidirectional(other: ObservableSet<E>) = Bindings.unbindContentBidirectional(this, other)

/** Unbind content of observable map bidirectionally to observable map. */
inline fun <K, V> ObservableMap<K, V>.unbindBidirectional(other: ObservableMap<K, V>) = Bindings.unbindContentBidirectional(this, other)

/** Bind content of list to observable list. */
inline fun <E> List<E>.bind(other: ObservableList<E>) = Bindings.bindContent(this, other)

/** Bind content of set to observable set. */
inline fun <E> Set<E>.bind(other: ObservableSet<E>) = Bindings.bindContent(this, other)

/** Bind content of map to observable map. */
inline fun <K, V> Map<K, V>.bind(other: ObservableMap<K, V>) = Bindings.bindContent(this, other)

/** Unbind content of list to observable list. */
inline fun <E> List<E>.unbind(other: ObservableList<E>) = Bindings.unbindContent(this, other)

/** Unbind content of set to observable set. */
inline fun <E> Set<E>.unbind(other: ObservableSet<E>) = Bindings.unbindContent(this, other)

/** Unbind content of map to observable map. */
inline fun <K, V> Map<K, V>.unbind(other: ObservableMap<K, V>) = Bindings.unbindContent(this, other)