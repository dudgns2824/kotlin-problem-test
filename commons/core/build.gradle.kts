plugins {
    id("spring-common-conventions")
}

dependencies {
    implementation(libs.bundles.commons.common)
    testImplementation(libs.bundles.test.junit)

    testImplementation(libs.bundles.test.kotest)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}