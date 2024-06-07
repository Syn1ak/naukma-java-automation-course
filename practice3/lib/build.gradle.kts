plugins {
    `java-library`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.9.1")

    implementation("org.apache.commons:commons-math3:3.6.1")

    implementation("com.google.guava:guava:32.0.0-android")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}