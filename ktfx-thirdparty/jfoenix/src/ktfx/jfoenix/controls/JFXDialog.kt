@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent
import javafx.scene.Node
import javafx.scene.layout.StackPane
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.layouts.NodeManager
import ktfx.internal.KtfxInternals
import kotlin.coroutines.CoroutineContext

fun JFXDialog.onDialogClosed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(JFXDialogEvent) -> Unit
): Unit = setOnDialogClosed { event -> GlobalScope.launch(context) { action(event) } }

fun JFXDialog.onDialogOpened(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(JFXDialogEvent) -> Unit
): Unit = setOnDialogOpened { event -> GlobalScope.launch(context) { action(event) } }

open class _JFXDialog(
    dialogContainer: StackPane?,
    transitionType: DialogTransition,
    overlayClose: Boolean
) : JFXDialog(dialogContainer, null, transitionType, overlayClose), NodeManager {

    override fun <R : Node> R.add(): R = also { content = KtfxInternals.asPane(it) }
}

fun jfxDialog(
    dialogContainer: StackPane? = null,
    transitionType: JFXDialog.DialogTransition = JFXDialog.DialogTransition.CENTER,
    overlayClose: Boolean = true,
    init: (_JFXDialog.() -> Unit)? = null
): JFXDialog = _JFXDialog(dialogContainer, transitionType, overlayClose).also { init?.invoke(it) }