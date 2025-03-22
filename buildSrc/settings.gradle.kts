rootProject.name = "buildSrc"

dependencyResolutionManagement {
    versionCatalogs { //libs.versions.toml 로드
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}