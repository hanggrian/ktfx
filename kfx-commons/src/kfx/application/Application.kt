package kfx.application

import com.sun.javafx.application.LauncherImpl.launchApplication
import javafx.application.Application
import javafx.application.Application.launch
import javafx.application.Preloader

inline fun <reified A : Application> deploy(
    vararg args: String
) = launch(A::class.java, *args)

inline fun <reified A : Application, reified P : Preloader> deployWithPreloader(
    vararg args: String
) = launchApplication(A::class.java, P::class.java, args)