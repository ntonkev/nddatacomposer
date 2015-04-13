name := "nddatacomposer"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += "spray" at "http://repo.spray.io/"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

val sprayVersion = "1.3.3"

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

scalacOptions ++= Seq(
  "-Ywarn-value-discard"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka"   %% "akka-actor"        % "2.3.9",
  "com.typesafe.akka"   %% "akka-slf4j"         % "2.3.9",
  "ch.qos.logback"      % "logback-classic"    % "1.1.2",
  "io.spray"            %% "spray-client"       % sprayVersion,
  "io.spray"            %% "spray-routing"      % sprayVersion,
  "io.spray"            %% "spray-testkit"      % sprayVersion % "test",
  "org.json4s"          %% "json4s-native"      % "3.2.10",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
  "org.scalatest"       %% "scalatest"          % "2.2.2",
  "org.mockito"          % "mockito-all"        % "1.9.5" % "test",
  "com.gettyimages"     %% "spray-swagger"      % "0.5.0"
)


//"org.postgresql"       % "postgresql"         % "9.2-1003-jdbc4",
//"com.typesafe.slick"  %% "slick"              % "2.0.2",
//"joda-time"            % "joda-time"          % "2.3",
//"org.joda"             % "joda-convert"       % "1.5",
//"com.github.tototoshi" %% "slick-joda-mapper" % "1.1.0",
//"commons-daemon"       %  "commons-daemon"    % "1.0.15",
