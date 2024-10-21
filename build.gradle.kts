plugins {
    id("java")
    id("application")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-alpha.13")
    implementation("org.mongodb:mongodb-driver-sync:4.10.1") // Use the latest stable version

}

application {
    mainClass.set("bot.DJBot")
}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(18)) // or match your JDK version
    }
}
