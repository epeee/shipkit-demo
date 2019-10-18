buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.shipkit:shipkit:2.2.5")
    }
}

plugins {
    id("com.gradle.build-scan") version "2.4.2"
}

apply {
    plugin("org.shipkit.java")
}

buildScan {
    publishAlwaysIf(System.getenv("CI") != null)
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
}

subprojects {
    repositories {
        jcenter()
    }

    apply {
        plugin("java-library")
    }

    val junitJupiterVersion = "5.5.2"

    val testRuntimeOnly by configurations
    val testImplementation by configurations

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    }

    group = "io.github.epeee.shipkit-demo"

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

tasks.named<Wrapper>("wrapper") {
    gradleVersion = "5.6.3"
    distributionSha256Sum = "60a6d8f687e3e7a4bc901cc6bc3db190efae0f02f0cc697e323e0f9336f224a3"
}
