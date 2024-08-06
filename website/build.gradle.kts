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
    resources.from("src", "$rootDir/build/dokka/")
    styles.add("styles/prism-tomorrow.css")
    scripts.addAll(
        "https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js",
        "https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/components/prism-gradle.min.js",
        "https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/components/prism-kotlin.min.js",
    )
    languageAliases.put("kt", "kotlin")
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
        delete(layout.buildDirectory)
    }
    deployPages {
        dependsOn(":dokkaHtmlMultiModule")
    }
}
