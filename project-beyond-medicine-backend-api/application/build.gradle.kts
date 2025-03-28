plugins {
    id("spring-common-conventions")
    kotlin("kapt")
}

dependencies {
    implementation(project(":commons:core"))

    implementation(project(":domains:domain-user"))
    implementation(project(":domains:domain-prescription"))

    implementation(libs.bundles.project.beyond.medicine.backend.application)
}