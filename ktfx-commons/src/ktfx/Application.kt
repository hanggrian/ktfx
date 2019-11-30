@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.application.Application
import kotlin.reflect.KClass
import netscape.javascript.JSObject

/** Launch a JavaFX application with Kotlin class. */
fun <T : Application> launchApplication(type: KClass<T>, vararg args: String): Unit =
    Application.launch(type.java, *args)

/** Launch a JavaFX application with reified type. */
inline fun <reified T : Application> launchApplication(vararg args: String): Unit = launchApplication(T::class, *args)

/**
 * Opens the specified URI in a new browser window or tab.
 *
 * @see javafx.application.HostServices.showDocument
 */
inline fun Application.showDocument(uri: String): Unit = hostServices.showDocument(uri)

/**
 * Resolves the specified relative URI against the code base URI and returns the resolved URI.
 *
 * @see javafx.application.HostServices.getCodeBase
 * @see javafx.application.HostServices.resolveURI
 */
inline fun Application.resolveCodeURI(rel: String): String = hostServices.resolveURI(hostServices.codeBase, rel)

/**
 * Resolves the specified relative URI against the document base URI and returns the resolved URI.
 *
 * @see javafx.application.HostServices.getDocumentBase
 * @see javafx.application.HostServices.resolveURI
 */
inline fun Application.resolveDocumentURI(rel: String): String = hostServices.resolveURI(hostServices.documentBase, rel)

/**
 * Returns the JavaScript handle of the enclosing DOM window of the web page containing this application.
 *
 * @see javafx.application.HostServices.getWebContext
 */
inline val Application.webContext: JSObject get() = hostServices.webContext
