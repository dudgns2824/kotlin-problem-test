plugins {
    id("spring-common-conventions")

    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("kapt")
}

dependencies {
    api(project(":domains:domain-user"))

    implementation(project(":commons:core"))
    implementation(project(":domains:domain-prescription-client"))

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

    testImplementation(testFixtures(project(":modules:adapter-testfixture-db")))
}
