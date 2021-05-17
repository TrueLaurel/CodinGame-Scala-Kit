name := "CodinGame-Scala-Kit"
version := "0.1.0"
scalaVersion := "2.13.1"

// solve a weird issue with java dependencies (trait Approving)
// see https://stackoverflow.com/questions/43751394/package-cats-contains-object-and-package-with-same-name-implicits &
// https://github.com/druid-io/tranquility/blob/master/build.sbt
scalacOptions := Seq("-Yresolve-term-conflict:object")


resolvers += Resolver.mavenLocal

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.2" % "test"
libraryDependencies += "com.github.writethemfirst" % "approvals-java" % "0.12.0" % "test"
libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.13.6" % "test"
libraryDependencies += "org.scalameta" %% "scalafmt-core" % "2.5.2"

enablePlugins(JmhPlugin)
enablePlugins(JavaAppPackaging)
