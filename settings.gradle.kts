plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "backend"

// commons
include(
    ":commons:core",
)

// domains
include(
    ":domains:domain-user",
    ":domains:domain-user-client",
    ":domains:domain-prescription",
    ":domains:domain-prescription-client",
)
// project
include(
    ":project-beyond-medicine-backend-api:adapter-data-jpa",
    ":project-beyond-medicine-backend-api:application",
    ":project-beyond-medicine-backend-api:bootstrap",
    ":project-beyond-medicine-backend-api:connector",
)

// modules
include(
    ":modules:adapter-testfixture-db",
)