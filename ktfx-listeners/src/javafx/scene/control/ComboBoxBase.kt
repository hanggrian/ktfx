@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBoxBase

/** The ComboBox action, which is invoked whenever the [ComboBoxBase.valueProperty] property is changed. */
inline fun ComboBoxBase<*>.onAction(
    noinline action: (ActionEvent) -> Unit
): Unit = setOnAction { event -> action(event) }

/** Called just prior to the [ComboBoxBase] popup/display being shown. */
inline fun ComboBoxBase<*>.onShowing(
    noinline action: (Event) -> Unit
): Unit = setOnShowing { event -> action(event) }

/** Called just after the [ComboBoxBase] popup/display is shown. */
inline fun ComboBoxBase<*>.onShown(
    noinline action: (Event) -> Unit
): Unit = setOnShown { event -> action(event) }

/** Called just after the [ComboBoxBase] popup/display is shown. */
inline fun ComboBoxBase<*>.onHiding(
    noinline action: (Event) -> Unit
): Unit = setOnHiding { event -> action(event) }

/** Called just after the [ComboBoxBase] popup/display has been hidden. */
inline fun ComboBoxBase<*>.onHidden(
    noinline action: (Event) -> Unit
): Unit = setOnHidden { event -> action(event) }