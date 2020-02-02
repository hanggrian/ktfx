@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.web.WebView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [WebView] with initialization block. */
inline fun webView(
    init: (@LayoutsDslMarker WebView).() -> Unit
): WebView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return WebView().apply(init)
}

/** Add a [WebView] to this manager. */
fun NodeManager.webView(): WebView = addChild(WebView())

/** Add a [WebView] with initialization block to this manager. */
inline fun NodeManager.webView(
    init: (@LayoutsDslMarker WebView).() -> Unit
): WebView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(WebView(), init)
}
