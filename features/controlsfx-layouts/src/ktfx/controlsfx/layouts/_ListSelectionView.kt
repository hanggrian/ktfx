@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.ListSelectionView

/**
 * Add a [ListSelectionView] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.listSelectionView(): ListSelectionView<T> = listSelectionView() { }

/**
 * Create a [ListSelectionView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun <T> listSelectionView(configuration: (@LayoutDslMarker ListSelectionView<T>).() -> Unit):
    ListSelectionView<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(ListSelectionView<T>(), configuration = configuration)
}

/**
 * Add a [ListSelectionView] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun <T> NodeManager.listSelectionView(configuration: (@LayoutDslMarker
    ListSelectionView<T>).() -> Unit): ListSelectionView<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(ListSelectionView<T>(), configuration = configuration))
}

/**
 * Create a styled [ListSelectionView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun <T> styledListSelectionView(vararg styleClass: String, id: String? = null): ListSelectionView<T>
    = styledListSelectionView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ListSelectionView] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun <T> NodeManager.styledListSelectionView(vararg styleClass: String, id: String? = null):
    ListSelectionView<T> = styledListSelectionView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ListSelectionView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun <T> styledListSelectionView(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(ListSelectionView<T>(), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [ListSelectionView] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledListSelectionView(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(ListSelectionView<T>(), styleClass = *styleClass, id = id, configuration
      = configuration))
}
