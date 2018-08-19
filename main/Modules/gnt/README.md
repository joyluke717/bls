Cible Nexus Service requires a mysql database server (running on localhost and port 3306 as default defined in ./bin/server.yaml configuration file).  The required database schema file is at ./src/main/resources/sql/nexus.sql.  Please make sure mysql server is up and running before Cible Nexus service is started.

It is OK share the same database server with Cible Deply Service.  

RPM build feature requires the following packages installed with mininum vesion as indicated:
```
rpmrebuild-2.11-7: used to get the rpm spec from the given rpm file
rpm-4.14.1-1: leveraged rpm2cpio to extract the given rpm file
rpm-build-4.14.1-1: build package from a cible flavored rpm spec file
```
