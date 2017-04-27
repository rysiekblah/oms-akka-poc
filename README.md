# oms-akka-poc

Akka cluster is quite interesting part of technology and here is a POC how to implement OMS system based on that. Goal is to implement full flow, starting from creating an order, validation and publish to stock exchange (without FIX engine). Stock exchange will be mocked.

Modules
* event-dump-service - keeps snapshot of all events accured in cluster
* order-bot - validates an order based on clien't data
* order-rest-service - REST service exposing endpint for trading
* oms-common-lib - includes traits for actors, messages, constants

## oms-rest-service
TBD

## order-bot
TBD

## event-dump-service
TBD
