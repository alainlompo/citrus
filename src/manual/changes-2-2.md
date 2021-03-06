### Changes in Citrus 2.2?!

Citrus 2.2 is a release mostly adding new features as well as improvements to given Citrus features. Bugfixes of course are also part of the package. See the following overview on what has changed.

### Arquillian support

Arquillian is a well known integration test framework that comes with a great feature set when it comes to Java EE testing inside of a full qualified application server. With Arquiliian you can deploy your Java EE services in a real application server of your choice and execute the tests inside the application server boundaries. This makes it very easy to test your Java EE services in scope with proper JNDI resource allocation and other resources provided by the application server. Citrus is able to connect with the Arquillian test case. Speaking in more detail your Arquillian test is able to use a Citrus extension in order to use the Citrus feature set inside the Arquillian boundaries. See [arquillian](arquillian) for details.

### JUnit support

Citrus supports both major players in unit testing TestNG and JUnit. Unfortunately we did not offer the same feature support for JUnit as it was done for TestNG. Now with Citrus 2.2 we improved the JUnit support in Citrus so you are able to use all features with both frameworks. This is especially related to using the **@CitrusTest** and **@CitrusXmlTest** method annotations in test classes. See [run-junit](run-junit)how it works.

### Start/Stop server action

Citrus was missing a dedicated test action to start and stop Citrus server components at tet runtime. With the newly added test actions you are able to start and stop server components as you like within your test case. See [actions-manage-server](actions-manage-server)with a detailed description.

### Citrus Ant tasks

We discontinue to support the Citrus Ant tasks. The Ant tasks were not very stable an lacked full feature support when executing test cases with JUnit in Apache Ant. Instead we added a brief description on how to execute Citrus tests with the well documented and stable default JUnit and TestNG ant tasks. See [setup-using-ant](setup-using-ant)how it works.

### Bugfixes

Bugs are part of our software developers world and fixing them is part of your daily business, too. Finding and solving issues makes Citrus better every day. For a detailed listing of all bugfixes please refer to the complete changes log of each release in JIRA ([http://www.citrusframework.org/changes-report.html](http://www.citrusframework.org/changes-report.html)).

