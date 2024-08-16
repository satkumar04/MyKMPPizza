import Versions.KTOR_VERSION

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version Versions.KOTLIN_VERSION
}

kotlin {
    jvm()
    //androidTarget()
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            // Ktor
            implementation(Versions.Common.KTOR_CLIENT_CORE)
            implementation(Versions.Common.KTOR_LOGGING)
            implementation(Versions.Common.KTOR_CLIENT_JSON)
            implementation(Versions.Common.KTOR_CLIENT_SERIALIZATION)
            implementation("io.ktor:ktor-serialization-kotlinx-json:$KTOR_VERSION")
            implementation(Versions.Jvm.SERIALIZE)
            implementation(libs.ktor.client.content.negotiation)

            // Coroutines
            implementation(Versions.Common.COROUTINES) {
                version {
                    strictly(Versions.COROUTINES_MT)
                }
            }

            api(Versions.Common.KOIN_CORE)


        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation(Versions.Android.KTOR_CLIENT)
            implementation(Versions.Android.KTOR_OKHTTP)
            implementation(Versions.Android.VIEW_MODEL)
            //implementation(Versions.Android.VIEW_MODEL_UTIL)
        }

        iosMain.dependencies {
            implementation(Versions.iOS.KTOR_CLIENT)
        }
    }
}

android {
    namespace = "com.example.mypizzakmp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

