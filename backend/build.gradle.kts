import Versions.KTOR_VERSION
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar




application {
    mainClass.set("com.example.backend.ServerKt")
}


plugins {
    kotlin("jvm")
    application
    id("com.github.johnrengelman.shadow") version Versions.SHADOW_JAR_VERSION
    kotlin("plugin.serialization") version Versions.KOTLIN_VERSION
   // kotlin("plugin.serialization") version "1.9.22"
}




dependencies {
    implementation(kotlin("stdlib"))
    implementation(Versions.Jvm.KTOR_CLIENT_APACHE)
    implementation(Versions.Jvm.KTOR_SERIALIZATION)
    implementation(Versions.Jvm.KTOR_SERVER_CONTENT_NEGOTIATION)
    implementation(Versions.Jvm.KTOR_SERVER_CALL_LOGGING)
    implementation(Versions.Jvm.KTOR_STATUS_PAGES)
    implementation(Versions.Jvm.KTOR_SERVER_NETTY)
    implementation(Versions.Jvm.SLF4J)
    implementation(Versions.Jvm.KTOR_AUTH)
    implementation(Versions.Jvm.KTOR_WEB_SOCKETS)
    implementation(Versions.Jvm.KTOR_CLIENT_APACHE)
    implementation(Versions.Jvm.JETBRAINS_EXPOSED_CORE)
    implementation(Versions.Jvm.JETBRAINS_EXPOSED_DAO)
    implementation(Versions.Jvm.JETBRAINS_EXPOSED_JDBC)
    implementation(Versions.Jvm.POSTGRESQL)
    implementation(Versions.Jvm.HIKARI_CONNECTION_POOL)
    implementation(Versions.Jvm.KOIN_KTOR)
    implementation(Versions.Jvm.KOIN_KTOR_LOGGER)
    implementation(Versions.Jvm.SERIALIZE)
    implementation(libs.ktor.client.content.negotiation)
    implementation("io.ktor:ktor-serialization-kotlinx-json:$KTOR_VERSION")
    implementation(platform(Versions.Jvm.AWS_JAVA_SDK))
    implementation(Versions.Jvm.AWS_S3)
}

tasks.withType<ShadowJar> {
    archiveBaseName.set("publish")
    archiveClassifier.set("")
    archiveVersion.set("")
    isZip64 = true

}
