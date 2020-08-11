@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add an [ImageView] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.imageView(image: Image? = null): ImageView = imageView(image = image) { }

/**
 * Create an [ImageView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun imageView(image: Image? = null, configuration: (@LayoutDslMarker ImageView).() -> Unit):
    ImageView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(ImageView(image), configuration = configuration)
}

/**
 * Add an [ImageView] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.imageView(image: Image? = null, configuration: (@LayoutDslMarker
    ImageView).() -> Unit): ImageView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(ImageView(image), configuration = configuration))
}

/**
 * Create a styled [ImageView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledImageView(
  image: Image? = null,
  vararg styleClass: String,
  id: String? = null
): ImageView = styledImageView(image = image, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ImageView] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledImageView(
  image: Image? = null,
  vararg styleClass: String,
  id: String? = null
): ImageView = styledImageView(image = image, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ImageView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledImageView(
  image: Image? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(ImageView(image), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [ImageView] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledImageView(
  image: Image? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker ImageView).() -> Unit
): ImageView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(ImageView(image), styleClass = *styleClass, id = id, configuration =
      configuration))
}
