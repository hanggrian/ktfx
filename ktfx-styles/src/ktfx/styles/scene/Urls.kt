package ktfx.styles

class Urls(private vararg val urls: String) {
    override fun toString(): String = urls.joinToString { "url(\"$it\")" }
}