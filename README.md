# slavin-tech-test

## Tech debt/future improvements _(in no particular order)_
* Support to run tests in other browsers (pass the WebDrivers into the command that kicks off the tests.  
* Investigate running tests in parallel - initial look suggests that it can be achieved in config. Not sure all tests would support parallel execution.
* Consolidate class/element specific methods for interacting with the contacts table into generic methods in the base page object class, and then use those in the 'proper' page object classes.
* I'm not 100% happy with the robustness of the interactions with the contacts grid... Works most of the time - not good enough. Needs more investigation.
* Add security tests - there's a 'naughty strings' repo on GitHub which contains a list of attack strings. I'd have tests to programmatically test each text input control.
* Currently the tests run on Windows... I imagine there'll be a little work to handle OSX / Linux (e.g. difference in file path separators between Windows(/) & OSX/Linux(\)).
* Investigate other reporting options - see if there are any with more detailed output.
* Programmatically create test data (possibly via API).
* Look into the implications of making the test data driven... test method names should be descriptive enough so as not to worry about masking test inputs.

