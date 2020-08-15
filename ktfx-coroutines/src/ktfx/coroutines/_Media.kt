@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.media.Media
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Media.setOnError
 */
fun Media.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
) {
    return setOnError { GlobalScope.launch(context) { action() } }
}
