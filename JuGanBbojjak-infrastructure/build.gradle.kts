plugins {
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.spring") version "1.9.20"
    kotlin("plugin.jpa") version "1.9.20"
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2022.0.2")
    }
}

dependencies {
    implementation(project(":JuGanBbojjak-application"))

    // Jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // security
    implementation("org.springframework.boot:spring-boot-starter-security")

    // validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Web
    implementation("org.springframework.boot:spring-boot-starter-web")

    //Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.jetbrains.kotlin:kotlin-reflect")

    //Jwt
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")

    // querydsl
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
    kapt("jakarta.annotation:jakarta.annotation-api")
    kapt("jakarta.persistence:jakarta.persistence-api")

    runtimeOnly("com.mysql:mysql-connector-j")

    // swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
}

noArg {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
}
