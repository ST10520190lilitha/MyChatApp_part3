ChatApplicationPart1 

Student Information

St10520190

Lilitha Jubati

PROG5121

---

Project Information 

The `Main` class is the starting point of the QuickChat application. It handles user registration, login, and the main menu. During registration, the program collects the user's details and uses validation loops to ensure the username, password, and phone number meet the required criteria. After successful registration, the user must log in with the correct credentials before accessing the application. Once logged in, the user can send messages, view recently sent messages, or quit the program. When sending messages, the program generates a unique message ID, validates the recipient's phone number and message length, creates a message hash, and allows the user to send, store, or disregard the message. Loops and exception handling are used throughout the program to ensure valid input and smooth operation. 

The Message class is responsible for creating, validating, managing, and storing messages in the QuickChat application. It stores important message details such as the message ID, recipient phone number, message text, message hash, and send status. The class generates a unique 10-digit message ID, validates that the recipient's phone number follows the South African format (+27), and ensures that messages do not exceed 250 characters. It also creates a unique message hash using the message ID, message number, and parts of the message text. Users can choose to send, disregard, or store messages, with the message status being updated accordingly. When a message is stored, the class uses the Google Gson library to save it in a messages.json file and can also load previously saved messages from the file. Additionally, the class keeps track of the total number of messages processed and provides getter and setter methods to access and modify message information when needed. 

This Java code defines a unit test class named `MessageTest` using the JUnit 4 framework to validate the core functionality and data verification rules of a `Message` class within a chat application. It contains six individual test cases designed to check data validation logic, cryptographic hashing, and file persistence. The code systematically evaluates both positive and negative scenarios for message attributes; specifically, it verifies that valid 10-digit message IDs and properly formatted South African phone numbers (starting with "+27") pass validation checks, while rejecting non-numeric, truncated, or poorly formatted entries. Additionally, the test suite incorporates a robust retry mechanism (up to three attempts) for more complex operations, ensuring that the `Message` class can consistently generate a valid matching message hash and successfully persist message objects into a local JSON file (`messages.json`) using the Google Gson library.
