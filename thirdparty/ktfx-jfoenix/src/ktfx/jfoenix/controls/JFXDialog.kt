@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDialog
import javafx.scene.Node
import javafx.scene.layout.Region
import javafx.scene.layout.StackPane
import ktfx.NodeManager
import ktfx.scene.asRegion

class _JFXDialog(
    dialogContainer: StackPane?,
    content: Region?,
    transitionType: DialogTransition,
    overlayClose: Boolean
) : JFXDialog(dialogContainer, content, transitionType, overlayClose), NodeManager by NodeManager.INVOKABLE_ONLY {

    override fun <R : Node> R.invoke(): R = also { content = it.asRegion() }
}

fun jfxDialog(
    dialogContainer: StackPane? = null,
    content: Region? = null,
    transitionType: JFXDialog.DialogTransition = JFXDialog.DialogTransition.CENTER,
    overlayClose: Boolean = true,
    init: (_JFXDialog.() -> Unit)? = null
): JFXDialog = _JFXDialog(dialogContainer, content, transitionType, overlayClose).also { init?.invoke(it) }