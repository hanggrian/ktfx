@file:JvmMultifileClass
@file:JvmName("JfoenixCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import kotlin.OptIn
import kotlin.Suppress
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/**
 * @see JFXAutoCompletePopup.setSelectionHandler
 */
public fun <T> JFXAutoCompletePopup<T>.selectionHandler(context: CoroutineContext =
        Dispatchers.JavaFx, action: suspend CoroutineScope.(JFXAutoCompleteEvent<T>) -> Unit): Unit
        = setSelectionHandler { event -> GlobalScope.launch(context) { action(event) } }
