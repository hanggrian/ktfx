@file:JvmMultifileClass
@file:JvmName("ControlsfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.controlsfx.listeners

import javafx.event.ActionEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import org.controlsfx.control.HyperlinkLabel

/**
 * @see HyperlinkLabel.setOnAction
 */
public inline fun HyperlinkLabel.onAction(noinline action: (ActionEvent) -> Unit): Unit =
        setOnAction(action)
