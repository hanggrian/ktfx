@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDialog
import javafx.scene.Node
import javafx.scene.layout.StackPane
import ktfx.NodeManager
import ktfx.internal.KtfxInternals

open class _JFXDialog(
    dialogContainer: StackPane?,
    transitionType: DialogTransition,
    overlayClose: Boolean
) : JFXDialog(dialogContainer, null, transitionType, overlayClose), NodeManager by NodeManager.INVOKABLE_ONLY {

    override fun <R : Node> R.invoke(): R = also { content = KtfxInternals.asRegion(it) }
}

fun jfxDialog(
    dialogContainer: StackPane? = null,
    transitionType: JFXDialog.DialogTransition = JFXDialog.DialogTransition.CENTER,
    overlayClose: Boolean = true,
    init: (_JFXDialog.() -> Unit)? = null
): JFXDialog = _JFXDialog(dialogContainer, transitionType, overlayClose).also { init?.invoke(it) }