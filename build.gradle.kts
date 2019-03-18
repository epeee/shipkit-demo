buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.shipkit:shipkit:2.2.0")
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

    val junitJupiterVersion = "5.4.1"

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
    gradleVersion = "5.3-rc-3"
    distributionSha256Sum = "63b7114caa8629f5dc3074aab09b87476fbfba548ea20aefe97068287621acb7"
}
