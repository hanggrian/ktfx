@file:Suppress("ClassName")

package ktfx.styles.internal

import ktfx.styles.ImageViewStyleBuilder
import ktfx.styles.Urls

@PublishedApi
internal class _ImageViewStyleBuilder(
    prettyPrint: Boolean
) : _NodeStyleBuilder(prettyPrint), ImageViewStyleBuilder {
    override var image: Urls by map
}