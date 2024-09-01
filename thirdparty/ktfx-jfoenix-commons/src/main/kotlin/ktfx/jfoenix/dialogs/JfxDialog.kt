package ktfx.jfoenix.dialogs

import com.jfoenix.controls.JFXDialog
import javafx.scene.layout.StackPane
import java.util.WeakHashMap

private val shownDialogs = WeakHashMap<StackPane, JFXDialog>()

/**
 * Track a previously shown dialog within a container to close it before showing a new dialog.
 *
 * @param container parent layout, or the dialog's default container.
 */
public fun JFXDialog.showSingle(container: StackPane = dialogContainer) {
    shownDialogs[container]
        ?.takeIf { it in container.children }
        ?.close()
    shownDialogs[container] = apply { show() }
}
