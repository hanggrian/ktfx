@file:Suppress("NOTHING_TO_INLINE")

package ktfx.inputs

import javafx.scene.input.Clipboard
import javafx.scene.input.DataFormat

/** The content associated with this type, or null if there is none. */
inline operator fun Clipboard.get(dataFormat: DataFormat): Any? = getContent(dataFormat)