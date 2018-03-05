package kotlinfx.css.experimental

import javafx.scene.Cursor
import javafx.scene.effect.BlendMode
import javafx.scene.effect.Effect
import java.lang.Character.isUpperCase

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
            else -> "-fx-${map { if (isUpperCase(it)) "-${it.toLowerCase()}" else it.toString() }.joinToString("")}"
        }
    }
}

open class NodeStyle : Style() {
    var blendMode: BlendMode by map
    var cursor: Cursor by map
    var effect: Effect by map
    var focusTraversable: Boolean by map
    var opacity: Number by map
    var rotate: Number by map
    var scaleX: Number by map
    var scaleY: Number by map
    var scaleZ: Number by map
    var translateX: Number by map
    var translateY: Number by map
    var translateZ: Number by map
}

class AllStyle : NodeStyle() {

}

inline fun style(init: NodeStyle.() -> Unit): String = StringBuilder().apply {
    appendln(".node {")
    append(NodeStyle().apply(init).toString())
    append("}")
}.toString()