const val VERSION_GIT_PUBLISH = "2.1.3"

fun org.gradle.api.artifacts.dsl.DependencyHandler.gitPublish() =
    "org.ajoberstar:gradle-git-publish:$VERSION_GIT_PUBLISH"

val org.gradle.plugin.use.PluginDependenciesSpec.`git-publish`
    get() = id("org.ajoberstar.git-publish")