@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

import javafx.scene.control.Control
import org.controlsfx.validation.Severity
import org.controlsfx.validation.ValidationSupport
import org.controlsfx.validation.Validator

/* ktlint-enable package-name */

inline fun <T> Control.registerEmptyValidator(
    validation: ValidationSupport,
    message: String,
    severity: Severity = Severity.ERROR,
    required: Boolean = true
): Boolean = validation.registerValidator(
    this,
    required,
    Validator.createEmptyValidator<T>(message, severity)
)

inline fun <T> Control.registerEqualsValidator(
    validation: ValidationSupport,
    message: String,
    colletion: Collection<T>,
    severity: Severity = Severity.ERROR,
    required: Boolean = true
): Boolean = validation.registerValidator(
    this,
    required,
    Validator.createEqualsValidator<T>(message, severity, colletion)
)

inline fun <T> Control.registerPredicateValidator(
    validation: ValidationSupport,
    message: String,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    noinline predicate: (T) -> Boolean
): Boolean = validation.registerValidator(
    this,
    required,
    Validator.createPredicateValidator(predicate, message, severity)
)

inline fun <T> Control.registerRegexValidator(
    validation: ValidationSupport,
    message: String,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    noinline predicate: (T) -> Boolean
): Boolean = validation.registerValidator(
    this,
    required,
    Validator.createPredicateValidator(predicate, message, severity)
)