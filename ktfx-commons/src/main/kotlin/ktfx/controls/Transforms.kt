package ktfx.controls

import javafx.scene.Node
import javafx.scene.transform.Affine
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Shear
import javafx.scene.transform.Translate

/**
 * Adds [Affine] transformation.
 *
 * @param configuration the configuration block that customizes transformation.
 * @return the transformation added.
 */
public fun Node.affineTransformation(configuration: Affine.() -> Unit): Affine =
    Affine().also {
        it.configuration()
        transforms += it
    }

/**
 * Adds [Rotate] transformation.
 *
 * @param configuration the configuration block that customizes transformation.
 * @return the transformation added.
 */
public fun Node.rotateTransformation(configuration: Rotate.() -> Unit): Rotate =
    Rotate().also {
        it.configuration()
        transforms += it
    }

/**
 * Adds [Scale] transformation.
 *
 * @param configuration the configuration block that customizes transformation.
 * @return the transformation added.
 */
public fun Node.scaleTransformation(configuration: Scale.() -> Unit): Scale =
    Scale().also {
        it.configuration()
        transforms += it
    }

/**
 * Adds [Shear] transformation.
 *
 * @param configuration the configuration block that customizes transformation.
 * @return the transformation added.
 */
public fun Node.shearTransformation(configuration: Shear.() -> Unit): Shear =
    Shear().also {
        it.configuration()
        transforms += it
    }

/**
 * Adds [Translate] transformation.
 *
 * @param configuration the configuration block that customizes transformation.
 * @return the transformation added.
 */
public fun Node.translateTransformation(configuration: Translate.() -> Unit): Translate =
    Translate().also {
        it.configuration()
        transforms += it
    }
