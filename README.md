## This is POC for read/write mail from Casandra from Web service.
## Request
http://localhost:8080/email/

POST
 
{"@class":".Email","subject":"subject1","sender":"sender1","recipient":"recipient1","message":"This is test mail"}
