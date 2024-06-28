plugins {
    packeteventstest.`java-conventions`
    `java-library`
}

dependencies {
    implementation(libs.bundles.junit)
    compileOnlyApi(libs.packetevents.api)
    compileOnlyApi(libs.bundles.adventure)
    compileOnlyApi(libs.lombok)
    annotationProcessor(libs.lombok)
}

// So that SNAPSHOT is always the latest SNAPSHOT
configurations.all {
    resolutionStrategy.cacheDynamicVersionsFor(0, TimeUnit.SECONDS)
}