plugins {
    id("spring-common-conventions")

    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("kapt")
}

dependencies {
    implementation(project(":commons:core"))

    implementation(libs.bundles.project.beyond.medicine.backend.adapter.data.jpa)
    implementation(libs.spring.data.querydsl.jpa) {
        artifact {
            classifier = "jakarta"
        }
    }

    kapt(libs.bundles.project.beyond.medicine.backend.adapter.data.jpa.kapt)
    kapt(libs.spring.data.querydsl.apt) {
        artifact {
            classifier = "jakarta"
        }
    }

    testImplementation(libs.bundles.project.beyond.medicine.backend.adapter.data.jpa.test)
    testImplementation(libs.bundles.test.junit)
}