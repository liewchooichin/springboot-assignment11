# Notes for assignment 11

## Output of assignment
Input your message to be sent:
To: 80001000
Message: Spring Boot is interesting.
Sending message by SMS ...
---Sending notification ...---
To:80001000
Message:Spring Boot is interesting.
Channel:SMS
---Finish sending notification.---


## Ref: 

- [Spring PostConstruct and PreDestroy Annotations](https://www.baeldung.com/spring-postconstruct-predestroy)

- [Spring @Configuration Annotation](https://www.digitalocean.com/community/tutorials/spring-configuration-annotation)

## @Configuration

Created the files `MyBean.java`, `MyBeanConsumer.java`, `MyConfiguration.java` to try out @Configuration.


## @PostConstruct and @PreDestroy
Spring allows us to attach custom actions to bean creation and destruction. We can, for example, do it by implementing the InitializingBean and DisposableBean interfaces.

In this quick tutorial, we’ll look at a second possibility, the @PostConstruct and @PreDestroy annotations.

## @PostContruct

Spring calls the methods annotated with @PostConstruct only once, just after the initialization of bean properties. Keep in mind that these methods will run even if there’s nothing to initialize.

The method annotated with @PostConstruct can have any access level, but it can’t be static.

One possible use of @PostConstruct is populating a database. For instance, during development, we might want to create some default users:

```
@Component
public class DbInit {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void postConstruct() {
        User admin = new User("admin", "admin password");
        User normalUser = new User("user", "user password");
        userRepository.save(admin, normalUser);
    }
}
```

The above example will first initialize UserRepository and then run the @PostConstruct method.


## @PreDestroy

A method annotated with @PreDestroy runs only once, just before Spring removes our bean from the application context.


Same as with @PostConstruct, the methods annotated with @PreDestroy can have any access level, but can’t be static.

```
@Component
public class UserRepository {

    private DbConnection dbConnection;
    @PreDestroy
    public void preDestroy() {
        dbConnection.close();
    }
}
```

The purpose of this method should be to release resources or perform other cleanup tasks, such as closing a database connection, before the bean gets destroyed.




