@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.web.WebView
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [WebView] to this manager.
 */
fun NodeManager.webView(): WebView = webView() { }

/**
 * Create a [WebView] with configuration block.
 */
inline fun webView(configuration: (@LayoutDslMarker WebView).() -> Unit): WebView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(WebView(), configuration = configuration)
}

/**
 * Add a [WebView] with configuration block to this manager.
 */
inline fun NodeManager.webView(configuration: (@LayoutDslMarker WebView).() -> Unit): WebView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(WebView(), configuration = configuration))
}

/**
 * Create a styled [WebView].
 */
fun styledWebView(vararg styleClass: String, id: String? = null): WebView = styledWebView(
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [WebView] to this manager.
 */
fun NodeManager.styledWebView(vararg styleClass: String, id: String? = null): WebView =
    styledWebView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [WebView] with configuration block.
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
 */
inline fun NodeManager.styledWebView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker WebView).() -> Unit
): WebView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            WebView(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}
