package ktfx.coroutines.internal;

import javafx.util.Callback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public final class Callbacks {

    private Callbacks() {
        // no instance
    }

    /**
     * Kotlin can't have return type of {@link Void} when used as generics.
     *
     * @param function that should be invoked as function type.
     * @param <P>      param that is brought by callback.
     * @return callback with no return value.
     */
    @NotNull
    public static <P> Callback<P, Void> noReturn(@NotNull Function1<P, Unit> function) {
        return param -> {
            function.invoke(param);
            return null;
        };
    }
}