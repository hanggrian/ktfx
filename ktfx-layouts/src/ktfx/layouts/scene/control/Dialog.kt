@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Dialog
import ktfx.NodeManager

/* ktlint-enable package-name */

open class _Dialog<R> : Dialog<R>(), NodeManager by NodeManager.INVOKABLE_ONLY {

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