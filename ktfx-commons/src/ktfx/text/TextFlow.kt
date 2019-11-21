@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.text.Text
import javafx.scene.text.TextFlow

/**
 * Add text to this flow, returning the flow itself for re-append.
 *
 * @see java.lang.Appendable.append
 */
fun TextFlow.append(text: String): TextFlow =
    apply { children += Text(text) }

/**
 * Add new line to this flow, returning the flow itself for re-append.
 *
 * @see kotlin.text.appendln
 */
fun TextFlow.appendln(): TextFlow =
    append(SystemProperties.LINE_SEPARATOR)

/**
 * Add text with new line to this flow, returning the flow itself for re-append.
 *
 * @see kotlin.text.appendln
 */
inline fun TextFlow.appendln(text: String): TextFlow =
    append(text).appendln()

/** Add text to this flow, returning the flow itself for re-append. */
inline fun TextFlow.append(text: Any): TextFlow =
    append(text.toString())

/** Add text with new line to this flow, returning the flow itself for re-append. */
inline fun TextFlow.appendln(text: Any): TextFlow =
    append(text.toString()).appendln()

/**
 * @see kotlin.text.SystemProperties
 */
private object SystemProperties {
    /** Line separator for current system. */
    @JvmField
    val LINE_SEPARATOR = checkNotNull(System.getProperty("line.separator")) { "Unable to obtain separator character." }
}
