import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar

description = "Java Swing balloon tips"

plugins {
    id("com.vanniktech.maven.publish") version "0.35.0"
    `module-lib`
}

group = "io.github.osobolev"
version = "1.2.5.1"

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates("${project.group}", "${project.name}", "${project.version}")
    configure(JavaLibrary(
        javadocJar = JavadocJar.Javadoc(),
        sourcesJar = true
    ))
}

mavenPublishing.pom {
    name.set("balloontip")
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
        connection.set("scm:git:https://github.com/osobolev/balloontip.git")
        developerConnection.set("scm:git:https://github.com/osobolev/balloontip.git")
        url.set("https://github.com/osobolev/balloontip")
    }
}
