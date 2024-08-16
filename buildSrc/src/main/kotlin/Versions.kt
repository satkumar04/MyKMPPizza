object Versions {
    const val KTOR_VERSION = "2.1.3"
    const val SHADOW_JAR_VERSION = "8.1.1"
    const val SLF4J_VERSION = "2.23.1"
    const val EXPOSED_VERSION = "0.36.2"
    const val POSTGRESQL_VERSION = "42.7.3"
    const val HIKARI_VERSION = "5.1.0"
    const val KOIN_VERSION = "3.5.6"
    const val KOIN_KTOR_VERSION = "4.0.0-RC1"
    const val KOTLIN_VERSION = "1.9.20"
    const val SERIALIZE_VERSION = "1.6.0"
    const val AWS_VERSION = "2.27.3"
    const val LIFECYCLE_VERSION = "2.8.4"
    const val COMPOSE = "1.6.8"
    const val COMPOSE_ACT = "1.9.1"
    const val COMPOSE_NAV = "2.7.7"
    const val MATERIAL = "1.13.0-alpha05"
    const val COROUTINES_MT = "1.8.1"

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
        const val AWS_JAVA_SDK = "software.amazon.awssdk:bom:$AWS_VERSION"
        const val AWS_S3 = "software.amazon.awssdk:s3:$AWS_VERSION"


    }

    object Common {
        const val KTOR_CLIENT_CORE = "io.ktor:ktor-client-core:$KTOR_VERSION"
        const val KTOR_CLIENT_JSON = "io.ktor:ktor-client-json:$KTOR_VERSION"
        const val KTOR_LOGGING = "io.ktor:ktor-client-logging:$KTOR_VERSION"
        const val KTOR_CLIENT_SERIALIZATION = "io.ktor:ktor-client-serialization:$KTOR_VERSION"
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_MT"
        const val KOIN_CORE = "io.insert-koin:koin-core:$KOIN_VERSION"
    }

    object Android {
        const val KTOR_CLIENT = "io.ktor:ktor-client-android:$KTOR_VERSION"
        const val KTOR_OKHTTP = "io.ktor:ktor-client-okhttp:$KTOR_VERSION"
        const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION"
        const val VIEW_MODEL_UTIL = "androidx.lifecycle:lifecycle-viewmodel-compose:$LIFECYCLE_VERSION"

        // Compose
        const val COMPOSE_UI = "androidx.compose.ui:ui:$COMPOSE"
        const val COMPOSE_GRAPHICS = "androidx.compose.ui:ui-graphics:$COMPOSE"
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE"
        const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation-layout:$COMPOSE"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:$COMPOSE"
        const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:$COMPOSE_NAV"
        const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:$COMPOSE_ACT"
        const val MATERIAL_COMPONENTS = "com.google.android.material:material:$MATERIAL"

        const val KOIN_ANDROID_MAIN = "io.insert-koin:koin-android:$KOIN_VERSION"
    }

    object iOS {
        const val KTOR_CLIENT = "io.ktor:ktor-client-ios:$KTOR_VERSION"
    }
}