import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

java.sourceSets.getByName("main").java.srcDir("src")