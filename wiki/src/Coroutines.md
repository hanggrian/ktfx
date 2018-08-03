Similar to `KtFX Commons`, `KtFX Coroutines` contains only extension functions
for invoking JavaFX handlers. This includes `EventHandler` and `Callback` that
returns null.

General rules:
 * No instances (class, interface, object, etc.), just extension functions.
 * All classes are packaged under `ktfx.styles`.