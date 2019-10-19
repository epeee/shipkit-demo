rootProject.name = "shipkit-demo"

include("api")
include("impl")

enableFeaturePreview("GRADLE_METADATA")

plugins {
    id("com.gradle.enterprise").version("3.0")
}
