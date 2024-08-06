import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar



application {
    mainClass.set("com.example.backend.ServerKt")
}


plugins {
    kotlin("jvm")
    application
    id("com.github.johnrengelman.shadow") version Versions.SHADOW_JAR_VERSION
}




dependencies {
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

}

tasks.withType<ShadowJar> {
    archiveBaseName.set("publish")
    archiveClassifier.set("")
    archiveVersion.set("")
    isZip64 = true

}
