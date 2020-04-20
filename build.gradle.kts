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

    val junitJupiterVersion = "5.7.0-M1"

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
    gradleVersion = "6.4-rc-1"
    distributionSha256Sum = "f8e14fc40ebc468d578601cfeaef402844048ff8fc727d452e6b28922c53459c"
}
