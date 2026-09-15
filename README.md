Project Overview
=====================
This Spring Boot application provides a ticket management and announcement platform for university students. The architecture a model-view-controller (MVC) pattern to isolate web routing, business logic, and database persistence via Spring Data JPA and PostgreSQL.

1.1 How to Run the Application
===============================
In order for the app to run in any computer, it is packaged and dockerized.
More specifically:
1. Under location "web-programming-assignment\e16095-assignment\" run the maven command in a cmd or terminal: mvn clean package -Dmaven.test.skip=true
2. After running the above command, a "target" folder will be created. Inside "target" folder, copy the "e16095-assignment-0.0.1-SNAPSHOT.jar" file 
and paste it inside "e16095-assignment" directory (one dir above from which the .jar file exists).
3. The dockerfile will create a lightweight container image in which the Java application will run.
4. The docker-compose will create two containers (postgres-db and web-programming-assignment) to host the DB (postgres database) 
and the Java application.
5. Finally, to start the application, simply execute the runOnWindows.bat for Windows OS (a double click is enough) or the 
runOnLinux.sh for Linux OS. runOnWindows.bat lives right under "web-programming-assignment\" dir. The application takes about 1-2 minutes to start.
6. Your docker client app should be active on your computer. For example, Docker Desktop should be running by the time the "runOnWindows.bat" runs.
7. The app's source code is under the "\web-programming-assignment\e16095-assignment" directory.
8. When the app starts, it creates an admin user for convenience. This user has username: admin and password: admin
9. Visit URL "http://localhost:8080/api/login" to start browsing the app. Since there is no other user than the admin, you have to login as admin
(using the above credentials) and create new users, tickets (technical support requests) and announcements.
10. You may logout at any time and navigate through allowed pages (based on user's role) via the "Main Page" button.

#Note: Whenever the application starts anew, the DB's stored data inside the volume get erased, meaning that in the next run DB will be empty!!

1.2 Primary Classes & Roles
==========================
* Controllers
1. LoginController: Handles user authentication, login view rendering, and session creation.
2. RegistrationControllerManages public user registrations.
3. TicketController: Manages ticket creation, viewing, and user-level ticket interactions.
4. AnnouncementController: Displays public and student management.
5. AdminTicketController: Provides administrative endpoints to review, administrator, reject, or update ticket statuses.
6. AdminUserControllerHandles administrative user management and pending registration approvals.
7. AdminAnnouncementController: Manages administrative creation, editing, and deletion of system announcements.

* Services
1. UserService: Contains user lookup logic, verification password, and registration processing.
2. TicketService: Implements ticket lifecycle rules, state transitions, and filtering by user or status.
3. AnnouncementService: Handles announcement creation, modifications, and chronological sorting.
4. RegistrationService: Manages pending onboarding requests and approval/rejection workflows.

* Entities & DTOs
1. User: JPA entity representing system accounts and role permissions (e.g., USER, ADMIN).
2. Ticket: Maps support/request tickets containing fields for title, description, status, and associated user.
3. AnnouncementRepresents global messages posted by administrators.
4. RegistrationRequest: Stores pending registration submissions before administrative review.
5. TicketDto, UserDto, RegistrationDto: Transfer objects used to decouple database schema models from web forms and API contracts.

* Mappers & Interceptors
1. UserMapper, TicketMapper: Utility classes to converted database and DTOs.
2. AuthInterceptor: Pre-calculates entry validity before request execution, blocking paths and enforcing role-based access to  /admin/*routes.








2.2 Key Endpoints
----------------------------------
Endpoint	                        HTTP Method	        Access Level	            Purpose
/login	                            GET / POST	        Public	            Renders login page and authenticates user credentials.
/register	                        GET / POST	        Public	            Displays registration form and submissions onboarding requests.
/logout	                            POST	            Authenticated	    Invalidates the active HttpSession.
/tickets	                        GET	                User / Admin	    Lists tickets that belonged to the authenticated user.
/tickets/new	                    GET / POST	        User / Admin	    Renders ticket creation form and persists new tickets.
/announcements	                    GET	                Public / User	    Displays global anarchism system.
/admin/tickets	                    GET	                Admin	            Lists all user tickets across the system with optional status filters.
/admin/tickets/{id}/status	        POST	            Admin	            Updates a specific ticket status (e.g., APPROVED, REJECTED).
/admin/registrations	            GET	                Admin	            Displays pending registration requests.
/admin/registrations/{id}/approve	POST	            Admin	            Approves a registration and generates an active user account.
/admin/announcements/new	        GET / POST	        Admin	            Creates and publishes new announcement.



* Registration Flow: Unregistered users submit a request form mapped via RegistrationController. A RegistrationRequest entity is persisted with a default PENDING status.
* Authentication: LoginController validates incoming user credentials against UserRepository. On success, the user object/role is attached to the HTTP HttpSession.
* Access Control: AuthInterceptor checks active sessions prior to controller execution. Routes prefixed with /admin require an explicit ADMIN role, redirecting unauthenticated requests back to /login.

3.3 System Functionalities
---------------------------
* Authentication & Authorization
    Custom session management bound to HttpSession.
    Interceptor-level route protection redirecting unauthenticated requests back to /login.
    Role-based view rendering for standard users v. system administrators.

* Student Onboarding & Registration
    Public registration land requests in a  PENDINGstate.
    Administrative review workflow expectormins to accept or deny new user accounts.

* Ticket Lifecycle Engine
    Standard users submit tickets with specific categories and descriptions.
    Administrative dashboards down state transitions (PENDING -> APPROVED or REJECTED).
    Real-time status tracking for users on their personal dashboard.

* Announcement Broadcast System
    Global bulletin board for administrative notice.
    Full CRUD (Create, Read, Update, Delete) capabilities reserved for administrative accounts.