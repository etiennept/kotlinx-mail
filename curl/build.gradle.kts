plugins {
    kotlin("multiplatform")
}

group = "com.sum.kmail"
version = "1.0-SNAPSHOT"

kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }
    nativeTarget.compilations["main"].apply{
        cinterops.create("libcurl") {
            //includeDirs("usr/include/curl")
            //includeDirs("usr/include")
        }
    }

    sourceSets {

        val nativeMain by getting{
            dependencies {
                implementation(project(":core"))
            }
        }
        val nativeTest by getting
    }
}
