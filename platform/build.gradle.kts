import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    id("com.android.library")
    id("dev.buijs.klutter")
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.6.10"
}

version = "1.0"

klutter {
    root = rootProject.rootDir
    plugin {
       name = "batterylevel"
    }

    include("annotations")

}

kotlin {

    android()

    val xcfName = "Platform"
    val xcFramework = XCFramework(xcfName)

    ios {
       binaries.framework {
            baseName = xcfName
            xcFramework.add(this)
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
            xcFramework.add(this)
        }
    }

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
            }
        }

        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }

        val iosMain by getting
        val iosSimulatorArm64Main by getting {
           dependsOn(iosMain)
        }

        val iosTest by getting
        val iosSimulatorArm64Test by getting {
           dependsOn(iosTest)
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].kotlin { srcDirs("src/androidMain/kotlin") }
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
}