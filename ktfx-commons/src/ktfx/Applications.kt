package ktfx

import javafx.application.Application

/** Launch a JavaFX application with reified type. */
inline fun <reified T : Application> launchApplication(vararg args: String): Unit =
    Application.launch(T::class.java, *args)