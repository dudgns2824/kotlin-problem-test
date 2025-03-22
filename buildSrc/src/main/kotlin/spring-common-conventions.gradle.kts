import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("base-common-conventions")
    id("org.springframework.boot")
    id("io.spring.dependency-management")

    kotlin("plugin.spring")
}

dependencies {
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = JavaVersion.VERSION_17.majorVersion
    }
}

tasks.named<BootJar>("bootJar") {
    enabled = false
}

tasks.named<BootRun>("bootRun") {
    enabled = false
}

// 유닛 테스트
tasks.register<Test>("unitTest") {
    group = "verification"
    description = "Runs the unit tests."
    useJUnitPlatform {
        includeTags = setOf("UnitTest")
        excludeTags = setOf("IntegrationTest")
    }
}

// 통합 테스트
tasks.register<Test>("integrationTest") {
    group = "verification"
    description = "Runs the integration tests."
    useJUnitPlatform {
        includeTags = setOf("IntegrationTest")
        excludeTags = setOf("UnitTest")
    }
}
