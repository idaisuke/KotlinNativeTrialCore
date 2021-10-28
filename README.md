## iOS

XCFrameworkを作成する

```bash
./gradlew assemble createXCFramework
```

## Android

jarファイルを生成し、GitHub Packages で公開する

```bash
./gradlew assemble publishGprPublicationToGitHubPackagesRepository
```
