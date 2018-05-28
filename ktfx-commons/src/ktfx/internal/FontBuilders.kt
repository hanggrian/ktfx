@file:Suppress("ClassName")

package ktfx.internal

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import ktfx.scene.text.DefaultFontBuilder
import ktfx.scene.text.FontBuilder
import java.io.InputStream

@PublishedApi
internal class _DefaultFontBuilder : DefaultFontBuilder {
    private var _family: String? = null
    private var _weight: FontWeight? = null
    private var _posture: FontPosture? = null
    private var _size: Number = -1

    override fun plus(family: String): DefaultFontBuilder = apply { _family = family }
    override fun plus(weight: FontWeight): DefaultFontBuilder = apply { _weight = weight }
    override fun plus(posture: FontPosture): DefaultFontBuilder = apply { _posture = posture }
    override fun plus(size: Number): FontBuilder = apply { _size = size }

    override fun build(): Font = Font.font(_family, _weight, _posture, _size.toDouble())
}

@PublishedApi
internal class _CustomFontBuilder : FontBuilder {
    private var _custom: Any? = null
    private var _size: Number = -1

    @PublishedApi
    internal fun custom(custom: Any): FontBuilder = apply { _custom = custom }

    override fun plus(size: Number): FontBuilder = apply { _size = size }

    override fun build(): Font = when (_custom) {
        is String -> Font.loadFont(_custom as String, _size.toDouble())
        is InputStream -> Font.loadFont(_custom as InputStream, _size.toDouble())
        else -> error("")
    }
}