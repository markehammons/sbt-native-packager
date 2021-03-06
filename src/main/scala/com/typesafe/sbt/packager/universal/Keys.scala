package com.typesafe.sbt
package packager
package universal

import sbt._

trait UniversalKeys {
  val packageZipTarball =
    TaskKey[File]("package-zip-tarball", "Creates a tgz package.")
  val packageXzTarball =
    TaskKey[File]("package-xz-tarball", "Creates a txz package.")
  val packageOsxDmg = TaskKey[File]("package-osx-dmg", "Creates a dmg package for OSX (only on osx).")
  val stage = TaskKey[File](
    "stage",
    "Create a local directory with all the files laid out as they would be in the final distribution."
  )
  val dist = TaskKey[File]("dist", "Creates the distribution packages.")
  val packageRuntime = SettingKey[Boolean]("packageRuntime", "Enables bundling of a JRE with this build. This constrains the package to the host OS that generated it")
  val runtimeModules = SettingKey[Seq[String]]("runtimeModules", "The set of modules to build your runtime out of.")
  val stagingDirectory = SettingKey[File]("stagingDirectory", "Directory where we stage distributions/releases.")
  val topLevelDirectory = SettingKey[Option[String]]("topLevelDirectory", "Top level dir in compressed output file.")
  val universalArchiveOptions =
    SettingKey[Seq[String]]("universal-archive-options", "Options passed to the tar/zip command. Scope by task")
}
