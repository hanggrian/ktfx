@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Dialog

open class _Dialog<R> : Dialog<R>(), NodeInvokable {

    override fun <R : Node> R.invoke(): R = also {
        when (null) {
            dialogPane.content -> dialogPane.content = it
            dialogPane.expandableContent -> dialogPane.expandableContent = it
            else -> error("Dialogs may only have content and expandable content.")
        }
    }
}

fun <R> dialog(
    init: (_Dialog<R>.() -> Unit)? = null
): Dialog<R> = _Dialog<R>().also { init?.invoke(it) }