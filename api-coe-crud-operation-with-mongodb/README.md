# Content management service With MongoDB:- #
The POC code is to showcase the CRUD operations on MongoDB.

The sample URIs for the CRUD operation are,

- Get Contents: by planID
	`GET <<host-name>>:<<port>>/content/?planID=<<plan-id>>`

- Get Contents: by planID, issuer, state, product, documentType and language (all are mandatory)
	`GET <<host-name>>:<<port>>/content/?planID=<<plan-id>>&issuer=<<issuer>>&state=<<state>>&product=<<product>>&documentType=<<document-type>>&language=<<language>>`

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


## MONGODB Configuration ##

1. Start MongoDB Server from $MONGO_HOME/bin directory using `MONGO_HOME/bin>mongod`
2. Create a database with name `cms` using `MONGO_HOME/bin>mongo.exe`
3. Then prompt is blinked at `>`, then type `use cms` at the prompt and this message will be displayed `switched to db cms`
3. Create MONGO collection called *cms_core* at `>` using command `db.createCollection('cms_core')` 


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
- `java -jar build\libs\api-coe-crud-operation-with-mongodb-1.0.0.jar`
- `java -jar build\libs\api-coe-crud-operation-with-mongodb-1.0.0.jar -Dserver.port=8080` to run the application on port 8080

###### Note: use CREATE operation to add content to MongoDB and perform other operation sub-subsequently ######