## Activity-Server 
A restful web service written in Java

## Dependencies
- Spring 4.1
- Hibernate 4.3
- EHcache 2.9
- C3P0 0.9
- JPA 2.0
- H2 1.4

## Gradle
- jettyStart  : run server in embedded server
- jettyStop   : stop the server started by command above

## Packages
- controller : restful web-service provider
- converter  : spring type converter
- entity     : hibernate orm bean
- repository : data access object
- service    : service provider

## Resources
resources are divided into two environments for Spring

- develope   : include embedded database and mocked elements
- production : additional cache and remote database configuration, must put the following five documents to src/main/resources/production
    - ehcache.xml( standard ehcahe setting, cache name must be 'production' )
    
    - connection.properties
    ```
    min_size = 5
    max_size = 75
    ...or other c3p0 settings
    user     = [ your database user name ]
    password = [ your database user password ]
    ```
    
    - database.properties
    ```
    jdbc.driver = com.mysql.jdbc.Driver
    jdbc.url = jdbc:mysql://localhost/dbname
    init_database = true
    init_database_file = classpath:develope/data.sql
    ```
    
    - hibernate.properties
    ```
    hibernate.dialect  = org.hibernate.dialect.MySQL5Dialect
    hibernate.show_sql = true
    ...or other hibernate setting
    ```
    
    - remote.properties
    ```
    remote.attachment.url = http://example.com/attachment/
    ```
