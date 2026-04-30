### Accounting Ledger Application:



This application is a tool to help users keep track of their spending habits by keeping a record of every Deposit and Payment that the user makes.



###### Screen and Features:



**The Home Screen:** This screen gives the user initial options. Here the user can choose to add a deposit of money. Another option, the user can make a payment. Or the user can choose to look at their transaction history. You can exit the app from this screen by pressing the letter 'X'.



**Deposit Feature:** The user can activate this feature by pressing the letter "D" on the Home Screen. This screen prompts the user to enter data that the app needs to keep track of what the user deposited.



**Payment Feature:** The user can activate this feature by pressing the letter "P" on the Home Screen. This screen prompts the user to enter data that the app needs to keep track of what the user paid.



**Ledger Screen:** This screen can be reached by pressing the letter "L" on the Home Screen. Pressing the letter "L" brings the user to a new screen in the Ledger App. This screen gives the user four new options. These four options as a whole allow the user to view their transaction history. The user can return from this screen back to the Home Screen by pressing the letter "H".



**All Feature:** The user can activate this feature by pressing the letter "A" on the Ledger Screen. This feature displays all of the user's transactions from the newest entry to the oldest entry.



**Deposits History Feature:** The user can activate this feature by pressing the letter "D" on the Ledger Screen. This feature displays all of the user's deposit transactions from the newest entries to the oldest entries.



**Payment History Feature:** The user can activate this feature by pressing the letter "P" on the Ledger Screen. This feature displays all of the user's payment transactions from the newest entries to the oldest entries.



**Reports Screen:** This screen can be reached by pressing the letter "R" on the Ledger Screen. Pressing the letter "R" brings the user to a new screen in the Ledger app. This screen gives the user five more options. As a whole, these five new options give the user access to a more advanced search than the Ledger screen provided. The user can return from this screen back to the Ledger Screen by pressing the number zero.



###### Coding Language:



The coding language that was used for this project is Java.



###### Errors Made:



The common errors that I made during this project were labeling my variables with a vague title. Overthinking the process was also a hurdle to overcome. Last but not least, the variables "time" and "date" originally were set to being strings. Originally, this was not an issue for most of the code. It only became an issue when coding the Reports Screen. Using the split pattern method was the original direction being explored. But the true solution came after converting "date" and "time" from Strings to Local Date and to Local Time. The process paused while researching the two methods and how to implement them in a useful way in the code.





###### Reflection Section:



The section of code that I, as the developer, am the most proud of is the creation of the four methods that make my program functional.

Last week was a week that I wrestled with imposter syndrome more than I ever did before. So, starting off this project, I doubted my abilities. At first, I didn't like the idea of prompting the user for information first in order to build the transaction list using the CollectsTheDepositDATA() and CollectsMakingPaymentDATA() methods. But as I progressed with the idea that "I'll just polish it up later," I eventually began to realize that I loved the idea of allowing the user to type in their own information and the code to generate a newly formatted entry for my transaction.csv file. Later, I created the WritesDataToFile() method that contains its own file writer, and it writes all entries from the previous two methods to my transaction file. It also creates a new file if the transaction file doesn't already exist. Last but not least, I created a transactionFileReader(). This method contains an empty ArrayList that is used to read from the transactions file. This one method is the biggest reason that my Ledger Screen and Reports Screen give the user information. Without these four methods, my program would not be the same.

