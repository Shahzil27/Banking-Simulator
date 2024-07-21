#Integration Testing Method

To implement integration testing we used the code coverage tools inside of Eclipse to show the coverage of the tests. Since all the functions are used by the GUI, we implemented our integration testing in a way where the GUI would utilize the functions from all the other files.
As shown in the image [here](https://github.com/Shahzil27/Banking-Simulator/blob/main/Testing/Structure%20Based%20Testing/Integration%20Testing/IntegrationTesting.png) a great deal of many Files are used in the tests. This is how we made sure the interfacing between the classes
was functional. There were also many additonal functions created inside of [SimulatorGUI.java](https://github.com/Shahzil27/Banking-Simulator/blob/main/App/src/BankSim/SimulatorGUI.java) that can be found at the bottom that were used exclusively for testing. Since all the 
variables were private and did not require getter or setter functions, some were created to more easily ustilise the file in testing.
