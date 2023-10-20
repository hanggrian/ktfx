val developerId: String by project
val developerName: String by project
val developerUrl: String by project
val releaseArtifact: String by project
val releaseDescription: String by project
val releaseUrl: String by project

plugins {
    alias(libs.plugins.pages)
    alias(libs.plugins.git.publish)
}

pages {
    resources.from("$rootDir/build/dokka/")
    styles.add("https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism-tomorrow.min.css")
    scripts.addAll(
        "https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js",
        "https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/components/prism-groovy.min.js",
        "https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/components/prism-kotlin.min.js"
    )
    minimal {
        authorName = developerName
        authorUrl = developerUrl
        projectName = releaseArtifact
        projectDescription = releaseDescription
        projectUrl = releaseUrl
        button("View\nDocumentation", "dokka")
    }
}

gitPublish {
    repoUri.set("git@github.com:$developerId/$releaseArtifact.git")
    branch.set("gh-pages")
    contents.from(pages.outputDirectory)
}

tasks {
    register(LifecycleBasePlugin.CLEAN_TASK_NAME) {
        delete(buildDir)
    }
    deployPages {
        dependsOn(":dokkaHtmlMultiModule")
    }
}
