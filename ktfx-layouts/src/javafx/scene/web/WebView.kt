@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.web.WebView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [WebView] with configuration block. */
inline fun webView(
    configuration: (@LayoutDslMarker WebView).() -> Unit
): WebView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return WebView().apply(configuration)
}

/** Add a [WebView] to this manager. */
fun NodeManager.webView(): WebView = addChild(WebView())

/** Add a [WebView] with configuration block to this manager. */
inline fun NodeManager.webView(
    configuration: (@LayoutDslMarker WebView).() -> Unit
): WebView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(WebView(), configuration)
}
