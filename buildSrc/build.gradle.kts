plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal() {
        content {
            excludeGroupByRegex("dev\\.jwall64\\.*")
        }
    }
    maven {
        name = "Fabric"
        url = uri("https://maven.fabricmc.net/")
        content { 
            excludeGroupByRegex("dev\\.jwall64\\.*")
        }
    }
    maven {
        url = uri("https://maven.jwall64.dev/plugins")
        content { 
            includeGroupAndSubgroups("dev.jwall64")
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.21")
    implementation("com.gradleup.shadow:shadow-gradle-plugin:9.6.1")
    implementation("dev.jwall64:gradle-multi-version:0.4.0")
    implementation("dev.jwall64:gradle-patch:0.3.0")
    implementation("net.fabricmc:fabric-loom:1.19-SNAPSHOT")
}
