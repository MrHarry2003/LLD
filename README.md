THIS REPOSITORY CONTAINS FOLLOWING LOW LEVEL DESIGNS AS MENTIONED BELOW :-

DAY 1 :- 

  Task 1 :
    Write a program to depict Indian Politics.
    Consider the politics use cases :
    MP: is a person who won from a constituency 
    getConstituency - return their winning constituency.
    getDriver - returns the driver assigned for their vehicle (default car).
    exceedsSpendingLimit - returns true or false if Mps exceeds to their spending limit.
    PM->Ministers->MP (All of them are MPS) - PM has special permissions such as it can give permission to arrest any minister.
    PM enjoys special benefits such as Aircraft (along with car) and its designated driver. 
    Note: PM spending limit : 1 crore, Ministers: 10 lakhs, MP: 1 lakh.
    Need to design in a way  where Commisioner class can arrest MP, Ministers and PM when their expense exceeds their spending limit:
    canArrest - can arrest one or many MP.  
              Note: If PM  cant arrest.
                    If minister can arrest with PM permission
                    if mps they can be arrested without anyones permission.
    In Short, If the MP is not PM then he can be arrested by commisoner , If he is minister then can be arrested with PMs permisison.
    
  Task 2: 
    suppose you are making a program for a very famous IoT Inverter company,
    company have multiple inverters with multiple business logic,
    use cases:
    company have PCU, GTI, Zelio, Regalia, iCruze Inverters,
    All Inverters have Power rating which is determined by ( Current * Operating Voltage )
    Only PCU, GTI and Regalia are solar Inverters other are not (solar inverters get charge by solar panels and solar energy),
    Solar Inverters have Solar Panels also
    Solar Inverters further have two option one Battery version that whatever energy is produced will be stored in battery other will not store any energy,
    so PCU comes with battery but GTI have no battery,
    Solar Inverter also have GRID On , system where you can sell your extra energy back, GTI is GRID On where as this feature is not available in PCU,
    Non Solar Inverters are Simple Home Inverters Which have a Battery,"
    

DAY 2 :-

  Parking Lot Design:
    A parking lot or car park is a dedicated cleared area that is intended for parking vehicles.
    Use case
    Here are the main Actors in our system:
    Admin: Mainly responsible for adding and modifying parking floors, parking spots, entrance, and exit panels, adding/removing parking attendants, etc.
    Customer: All customers can get a parking ticket and pay for it.
    Parking attendant: Parking attendants can do all the activities on the customer’s behalf, and can take cash for ticket payment.
    System: To display messages on different info panels, as well as assigning and removing a vehicle from a parking spot.
    Here are the top use cases for Parking Lot:
    Add/Remove/Edit parking floor: To add, remove or modify a parking floor from the system. Each floor can have its own display board to show free parking spots.
    Add/Remove/Edit parking spot: To add, remove or modify a parking spot on a parking floor.
    Add/Remove a parking attendant: To add or remove a parking attendant from the system.
    Take ticket: To provide customers with a new parking ticket when entering the parking lot.
    Scan ticket: To scan a ticket to find out the total charge.
    Credit card payment: To pay the ticket fee with credit card.
    Cash payment: To pay the parking ticket through cash.
    Add/Modify parking rate: To allow admin to add or modify the hourly parking rate
    
  System Requirements:-
    We will focus on the following set of requirements while designing the parking lot:
    The parking lot should have multiple floors where customers can park their cars.
    The parking lot should have multiple entry and exit points.
    Customers can collect a parking ticket from the entry points and can pay the parking fee at the exit points on their way out.
    Customers can pay the tickets at the automated exit panel or to the parking attendant.
    Customers can pay via both cash and credit cards.
    Customers should also be able to pay the parking fee at the customer’s info portal on each floor. If the customer has paid at the info portal, they don’t have to pay at the exit.
    The system should not allow more vehicles than the maximum capacity of the parking lot. If the parking is full, the system should be able to show a message at the entrance panel and on the parking display board on the ground floor.
    Each parking floor will have many parking spots. The system should support multiple types of parking spots such as Compact, Large, Handicapped, Motorcycle, etc.
    The Parking lot should have some parking spots specified for electric cars. These spots should have an electric panel through which customers can pay and charge their vehicles.
    The system should support parking for different types of vehicles like car, truck, van, motorcycle, etc.
    Each parking floor should have a display board showing any free parking spot for each spot type.
    The system should support a per-hour parking fee model. For example, customers have to pay $4 for the first hour, $3.5 for the second and third hours, and $2.5 for all the remaining hours.



DAY 3 :-

  Task 1:
    Intent: user can paint brick in his/her city wall with caption, message and dedicate to someone on Valentine's day.
    > Anyone can read content of brick.
    > Anyone can comment on it.
    > Use cases:
    > Brick: Every country has n number of cities and every city can have 1 to n number of walls.
    > 1 wall can have max of 90 bricks. 2nd wall would be only initiated once all bricks of 1st wall will be occupied.
    > A brick can be only owned by a single guy..
    > When owner visits on his/her city wall then his brick should animate.
    > Need to find out total number of walls initiated, total number of bricks initiated in specific wall.
    > Admin can edit any brick whereas user can edit only his/her brick.
    > If more than 10 bricks would be flagged then brick would be in invisible mode.
    An owner can dedicate more than one brick to express his/ her love to more than one person whereas a specific brick can be only owned by one person.
    Find out hottest guy or girl that received max number of bricks.
    Find out the guy or girl that don't get any dedication.
    You can input 10 users from command line. Whole project should be able to run through command line.

    
  Task 2 :
    As described task is:
    You have to create a program for ATM Which would have certain defined denominations of notes : 100 ,200, 500, and 2000 INR.
    Now you have to design your ATM in such a way that at any time ATM can be top-up with any required domination like I can add 41000 as (2000 x 20) + (500 x 2) notes
    Your ATM should have a function to withdraw cash , input can be any amount:
    Use cases for withdraw as below:
    1: if amount is not present show error insufficient balance
    2: if amount is not in the factor of available denominations show error to ask for multiple of available denomination
    3: first largest denomination should be used than smaller : like if I opt for 2300 rs, amount dispatched should be (2000 x 1 ) + (200 x 1) + (100 x 1)
    3.b: if any denomination is not there like suppose you don’t have 2000 notes left in ATM , then, amount dispatched should be (500 x 4) + (200 x 1) + (100 x 1)
    
  Next step: it can be done by Modi Ji, that older denomination is not valid in case of demonetization, like 2000 Notes are banned and new 5000 notes are legal , so you code should be like you don’t need to change much of it,
    Try to achieve OOPS , and SOLID principles as much as you can,
    Also, we will add new use cases to see whether your system can adapt to those changes. If Not, then your design is bad. (SOLID,TRY,YAGNI,KISS)


DAY 4 :-

  A Library Management System is a software built to handle the primary housekeeping functions of a library. Libraries rely on library management systems to manage asset collections as well as relationships with their members. Library management systems help libraries keep track of the books and their checkouts, as well as members’ subscriptions and profiles.
  Library management systems also involve maintaining the database for entering new books and recording books that have been borrowed with their respective due dates.
  System Requirements
  Always clarify requirements at the beginning of the interview. Be sure to ask questions to find the exact scope of the system that the interviewer has in mind.
  We will focus on the following set of requirements while designing the Library Management System:
  Any library member should be able to search books by their title, author, subject category as well by the publication date.
  Each book will have a unique identification number and other details including a rack number which will help to physically locate the book.
  There could be more than one copy of a book, and library members should be able to check-out and reserve any copy. We will call each copy of a book, a book item.
  The system should be able to retrieve information like who took a particular book or what are the books checked-out by a specific library member.
  There should be a maximum limit (5) on how many books a member can check-out.
  There should be a maximum limit (10) on how many days a member can keep a book.
  The system should be able to collect fines for books returned after the due date.
  Members should be able to reserve books that are not currently available.
  The system should be able to send notifications whenever the reserved books become available, as well as when the book is not returned within the due date.
  Each book and member card will have a unique barcode. The system will be able to read barcodes from books and members’ library cards.
  Use case diagram
  We have three main actors in our system:
  Librarian: Mainly responsible for adding and modifying books, book items, and users. The Librarian can also issue, reserve, and return book items.
  Member: All members can search the catalog, as well as check-out, reserve, renew, and return a book.
  System: Mainly responsible for sending notifications for overdue books, canceled reservations, etc.
  Here are the top use cases of the Library Management System:
  Add/Remove/Edit book: To add, remove or modify a book or book item.
  Search catalog: To search books by title, author, subject or publication date.
  Register new account/cancel membership: To add a new member or cancel the membership of an existing member.
  Check-out book: To borrow a book from the library.
  Reserve book: To reserve a book which is not currently available.
  Renew a book: To reborrow an already checked-out book.
  Return a book: To return a book to the library which was issued to a member.



DAY 5 :-

  Create a whats app as following
  Users have contacts and can chat with any contact
  Messaging in text audio and video
  Users can see the status of all the contacts
  Users can post status
  Status can be text and image


DAY 6:-

  Hotel Management system
  
  
  Problem Statement :
  Application for Hotel reservation. We will take the selection criteria from user and display the hotels list for user basing on the criteria. User can book the room if there is availability of the rooms in that particular hotel. There are three different types of user roles for the application they are administrator , hotel agent and normal user. Following are the actions provided for each user.
  
  
  Normal user :
  Can register for the site
  Search the hotel details basing on the criteria.
  Book the hotel room
  Can modify the self details.
  Hotel Agent:
  Can register for the site
  Can add/update the details of the hotel.
  
  
  Adminstrator:
  Will approve the new hotel details added to the application
  Can delete the user/hotel details.
  Minimal Features :
  Adding Hotel information such as hotel name, location, number of rooms , facilities etc. to the database
  Listing the hotels based on different criteria selected by the user.
  User able to select a hotel and book a room.
  Booking permitted only if there are rooms available
  Displaying the reservation status.
  Registration of users.
  Update user details.
  Modify hotel details.
  Approval of the details entered by the hotel agent.
  Delete user/hotel details by admin
  Additional Features:
  Taking Feedback from user.
  Rating the hotels based on the feedback.
  
  
  Goals:
  To complete the hotel booking flow, registration of the users, adding details of the hotels.
  Deliverables:
  Minimal Features and additional features provided if time permits.
  Out of scope:
  We are not embedding payment gateway in the current application we will try if time permits after completion of additional features.
