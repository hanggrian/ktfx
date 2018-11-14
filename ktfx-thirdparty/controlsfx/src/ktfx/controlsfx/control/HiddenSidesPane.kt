@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.NodeInvokable
import org.controlsfx.control.HiddenSidesPane

/**
 * Invoking layout DSL will only set content.
 * To set other sides, explicitly use `top`, `left`, `bottom`, or `right`.
 */
open class _HiddenSidesPane : HiddenSidesPane(), NodeInvokable {

    override fun <R : Node> R.invoke(): R = also { content = it }
}

/** Creates a [HiddenSidesPane]. */
fun hiddenSidesPane(
    init: ((@LayoutDsl _HiddenSidesPane).() -> Unit)? = null
): HiddenSidesPane = _HiddenSidesPane().also { init?.invoke(it) }

/** Creates a [HiddenSidesPane] and add it to this manager. */
inline fun NodeInvokable.hiddenSidesPane(
    noinline init: ((@LayoutDsl _HiddenSidesPane).() -> Unit)? = null
): HiddenSidesPane = ktfx.controlsfx.hiddenSidesPane(init)()