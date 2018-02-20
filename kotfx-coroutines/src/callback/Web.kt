@file:JvmMultifileClass
@file:JvmName("CallbacksKt")

package kotfx.coroutines

import javafx.scene.web.PopupFeatures
import javafx.scene.web.PromptData
import javafx.scene.web.WebEngine
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext

fun WebEngine.confirmHadler(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(String) -> Boolean
) = setConfirmHandler { param -> runBlocking(context) { action(param) } }

fun WebEngine.createPopupHandler(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(PopupFeatures) -> WebEngine
) = setCreatePopupHandler { param -> runBlocking(context) { action(param) } }

fun WebEngine.promptHandler(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(PromptData) -> String
) = setPromptHandler { param -> runBlocking(context) { action(param) } }