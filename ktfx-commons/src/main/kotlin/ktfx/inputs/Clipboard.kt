@file:Suppress("NOTHING_TO_INLINE")

package ktfx.inputs

import javafx.scene.input.Clipboard
import javafx.scene.input.DataFormat

/** Convenient method to put single content to clipboard. */
public operator fun Clipboard.set(dataFormat: DataFormat, content: Any): Boolean =
    setContent(mapOf(dataFormat to content))

/** The content associated with this type, or null if there is none. */
public inline operator fun Clipboard.get(dataFormat: DataFormat): Any? = getContent(dataFormat)

/** Returns true if there is content on this clipboard for this type. */
public inline operator fun Clipboard.contains(dataFormat: DataFormat): Boolean =
    hasContent(dataFormat)
