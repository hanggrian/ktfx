@file:JvmMultifileClass
@file:JvmName("CollectionsBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.collections.ObservableSet

/** Generates a bidirectional binding between two instances of [ObservableSet]. */
inline fun <E> ObservableSet<E>.bindContentBidirectional(other: ObservableSet<E>): Unit =
    Bindings.bindContentBidirectional(this, other)

/** Remove a bidirectional binding between two instances of [ObservableSet]. */
inline fun <E> ObservableSet<E>.unbindContentBidirectional(other: ObservableSet<E>): Unit =
    Bindings.unbindContentBidirectional(this, other)

/** Generates a bidirectional binding between an [ObservableSet] and a [Set]. */
inline fun <E> Set<E>.bindContent(other: ObservableSet<E>): Unit = Bindings.bindContent(this, other)

/** Remove a bidirectional binding between an [ObservableSet] and a [Set]. */
inline fun <E> Set<E>.unbindContent(other: ObservableSet<E>): Unit =
    Bindings.unbindContent(this, other)

/** Creates a new [IntegerBinding] that contains the size [ObservableSet]. */
inline val <E> ObservableSet<E>.sizeBinding: IntegerBinding get() = Bindings.size(this)

/** Creates a new [BooleanBinding] that holds `true` if a given [ObservableSet] is empty. */
inline val <E> ObservableSet<E>.emptyBinding: BooleanBinding get() = Bindings.isEmpty(this)

/** Creates a new [BooleanBinding] that holds `true` if a given [ObservableSet] is not empty. */
inline val <E> ObservableSet<E>.notEmptyBinding: BooleanBinding get() = Bindings.isNotEmpty(this)
