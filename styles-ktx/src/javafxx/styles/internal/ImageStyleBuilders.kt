@file:Suppress("ClassName")

package javafxx.styles.internal

import javafxx.styles.ImageViewStyleBuilder
import javafxx.styles.Urls

@PublishedApi
internal class _ImageViewStyleBuilder(
    prettyPrint: Boolean
) : _NodeStyleBuilder(prettyPrint), ImageViewStyleBuilder {
    override var image: Urls by map
}