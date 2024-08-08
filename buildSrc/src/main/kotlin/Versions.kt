object Versions {
    const val KTOR_VERSION = "2.1.3"
    const val SHADOW_JAR_VERSION = "8.1.1"
    const val SLF4J_VERSION = "2.23.1"
    const val EXPOSED_VERSION = "0.36.2"
    const val POSTGRESQL_VERSION = "42.7.3"
    const val HIKARI_VERSION = "5.1.0"
    const val KOIN_VERSION = "3.5.6"
    const val KOIN_KTOR_VERSION = "4.0.0-RC1"
    const val KOTLIN_VERSION = "2.0.10"
    const val SERIALIZE_VERSION = "1.6.0"
    object Jvm {
        const val KTOR_AUTH = "io.ktor:ktor-server-auth:$KTOR_VERSION"
        const val KTOR_WEB_SOCKETS = "io.ktor:ktor-websockets:$KTOR_VERSION"
        const val KTOR_CLIENT_APACHE = "io.ktor:ktor-client-apache:$KTOR_VERSION"
        const val KTOR_SERVER_NETTY = "io.ktor:ktor-server-netty:$KTOR_VERSION"
        const val KTOR_SERIALIZATION = "io.ktor:ktor-serialization:$KTOR_VERSION"
        const val SLF4J = "org.apache.logging.log4j:log4j-slf4j-impl:$SLF4J_VERSION"
        const val KTOR_SERVER_CONTENT_NEGOTIATION = "io.ktor:ktor-server-content-negotiation:$KTOR_VERSION"
        const val KTOR_SERVER_CALL_LOGGING = "io.ktor:ktor-server-call-logging:$KTOR_VERSION"
        const val KTOR_STATUS_PAGES = "io.ktor:ktor-server-status-pages:$KTOR_VERSION"
        const val JETBRAINS_EXPOSED_CORE = "org.jetbrains.exposed:exposed-core:$EXPOSED_VERSION"
        const val JETBRAINS_EXPOSED_DAO = "org.jetbrains.exposed:exposed-dao:$EXPOSED_VERSION"
        const val JETBRAINS_EXPOSED_JDBC = "org.jetbrains.exposed:exposed-jdbc:$EXPOSED_VERSION"
        const val HIKARI_CONNECTION_POOL = "com.zaxxer:HikariCP:$HIKARI_VERSION"
        const val POSTGRESQL = "org.postgresql:postgresql:$POSTGRESQL_VERSION"
        const val KOIN_KTOR = "io.insert-koin:koin-ktor:$KOIN_KTOR_VERSION"
        const val KOIN_KTOR_LOGGER = "io.insert-koin:koin-logger-slf4j:$KOIN_VERSION"
        const val SERIALIZE = "org.jetbrains.kotlinx:kotlinx-serialization-json:$SERIALIZE_VERSION"


    }
}