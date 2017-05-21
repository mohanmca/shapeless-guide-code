scalaVersion      in ThisBuild := "2.12.2"

scalacOptions in Global ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-unchecked",
  "-feature",
  "-Xlint",
  "-Xfatal-warnings",
  "-Ywarn-dead-code"
)

libraryDependencies in Global ++= Seq(
  "com.chuusai"   %% "shapeless"     % "2.3.2",
  "org.typelevel" %% "cats"          % "0.9.0",
  "io.circe"      %% "circe-core"    % "0.8.0",
  "io.circe"      %% "circe-generic" % "0.8.0",
  "io.circe"      %% "circe-parser"  % "0.8.0",
  "org.scalactic" %% "scalactic"     % "3.0.3" % Test,
  "org.scalatest" %% "scalatest"     % "3.0.3" % Test
)

lazy val common =
  project.in(file("common"))

lazy val helloworld =
  project.in(file("helloworld")).dependsOn(common)

lazy val representations =
  project.in(file("representations")).dependsOn(common)

lazy val csv =
  project.in(file("csv")).dependsOn(common)

lazy val literaltypes =
  project.in(file("literaltypes")).dependsOn(common)

lazy val json =
  project.in(file("json")).dependsOn(common)

lazy val numfields =
  project.in(file("numfields")).dependsOn(common)

lazy val random =
  project.in(file("random")).dependsOn(common)

lazy val migrations =
  project.in(file("migrations")).dependsOn(common)

lazy val mapping =
  project.in(file("mapping")).dependsOn(common)

lazy val root = project.in(file("."))
  .aggregate(
    helloworld,
    representations,
    csv,
    literaltypes,
    json,
    numfields,
    random,
    migrations,
    mapping
  )


