@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.fxml.FXMLLoader
import javafx.fxml.FXMLLoader.DEFAULT_CHARSET_NAME
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.SceneAntialiasing
import javafx.scene.SceneAntialiasing.DISABLED
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint
import javafx.util.BuilderFactory
import javafx.util.Callback
import java.net.URL
import java.nio.charset.Charset
import java.nio.charset.Charset.forName
import java.util.*

@JvmOverloads
inline fun URL.loadFXML(
        resources: ResourceBundle? = null,
        builderFactory: BuilderFactory? = null,
        controllerFactory: Callback<Class<*>, Any>? = null,
        charset: Charset = forName(DEFAULT_CHARSET_NAME)
): Parent = FXMLLoader.load<Parent>(this, resources, builderFactory, controllerFactory, charset)

@JvmOverloads
inline fun Parent.toScene(
        fill: Paint = WHITE
): Scene = Scene(this, fill)

@JvmOverloads
inline fun Parent.toScene(
        width: Number,
        height: Number,
        fill: Paint = WHITE
): Scene = Scene(this, width.toDouble(), height.toDouble(), fill)

@JvmOverloads
inline fun Parent.toScene(
        width: Number,
        height: Number,
        depthBuffer: Boolean,
        antiAliasing: SceneAntialiasing = DISABLED
): Scene = Scene(this, width.toDouble(), height.toDouble(), depthBuffer, antiAliasing)