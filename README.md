# slavin-tech-test

## Tech debt/future improvements
* I've only run the tests in Google Chrome on Windows 10... need to make tests run on supported OS/browser combinations.
* Investigate running tests in parallel - initial look suggests that it can be achieved in config. Not sure all tests would support parallel execution.
* Convert class/element specific methods for interacting with the contacts table into generic methods in the base page object class, and then use those in the 'proper' page object classes.
* Improve the robustness of the interactions with the contacts table... I've added some retry logic in the event of _problems_ with a particular element but needs more investigation.
* Add security tests - there's a 'naughty strings' repo on GitHub which contains a list of attack strings. I'd have tests to programmatically test each text input control.
* Investigate other reporting options - see if there are any with more detailed output.
* Programmatically create test data (possibly via API) to cut down test execution time.
* Look into the implications of making the test data driven... test method names should be descriptive enough to mitigate masking test inputs and _hiding_ the purpose of the test.

