Instructions for the Profile Exercise

1. Create a new Github repository called 'ProfileExercise'
2. Create a new Spring Web project.  This project can use either Gradle or Maven as a build tool.
3. We will be creating a REST API that retrieves and adds a new user profile.  The profile will contain the following information:
   * Username (string)
   * First Name (string)
   * Last Name (string)
   * City (string)
   * State or Province (string)
   * Age (integer)
   * Favorite Color (string)
4. The user profile information will be stored in an in-memory map datastore that is keyed by a UUID.
5. The following API endpoints are required:
   * GET all profiles that returns a collection of UUIDs and usernames
   * GET one profile by UUID that returns all of the fields of one user profile
     * Attempting to get a profile by key that does not exist should return a 'Not Found'
   * POST one new profile that requires all fields except for 'Favorite Color' to be provided
     * Not having all of the required fields should return a 'Bad Request'
     * Not providing a 'Favorite Color' should set the stored value to 'Not Specified'
6. The API should be written using a test-first TDD process.
7. The code should be organized in a typical controller -> service -> repository tiered structure.