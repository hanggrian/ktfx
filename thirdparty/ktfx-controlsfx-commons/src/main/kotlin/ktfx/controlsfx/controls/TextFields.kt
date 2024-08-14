@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.controls

import javafx.scene.control.TextField
import javafx.util.StringConverter
import org.controlsfx.control.textfield.AutoCompletionBinding
import org.controlsfx.control.textfield.TextFields

/**
 * Create a new auto-completion binding between the given [TextField] using the given auto-complete
 * suggestions.
 */
public inline fun <T> TextField.bindAutoCompletion(
    vararg possibleSuggestions: T,
): AutoCompletionBinding<T> = TextFields.bindAutoCompletion(this, *possibleSuggestions)

/** Alias of [bindAutoCompletion] with collection input. */
public inline fun <T> TextField.bindAutoCompletion(
    possibleSuggestions: Collection<T>,
): AutoCompletionBinding<T> = TextFields.bindAutoCompletion(this, possibleSuggestions)

/**
 * Create a new auto-completion binding between the given [TextField] and the given suggestion
 * provider.
 */
public inline fun <T> TextField.bindAutoCompletion(
    noinline suggestionProvider: (AutoCompletionBinding.ISuggestionRequest) -> Collection<T>,
): AutoCompletionBinding<T> = TextFields.bindAutoCompletion(this, suggestionProvider)

/**
 * Create a new auto-completion binding between the given [TextField] and the given suggestion
 * provider.
 */
public inline fun <T> TextField.bindAutoCompletion(
    converter: StringConverter<T>,
    noinline suggestionProvider: (AutoCompletionBinding.ISuggestionRequest) -> Collection<T>,
): AutoCompletionBinding<T> = TextFields.bindAutoCompletion(this, suggestionProvider, converter)
