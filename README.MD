# LoggedFuSkater Java Library
See: https://github.com/LoggedFuSkater/standard/blob/master/README.MD

## Usage
Add the github packages page as a repository in your `~.m2/settings.xml`:
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                               http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <profiles>
    <profile>
      <id>MyProfile</id>
      <repositories>
        ...
        <repository>
          <id>lfs</id>
          <name>LoggedFuSkater Java Maven Packages</name>
          <url>https://maven.pkg.github.com/LoggedFuSkater/java</url>
        </repository>
      </repositories>
    </profile>
  </profiles>

  <servers>
    ...
    <server>
      <id>lfs</id>
      <username>GITHUB-USERNAME</username>
      <password>TOKEN</password>
    </server>
  </servers>
</settings>
```
Then add the dependency to your pom:
```xml
<dependency>
  <groupId>org.loggedfuskater</groupId>
  <artifactId>LoggedFuSkater</artifactId>
  <version>1.0.0</version>
</dependency>
```

#### Generating The Token
 1. Go to gitlab account settings > Developer Settings > Personal access tokens
 2. Click `Generate new token`
 3. Write a note and check the `read:packages` checkbox
 4. Click `Generate token`
 5. Copy the token and paste in the `<password>` field in your settings.xml
