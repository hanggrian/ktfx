package ktfx.internal;

import javafx.util.Callback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

final class CallbackUtils {

    private CallbackUtils() {
    }

    @NotNull
    static <P> Callback<P, Void> noReturn(@NotNull final Function1<P, Unit> function) {
        return param -> {
            function.invoke(param);
            return null;
        };
    }
}