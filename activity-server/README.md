## Activity-Server 
This is a restful web service written in Java

## Dependencies
- Spring 4.1
- Hibernate 4.3
- EHcache 2.9
- C3P0 0.9
- JPA 2.0

## Gradle
- SpringMVCRun  : run activity-server in embedded tomcat with 'production' environment
- SpringMVCStop : stop the tomcat server launched by task 'SpringMVCRun'

## Packages
- entity     : hibernate orm bean
- converter  : spring type converter
- repository : data access object
- service    : service provider
- webservice : rest web service

## Resources
resources are divided into two environments for Spring

- develope   : include embedded database and mocked elements
- production : additional cache and remote database configuration, need to put the following five documents to /production
    - ehcache.xml( standard ehcahe setting, cache name need to be 'production' )
    
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
    remote.attachment.url = http://example.com/attachment
    ```
