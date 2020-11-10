OAUTH2 Rest

Microsevicio de authorización y autenticación de clientes y aplicaciones.
Esta implementación utiliza una base de datos H2, es solo para realizar pruebas.

OAuth2:
A continuación se detallan los usuarios para generar tokens:

    * phoneNumber: 3511234567
    * password: tincho123
    
    * phoneNumber: 3517654321
    * password: nati123
    
URL para probar el servicio:

    * http://localhost:8080/oauth/token?grant_type=password&username=3511234567&password=tincho123
    
    * Authorization: Basic Auth
        **Username: workshopLogin
        **Password: wox9fNy9ewVS3LkW8YalKZOe