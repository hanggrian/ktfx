@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.web.WebView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [WebView] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.webView(): WebView = webView() { }

/**
 * Create a [WebView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun webView(configuration: (@LayoutDslMarker WebView).() -> Unit): WebView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(WebView(), configuration = configuration)
}

/**
 * Add a [WebView] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.webView(configuration: (@LayoutDslMarker WebView).() -> Unit): WebView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(WebView(), configuration = configuration))
}

/**
 * Create a styled [WebView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledWebView(vararg styleClass: String, id: String? = null): WebView = styledWebView(styleClass
    = *styleClass, id = id) { }

/**
 * Add a styled [WebView] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledWebView(vararg styleClass: String, id: String? = null): WebView =
    styledWebView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [WebView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledWebView(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker WebView).() -> Unit
): WebView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(WebView(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [WebView] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledWebView(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker WebView).() -> Unit
): WebView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(WebView(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
