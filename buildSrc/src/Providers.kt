import org.gradle.api.artifacts.Configuration
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope

operator fun <T> Provider<T>.invoke(): T = get()

operator fun Provider<Configuration>.invoke(scope: DependencyHandlerScope, dependency: Any): Unit = scope.run {
    this@invoke()(dependency)
}