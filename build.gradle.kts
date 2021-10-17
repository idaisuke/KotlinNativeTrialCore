plugins {
    kotlin("multiplatform") version "1.5.31"
}

group = "me.daisuke"
version = "1.0-SNAPSHOT"

val hostOs = System.getProperty("os.name")
val isMingwX64 = hostOs.startsWith("Windows")
val isMacOS = hostOs == "Mac OS X"

repositories {
    mavenCentral()
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "KotlinNativeTrialCore"
            }
        }
    }
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }
    js(LEGACY) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }

    val nativeTarget = when {
        isMacOS -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}

if (isMacOS) {
    val cleanXCFramework by tasks.registering(Delete::class) {
        delete("xcframework")
    }

    val createXCFramework by tasks.registering(Exec::class) {
        commandLine(
            "xcodebuild", "-create-xcframework",
            "-framework", "build/bin/iosArm64/releaseFramework/KotlinNativeTrialCore.framework",
            "-framework", "build/bin/iosX64/releaseFramework/KotlinNativeTrialCore.framework",
            "-output", "xcframework/KotlinNativeTrialCore.xcframework"
        )
    }

    tasks {
        createXCFramework {
            dependsOn(cleanXCFramework)
        }
    }
}
