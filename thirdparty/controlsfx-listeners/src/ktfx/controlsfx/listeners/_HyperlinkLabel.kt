@file:JvmMultifileClass
@file:JvmName("ControlsFxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.listeners

import javafx.event.ActionEvent
import org.controlsfx.control.HyperlinkLabel
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see HyperlinkLabel.setOnAction
 */
public inline fun HyperlinkLabel.onAction(noinline action: (ActionEvent) -> Unit) {
    return setOnAction(action)
}
