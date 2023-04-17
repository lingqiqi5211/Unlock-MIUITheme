@file:Suppress("UnstableApiUsage")
@file:SuppressLint("ChromeOsAbiSupport")

import android.annotation.SuppressLint
import com.android.build.gradle.internal.api.BaseVariantOutputImpl

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 33
    buildToolsVersion = "33.0.2"
    namespace = "com.yuk.fuckMiuiThemeManager"
    defaultConfig {
        applicationId = namespace
        minSdk = 30
        targetSdk = 33
        versionCode = 17
        versionName = "1.7.2-for 0.07"
        ndk.abiFilters += "arm64-v8a"
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            setProguardFiles(listOf("proguard-rules.pro", "proguard-log.pro"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    packaging {
        resources {
            excludes += "/META-INF/**"
            excludes += "/kotlin/**"
            excludes += "/*.json"
        }
        dex {
            useLegacyPackaging = true
        }
        applicationVariants.all {
            outputs.all {
                (this as BaseVariantOutputImpl).outputFileName =
                    "FuckMiuiThemeManager-$versionName.apk"
            }
        }
    }
}

dependencies {
    compileOnly("de.robv.android.xposed:api:82")
    implementation("com.github.kyuubiran:EzXHelper:1.0.3")
    implementation("org.luckypray:DexKit:1.1.4")
}