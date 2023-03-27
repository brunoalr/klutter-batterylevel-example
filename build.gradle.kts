buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://repsy.io/mvn/buijs-dev/klutter") }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("dev.buijs.klutter:kore:2022.r6-9.alpha")
        classpath("dev.buijs.klutter:klutter-gradle:2022.r6-9.alpha")
    }
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    maven { url = uri("https://repsy.io/mvn/buijs-dev/klutter") }
}

allprojects {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven {
            url = uri("https://repsy.io/mvn/buijs-dev/klutter")
        }
    }

}
