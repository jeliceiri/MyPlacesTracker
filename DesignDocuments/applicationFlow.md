#Application Flow Draft

##User Sign Up
1. User chooses Login on the Login Screen.
2. User chooses Signup in AWS Cognito. 
3. User fills out the New User Sign Up Form and submits.
4. The request goes to Cognito.
5. Cognito mails a verification code to the User.
6. The user enters the verification code to confirm.  
7. The request goes to the Login and Auth servlets.
8. A User object is created along with a new user in the database.
9. A Welcome message is displayed to a jsp.

##User Login
1. User fills out the Cognito Sign in Form and submits. 
2. The request goes to the Login and Auth servlets.
3. A User object is created from an existing user in the database.
4. A Welcome message is displayed to a jsp.
5. If the User is not authenticated, an error message will appear.

##View Trips
1. Index page is forwarded to the View Trips servlet.
2. The View Trips servlet uses the User DAO to select all trips associated with the User.
3. The servlet sends the list of Trips to the View Trips jsp to be displayed.

##Add Trip
1. The User clicks on the Add Trip button in the View Trips jsp.
2. The User fills out the Add Trip form and submits.
3. The Add Trip servlet creates a Trip object and uses the Trip DAO to insert the new Trip into the database.
4. The servlet uses the Trip DAO to select all trips associated with the User.
5. The servlet sends the list to Trips to the View Trips jsp to be displayed.

##Trip Info
1. The User clicks on the View button associated with a Trip name in the View Trips jsp and submits.
2. The Trip Info servlet uses the Trip DAO to select the specified trip and retrieve the associated Notes and Destinations.
3. The servlet sends the lists of Destinations and Notes and sends them to the Trip Info jsp to be displayed.

##Add Destination
1. The User clicks on the Add Destination button in the Trip Info jsp.
2. The Add Destination Form servlet uses the Trip DAO to select the associated trip and send it to the Add Destination jsp.
3. The User fills out the Add Destination form and submits.
4. The Add Destination servlet uses the Destination Dao and Trip Dao to insert a Destination into the database.
5. The servlet sends a list of Destinations and Notes associated with the Trip and sends them to the Trip Info jsp to be displayed.

##Add Travel Note
1. The User clicks on the Add Travel Note button in the Trip Info jsp.
2. The Add Note Form servlet uses the Trip Dao to select the associated trip and send it to the Add Note form.
3. The User fills out the Add Travel Note form and submits.
4. The Add Note servlet uses the Note Dao and the Trip Dao to insert a new Note into the database. 
5. The servlet sends a list of Destinations and Notes associated with the Trip and sends them to the Trip Info jsp to be displayed.

##Edit and Delete Travel Note
1. The User clicks on the Edit button associated with a Note in the Trip Info jsp.
2. The Edit Note Form servlet uses the Trip Dao to select the associated trip and send it to the Edit Note form.
3. The User fills out the Edit Note form and submits.
4. The Edit Note servlet uses the Note Dao and the Trip Dao to update or delete a new Note.
5. The servlet sends a list of Destinations and Notes associated with the Trip and sends them to the Trip Info jsp to be displayed.