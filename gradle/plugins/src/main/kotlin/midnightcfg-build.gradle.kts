plugins {
    id("java")
    id("java-library")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    withSourcesJar()
}

repositories {
    mavenCentral()
    if(GradleVersion.version(version as String).isSnapshot) {
    }
}

tasks.test {
    useJUnitPlatform()
    workingDir("run/test")
}