plugins {
    id("org.jetbrains.kotlin.jvm") version "{{versions.kotlin.value}}"
    id("org.jetbrains.kotlin.kapt") version "{{versions.kotlin.value}}"
    id("org.jetbrains.kotlin.plugin.allopen") version "{{versions.kotlin.value}}"
    {{#server.micronaut}}
    id("io.micronaut.application") version "{{versions.micronaut_application.value}}"
    {{/server.micronaut}}
    id("io.specgen.gradle") version "{{versions.specgen.value}}"
}

group = "{{groupid.value}}"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:{{versions.kotlin.value}}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:{{versions.kotlin.value}}")

    {{#server.micronaut}}
    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("jakarta.annotation:jakarta.annotation-api")
    runtimeOnly("org.slf4j:slf4j-simple")
    {{/server.micronaut}}
}

application {
    mainClass.set("{{package.value}}.{{mainclass.value}}Kt")
}

java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

specgen {
    serviceKotlin {
        packageName.set("{{package.value}}")
        server.set("{{server.value}}")
        specFile.set(file("spec.yaml"))
        servicesPath.set(file("src/main/kotlin"))
        {{#swagger.value}}
        swaggerPath.set(file("src/main/resources/static/docs/swagger.yaml"))
        {{/swagger.value}}
    }
}

{{#server.micronaut}}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("{{package.value}}.*")
    }
}
{{/server.micronaut}}