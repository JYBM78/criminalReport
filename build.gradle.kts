/*
En este archivo se añaden las dependencias, cambiando configuraciones
o añadiendo repositorios.
*/

plugins {
    java
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7" // Gestor de dependencias
}

group = "co.edu.uniquindio"
version = "0.0.1-SNAPSHOT"
description = "plataforma que permita a los ciudadanos reportar" +
        " de manera sencilla y eficiente situaciones de riesgo o emergencia en su entorno."

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21) // Versión de Java
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web") // Dependencia para tener acceso a código ya hecho y enjfocarnos más en la parte lógica y no en la configuración del proyecto
    implementation("org.springframework.boot:spring-boot-starter-validation") // Dependencia para validaciones
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.0") // Dependencia para @SecurityRequirement(name = "bearerAuth")
    implementation ("org.springframework.boot:spring-boot-starter-data-mongodb")

    compileOnly("org.projectlombok:lombok") // Dependencia que evita código repetitivo de Java
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test") // Dependencia para pruebas unitarias
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation ("org.projectlombok:lombok")
    annotationProcessor ("org.projectlombok:lombok")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
