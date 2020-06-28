# Content management API service wrapping SOAP WS #
The POC code is to showcase the CRUD operations by calling [SOAP Service](https://rc-github.deltads.ent/DEVPROJECTS/api-coe-crud-operation-with-soap-ws.git "soap service").

The sample URIs for the CRUD operation are,

- Get Contents: by planID
	`GET <<host-name>>:<<port>>/content/?planID=<<plan-id>>`

- Add Contents:
    `POST <<host-name>>:<<port>>/content`
>     {
>       "planID": "<<plan-id>>",
>       "issuer": "<<issuer>>",
>       "state": "<<state>>",
>       "productType": "<<productType>>",
>       "language": "<<language>>",
>       "docType": "<<docType>>",
>       "content": "<<content>>"
>     }


- Update Contents: 
	`PUT <<host-name>>:<<port>>/content`
>     {
>       "planID": "<<plan-id>>",
>       "issuer": "<<issuer>>",
>       "state": "<<state>>",
>       "productType": "<<productType>>",
>       "language": "<<language>>",
>       "docType": "<<docType>>",
>       "content": "<<content>>"
>     }

- Delete Contents: by planID
    `DELETE <<host-name>>:<<port>>/content/?planID=<<plan-id>>`

## Run Microservice Application ##
1. application.properties having configuration parameters, 
2. parameters can be passed at runtime using -D either using maven or gradle
3. Goto home directory of the microservice project and perform maven or gradle commands to run the service

### Start the application using maven ###
- `mvn clean install`
- `mvn spring-boot:run`
- `mvn spring-boot:run -Dserver.port=8888` to run the application on port 8888
 
### Start the application using gradle ###
- `gradlew build`
- `java -jar build\libs\api-coe-crud-operation-with-soap-ws-wrapper-1.0.0.jar`
- `java -jar build\libs\api-coe-crud-operation-with-soap-ws-wrapper-1.0.0.jar -Dserver.port=8080` to run the application on port 8080

###### Note: use CREATE operation to add content to MySQL and perform other operation sub-subsequently ######