

group = "com.sum.kmail"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}
buildscript {
    repositories {
        gradlePluginPortal()

        mavenCentral()
    }
    dependencies {

        classpath(kotlin("gradle-plugin", version = "1.6.10"))

    }
}