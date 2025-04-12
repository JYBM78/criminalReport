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
    maven {
        url = uri("https://jitpack.io")
    }

    dependencies {
        implementation("com.cloudinary:cloudinary-http45:1.39.0")
        implementation("org.simplejavamail:simple-java-mail:8.12.5")
        implementation("org.simplejavamail:batch-module:8.12.5")
        implementation("org.springframework.boot:spring-boot-starter-mail")
        implementation("org.springframework.boot:spring-boot-starter-web") // Dependencia para tener acceso a código ya hecho y enjfocarnos más en la parte lógica y no en la configuración del proyecto
        implementation("org.springframework.boot:spring-boot-starter-websocket")
        implementation("org.springframework.boot:spring-boot-starter-validation") // Dependencia para validaciones
        //implementation("org.springframework.boot:spring-boot-starter-security") // Esta dependencia activa por defecto una seguridad básica con autenticación HTTP (usuario/contraseña) cuando no se configura nada explícitamente.
        implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.0") // Dependencia para @SecurityRequirement(name = "bearerAuth")
        implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.mapstruct:mapstruct:1.6.3")
        annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
        annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
        compileOnly("org.projectlombok:lombok") // Dependencia que evita código repetitivo de Java
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test") // Dependencia para pruebas unitarias
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        testImplementation("org.mockito:mockito-core")
        testImplementation("org.mockito:mockito-junit-jupiter")

        implementation("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
