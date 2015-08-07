import _root_.de.johoop.jacoco4sbt.JacocoPlugin.jacoco

name := """MyApp"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  cache,
  javaWs
)

libraryDependencies += "org.mockito" % "mockito-core" % "1.10.19"
libraryDependencies += "org.webjars" % "bootstrap" % "3.3.4"

jacoco.settings
parallelExecution in jacoco.Config := false

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator