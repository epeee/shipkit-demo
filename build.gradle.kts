buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.shipkit:shipkit:2.2.5")
    }
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
        testImplementation(platform("org.junit:junit-bom:$junitJupiterVersion"))
        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    group = "io.github.epeee.shipkit-demo"

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

tasks.named<Wrapper>("wrapper") {
    gradleVersion = "6.0.1"
    distributionSha256Sum = "d364b7098b9f2e58579a3603dc0a12a1991353ac58ed339316e6762b21efba44"
}
