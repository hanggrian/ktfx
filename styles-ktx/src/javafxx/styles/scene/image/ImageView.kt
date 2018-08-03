@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafxx.styles.internal._ImageViewStyleBuilder

interface ImageViewStyleBuilder {

    /** Relative URLs are resolved against the URL of the stylesheet. */
    var image: Urls
}

inline fun imageViewStyle(
    prettyPrint: Boolean = false,
    builder: ImageViewStyleBuilder.() -> Unit
): String = _ImageViewStyleBuilder(prettyPrint).apply(builder).toString()