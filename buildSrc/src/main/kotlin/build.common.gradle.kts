import buildlogic.Utils;

plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
    withSourcesJar()
}

tasks.withType<Jar> {
    archiveBaseName.set(Utils.getArchiveName(project, rootProject))
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    workingDir("run/test")
    run {
        mkdir("run/test")
    }
}
