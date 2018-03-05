package kotlinfx.coroutines.internal;

import javafx.util.Callback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/**
 * Some Java just can't be written in Kotlin, this utility class should take care of it.
 */
public final class Interoperability {

    private Interoperability() {
    }

    /**
     * Kotlin can't have return type {@link Void}.
     *
     * @param function that should be invoked as function type.
     * @param <P>      param that is brought by {@link Callback}.
     * @return {@link Callback} with no return value.
     */
    @NotNull
    public static <P> Callback<P, Void> asCallback(@NotNull Function1<P, Unit> function) {
        return param -> {
            function.invoke(param);
            return null;
        };
    }
}