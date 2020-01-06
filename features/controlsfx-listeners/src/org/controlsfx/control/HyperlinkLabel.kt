@file:JvmMultifileClass
@file:JvmName("ControlsFxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.listeners

import javafx.event.ActionEvent
import org.controlsfx.control.HyperlinkLabel

/** Sets a new EventHandler which will be invoked whenever a hyperlink is fired. */
inline fun HyperlinkLabel.onAction(
    noinline action: (ActionEvent) -> Unit
): Unit = setOnAction { event -> action(event) }
