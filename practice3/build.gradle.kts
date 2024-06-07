plugins {
    id("java")
    kotlin("jvm") version "1.8.0"
    "java-base"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(gradleApi())
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("checkFileExistence") {
    val filePath = "rpn-evaluator-util/src/main/resources/checkFile.txt"
    if (file(filePath).exists()) {
        println("File exists")
    } else {
        println("File does not exist")
    }
}

rootProject.tasks.getByName("build").dependsOn("hello")

abstract class HelloTask : DefaultTask() {
    @TaskAction
    fun hello() {
        println("hello from HelloTask")
    }
}

tasks.register<HelloTask>("hello") {
    group = "Custom tasks"
    description = "A lovely greeting task."
}