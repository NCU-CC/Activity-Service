## Activity-Server 
A restful web service written in Java

## Dependencies
- Spring 4.1
- Hibernate 4.3
- EHcache 2.9
- HikariCP 2.3.1
- JPA 2.0

## Gradle
- jettyStart  : run server in embedded server
- jettyStop   : stop the server started by command above

## Resources
resources are divided into two environments for Spring

- develope   : include embedded database and mocked elements
- production : additional cache and remote database configuration, must put the following five documents to src/main/resources/production
    - ehcache.xml( standard ehcahe setting, cache name must be 'production' )
    
    - connection.properties
    ```
    dataSourceClassName = [ your datasource class ] ( ex: com.mysql.jdbc.jdbc2.optional.MysqlDataSource )
    dataSource.url = [ your jdbc url ] ( ex: jdbc:mysql://localhost/dbname )
    dataSource.user = [ your user name ]
    dataSource.password = [ your password ]
    ... or other hikariCP settings
    ```
    
    - database.properties
    ```
    init_database = [ true / false ]
    init_database_file = classpath:develope/data.sql
    ```
    
    - hibernate.properties
    ```
    hibernate.dialect  = org.hibernate.dialect.MySQL5Dialect
    ...and other hibernate setting
    ```
    
    - remote.properties
    ```
    remote.attachment.url = http://example.com/attachment/
    ```
