# Content Management Service With SOAP WS using spring-boot,back-end as MySQL #
The POC code is to showcase the CRUD operations on apache SOLR.

WSDL URL: http://<< hostname>>:<< port>>/soapws/content.wsdl 

The requests for CRUD operation are,

- Get Contents: by planID
>  	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:con="http://www.cms.api.coe.hcl.com/content-ws">
>  	   <soapenv:Body>
>  	      <con:getContentByPlanIdRequest>
>  	         <con:planId>sample-input</con:planId>
>  	      </con:getContentByPlanIdRequest>
>  	   </soapenv:Body>
>  	</soapenv:Envelope>

- Add Contents:
> 	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
>  	xmlns:ns2="http://www.cms.api.coe.hcl.com/content-ws">
>  	   <soapenv:Body>
>  	      <ns2:addContentRequest>
>  	         <ns2:content>
>  	            <ns2:planId>CX5</ns2:planId>
>  	            <ns2:issuer>AARP</ns2:issuer>
>  	            <ns2:productType>DHMO</ns2:productType>
>  	            <ns2:state>CA</ns2:state>
>  	            <ns2:docType>PDF</ns2:docType>
>  	            <ns2:language>EN</ns2:language>
>  	            <ns2:content>Ready to get a quote?</ns2:content>
>  	         </ns2:content>
>  	      </ns2:addContentRequest>
>  	   </soapenv:Body>
>  	</soapenv:Envelope>


- Update Contents: 
> 	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
>  	xmlns:con="http://www.cms.api.coe.hcl.com/content-ws"
>  	xmlns:ns2="http://www.cms.api.coe.hcl.com/content-ws">
>  	   <soapenv:Header/>
>  	   <soapenv:Body>
>  	      <con:updateContentRequest>
>  	         <con:content>
>  	            <ns2:planId>CX5</ns2:planId>
>  	            <ns2:issuer>AARP</ns2:issuer>
>  	            <ns2:productType>DHMO</ns2:productType>
>  	            <ns2:state>CA</ns2:state>
>  	            <ns2:docType>PDF</ns2:docType>
>  	            <ns2:language>EN</ns2:language>
>  	            <ns2:content>Ready to get a quote???</ns2:content>
>  	         </con:content>
>  	      </con:updateContentRequest>
>  	   </soapenv:Body>
>  	</soapenv:Envelope>

- Delete Contents: by planID
> 	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:con="http://www.cms.api.coe.hcl.com/content-ws">
>  	   <soapenv:Header/>
>  	   <soapenv:Body>
>  	      <con:deleteContentRequest>
>  	         <con:planId>CX5</con:planId>
>  	      </con:deleteContentRequest>
>  	   </soapenv:Body>
>  	</soapenv:Envelope>


## MySQL Configuration ##
Please refer to the README.md of [CRUD with MySQL](https://rc-github.deltads.ent/DEVPROJECTS/api-coe-crud-operation-with-mysql.git "CRUD With MySQL Server") for MySQL server configurations.

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
- `java -jar build\libs\api-coe-crud-operation-with-soap-ws-1.0.0.jar`
- `java -jar build\libs\api-coe-crud-operation-with-soap-ws-1.0.0.jar -Dserver.port=8080` to run the application on port 8080

###### Note: use CREATE operation to add content to MySQL and perform other operation sub-subsequently ######