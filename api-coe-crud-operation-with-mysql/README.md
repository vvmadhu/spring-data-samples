# Content management service With MySQL Server:- #
The POC code is to showcase the CRUD operations on MySQL Server.

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


## MySQL Configuration ##
Following steps to be followed in setting-up MySQL Server DB. Please refer to properties specified in application.properties

1. create user '*username*' identified by '*password*';
    > username, password refer to spring.datasource.username, spring.datasource.password from application.properties
2. create schema '*cms*';
	> cms refer to spring.datasource.url from application.properties
3. execute below script to create table with name **cms**(Specified in ContentEntity.java)


	>     create table cms.cms (
	>     planID varchar(20) primary key,
	>     issuer varchar(20),
	>     state varchar(2), 
	>     productType varchar(20),
	>     language varchar(15), 
	>     docType varchar(45),
	>     content varchar(500))

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
- `java -jar build\libs\api-coe-crud-operation-with-mysql-1.0.0.jar`
- `java -jar build\libs\api-coe-crud-operation-with-mysql-1.0.0.jar -Dserver.port=8080` to run the application on port 8080

###### Note: use CREATE operation to add content to MySQLServer and perform other operation sub-subsequently ######