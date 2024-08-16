@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.scene.control.ButtonBase
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
 * @see ButtonBase.setOnAction
 */
public fun ButtonBase.onAction(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ActionEvent) -> Unit): Unit = setOnAction { event ->
        GlobalScope.launch(context) { action(event) } }
