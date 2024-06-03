import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun properties(key: String) = project.findProperty(key).toString()

plugins {
    // Java support
    id("java")
    id("java-library")
    // Kotlin support
    id("org.jetbrains.kotlin.jvm") version "1.9.23"
    // Gradle IntelliJ Plugin
    id("org.jetbrains.intellij") version "1.17.2"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.23"
//    kotlin("jvm")
}

group = "com.example"
version = "1.0-SNAPSHOT"

allprojects {
    apply{
        plugin("org.jetbrains.intellij")
    }
    repositories {
        mavenCentral()
        maven { url = uri("https://cache-redirector.jetbrains.com/repo.maven.apache.org/maven2") }
        maven { url = uri("https://packages.jetbrains.team/maven/p/ij/intellij-dependencies") }
    }
    // Configure Gradle IntelliJ Plugin - read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
    intellij {
        pluginName.set(properties("pluginName"))
        version.set(properties("platformVersion"))
        type.set(properties("platformType"))

        // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
        plugins.set(properties("platformPlugins").split(',').map(String::trim).filter(String::isNotEmpty))
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.22.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation(kotlin("stdlib-jdk8"))
}

