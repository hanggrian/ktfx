package ktfx.styles

class ImageViewStyleBuilder : NodeStyleBuilder() {

    /** Relative URLs are resolved against the URL of the stylesheet. */
    var image: Urls by map
}

inline fun imageViewStyle(builder: ImageViewStyleBuilder.() -> Unit): String =
    ImageViewStyleBuilder().apply(builder).toString()