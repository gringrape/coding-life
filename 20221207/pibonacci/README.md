`build.sbt`:
```sbt
scalaVersion := "3.2.0"
```

metals => import build

`.vscode/settings.json`:
```json
{
  "editor.formatOnSave": true
}
```

`project/build.properties`:
```properties
sbt.version=1.7.3
```

ScalaCheck 의존성 추가
https://scalacheck.org/
```
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1" % "test"
```
