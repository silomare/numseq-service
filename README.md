# numseq-service 
*(build/run instructions for windows)*

1. **clone repo**

2. **build**  
   $ mvn clean package site -DskipTests  
   - 2.1 check reports:  
     open target/site/project-reports.html  

3. **start service**  
   $ cd target  
   $ java -jar numseq-service-0.0.1-SNAPSHOT.jar --topic=fizzbuzz-input

4. **monitor kafka topic**  
   - 4.1 start zookeper  
         $ .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties  
   - 4.2 start kafka server  
         $ .\bin\windows\kafka-server-start.bat .\config\server.properties  
   - 4.3 start console listener on "fizzbuzz-input"  
         $ .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic fizzbuzz-input --property 
value.deserializer=org.apache.kafka.common.serialization.IntegerDeserializer

5. **trigger number generation (using powershell)**  
   $ Invoke-RestMethod -URI http://localhost:8080/numproducer/kafkatopic  -Method POST

