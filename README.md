# slavin-tech-test

## tech debt/improvements
* Consolidate class/element specific methods for interacting with the contacts table into generic methods in the base page object, and then use those in the 'proper' page objects
* I'm not 100% happy with the robustness of my interactions with the contacts grid... Works most of the time - not good enough. Needs more investigation.
* Add security tests - there's a 'naughty strings' repo on GitHub which is a useful resource.
* Currently the