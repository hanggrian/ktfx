package kotfx.internal;

import javafx.util.Callback;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public final class Interops {

    private Interops() {
    }

    @NotNull
    public static <T> Callback<T, Void> asCallback(@NotNull Consumer<T> consumer) {
        return param -> {
            consumer.accept(param);
            return null;
        };
    }
}