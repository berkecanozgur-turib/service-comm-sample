plugins {
	java
	id("org.springframework.boot") version "4.0.3"
	id("io.spring.dependency-management") version "1.1.7"
    id("org.springdoc.openapi-gradle-plugin") version "1.9.0"
    id("io.swagger.core.v3.swagger-gradle-plugin") version "2.2.44"
    id("maven-publish")
}

group = "org.comm"
version = project.property("version") as String? ?: "0.0.1-SNAPSHOT"
description = "Common Sample Objects Project"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


openApi {
    outputDir.set(file("src/main/resources/openapi"))
    outputFileName.set("${project.name}-openapi-specification.yaml")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.named("build") {
    dependsOn("generateOpenApiDocs")
}

publishing {
    publications {
        create<MavenPublication>("openApiSpec") {
            artifact(file("src/main/resources/openapi/sample-openapi-specification.yaml")) {
                classifier = "openapi"
                extension = "yaml"
            }
            pom {
                name.set("sample-openapi-specification")
                description.set("OpenAPI specification for sample project")
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/${System.getenv("GITHUB_REPOSITORY") ?: "berkecanozgur/sample"}")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}