@file:JvmName("PlatformsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx

import javafx.application.ConditionalFeature
import javafx.application.Platform

inline val FEATURE_GRAPHICS get() = ConditionalFeature.GRAPHICS
inline val FEATURE_CONTROLS get() = ConditionalFeature.CONTROLS
inline val FEATURE_MEDIA get() = ConditionalFeature.MEDIA
inline val FEATURE_WEB get() = ConditionalFeature.WEB
inline val FEATURE_SWT get() = ConditionalFeature.SWT
inline val FEATURE_SWING get() = ConditionalFeature.SWING
inline val FEATURE_FXML get() = ConditionalFeature.FXML
inline val FEATURE_SCENE3D get() = ConditionalFeature.SCENE3D
inline val FEATURE_EFFECT get() = ConditionalFeature.EFFECT
inline val FEATURE_SHAPE_CLIP get() = ConditionalFeature.SHAPE_CLIP
inline val FEATURE_INPUT_METHOD get() = ConditionalFeature.INPUT_METHOD
inline val FEATURE_TRANSPARENT_WINDOW get() = ConditionalFeature.TRANSPARENT_WINDOW
inline val FEATURE_UNIFIED_WINDOW get() = ConditionalFeature.UNIFIED_WINDOW
inline val FEATURE_TWO_LEVEL_FOCUS get() = ConditionalFeature.TWO_LEVEL_FOCUS
inline val FEATURE_VIRTUAL_KEYBOARD get() = ConditionalFeature.VIRTUAL_KEYBOARD
inline val FEATURE_INPUT_TOUCH get() = ConditionalFeature.INPUT_TOUCH
inline val FEATURE_INPUT_MULTITOUCH get() = ConditionalFeature.INPUT_MULTITOUCH
inline val FEATURE_INPUT_POINTER get() = ConditionalFeature.INPUT_POINTER

/** Returns true if this feature is supported. */
inline val ConditionalFeature.isSupported: Boolean
    get() = try {
        Platform.isSupported(this)
    } catch (e: Exception) {
        false
    }

/** Returns true if [features] are all supported. */
inline fun isSupported(vararg features: ConditionalFeature): Boolean {
    require(features.isNotEmpty(), { "Features can't be empty!" })
    return features.all { it.isSupported }
}

/** Executes [block] in JavaFX Application Thread. */
inline fun runLater(crossinline block: () -> Unit) = Platform.runLater { block() }

/** Executes [block] in current thread if [features] are all supported. */
inline fun runLaterIfSupported(vararg features: ConditionalFeature, crossinline block: () -> Unit) {
    when {
        isSupported(*features) -> runLater(block)
    }
}

/** Executes [block] in current thread if [features] are all supported, [fallback] otherwise. */
inline fun runLaterIfSupported(vararg features: ConditionalFeature, crossinline block: () -> Unit, crossinline fallback: () -> Unit) {
    when {
        isSupported(*features) -> runLater(block)
        else -> runLater(fallback)
    }
}

/** Executes [block] in JavaFX Application Thread if [features] are all supported. */
inline fun runIfSupported(vararg features: ConditionalFeature, block: () -> Unit) {
    when {
        isSupported(*features) -> block()
    }
}

/** Executes [block] in JavaFX Application Thread if [features] are all supported, [fallback] otherwise. */
inline fun runIfSupported(vararg features: ConditionalFeature, block: () -> Unit, fallback: () -> Unit) {
    when {
        isSupported(*features) -> block()
        else -> fallback()
    }
}

/** Returns [block] if [features] are all supported, null otherwise. */
inline fun <T, R> T.getIfSupported(vararg features: ConditionalFeature, block: T.() -> R): R? {
    return when {
        isSupported(*features) -> block()
        else -> null
    }
}

/** Returns [block] if [features] are all supported, [fallback] otherwise. */
inline fun <T, R> T.getIfSupported(vararg features: ConditionalFeature, block: T.() -> R, fallback: T.() -> R): R {
    return when {
        isSupported(*features) -> block()
        else -> fallback()
    }
}

/** Returns true if calling thread is JavaFX Application Thread. */
inline fun isFXApplicationThread(): Boolean = Platform.isFxApplicationThread()

/** Causes the JavaFX application to terminate. */
inline fun exitFXApplication() = Platform.exit()