@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.utils.JFXNodeUtils
import javafx.scene.layout.Background
import javafx.scene.layout.Region
import javafx.scene.paint.Color
import javafx.scene.paint.Paint

inline fun Region.updateBackground(
    newBackground: Background,
    paint: Paint = Color.BLACK
) = JFXNodeUtils.updateBackground(newBackground, this, paint)

inline fun Color.toHex(): String = JFXNodeUtils.colorToHex(this)