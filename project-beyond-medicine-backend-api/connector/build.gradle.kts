plugins {
    id("spring-common-conventions")
    kotlin("kapt")
}

dependencies {
    implementation(project(":project-beyond-medicine-backend-api:application"))

    implementation(project(":commons:core"))

    implementation(libs.bundles.project.beyond.medicine.backend.connector)
    kapt(libs.bundles.project.beyond.medicine.backend.connector.kapt)
}

allprojects {
    tasks.matching { it.name.contains("kapt") }.configureEach {
        enabled = false
    }
}