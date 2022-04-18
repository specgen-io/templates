pluginManagement {
    repositories {
        maven("https://specgen.jfrog.io/artifactory/maven") {
            credentials {
                username = System.getProperty("jfrog.user")
                password = System.getProperty("jfrog.pass")
            }
        }

        mavenLocal()
        gradlePluginPortal()
    }

    plugins {
        id("io.specgen.gradle") version "{{versions.specgen.value}}"
    }
}

rootProject.name = "{{project_name.value}}"
