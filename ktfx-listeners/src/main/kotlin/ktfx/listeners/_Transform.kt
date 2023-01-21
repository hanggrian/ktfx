@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.listeners

import javafx.scene.transform.Transform
import javafx.scene.transform.TransformChangedEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Transform.setOnTransformChanged
 */
public inline fun Transform.onTransformChanged(noinline action: (TransformChangedEvent) -> Unit):
        Unit = setOnTransformChanged(action)
