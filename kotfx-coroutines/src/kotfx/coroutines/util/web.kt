@file:JvmMultifileClass
@file:JvmName("UtilsKt")

package kotfx.coroutines

import javafx.scene.web.PopupFeatures
import javafx.scene.web.PromptData
import javafx.scene.web.WebEngine
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext

fun WebEngine.confirmHandler(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(String) -> Boolean
) = setConfirmHandler { param -> runBlocking(context) { callback(param) } }

fun WebEngine.createPopupHandler(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(PopupFeatures) -> WebEngine
) = setCreatePopupHandler { param -> runBlocking(context) { callback(param) } }

fun WebEngine.promptHandler(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(PromptData) -> String
) = setPromptHandler { param -> runBlocking(context) { callback(param) } }