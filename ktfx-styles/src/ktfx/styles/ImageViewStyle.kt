package ktfx.styles

class Urls(private vararg val urls: String) {

    override fun toString(): String = urls.joinToString { "url(\"$it\")" }
}

class ImageViewStyle : NodeStyle() {
    var image: Urls by map
}

inline fun imageViewStyle(vararg selectors: String, styles: ImageViewStyle.() -> Unit): String =
    styleOf(*selectors, styles = ImageViewStyle().apply(styles).toString())