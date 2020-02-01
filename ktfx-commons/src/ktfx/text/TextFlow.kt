@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.text.Text
import javafx.scene.text.TextFlow

/**
 * Sets the character at the specified [index] to the specified [value].
 *
 * @see kotlin.text.set
 */
operator fun TextFlow.set(index: Int, value: String) {
    val child = children[index]
    require(child is Text) { "TextFlow child is not a Text." }
    child.text = value
}

/**
 * Clears the content of this flow making it empty.
 *
 * @see kotlin.text.clear
 */
fun TextFlow.clear(): TextFlow = apply { children.clear() }

/**
 * Appends [value] to this flow.
 *
 * @see java.lang.Appendable.append
 */
fun TextFlow.append(value: String?): TextFlow = apply { children += Text(value ?: "null") }

/**
 * Appends [value] to this flow.
 *
 * @see java.lang.StringBuilder.append
 */
fun TextFlow.append(value: Any?): TextFlow = append(value?.toString())

/**
 * Appends a line separator to this flow.
 *
 * @see kotlin.text.appendln
 */
fun TextFlow.appendln(): TextFlow = append(SystemProperties.LINE_SEPARATOR)

/**
 * Appends [value] to this flow, followed by a line separator.
 *
 * @see kotlin.text.appendln
 */
inline fun TextFlow.appendln(value: String?): TextFlow = append(value).appendln()

/**
 * Appends [value] to this flow, followed by a line separator.
 *
 * @see kotlin.text.appendln
 */
inline fun TextFlow.appendln(value: Any?): TextFlow = append(value).appendln()

/**
 * @see kotlin.text.SystemProperties
 */
private object SystemProperties {
    /** Line separator for current system. */
    @JvmField
    val LINE_SEPARATOR = checkNotNull(System.getProperty("line.separator")) { "Unable to obtain separator character." }
}
