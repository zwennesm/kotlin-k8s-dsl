plugins {
    kotlin("jvm") version "1.3.61"
    kotlin("kapt") version "1.3.61"
}

group = "nl.zwennesm.k8s.dsl"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/juanchosaravia/autodsl")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("org.slf4j:slf4j-log4j12:1.7.30")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.1")
    implementation("com.fkorotkov:kubernetes-dsl:2.6")
    implementation("io.fabric8:kubernetes-client:4.6.3")
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
    api("com.juanchosaravia.autodsl:annotation:0.0.9")
    kapt("com.juanchosaravia.autodsl:processor:0.0.9")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}