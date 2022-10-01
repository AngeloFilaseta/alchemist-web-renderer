@file:Suppress("UnstableApiUsage", "UnusedPrivateMember")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    application
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotest.multiplatform)
    alias(libs.plugins.dokka)
    alias(libs.plugins.gitSemVer)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.taskTree)
}

repositories {
    google()
    mavenCentral()
}

kotlin {
    jvm {
        withJava()
    }
    js(IR) {
        browser {
            binaries.executable()
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlin.stdlib)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.bundles.kotlin.testing.common)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.bundles.alchemist)
                implementation(libs.bundles.ktor.server)
                implementation(libs.logback.classic)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(libs.bundles.kotlin.testing.jvm)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(libs.bundles.ktor.client)
                implementation(project.dependencies.enforcedPlatform(libs.kotlin.wrappers.bom))
                implementation(libs.bundles.kotlin.react)
            }
        }
    }

    targets.all {
        compilations.all {
            kotlinOptions {
                allWarningsAsErrors = true
            }
        }
    }
}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
    filter {
        isFailOnNoMatchingTests = false
    }
    testLogging {
        showExceptions = true
        showStandardStreams = true
        events = setOf(
            org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
            org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
        )
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

application {
    mainClass.set("it.unibo.alchemist.Alchemist")
}

tasks.getByName<JavaExec>("run") {
    args(
        "--batch",
        "--yaml",
        rootProject.projectDir.absolutePath + "/src/commonTest/resources/yaml/sapere.yml"
    )
    classpath(tasks.getByName<Jar>("jvmJar"))
}

// include JS artifacts in any JAR we generate
tasks.getByName<Jar>("jvmJar") {
    val mode = if (project.hasProperty("isProduction") ||
        project.gradle.startParameter.taskNames.contains("installDist")
    ) {
        "Production"
    } else {
        "Development"
    }
    val taskName = "jsBrowser${mode}Webpack"
    val webpackTask = tasks.getByName<org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack>(taskName)
    dependsOn(webpackTask) // JS is compiled first
    from(File(webpackTask.destinationDirectory, webpackTask.outputFileName))
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
