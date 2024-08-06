object Versions {
    const val KTOR_VERSION = "2.1.3"
    const val SHADOW_JAR_VERSION = "8.1.1"
    const val SLF4J_VERSION = "2.23.1"
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
    }
}