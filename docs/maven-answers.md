# Maven Lifecycle Answers

## B2.1 — Phases run by `mvn package` (in order)
validate → initialize → generate-sources → process-sources →
generate-resources → process-resources → compile → process-classes →
generate-test-sources → process-test-sources → generate-test-resources →
process-test-resources → test-compile → test → prepare-package → package

## B2.2 — `mvn install` vs `mvn package`
`mvn package` runs the full default lifecycle up to and including `package`,
producing the build artifact (e.g. JAR) in the local `target/` folder.
`mvn install` runs everything `package` does, and additionally copies that
artifact into the local Maven repository (`~/.m2/repository`), making it
available as a dependency for other local Maven projects.

## B2.3 — Why JUnit should use `test` scope
`test` scope means the dependency is only on the classpath during test
compilation and execution — it is never bundled into the final packaged
artifact. If JUnit were on the default `compile` scope, it would ship inside
the production JAR, bloating it and unnecessarily exposing testing
internals in a runtime environment where it serves no purpose.