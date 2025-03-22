plugins {
    id("spring-common-conventions")

    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("kapt")
}

dependencies {
    implementation(project(":project-beyond-medicine-backend-api:adapter-data-jpa"))
    implementation(project(":project-beyond-medicine-backend-api:connector"))
    implementation(project(":project-beyond-medicine-backend-api:application"))

    implementation(project(":commons:core"))

    implementation(libs.bundles.project.beyond.medicine.backend.bootstrap)
}