@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.controls

import javafx.scene.control.TextField
import javafx.util.StringConverter
import org.controlsfx.control.textfield.AutoCompletionBinding
import org.controlsfx.control.textfield.TextFields

/** Create a new auto-completion binding between the given [TextField] using the given auto-complete suggestions. */
inline fun <T> TextField.bindAutoCompletion(vararg possibleSuggestions: T): AutoCompletionBinding<T> =
    TextFields.bindAutoCompletion(this, *possibleSuggestions)

/** Alias of [bindAutoCompletion] with collection input. */
inline fun <T> TextField.bindAutoCompletion(possibleSuggestions: Collection<T>): AutoCompletionBinding<T> =
    TextFields.bindAutoCompletion(this, possibleSuggestions)

/** Create a new auto-completion binding between the given [TextField] and the given suggestion provider. */
inline fun <T> TextField.bindAutoCompletion(
    crossinline suggestionProvider: (AutoCompletionBinding.ISuggestionRequest) -> Collection<T>
): AutoCompletionBinding<T> = TextFields.bindAutoCompletion(this) { suggestionProvider(it) }

/** Create a new auto-completion binding between the given [TextField] and the given suggestion provider. */
inline fun <T> TextField.bindAutoCompletion(
    converter: StringConverter<T>,
    crossinline suggestionProvider: (AutoCompletionBinding.ISuggestionRequest) -> Collection<T>
): AutoCompletionBinding<T> = TextFields.bindAutoCompletion(this, { suggestionProvider(it) }, converter)
