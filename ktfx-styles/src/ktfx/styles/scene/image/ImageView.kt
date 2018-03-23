package ktfx.styles

class ImageViewStyleBuilder(prettyPrint: Boolean) : NodeStyleBuilder(prettyPrint) {

    /** Relative URLs are resolved against the URL of the stylesheet. */
    var image: Urls by map
}

inline fun imageViewStyle(
    prettyPrint: Boolean = false,
    builder: ImageViewStyleBuilder.() -> Unit
): String = ImageViewStyleBuilder(prettyPrint).apply(builder).toString()