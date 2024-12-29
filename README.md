# Project Poseidon example plugin
*This project is not affiliated with Project Poseidon, if you have any problems with it, tell me, not them!*

This is an example plugin for Project Poseidon, a Minecraft server software that allows you to create plugins for Minecraft beta 1.7.3.
You can see more information about Project Poseidon [here](https://github.com/RhysB/Project-Poseidon)

## To use this repo
Simply fork this repo or copy the files in it to your own folder. From there you can modify the files to meet your needs.
### [pom.xml](/pom.xml)
This is your Maven POM file. It is used by Maven to configure and build your project. You can find more info in the [Maven docs](https://maven.apache.org/pom.html).

Modify lines 7-10:
```xml
    <groupId>com.example.exampleplugin</groupId>
    <artifactId>ExamplePlugin</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
```
To use your own groupId, artifactId and name. The groupId should be a valid Java package name and is usually a domain name in big endian order but it doesn't have to be. Keep in mind that because the groupId has to follow Java package name conventions, it may not contains any hyphens (-).

The artifactId will be the name of the jar file your plugin will be packaged as without the version number.

The version should be incremented before every release. How you increment versions is technically up to you, you may want to follow some common practices used by other people, such as [semantic versioning](https://semver.org/).

### [plugin.yml](/src/main/resources/plugin.yml)
This contains info about your plugin used by the Poseidon server to load your plugin. If this file is absent, the server won't be able to load your plugin at all.

It contains:
```yml
name: Example Plugin
version: '${project.version}'
main: com.example.exampleplugin.ExamplePlugin
```
The `name` is simply the name of your plugin. The `version` is updated automatically by maven when you build the project. All you really have to worry about is `main`. This contains the full name of your main plugin class; the one that `extends JavaPlugin`.

### The Java code
The folder structure of your Java code must match your package name. The class file `ExamplePlugin` in the package `com.example.exampleplugin` must live in `src/main/java/com/example/exampleplugin`. The package of your main class should match the artifactId in your `pom.xml`. So if you're mrcoolguy, and the groupId for your treeXplodr plugin is `mrcoolguy.treexplodr`, and you main class is `TreeXploderPlugin`, it will live in `src/main/java/mrcoolguy/treexplodr/TreeXploderPlugin.java`.

This example mod has the groupId `com.example.exampleplugin` so all of its code lives in `src/main/java/com/example/exampleplugin`.

## Building
Use maven to build by using
```sh
mvn compile resources:resources package
```
You will find your jar file at `target/{groupId}-{version}.jar`.
