plugins {
    kotlin("jvm") version "2.1.10"
    application
}

group = "com.assu.study"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.10")
    // 코루틴 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
    // JUnit5 테스트 API(테스트 코드 작성용)
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.12.0")
    // JUnit5 테스트 엔진(테스트 실행 시 필요)
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.12.0")
    // 코루틴 테스트 라이브러리
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.1")
}

// JUnit5 를 사용하기 위한 옵션
tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}
