name := """play-2.3.6-mybatis-sample"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.mybatis" % "mybatis" % "3.1.1",
  "org.mybatis" % "mybatis-guice" % "3.3",
  javaCore, javaJdbc
)

// "Add mapper xml files to classpath" -- blank line necessary for SBT
unmanagedResourceDirectories in Compile <+= baseDirectory( _ / "app" )

// but filter out java and html files that would then also be copied to the classpath
excludeFilter in Compile in unmanagedResources := "*.java" || "*.html"
