import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")

}

kotlin {

    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
            systemProperty("java.library.path", File(buildDir, "/bin/native/releaseShared"))
        }
    }


    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }
    sourceSets {
    val commonMain by getting{
        dependencies{

        }
    }
    val commonTest by getting {
        dependencies {
            implementation(kotlin("test"))
            }
        }
        val nativeMain by getting
        val nativeTest by getting
    }

}