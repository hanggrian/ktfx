package ktfx.controlsfx.controls

import javafx.scene.control.Control
import org.controlsfx.validation.Severity
import org.controlsfx.validation.ValidationSupport
import org.controlsfx.validation.Validator
import java.lang.ref.WeakReference

private lateinit var validationSupportRef: WeakReference<ValidationSupport>
private val validationSupport: ValidationSupport
    get() =
        validationSupportRef.get()
            ?: ValidationSupport().also { validationSupportRef = WeakReference(it) }

/** Set control's required flag. */
public inline var Control.isValidationRequired: Boolean
    get() = ValidationSupport.isRequired(this)
    set(value) = ValidationSupport.setRequired(this, value)

/** Register empty validation. */
public fun <T> Control.registerEmptyValidator(
    message: String,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    support: ValidationSupport = validationSupport,
): Boolean =
    support.registerValidator(
        this,
        required,
        Validator.createEmptyValidator<T>(message, severity),
    )

/** Register equals validation. */
public fun <T> Control.registerEqualsValidator(
    message: String,
    collection: Collection<T>,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    support: ValidationSupport = validationSupport,
): Boolean =
    support.registerValidator(
        this,
        required,
        Validator.createEqualsValidator<T>(message, severity, collection),
    )

/** Register predicate validation. */
public fun <T> Control.registerPredicateValidator(
    message: String,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    support: ValidationSupport = validationSupport,
    predicate: (T) -> Boolean,
): Boolean =
    support.registerValidator(
        this,
        required,
        Validator.createPredicateValidator<T>(predicate, message, severity),
    )

/** Register regex validation. */
public fun Control.registerRegexValidator(
    message: String,
    regex: String,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    support: ValidationSupport = validationSupport,
): Boolean =
    support.registerValidator(
        this,
        required,
        Validator.createRegexValidator(message, regex, severity),
    )

/** Register regex validation. */
public fun Control.registerRegexValidator(
    message: String,
    regex: Regex,
    severity: Severity = Severity.ERROR,
    required: Boolean = true,
    support: ValidationSupport = validationSupport,
): Boolean =
    support.registerValidator(
        this,
        required,
        Validator.createRegexValidator(message, regex.toPattern(), severity),
    )
