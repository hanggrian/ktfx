@file:JvmName("SelectionModelsKt")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.kotfx

import javafx.scene.control.SelectionModel

inline val <T> SelectionModel<T>.isSelected: Boolean get() = selectedIndex >= 0

inline val <T> SelectionModel<T>.isNotSelected: Boolean get() = selectedIndex < 0