package ktfx.styles

import javafx.geometry.Insets
import javafx.scene.paint.Color
import java.lang.Character.isUpperCase

open class StyleBuilder {
    protected val map: MutableMap<String, Any> = mutableMapOf()

    override fun toString(): String = StringBuilder().also {
        map.forEach { key, value -> it.appendln("${key.toKey()}: ${value.toValue()};") }
    }.toString()

    private companion object {
        val NO_FX = arrayOf("visibility")

        fun String.toKey() = when (this) {
            in NO_FX -> this
            else -> "-fx-${map { if (isUpperCase(it)) "-${it.toLowerCase()}" else it.toString() }.joinToString("")}"
        }

        fun Any.toValue(): String = when (this) {
            is String -> this
            is Color -> String.format("#%02X%02X%02X", (red * 255).toInt(), (green * 255).toInt(), (blue * 255).toInt())
            is Insets -> "$top $right $bottom $left"
            else -> toString()
        }.toLowerCase()
    }
}