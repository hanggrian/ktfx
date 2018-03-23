package ktfx.styles

interface ImageViewStyleBuilder {

    /** Relative URLs are resolved against the URL of the stylesheet. */
    var image: Urls
}

@PublishedApi
@Suppress("ClassName")
internal class _ImageViewStyleBuilder(prettyPrint: Boolean) : _NodeStyleBuilder(prettyPrint), ImageViewStyleBuilder {
    override var image: Urls by map
}

inline fun imageViewStyle(
    prettyPrint: Boolean = false,
    builder: ImageViewStyleBuilder.() -> Unit
): String = _ImageViewStyleBuilder(prettyPrint).apply(builder).toString()