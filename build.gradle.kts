plugins {
    java
    kotlin("jvm") version "1.9.23"
}

val group by properties
val version by properties

repositories {
    mavenCentral()
    maven("https://repo.marcloud.net/")
    maven("https://libraries.minecraft.net/")
    maven("https://nifty-gui.sourceforge.net/nifty-maven-repo/")
}

dependencies {
    implementation("oshi-project:oshi-core:1.1")
    implementation("net.java.dev.jna:jna:3.4.0")
    implementation("net.java.dev.jna:platform:3.4.0")
    implementation("com.ibm.icu:icu4j:62.1")
    implementation("net.sf.jopt-simple:jopt-simple:4.9")
    implementation("com.paulscode:codecjorbis:20101023")
    implementation("com.paulscode:codecwav:20101023")
    implementation("com.paulscode:libraryjavasound:20101123")
    implementation("com.paulscode:librarylwjglopenal:20100824")
    implementation("com.paulscode:soundsystem:20120107")
    implementation("io.netty:netty-all:4.0.23.Final")
    implementation("com.google.guava:guava:17.0")
    implementation("org.apache.commons:commons-lang3:3.8.1")
    implementation("commons-io:commons-io:2.6")
    implementation("commons-codec:commons-codec:1.11")
    implementation("net.java.jinput:jinput:2.0.9")
    implementation("net.java.jutils:jutils:1.0.0")
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("org.apache.commons:commons-compress:1.18")
    implementation("org.apache.httpcomponents:httpclient:4.5.6")
    implementation("commons-logging:commons-logging:1.2")
    implementation("org.apache.httpcomponents:httpcore:4.4.10")
    implementation("org.apache.logging.log4j:log4j-core:2.0-beta9")
    implementation("org.apache.logging.log4j:log4j-api:2.0-beta9")
    implementation("org.lwjgl.lwjgl:lwjgl:2.9.3")
    implementation("org.lwjgl.lwjgl:lwjgl_util:2.9.3")
    implementation("com.mojang:realms:1.7.59")
    implementation("com.mojang:authlib:1.5.21")
    implementation("tv.twitch:twitch:6.5")
}

kotlin {
    jvmToolchain(8)
}

tasks.register<JavaExec>("runClient") {
    group = "gradle-mcp"

    mainClass = "Start"
    classpath = sourceSets.main.get().runtimeClasspath
    if(System.getProperties()["os.name"].toString().lowercase().contains("windows")) {
        jvmArgs("-Djava.library.path=../natives/windows")
    } else {
        jvmArgs("-Djava.library.path=../natives/linux")
    }
    workingDir = project.projectDir.resolve("run")
}