plugins {
    `java-library`

    kotlin("jvm")
}

val libs: VersionCatalog = versionCatalogs.named("libs")
dependencies {
    implementation(libs.findBundle("commons-base").get())
    testImplementation(libs.findBundle("commons-base-kotest").get())
    implementation(libs.findLibrary("jackson-module-kotlin").get())
}


repositories {
    mavenCentral()
}

tasks.named<Test>("test") {
    description = "Runs the total tests."
    useJUnitPlatform()
}

tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.named<Jar>("jar") {
    enabled = true
}

val applicationGroup: String = project.findProperty("application.group").toString()
val applicationGroupName: String = project.findProperty("application.group.name").toString()
val applicationName: String = project.findProperty("application.name").toString()
val applicationVersion: String = project.findProperty("application.version").toString()
val currentTaskName = project.gradle.startParameter.taskNames.firstOrNull()

tasks.named<Jar>("jar") {
    enabled = true
    archiveBaseName = applicationName
    archiveVersion = applicationVersion
    archiveFileName = "$applicationGroupName-$applicationName-$applicationVersion.jar"

    if (currentTaskName == "bootJar" || currentTaskName == "jar") {
        exclude("**/application**-env.yml")
    }
}
