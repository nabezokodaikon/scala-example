import sbt._
import sbt.Keys._

object Dependencies {
  val scalatest="org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
  val utilCore="com.twitter" % "util-core_2.11" % "6.23.0"
  val all = Seq(scalatest, utilCore)
}

object Resolvers {
  val snapshots = "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"
  val releases = "releases"  at "http://oss.sonatype.org/content/repositories/releases"
  val all = Seq(snapshots, releases)
}

object Format {
  import com.typesafe.sbt.SbtScalariform._

  lazy val all = scalariformSettings ++ Seq(
    ScalariformKeys.preferences in Compile := formattingPreferences,
    ScalariformKeys.preferences in Test := formattingPreferences
  )

  def formattingPreferences = {
    import scalariform.formatter.preferences._
    FormattingPreferences()
      .setPreference(AlignParameters, true)
      .setPreference(AlignSingleLineCaseStatements, false)
  }
}

object Build extends Build {

  lazy val example = Project(
    id = "example",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "example",
      organization := "org.example",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.11.4",
      libraryDependencies ++= Dependencies.all,
      resolvers ++= Resolvers.all
      // add other settings here
    ) ++ Format.all
  )
}
