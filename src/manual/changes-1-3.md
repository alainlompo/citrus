### Changes in Citrus 1.3.x

### @CitrusTest and @CitrusXmlTest annotations

With the new Java DSL capabilities Citrus created new ways of executing test cases within a TestNG or JUnit test class. Now we even improved the usage here with two new annotations **@CitrusTest** and **CitrusXmlTest** . The integration into the unit test class has never been easier for you.

The new Citrus annotations go directly to your unit test methods. With this enhancement you can have multiple Citrus test cases in one single Java class and the Citrus tests now are able to coexist with other unit test methods. You can even mix Java DSL and XML Citrus test cases in a single Java class.

The XML Citrus tests can be grouped to a single Java class with multiple XML files loaded during execution. There is even a package scan for all Citrus XML files within a directory structure so you do not have to create a Java class for each test case anymore.

We have changed the documentation in this guide so you can see how to use the new annotations. For detailed overview see [run-config-testng](run-config-testng). Also see our Citrus blog where we continuously describe the many possibilities that you have with the new annotations.

### @CitrusParameters annotation

Citrus is able to use the fabulous TestNG data provider capabilities in order to execute a test case several times with different data provided form external resources. The new @CitrusParameters annotation helps to set parameter names which are used as test variable names in the test case.

### Schema repository configuration components

Defining schema repositories and schemas (xsd, wsdl) is common use in Citrus. We have added XML bean definition parsers so defining those components is less verbose. You can use the Citrus **citrus:schema-repository** and **citrus:schema** components in your Spring application context configuration. The components do receive several attributes for further configuration. XSD, WSDL and schema collections are supported here.

Checkout [xsd-validation](xsd-validation)for examples how to use the new configuration components.

### Change date function

We have added a new Citrus function **citrus:changeDate()** that is available for you by default. The function changes a given date value adding or removing a datetime offset (e.g. year, month, day, hour, minute, second). So you can manipulate each date value also those of dynamic nature coming with some message.

See [functions-changedate](functions-changedate)for examples and detailed syntax usage of this function.

### Weekday validation matcher

The new weekday validation matcher also works on date values. The matcher checks that a given date value evaluates to a expected day of the week. So the user can check that a date field is always a saturday for instance. This is very helpful when checking that a given date value is not a working day for example.

See [validation-matcher-weekday](validation-matcher-weekday)for some more detailed description of the matcher's capabilities.

### Java DSL

Citrus users, in particular those with development experience, do often tell me about the nasty XML code they have to deal with for writing Citrus test definitions. Developers want to write Java code rather than XML. Although I personally do like the Citrus XML test syntax we have introduced a Java DSL language for writing Citrus tests with Java only.

We have introduced the Java DSL to all major test action features in Citrus so you can switch without having to worry about loosing functionality. Details can be seen in the test action section where we added Java DSL examples almost everywhere ([actions](actions)). The basic Java DSL setup is described in [testcase](testcase).

### XHTML message validation

Message validation for Html code was not really comfortable as Html does not confirm to be wellformed and valid XML syntax. XHTML tries to close this gap by automatically resolving all Html specific XML syntax rule violations. With Citrus 1.3 we introduced a XHTML message validator which does the magic for converting Html code to proper wellformed and valid XML. In a test case you can then use the full XML validation power in Citrus in order to validate incoming Html messages. Section [validation-xhtml](validation-xhtml)deals with the new validation capabilities for Html.

### Multiple SOAP fault detail support

SOAP fault messages can hold many SOAP fault detail elements. Citrus was able to handle a single SOAP fault detail on sending and receiving test actions from the very beginning but multiple SOAP fault detail elements were not supported. Fortunately things are getting better and you can send and receive as many fault detail elements as you like in Citrus 1.3. For each SOAP fault detail you can specify individual validation rules and expectations. See [soap-faults](soap-faults)for detailed description.

### Jetty server security handler

With our Jetty server component you can set up Http mock servers very easy. The server is automatically configured to accept Http client connections and to load a Spring application context on startup. Now you can also set some more details on this automatic server configuration (e.g. server context path, servlet names or servlet mappings). In addition to that you can access the security context of the web container. This enables you to set up security constraints such as basic authentication on server resources. Clients are then forced to authenticate properly when accessing the server. Unauthorized users will get **401 access denied** errors immediately. See [http-basic-auth-server](http-basic-auth-server)for details. Of course this also applies to our SOAP WebService Jetty server components ([soap-basic-auth-server](soap-basic-auth-server)).

### Test actors

We introduced a new concept of test actors for sending and receiving test actions. This enables you to link a test actor (e.g. interface partner application, backend application) to a test action in your test. Following from that you can enable/disable test actors and all linked test actions very easy. This enables us to reuse Citrus test cases in end-to-end test scenarios where not all interface partners get simulated by Citrus. If you like to read more about this concept follow the detailed instruction in [test-actors](test-actors).

### Simulate Http error codes with SOAP

Citrus provides SOAP WebServices server simulation with clients connecting to the server sending SOAP requests. As a server Citrus is now able to simulate Http error codes like **404 Not found** and **500 Internal server error** . Before that the Citrus SOAP server had to always respond with a proper SOAP response or SOAP fault. See [soap-http-errors](soap-http-errors)for details.

### SSH server and client

The Citrus family has raised a new member in adding SSH connectivity. With the new SSH module you are able to provide a full stack SSH server. The SSH server accepts client connections and you as a tester can simulate any SSH server functionality with proper validation as it is known to Citrus SOAP and HTTP modules. In addition to that you can also use the Citrus SSH client in order to connect to an external SSH server. You can execute SSH commands on the SSH server and validate the respective response data. The full description is provided in [ssh](ssh).

### ANT run test action

With this new test action you can call ANT builds from your test case. The action executes one or more ANT build targets on a build.xml file. You can specify build properties that get passed to the ANT build and you can add a custom build listener. In case the ANT build run fails the test fails accordingly with the build exception. See [actions-antrun](actions-antrun)for details.

### Polling interval for reply handlers

With synchronous communication in Citrus we always have a combination of a synchronous message sender and a reply handler component. These two perform a handshake when passing synchronous reply messages to the test for further processing such as message validation. While the sender is waiting for the synchronous response to arrive the reply handler polls for the reply message. This polling for reply messages was done in a static way which often led to time delays according to long polling intervals. Now with Citrus 1.3 you can set the polling-interval for the reply handler as you like. This setting is valid for all reply handler components in Citrus (citrus-jms, citrus-http, citrus-ws, citrus-channel, citrus-shh, and so on).

### Upgrading from version 1.2

If you are coming from Citrus 1.2 you may have to look at the following points in order to have a smooth upgrade to the new release version.

*  **Jetty version upgrade** We are using Jetty a lot for starting Http server mocks within Citrus. In order to stay up to date we upgraded to Jetty 8.1.7 version with this Citrus release. This implies that package names did change for Jetty API. In general there is no conflict for you as a Citrus user, but you may want to adjust your logging configuration according to new Jetty packages. Jetty package names did change from **ord.mortbay** to **org.eclipse.jetty** .

*  **Spring version upgrade** Staying up to date with the versions of 3rd library dependencies is quite important for us. So we upgrade our dependencies to newer versions with each release. As we did only upgrade minor versions there is no significant change or problems to be expected. However you may take care on versions and release changes in the Spring world for details and migration.

*  **TIBCO module** We decided to put the TIBCO module separately as it is a very special connectivity adapter for TIBCO software only. So you will not find the TIBCO module within the Citrus distribution anymore. We will maintain a TIBCO connectivity adapter separately in the future.



