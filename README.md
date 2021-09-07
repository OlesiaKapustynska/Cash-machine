## Cash-machine
The simple ATM app.
###Technologies used:
Spring Boot, Spring Data, Hibernate
Database - MySQL
Packaging - Apache Maven
***
You can use this requests:
 - POST register (registration user)
 - POST login (login user and get token)
 - GET cards/balance/{cardNumber} (get card balance)
 - GET cards/transactions/{cardNumber} (get all card transactions)
 - POST transaction/replenish/{cardNumber} (put money)
 - POST transaction/withdraw/{cardNumber} (get money)
 - GET users/{id} - (get all cards by user id)