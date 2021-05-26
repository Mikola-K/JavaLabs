## Task
Write code for Lab 2
- Concert hall. Implement a hierarchy of performances that can take place in a concert hall (for example, a circus show, a symphony orchestra concert, etc.). Search for performances in which musicians take part, and display the result sorted by the number of musicians involved
Implement the ability to sort performances by the average ticket price
The implementation of sorting should provide the ability to sort both in descending and ascending order	
- Draw a UML class diagram https://drive.google.com/file/d/1AagWhSkkZgEDvQEBdu__osKVnGrpmPn2/view
- Use java code convention
- CLasses must be distributed in packages
- Work with console must be minimal
- Code must contain only that classes that are described in the diagram
- Sorting must use java built-in methods
- Sorting must be implemented in separate method
- No static methods/attributes are allowed (the only exception is a main method)
- You must use an Enum
- Code must be in a separate branch with PR
- Comparison must be implemented using lambdas
- Instead of getters/setters you should use @Data annotation from lombok
- Use maven and Jococo(in build section), FindBugs, PMD, CheckStyle plugins(reporting section)
- Run mvn site and fix errors reported by checkstyle, pmd and findbugs
## To run:
 - Clone/download code branch
 - If using IntelliJ IDEA: push 'RUN' button. If not: read next steps
 - `cd` into repo folder
 - Run `mvn compile`
 - Run `mvn package`
 - Run `java -cp target/lab8-VERSION.jar com.maxrt.shoeshop.App` (replace `VERSION` with current version,
  can be found in `pom.xml`)
 - Alternatively, `cd` into `target/classes` and run `java com/maxrt/shoeshop/App` (can be run after `mvn compile`)