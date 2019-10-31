package ktfx.internal;

import javafx.util.Callback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

final class Utils {

    private Utils() {
    }

    @NotNull
    static <P> Callback<P, Void> noReturn(@NotNull Function1<P, Unit> function) {
        return param -> {
            function.invoke(param);
            return null;
        };
    }
}