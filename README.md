# JavaStuff
Java college assignment

Assignment option 5: Machine learning model using Naive Bayes
This program serves as a tonsillitis checker. The user can enter in their systems, and the program will show them the probability
of having tonsillitis. It gets this probability from applying the Naive Bayes algortihm to a set of test data. The user can also
check the accuracy of the algorithm by getting it to evaluate itself using some of the test data.

*** Classes ***

* Control - This is the control class and is used to instantiate an object of MenuGUI

* DataAlgorithm - This class gets an ArrayList of Patient classes from the FileProcessor class
  and uses the Naive Bayes algorithm to find the probability of a patient having tonsillitis

* DeveloperGUI - This is the GUI that lets the user test the accuracy of the algorithm

* FileProcessor - This class reads through a file line by line, and adds each line to a new Patient in patientList, returning patientList

* MenuGUI - This is the GUI that lets the user is initially greeted with, allowing them to test a Patient or enter dev options

* Patient - This class is used to simulate a Patient with attributes for their symptoms and contains a ToString() to print an object

* PatientGUI - This is the GUI that lets the user create a Patient and test the probability of it having tonsillitis

*** Instructions ***

The user is initially greeted with a main menu. They can click 'Test a Patient' to enter the symptoms of a patient
and get the probability of them having tonsillitis. They can also click 'Developer options' to either test the
accuracy of the algorithm, or display the test data in a text area.
