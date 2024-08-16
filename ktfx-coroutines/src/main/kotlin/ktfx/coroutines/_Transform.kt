@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.scene.transform.Transform
import javafx.scene.transform.TransformChangedEvent
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
 * @see Transform.setOnTransformChanged
 */
public fun Transform.onTransformChanged(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(TransformChangedEvent) -> Unit): Unit =
        setOnTransformChanged { event -> GlobalScope.launch(context) { action(event) } }
