plugins {
    alias(drawingPadLibs.plugins.kotlinMultiplatform)
    alias(drawingPadLibs.plugins.androidKotlinMultiplatformLibrary)
    alias(drawingPadLibs.plugins.androidLint)
    alias(drawingPadLibs.plugins.composeMultiplatform)
    alias(drawingPadLibs.plugins.composeCompiler)
}

kotlin {

    androidLibrary {
        namespace = "com.wiswm.drawing_pad"
        compileSdk = 36
        minSdk = 24

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    val xcfName = "drawing-padKit"

    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(drawingPadLibs.kotlin.stdlib)
                implementation(compose.material3)
                implementation(compose.components.resources)
            }
        }

        commonTest {
            dependencies {
                implementation(drawingPadLibs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                implementation(drawingPadLibs.androidx.activity.compose)
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(drawingPadLibs.androidx.runner)
                implementation(drawingPadLibs.androidx.core)
                implementation(drawingPadLibs.androidx.testExt.junit)
            }
        }

        iosMain {
            dependencies {
            }
        }
    }
}