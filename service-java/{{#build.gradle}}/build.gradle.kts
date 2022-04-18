plugins {
    id("java")
    id("org.springframework.boot") version "{{versions.spring_boot.value}}"
    id("io.spring.dependency-management") version "{{versions.spring_dependency.value}}"
    id("io.specgen.gradle")
}

group = "{{group_id.value}}"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.google.code.findbugs:jsr305:{{versions.jsr305.value}}")
    {{#jsonlib.moshi}}
    implementation("com.squareup.moshi:moshi:{{versions.moshi.value}}")
    implementation("com.squareup.moshi:moshi-adapters:{{versions.moshi.value}}")
    implementation("com.squareup.moshi:moshi-kotlin:{{versions.moshi.value}}")
    {{/jsonlib.moshi}}
    implementation("jakarta.annotation:jakarta.annotation-api:{{versions.jakarta.value}}")
    {{#swagger.value}}
    implementation("io.springfox:springfox-boot-starter:{{versions.springfox.value}}")
    {{/swagger.value}}
}

java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

specgen {
    serviceJava {
        jsonlib.set("{{jsonlib.value}}")
        packageName.set("{{package_name.value}}")
        server.set("{{server.value}}")
        specFile.set(file("../spec.yaml"))
        servicesPath.set(file("src/main/java"))
        {{#swagger.value}}
        swaggerPath.set(file("src/main/resources/static/docs/swagger.yaml"))
        {{/swagger.value}}
    }
}
