package ktfx.controlsfx.controls

import javafx.scene.control.TextField
import javafx.util.StringConverter
import org.controlsfx.control.textfield.AutoCompletionBinding
import org.controlsfx.control.textfield.TextFields

fun <T> TextField.bindAutoCompletion(vararg possibleSuggestions: T): AutoCompletionBinding<T> =
    TextFields.bindAutoCompletion(this, *possibleSuggestions)

fun <T> TextField.bindAutoCompletion(possibleSuggestions: Collection<T>): AutoCompletionBinding<T> =
    TextFields.bindAutoCompletion(this, possibleSuggestions)

fun <T> TextField.bindAutoCompletion(
    suggestionProvider: (AutoCompletionBinding.ISuggestionRequest) -> Collection<T>
): AutoCompletionBinding<T> = TextFields.bindAutoCompletion(this, suggestionProvider)

fun <T> TextField.bindAutoCompletion(
    suggestionProvider: (AutoCompletionBinding.ISuggestionRequest) -> Collection<T>,
    converter: StringConverter<T>
): AutoCompletionBinding<T> = TextFields.bindAutoCompletion(this, suggestionProvider, converter)
