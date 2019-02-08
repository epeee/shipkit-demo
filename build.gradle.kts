import com.gradle.scan.plugin.BuildScanExtension

buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.shipkit:shipkit:2.0.31")
        classpath("com.gradle:build-scan-plugin:2.1")
    }
}

apply {
    plugin("com.gradle.build-scan")
    plugin("org.shipkit.java")
}

configure<BuildScanExtension> {
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
    gradleVersion = "5.0"
    distributionSha256Sum = "6157ac9f3410bc63644625b3b3e9e96c963afd7910ae0697792db57813ee79a6"
}
