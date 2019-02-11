buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.shipkit:shipkit:2.0.31")
    }
}

plugins {
    id("com.gradle.build-scan") version "2.1"
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
        plugin("java")
    }

    val junitJupiterVersion = "5.4.0"

    val testRuntimeOnly by configurations
    val testCompile by configurations

    dependencies {
        testCompile("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    }

    group = "io.github.epeee.shipkit-demo"

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

tasks.named<Wrapper>("wrapper") {
    gradleVersion = "5.2.1"
    distributionSha256Sum = "748c33ff8d216736723be4037085b8dc342c6a0f309081acf682c9803e407357"
}
