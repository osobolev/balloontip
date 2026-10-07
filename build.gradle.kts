import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SourcesJar

description = "Java Swing balloon tips"

plugins {
    id("com.vanniktech.maven.publish") version "0.37.0"
    id("module-lib")
}

group = "io.github.osobolev"
version = "1.2.5.1"

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates("${project.group}", "${project.name}", "${project.version}")
    configure(JavaLibrary(
        javadocJar = JavadocJar.Javadoc(),
        sourcesJar = SourcesJar.Sources()
    ))
}

mavenPublishing.pom {
    name = "balloontip"
    description = "Provides balloon tips for use in Java Swing applications"
    url = "https://github.com/osobolev/balloontip"
    licenses {
        license {
            name = "3-Clause BSD license"
            url = "http://www.opensource.org/licenses/BSD-3-Clause"
        }
    }
    developers {
        developer {
            name = "Oleg Sobolev"
            organizationUrl = "https://github.com/osobolev"
        }
    }
    scm {
        connection = "scm:git:https://github.com/osobolev/balloontip.git"
        developerConnection = "scm:git:https://github.com/osobolev/balloontip.git"
        url = "https://github.com/osobolev/balloontip"
    }
}
