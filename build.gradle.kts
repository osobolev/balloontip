description = "Java Swing balloon tips"

plugins {
    id("com.github.ben-manes.versions") version "0.45.0"
    `module-lib`
}

group = "io.github.osobolev"
version = "1.2.5"

(publishing.publications["mavenJava"] as MavenPublication).pom {
    description.set("Provides balloon tips for use in Java Swing applications")
    url.set("https://github.com/osobolev/balloontip")
    licenses {
        license {
            name.set("3-Clause BSD license")
            url.set("http://www.opensource.org/licenses/BSD-3-Clause")
        }
    }
    developers {
        developer {
            name.set("Oleg Sobolev")
            organizationUrl.set("https://github.com/osobolev")
        }
    }
    scm {
        connection.set("scm:git:https://github.com/osobolev/wincom.git")
        developerConnection.set("scm:git:https://github.com/osobolev/wincom.git")
        url.set("https://github.com/osobolev/wincom")
    }
}
