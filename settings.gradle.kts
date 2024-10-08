rootProject.name = "springboot-template"

include(
    "serialization-domain",
    "serialization-infrastructure:jpa",
    "serialization-infrastructure:feign",
    "serialization-infrastructure:json",
    "serialization-infrastructure:avro",
    "serialization-infrastructure:protobuf",
    "serialization-common",
    "serialization-server",
    "serialization-reactive-server"
)

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        maven {
            url = uri("https://maven.pkg.github.com/disdong123/version-catalog")
            credentials {
                // PAT, github username 을 환경변수 (.zshrc 등)로 저장해야합니다.
                username = System.getenv("DISDONG_USERNAME")
                password = System.getenv("DISDONG_TOKEN")
            }
        }
    }
    versionCatalogs {
        create("libs") {
            from("kr.disdong:spring-version-catalog:0.0.31")
        }
    }
}
