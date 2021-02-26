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