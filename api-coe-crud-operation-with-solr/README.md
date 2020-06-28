# Content management service With Apache SOLR:- #
The POC code is to showcase the CRUD operations on apache SOLR.

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


## SOLR Configuration ##
1. Start apache SOLR from $SOLR_HOME/bin directory using `SOLE_HOME/bin>solr start -p <<port-number>>`
2. Create SOLR collection called *cms_collection* using command `SOLE_HOME/bin>solr create_core -c cms_collection`
3. Stop SOLR using the command `SOLE_HOME/bin>solr stop -p <<port-number>>`
4. Modified the managed-schema with from `$SOLR_HOME/server/solr/cms_collection/conf/managed-schema` with below configuration details
	1. add below configurations
	`<uniqueKey>planID</uniqueKey>`
	2. add below configurations
	>     	<field name="planID" type="string" indexed="true" required="true" multiValued="false" stored="true"/>
	>     	<field name="issuer" type="string" indexed="true" required="true" multiValued="false" stored="true"/>
	>     	<field name="state" type="string" indexed="true" required="true" multiValued="false" stored="true"/>
	>     	<field name="productType" type="string" indexed="true" required="true" multiValued="false" stored="true"/>
	>     	<field name="language" type="string" indexed="true" required="true" multiValued="false" stored="true"/>     	<field name="docType" type="string" indexed="true" required="true" multiValued="false" stored="true"/>
	>     	<field name="content" type="string" indexed="true" required="true" multiValued="false" stored="true"/

5. Start apache solr to accept the solr document changes

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
- `java -jar build\libs\api-coe-crud-operation-with-solr-1.0.0.jar`
- `java -jar build\libs\api-coe-crud-operation-with-solr-1.0.0.jar -Dserver.port=8080` to run the application on port 8080

###### Note: use CREATE operation to add content to SOLR and perform other operation sub-subsequently ######