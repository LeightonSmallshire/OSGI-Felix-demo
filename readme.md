# Felix OSGI minimal example
This tiny project contains a Felix-driven OSGI container and a bundle implementing a serviceListener. 
The container will start each installed bundle and list it's registered services.

## Build and run
>mvn clean package; java -jar application/target/application-1.0-SNAPSHOT-jar-with-dependencies.jar

## Expected Output
>Starting OSGI...
Hello world!
Bundle: org.apache.felix.framework
&emsp;Registered services:
&emsp;&emsp;[org.osgi.service.resolver.Resolver]
&emsp;&emsp;[org.osgi.service.packageadmin.PackageAdmin]
&emsp;&emsp;[org.osgi.service.startlevel.StartLevel]
&emsp;&emsp;[org.osgi.service.condition.Condition]
&emsp;&emsp;Bundle: org.example.demo-service
Stopping...
Goodbye, cruel world
