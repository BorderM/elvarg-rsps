import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm) apply true
    alias(libs.plugins.kotlin.serialization)
    idea
}

allprojects {
    apply(plugin = "idea")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

    group = "com.elvarg"
    version = "0.0.1"

    repositories {
        mavenLocal()
        mavenCentral()
    }

    val lib = rootProject.project.libs
    dependencies {
        with(lib) {
            implementation(gson)
            implementation(guava)
            implementation(progress.bar)
            implementation(inline.loggerr)
            implementation(kotlin.logging)
            implementation(kotlinx.coroutines)
            implementation(kotlin.script.runtime)
            implementation(kotlin.scripting)
            implementation(kotlin.reflect)
            implementation("org.litote.kmongo:kmongo-coroutine-serialization:4.5.0")
            implementation("org.jetbrains.kotlin:kotlin-scripting-common:1.9.10")
            implementation("org.jetbrains.kotlin:kotlin-scripting-jvm:1.9.10")
            implementation("org.jetbrains.kotlin:kotlin-scripting-jvm-host:1.9.10")
            implementation("org.jetbrains.kotlin:kotlin-scripting-dependencies:1.9.10")
            implementation("org.jetbrains.kotlin:kotlin-scripting-dependencies-maven:1.9.10")
        }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
    kotlin{
        jvmToolchain{
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    idea {
        module {
            inheritOutputDirs = false
            outputDir = file("${project.buildDir}/classes/kotlin/main")
            testOutputDir = file("${project.buildDir}/classes/kotlin/test")
        }
    }

    tasks.compileJava {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }

    tasks.withType<KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = listOf(
                "-Xallow-any-scripts-in-source-roots" ,
            )
        }
    }
    configurations.all {
        resolutionStrategy.eachDependency {
            if (requested.group == "org.jetbrains.kotlin") {
                useVersion("1.9.10")
            }
        }
    }
}


