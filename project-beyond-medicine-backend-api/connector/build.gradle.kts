plugins {
    id("spring-common-conventions")
    id("java-test-fixtures")

    kotlin("kapt")
}

dependencies {
    implementation(project(":project-beyond-medicine-backend-api:application"))

    implementation(project(":commons:core"))

    implementation(project(":domains:domain-user"))

    implementation(libs.bundles.project.beyond.medicine.backend.connector)
    kapt(libs.bundles.project.beyond.medicine.backend.connector.kapt)

    testImplementation(testFixtures(project(":modules:adapter-testfixture-db")))
}

allprojects {
    tasks.matching { it.name.contains("kapt") }.configureEach {
        enabled = false
    }
}