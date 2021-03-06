### Changes in Citrus 1.2

### Spring version update

We have some major version upgrades in our Spring dependencies. We are now using Spring 3.1.1, Spring Integration 2.1.2 and SpringWS 2.1.0. This upgrade was overdue for some time and is definitely worth it. With these upgrades we had to apply some changes in our API, too. This is because we are using the Spring classes a lot in our code. See the upgrade guide in this chapter for all significant changes that might affect your project.

### New groovy features

Citrus extended the possibilities to work with script languages like Groovy. You can use Groovy's MarkupBuilder to create XML message payloads. Your Groovy code goes right into the test case or comes from external file. With MarkupBuilder you do not need to care about XML message syntax and overhead. Just focus on the pure message content. You can read the details in [groovy-markupbuilder](groovy-markupbuilder).

Further Groovy feature goes to the validation capabilities. Instead of working with XML DOM tree comparison and XPath expression validation you can use Groovy XMLSlurper. This is very useful for those of you who need to do complex message validation and do not like the XML/XPath syntax at all. With XMLSlurper you can access the XML DOM tree via named closure operations which feels great. This especially comes in handy for complex generic XML structures as you can search for elements, sort element list and use the powerful contains operation. This is all described in [groovy-xmlslurper](groovy-xmlslurper).

Some other Groovy support extension comes in SQL result set validation ([actions-database-groovy](actions-database-groovy)). When reading data from the database someone is able to validation the resulting data row set with Groovy script. The script code easily accesses the rows and columns with Groovy's out-of-the-box list and map handling. This adds very powerful validation to multi-row data sets from the database.

### SQL multi-line result set validation

In this new Citrus version the tester can validate SQL Query results that have multiple rows. In the past Citrus could only handle a single row in the result set. Now this new release brings light into the dark. See also the new Groovy SQL result set validation which fits brilliant for complex multi-row SQL result set validation. The details can be found in [actions-database-query](actions-database-query)

### Extended message format support

In previous versions Citrus was primary designed to handle XML message payloads. With this new release Citrus is also able to work with other message formats such as JSON, CSV, PLAINTEXT. This applies to sending messages as well as receiving and particularly validating message payloads. The tester can specify several message validators in Citrus for different message formats. According to the expected message format the proper validator is chosen to perform the message validation.

We have implemented a JSON message validator capable of ignoring specific JSON entries and handling JSONArrays. We also provide a plain text message validator which is very basic to be honest. The framework is ready to receive new validator implementations so you can add custom validators for your specific needs.

### New XML features

XML namespace handling is tedious expecially if you have to deal with a lot of XPath expressions in your tests. Before you had need to specify a namespace context for the XPath expression every time you use them in your test - now you can have a central namespace context which declares namespaces you use in your project. These namespaces identified by some prefix are available throughout the test project which is much more maintainable and easy to use. See how it works in [xpath-namespace](xpath-namespace).

### SOAP support improvements

WsAddressing standard is now supported in Citrus ([soap-ws-adressing](soap-ws-adressing)). This means you can declare the specific WsAddressing message headers on message sender level in order to send messages with WsAddressing feature. The header is constructed automatically for all SOAP messages that are sent over the message sender.

Dynamic SOAP endpoint uri resolver enables you to dynamically address SOAP endpoints during a test. Sometimes a message sender may dynamically have to change the SOAP url for each call (e.g. address different request uri parts). With a endpoint uri resolver set on the message sender you can handle this requirement very easy. The tip for dynamic endpoint resolving was added to [soap-sender](soap-sender)

We also simplified the synchronous SOAP HTTP communication within test cases. In previous versions you had to build complex parallel and sequential container constructs in order to continue with test execution while the SOAP message sender is waiting for the synchronous response to arrive. Now you can simply fork the message sending action and continue with further test actions while synchronous SOAP communication takes place. See the [soap-fork-mode](soap-fork-mode)for details

Some really small change introduced with this release is the fact that Citrus now logs SOAP messages in their pure nature. This means that you can see the complete SOAP envelope of messages in the Citrus log files. This is more than helpful when searching for errors inside your test case.

### Http and RESTful WebServices

We have changed Http communication components for full support of RESTful WebServices on client and server side. The Http client now uses Spring's REST support for Http requests (GET, PUT, DELETE, POST, etc.). The server side has changed, too. The Http server now provides RESTful WebServices and is compliant to the existing SOAP Jetty server implementation in Citrus. If you want to upgrade existing projects to this version you may have to adjust the Spring application context configuration to some extent.

For details have a look at the upgrade guide ([history-upgrading](history-upgrading)) in this chapter or find detailed explanations to the new Http components in [http](http).

### HTML reporting

Citrus provides HTML reports after each test run with detailed information on the failed tests. You can immediately see which tests failed in execution and where the test stopped. [reporting-html](reporting-html)provides details on this new feature.

### Validation matchers

The new validation matchers will put the message validation mechanisms to a new level. With validation matchers you are able to execute powerful assertions on each message content element. For instance you can use the isNumber validation matcher for checking that a message value is of numeric nature. We added several matcher implementations that are ready for usage in your test but you can also write your custom validation matchers. Have a look at [validation-matchers](validation-matchers)for details.

### Conditional container

The new conditional test action container enables you to execute test actions only in case a boolean expression evaluates to true. So the nested test actions inside the container may be not executed at all in case a condition is not met. See [containers-conditional](containers-conditional)for details.

### Support for message selectors on message channels

Spring Integration message channels do not support message selectors like JMS queues do for example. With Citrus 1.2 we implemented a solution for this issue with a special message channel implementation. So you can use the message selector feature also when using message channels. Go to [message-channel-selector-support](message-channel-selector-support)for details.

### New test actions

We introduced some completely new test actions in this release for you. The new actions are listed below:

* Purge message channel action ()


See [actions](actions) for detailed instructions how to use the new actions.

### New functions

We introduced some new default Citrus functions that will ease the testers life. This includes commonly used functions like encoding/decoding base64 bindary data, escaping XML and generating random Java UUID values. These are the new functions in this release:

* citrus:randomUUID()
* citrus:cdataSection()
* citrus:encodeBase64()
* citrus:decodeBase64()
* citrus:digestAuthHeader()
* citrus:localHostAddress()


See [functions](functions) for detail descriptions of each function.

### Upgrading from version 1.1

If you are coming from Citrus 1.1 final you may have to look at the following points.

*  **Spring version update** We did some major version upgrades on our Spring dependencies. We are now using Spring 3.1.1, Spring Integration 2.1.2 and SpringWS 2.1.0. These new major releases bring some code changes in our Citrus API which might affect your code and configuration, too. So please update your configuration, it is definitely worth it!

*  **Spring Integration headers:** With 2.0.x version Spring Integration has removed the internal header prefix ("springintegration_"). So in some cases you might use those internal header names in your test cases in order to synchronize synchronous communication with internal message ids. Your test case will fail as long as you use the old Spring internal header prefix in the test. Simply remove the header prefix wherever used and your test is up and running again.

*  **Message validator:** You need to specify at least one message validator in the Spring application context. Before this was internally a static XML message validator, but now we offer different validators for several message formats like XML and JSON. Please see the Java API doc on MessageValidator interface for available implementations. If you just like to keep it as it was before add this bean to the Spring application context:

```xml
<bean id="xmlMessageValidator" class="com.consol.citrus.validation.xml.DomXmlMessageValidator"/>
```

*  **Test suite:** We have eliminated/changed the Citrus test suite logic because it duplicates those test suites defined in TestNG or JUnit. In older versions the tester had to define a Citrus test suite in Spring application context in order to execute test actions before/after the test run. Now these tasks before and after the test run are decoupled from a test suite. You define test suites exclusively in TestNG or JUnit. The test actions before/after the test run are separately defined in Spring application context so you have to change this configuration in your Citrus project.

See [testsuite](testsuite) for details on this configuration changes.

*  **JUnit vs. TestNG:** We support both famous unit testing frameworks JUnit and TestNG. With this release you are free to choose your prefered one. In this manner you need to add either a JUnit dependency or a TestNG dependency to your project on your own. We do not have static dependencies in our Maven POM to neither of those two. On our side these dependencies are declared optional so you feel free to add the one you like best to your Maven POM. Just add a JUnit or TestNG dependency to your Maven project or add the respective jar file to your project if you use ANT instead.



