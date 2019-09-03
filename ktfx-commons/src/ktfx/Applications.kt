@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.application.Application
import kotlin.reflect.KClass

/** Launch a JavaFX application with Kotlin class. */
inline fun <T : Application> launch(type: KClass<T>, vararg args: String): Unit =
    Application.launch(type.java, *args)

/** Launch a JavaFX application with reified type. */
inline fun <reified T : Application> launch(vararg args: String): Unit =
    launch(T::class, *args)
