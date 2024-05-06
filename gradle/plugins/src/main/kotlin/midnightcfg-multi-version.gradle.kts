plugins {
    id("java")
    id("java-library")
    id("dev.jwall64.gradle-multi-version")
    id("dev.jwall64.gradle-patch")
}


multiVersion {
    useSourceDirectorySets()
    defaultVersion(21)
    additionalVersions(17,11,8)
}

patch {
    patchSet("java8", sourceSets["main"], sourceSets["main"].java, multiVersion.getCompileTask(8))
    patchSet("java11", sourceSets["main"], sourceSets["main"].java, multiVersion.getCompileTask(11))
    patchSet("java17", sourceSets["main"], sourceSets["main"].java, multiVersion.getCompileTask(17))
}
