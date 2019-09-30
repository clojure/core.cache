Including core.cache in your projects
=====================================

The core.cache releases and snapshots are stored in the following repositories:

 * Release versions stored at [Maven Central](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22org.clojure%22%20AND%20a%3A%22core.cache%22)
 * Snapshot versions stored at [Sonatype](https://oss.sonatype.org/index.html#nexus-search;gav~org.clojure~core.cache~~~) (url at <http://oss.sonatype.org/content/repositories/snapshots>)

## Leiningen

You can use core.cache in your [Leiningen](https://github.com/technomancy/leiningen) projects with the following `:dependencies` directive in your `project.clj` file:

    [org.clojure/core.cache "0.8.2"]

## Maven

For Maven-driven projects, use the following slice of XML in your `pom.xml`'s `<dependencies>` section:

    <dependency>
	  <groupId>org.clojure</groupId>
	  <artifactId>core.cache</artifactId>
	  <version>0.8.2</version>
	</dependency>

Enjoy!
