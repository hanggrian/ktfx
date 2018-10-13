@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

import javafx.scene.control.Control
import org.controlsfx.validation.Severity
import org.controlsfx.validation.ValidationSupport
import org.controlsfx.validation.Validator

/* ktlint-enable package-name */

private lateinit var support: ValidationSupport

@PublishedApi internal val singletonSupport: ValidationSupport
    get() {
        if (!::support.isInitialized) {
            support = ValidationSupport()
        }
        return support
    }

/** Register empty validation. */
inline fun <T> Control.registerEmptyValidator(
    message: String,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    support: ValidationSupport = singletonSupport
): Boolean = support.registerValidator(
    this,
    required,
    Validator.createEmptyValidator<T>(message, severity)
)

/** Register equals validation. */
inline fun <T> Control.registerEqualsValidator(
    message: String,
    colletion: Collection<T>,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    support: ValidationSupport = singletonSupport
): Boolean = support.registerValidator(
    this,
    required,
    Validator.createEqualsValidator<T>(message, severity, colletion)
)

/** Register predicate validation. */
inline fun <T> Control.registerPredicateValidator(
    message: String,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    support: ValidationSupport = singletonSupport,
    noinline predicate: (T) -> Boolean
): Boolean = support.registerValidator(
    this,
    required,
    Validator.createPredicateValidator<T>(predicate, message, severity)
)

/** Register regex validation. */
inline fun Control.registerRegexValidator(
    message: String,
    regex: String,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    support: ValidationSupport = singletonSupport
): Boolean = support.registerValidator(
    this,
    required,
    Validator.createRegexValidator(message, regex, severity)
)

/** Register regex validation. */
inline fun Control.registerRegexValidator(
    message: String,
    regex: Regex,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    support: ValidationSupport = singletonSupport
): Boolean = support.registerValidator(
    this,
    required,
    Validator.createRegexValidator(message, regex.toPattern(), severity)
)