@file:JvmMultifileClass
@file:JvmName("ControlsfxCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.controlsfx.coroutines

import javafx.event.ActionEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.HyperlinkLabel

/**
 * @see HyperlinkLabel.setOnAction
 */
public fun HyperlinkLabel.onAction(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ActionEvent) -> Unit): Unit = setOnAction { event ->
        GlobalScope.launch(context) { action(event) } }
