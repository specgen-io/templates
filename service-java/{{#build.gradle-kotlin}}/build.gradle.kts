plugins {
    id("java")
    {{#server.spring}}
    id("org.springframework.boot") version "{{versions.spring_boot.value}}"
    id("io.spring.dependency-management") version "{{versions.spring_dependency.value}}"
    {{/server.spring}}
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
    {{#server.spring}}
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    {{#jsonlib.moshi}}
    implementation("com.google.code.findbugs:jsr305:{{versions.jsr305.value}}")
    implementation("com.squareup.moshi:moshi:{{versions.moshi.value}}")
    implementation("com.squareup.moshi:moshi-adapters:{{versions.moshi.value}}")
    {{/jsonlib.moshi}}
    {{#swagger.value}}
    implementation("io.springfox:springfox-boot-starter:{{versions.springfox.value}}")
    {{/swagger.value}}
    {{/server.spring}}
    {{#server.micronaut}}
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut:micronaut-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    runtimeOnly("org.slf4j:slf4j-simple")
    implementation("io.micronaut:micronaut-jackson-databind")
    {{#swagger.value}}
    implementation("io.swagger.core.v3:swagger-annotations")
    {{/swagger.value}}
    {{/server.micronaut}}
}

{{#server.micronaut}}
application {
    mainClass.set("{{package.value}}.{{mainclass.value}}")
}
{{/server.micronaut}}

java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

specgen {
    serviceJava {
        {{^server.micronaut}}
        jsonlib.set("{{jsonlib.value}}")
        {{/server.micronaut}}
        packageName.set("{{package.value}}")
        server.set("{{server.value}}")
        specFile.set(file("spec.yaml"))
        servicesPath.set(file("src/main/java"))
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
