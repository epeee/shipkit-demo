buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.shipkit:shipkit:2.1.8")
    }
}

plugins {
    id("com.gradle.build-scan") version "2.2.1"
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

    val junitJupiterVersion = "5.4.0"

    val testRuntimeOnly by configurations
    val testImplementation by configurations

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    }

    group = "io.github.epeee.shipkit-demo"

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

tasks.named<Wrapper>("wrapper") {
    gradleVersion = "5.3-rc-2"
    distributionSha256Sum = "4110201a819b28600bfe06ef02950c6b749616c2197ed0da2514451a378c709b"
}
