package ktfx.application

import javafx.application.Application

/** Launch a JavaFX application with reified type. */
inline fun <reified T : Application> launch(vararg args: String): Unit = Application.launch(T::class.java, *args)