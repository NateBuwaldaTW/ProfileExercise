Instructions for the Profile Exercise

1. Create a new Github repository called 'ProfileExercise'
2. Create a new Spring Web project.  This project can use either Gradle or Maven as a build tool.
3. We will be creating a REST API that retrieves and adds a new user profile.  The profile will contain the following information:
   * Username
   * First Name
   * Last Name
   * City
   * State or Province
   * Age
   * Favorite Color
4. The user profile information will be stored in an in-memory map datastore that is keyed by a UUID.
5. The following API endpoints are required:
   * GET all profiles that returns a collection of UUIDs and usernames
   * GET one profile by UUID that returns all of the fields of one user profile
   * POST one new profile that requires all fields to be provided
6. The API should be written using a test-first TDD process.
7. The code should be organized in a typical controller -> service -> repository tiered structure.