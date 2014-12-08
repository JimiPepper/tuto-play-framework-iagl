name := """portFolioProjet"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "mysql" % "mysql-connector-java" % "5.1.27",
  "org.apache.commons" % "commons-email" % "1.3.3",
  cache,
  javaWs
)