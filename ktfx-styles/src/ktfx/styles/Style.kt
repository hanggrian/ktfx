package ktfx.styles

open class Style {
    protected val map: MutableMap<String, Any> = mutableMapOf()

    override fun toString(): String {
        var s = ""
        map.forEach { key, value -> s += "\t${key.toFXKey()}: ${value.toString().toLowerCase()};\n" }
        return s
    }

    private companion object {
        val NO_FX = arrayOf("visibility")

        fun String.toFXKey() = when {
            this in NO_FX -> this
            else -> "-fx-${map { if (Character.isUpperCase(it)) "-${it.toLowerCase()}" else it.toString() }.joinToString("")}"
        }
    }
}

@PublishedApi
internal fun styleOf(vararg selectors: String, styles: String): String = selectors.joinToString(" ").let {
    return when {
        it.isNotEmpty() -> StringBuilder(it).appendln(" {").append(styles).append('}').toString()
        else -> styles
    }
}