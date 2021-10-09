#Application Flow Draft

##User Sign Up
1. User chooses New User Sign Up on the Login Screen.
2. User fills out the New User Sign Up Form and submits.
3. The request goes to the Sign Up servlet.
4. The servlet creates a User object, a new user in the database, and sends a confirmation messagge to a jsp.

##User Login
1. User fills out the Login Form and submits.
2. If the user is authenticated, the server will grant access for the user to edit pages.
3. If the user is not authenticated, an error message will appear.

##View Trips
1. Index page is forwarded to the View Trips servlet.
2. The View Trips servlet uses the Trip DAO to select all trips and creates Trips objects from the results.
3. The servlet sends the list of Trips to the Trips jsp to be displayed.

##Add Trip
1. The user clicks on the Add Trip jsp link in the View Trips jsp.
2. The user fills out the Add Trip form and submits.
3. The Add Trip servlet creates a Trip object and uses the Trip DAO to insert the new Trip into the database.
4. The servlet uses the Trip DAO to select all trips and creates Trips objects from the results.
5. The servlet sends the list to the Trips jsp.

##Trip Info
1. The user clicks on a Trip Name in the View Trips jsp and submits.
2. The Trip Info servlet uses the Trip DAO to select the specified trip and create a Trip object.
3. The servlet uses the Trip object to retrieve the list of destinations and notes attached to the trip and send them to the Trip Info jsp to be displayed.