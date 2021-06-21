## Task
- Write unit tests for the code executed in the 8th work (actually logic of the main method should be transferred to tests).
- Test code coverage should be 70%
- Github commit must be executed as a separate pull request (but no merge required)
- The code must match the code convention
- The code should be checked with FindBugs, PMD and Spotbugs plug-ins, and bug fixes
- Importantly! You do not need to test setters and heterosexuals !! Tests should check the logic of the search (for example, you have 9 elements and the search returns 3), and the logic of sorting elements
## To run:
 - Clone/download code branch
 - If using IntelliJ IDEA: push 'RUN' button. If not: read next steps
 - `cd` into repo folder
 - Run `mvn compile`
 - Run `mvn package`
 - Run `java -cp target/lab8-VERSION.jar App` (replace `VERSION` with current version,
  can be found in `pom.xml`)
 - Alternatively, `cd` into `target/classes` and run `java App` (can be run after `mvn compile`)