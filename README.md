Accounting Ledger Application:

This application is a tool to help users to keep track of their spending habits by keeping a record of the every Deposit and Payment that the user makes.



Screen and Features:



The Home Screen: This screen gives the user initial options. Here the user can choose to add a deposit of money. Another option, the user can make a payment. Or the user can choose to look at their transaction history. You can exit the app from this screen by pressing the letter 'X'.



Deposit Feature: The user can activate this feature by pressing the letter "D" on the Home Screen. This screen prompts the user to enter data that the app needs to keep track of what the user deposited.



Payment Feature: The user can activate this feature by pressing the letter "P" on the Home Screen. This screen prompts the user to enter data that the app needs to keep track of what the user paid.



Ledger Screen: This screen can be reached by pressing the letter "L" on the Home Screen. Pressing the letter "L" bring the user to a new screen in the Ledger App. This screen gives the user four new options. These four options as a whole allows the user to view their transaction history. The user can return from this Screen back to the Home Screen by pressing the letter "H".



All Feature: The user can activate this feature by pressing the letter "A" on the Ledger Screen. This feature displays all of the users transactions from the newest entry to the oldest entry.



Deposits History Feature: The user can activate this feature by pressing the letter "D" on the Ledger Screen. This feature displays all of the users deposit transactions from the newest entries to the oldest entries.



Payment History Feature: The user can activate this feature by pressing the letter "P" on the Ledger Screen. This feature displays all of the users payment transactions from the newest entries to the oldest entries.



Reports Screen: This screen can be reached by pressing the letter "R" on the Ledger Screen. Pressing the letter "R" brings the user to a new screen in the Ledger app. This Screen gives the user Five more options. As a whole these Five new options gives the user access to a more advanced search than the Ledger screen provided. The user can return from this screen back to the Ledger Screen by pressing the number Zero.







Coding Language: 

The coding language that was used for this project is Java. 



Errors Made:

The common errors that I made during this project was labeling my variables with a vague title. Overthinking the process was also a hurdle to overcome. Last but not least the variables "time" and "date" originally were set to being a string. originally this was not a issue for most of the code. It only became a issue when coding the Reports Screen. Using the split. Pattern method was the was the original direction being explored. But the true solution came after converting "date" and "time" from Strings to Local Date and to Local Time. The process paused while researching the two methods and how to implement them in a useful way to the code.



Section to Brag:

The section of code that I, as the developer, am the most proud of is the creation of the four methods that makes my program functional.

Last week was a week that I wrestled with imposter syndrome more than I ever did before. So starting off this project I doubted my abilities. At first I didn't like the idea of prompting user for information first in order to build the transaction list using theCollectsTheDepositDATA(), and CollectsMakingPaymentDATA() . But as I progressed through with the idea that "I'll just polish it up later" I eventually began to realize that I loved the idea of allowing the user to type in their own information and the code a to generate a newly formated entry for my transaction.csv file. Later I created the WritesDataToFile() method that contains it's own file writer and it write all entry from the previous to methods to my transaction file. I also creates a new file if the transaction file doesn't already exist. Last but not least I created a transactionFileReader(). This method contains a empty Array list, that is used to read from the transactions file. This one method the biggest reason that my Ledger Screen and Reports Screen gives the user information. without these four methods my program would not be the same.



&#x20; 

