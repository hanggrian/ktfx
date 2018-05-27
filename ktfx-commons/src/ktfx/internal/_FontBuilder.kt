package ktfx.internal

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import ktfx.scene.text.FontBuilder
import java.io.InputStream

@Suppress("ClassName")
@PublishedApi
internal class _FontBuilder : FontBuilder {
    private var _custom: Any? = null
    private var _family: String? = null
    private var _weight: FontWeight? = null
    private var _posture: FontPosture? = null
    private var _size: Number = -1

    override fun load(custom: String): _FontBuilder = apply { _custom = custom }
    override fun load(custom: InputStream): _FontBuilder = apply { _custom = custom }
    override fun family(family: String): _FontBuilder = apply { _family = family }
    override fun weight(weight: FontWeight): _FontBuilder = apply { _weight = weight }
    override fun posture(posture: FontPosture): _FontBuilder = apply { _posture = posture }
    override fun size(size: Number): _FontBuilder = apply { _size = size }

    override fun build(): Font = when (_custom) {
        is String -> Font.loadFont(_custom as String, _size.toDouble())
        is InputStream -> Font.loadFont(_custom as InputStream, _size.toDouble())
        else -> Font.font(_family, _weight, _posture, _size.toDouble())
    }
}