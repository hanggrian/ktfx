@file:OptIn(ExperimentalContracts::class)

package ktfx.controls

import javafx.scene.Node
import javafx.scene.transform.Affine
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Shear
import javafx.scene.transform.Translate
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Adds [Affine] transformation.
 *
 * @param configuration the configuration block that customizes transformation.
 * @return the transformation added.
 */
public fun Node.affineTransformation(configuration: Affine.() -> Unit): Affine {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Affine().also {
        it.configuration()
        transforms += it
    }
}

/**
 * Adds [Rotate] transformation.
 *
 * @param configuration the configuration block that customizes transformation.
 * @return the transformation added.
 */
public fun Node.rotateTransformation(configuration: Rotate.() -> Unit): Rotate {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Rotate().also {
        it.configuration()
        transforms += it
    }
}

/**
 * Adds [Scale] transformation.
 *
 * @param configuration the configuration block that customizes transformation.
 * @return the transformation added.
 */
public fun Node.scaleTransformation(configuration: Scale.() -> Unit): Scale {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Scale().also {
        it.configuration()
        transforms += it
    }
}

/**
 * Adds [Shear] transformation.
 *
 * @param configuration the configuration block that customizes transformation.
 * @return the transformation added.
 */
public fun Node.shearTransformation(configuration: Shear.() -> Unit): Shear {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Shear().also {
        it.configuration()
        transforms += it
    }
}

/**
 * Adds [Translate] transformation.
 *
 * @param configuration the configuration block that customizes transformation.
 * @return the transformation added.
 */
public fun Node.translateTransformation(configuration: Translate.() -> Unit): Translate {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Translate().also {
        it.configuration()
        transforms += it
    }
}
