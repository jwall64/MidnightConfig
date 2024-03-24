rootProject.name = "midnightcfg"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }

    includeBuild("gradle/plugins")
}

include("api")

include("codec-nbt")
include("codec-json")
include("codec-gson")
include("codec-binary")

include("cfgtool")