plugins {
    id("spring-common-conventions")

    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("kapt")
}

dependencies {
    api(project(":domains:domain-prescription"))
    api(project(":domains:domain-user"))
    implementation(project(":commons:core"))

    implementation(libs.spring.data.querydsl.jpa) {
        artifact {
            classifier = "jakarta"
        }
    }
    kapt(libs.spring.data.querydsl.apt) {
        artifact {
            classifier = "jakarta"
        }
    }
    kapt(libs.bundles.domains.common.kapt)
    implementation(libs.bundles.domains.common)

    testImplementation(libs.bundles.domains.common.test)
}
