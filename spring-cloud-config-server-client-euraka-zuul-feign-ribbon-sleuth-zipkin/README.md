# Requirement
* Create services
	* Customer service
	* Cart service
	* Payment service
* Create Spring cloud config server
* Setup follwing services as client to Spring cloud config server
	* Customer service
	* Cart service
	* Payment service
* On calling API in Customer service get cart and payment details using Feign and ribbon
* Start multiple instances of services on different ports
* Create Zuul API gateway
	* All requests should go through API gateway
* Enable Sleuth in `zuul-gateway`, `Customer service`, `Cart service`, `Payment service`
* Install Rabbit MQ
* Put `zuul-gateway`, `Customer service`, `Cart service`, `Payment service` logs in Rabbit MQ
* `zipkin-distributed-tracing-server` listening on Rabbit MQ
* `zipkin-distributed-tracing-server` takes logs from Rabbit MQ to in memory DB