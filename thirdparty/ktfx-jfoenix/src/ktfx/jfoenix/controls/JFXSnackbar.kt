@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXSnackbar
import javafx.scene.Node
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import ktfx.internal.KtfxInternals

open class _JFXSnackbar : JFXSnackbar(), NodeManager by NodeManager.INVOKABLE_ONLY {

    override fun <R : Node> R.invoke(): R = also { registerSnackbarContainer(KtfxInternals.asPane(it)) }
}

/** Creates a [JFXSnackbar]. */
fun jfxSnackbar(
    init: ((@LayoutDsl _JFXSnackbar).() -> Unit)? = null
): JFXSnackbar = _JFXSnackbar().also { init?.invoke(it) }

/** Creates a [JFXSnackbar] and add it to this manager. */
inline fun NodeManager.jfxSnackbar(
    noinline init: ((@LayoutDsl _JFXSnackbar).() -> Unit)? = null
): JFXSnackbar = ktfx.jfoenix.jfxSnackbar(init)()