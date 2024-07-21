<img src="media/image1.png" style="width:6.5in;height:1.10972in"
alt="https://www.uregina.ca/communications-marketing/assets/visual-identity/tagline-urlogo-white-background/ur_logo-w-1-line-tagline_horiz_full-colour_rgb.png" />

ENSE 375 – Software Testing and Validation

Online Banking Simulator

Quinn Maloney (200431628)

Brooklyn Coulson (200375222)

Shahzil Siddiqui (200448986)

# Table of Contents

[1 Introduction [5](#introduction)](#introduction)

[2 Design Problem [6](#design-problem)](#design-problem)

[2.1 Problem Definition [6](#problem-definition)](#problem-definition)

[2.2 Design Requirements
[6](#design-requirements)](#design-requirements)

[2.2.1 Functions [6](#functions)](#functions)

[2.2.2 Objectives [6](#objectives)](#objectives)

[2.2.3 Constraints [6](#constraints)](#constraints)

[3 Solution [7](#solution)](#solution)

[3.1 Solution 1 [7](#solution-1)](#solution-1)

[3.2 Solution 2 [7](#solution-2)](#solution-2)

[3.3 Final Solution [7](#final-solution)](#final-solution)

[3.3.1 Components [7](#components)](#components)

[3.3.2 Features [7](#features)](#features)

[3.3.3 Environmental, Societal, Safety, and Economic Considerations
[7](#environmental-societal-safety-and-economic-considerations)](#environmental-societal-safety-and-economic-considerations)

[3.3.5 Test cases and results [7](#limitations)](#limitations)

[3.3.4 Limitations [7](#limitations)](#limitations)

[4 Team Work [8](#team-work)](#team-work)

[4.1 Meeting 1 [8](#meeting-1)](#meeting-1)

[4.2 Meeting 2 [8](#meeting-2)](#meeting-2)

[4.3 Meeting 3 [8](#meeting-3)](#meeting-3)

[4.4 Meeting 4 [8](#meeting-4)](#meeting-4)

[5 Project Management [9](#project-management)](#project-management)

[6 Conclusion and Future Work
[10](#conclusion-and-future-work)](#conclusion-and-future-work)

[7 References [11](#references)](#references)

[8 Appendix [12](#appendix)](#appendix)

- Proof read the text for typing and grammar mistakes.

- Follow the IEEE Bibliography style for the references by selecting
  "References/ Citations & Bibliography/ Style".

# List of Figures

# List of Tables

# Introduction

- Give a brief description of the design and a summary of the relevant
  background information related to the topic. Give a rationale about
  what is needed and why.

- Give the reader an overview of what is in the next sections.

- Do not put any detailed results of your work here.

# Design Problem

This section has the following two subsections:

## Problem Definition

We strive to create an online banking simulator to assist those who are
new to using online banking and would like to have a better
understanding of how to use this new technology effectively and
efficiently. This simulator will be using preset accounts for the user
to test online banking with to better understand how they may use it for
their own banking needs without the worry of damaging their financials
in the process. The motivation for this project stems from the
observation that many growing individuals lack education on how one
should properly operate and interact with a banking system.
Acknowledging the fundamental role banking plays in our daily lives, we
find it motivating to develop such a system. Some restrictions may
include: deposit restrictions (can’t be below 0, can’t be above X),
withdraw restrictions (can’t be 0 or lower, can’t be more than you
have), daily withdrawal limits (cannot withdraw more than X in a day
determined by account type), login and signup restrictions (length
and/or required characters).

## Design Requirements

### Functions

- Withdraw: Takes money out of select account

- New Login: Create login credentials for a user

- Login: Login a user

- Deposit: Adds money to select account

- Etransfer: Send money from your account to someone else within your
  contact list or to a new contact

  - Add New Contact: Add a new recipient to your contact list

  - Delete Contact: Remove a recipient from your contact list

- Transfer between accounts: Takes funds from one account to add to
  another

- Pay Bill: select a payee to send money to

  - Add Payee: Add account information for a new payee

  - Remove Payee: Remove payee

- Update Account Info:

  - Update Name: allows to change the username

  - Update Address allows to change address

  - Update Phone Number: allows to change phone number

- View Account Balance: Check the balance of money within a specified
  account associated with the logged in user’s banking plan

### Objectives

- Be able to simulate creating login credentials (general bank account)
  \[Primary\]

- Be able to edit limited account settings (login credentials, address)
  \[Primary\]

- Be able to login with preset account (different bank account types for
  them to be able to play around with) \[Primary\]

- Withdraw and deposit funds on preset accounts \[Primary\]

- Transfer money from one account to another \[Secondary\]

- Simulate e-transfers from one preset account holder to another
  \[Secondary\]

- Add a payee and demonstrate how to pay bills electronically
  \[Secondary\]

- Demonstrate restrictions when moving monetary funds according to
  preset account types \[Primary\]

- View balances within existing accounts within a logged in user
  \[Primary\]

### Constraints

- Economic factors

  - Cost

  - Software available

- Regulatory compliance (Security and Access)

  - No real data from any account holders with the organization will be
    used

  - Ensure login details are correct before granting access to the
    (dummy) account information

- Reliability

  - It accurately simulates an interaction one would have with a real
    banking application

  - The software will be able to handle all incorrect input properly

- Ethics

  - No info based on real actors

  - Does not mimic existing banking institutions' design that could
    become a culprit of fraud.

# Solution

In this section, you will provide an account of some solutions your team
brainstormed to implement the project. Some solutions might not have all
the desired features, some might not satisfy the constraints, or both.
These solutions come up in your mind while you brainstorm ways of
implementing all the features while meeting the constraints. Towards,
the end you select a solution that you think has all the features and
satisfies all the constraints. Remember that an engineering design is
iterative in nature!

## Solution 1

A full banking application with an embedded database to represent a
fully functional application. In this version we envision to deliver the
closest experience to our user with respect to using a banking
application without the real-life risks that are closely coupled. We
envisioned using an SQL database to hold sets of data where the users
can create one of their own accounts. Based on the user’s requirements,
this includes a child, student, and an everyday account. The primary
reason we chose not to pursue with this solution is with respect to the
project timeline and delivery constraints. In addition, managing a
database requires for resources and time to be further divided, causing
a deviation from the project’s primary goal and objectives, which falls
beyond the scope of the project.

<img src="media/image2.png" style="width:4.18395in;height:2.15857in"
alt="A graph paper with a drawing Description automatically generated" />

> Figure 1: Low fidelity paper prototype for main page, solution 1.

<img src="media/image3.png" style="width:4.17455in;height:2.12767in"
alt="A white sheet with blue writing Description automatically generated with medium confidence" />

> Figure 2: Low fidelity prototype for withdraw page, solution 1.

## Solution 2

Our second solution is to change from a banking application to make a
banking simulation. This allows us to have similar functionality without
requiring a database. The application will be able to simulate a user
logging in with either pre-made or their own credentials, withdraw or
deposit money into accounts, demonstrate restrictions and limits when
moving money, view balances, and edit or change the accounts settings.
Like solution one, we will still include multiple banking plans to
represent the different types of accounts and restrictions a user is
likely to face in a real banking application. The difference being we
will not have to develop and maintain a database to accompany the
banking application.

<img src="media/image4.png" style="width:3.66467in;height:2.00099in"
alt="A graph paper with text on it Description automatically generated" />

Figure 3: Low fidelity paper prototype for main page, solution 2.

> <img src="media/image5.png" style="width:3.59552in;height:1.84077in"
> alt="A whiteboard with blue and red text Description automatically generated" />

Figure 4: Low fidelity prototype for withdraw page, solution 2.

## Final Solution

This is the final solution. <span class="mark">Explain why it is better
than other solutions</span>. You may use a table for comparison
purposes. After providing the reason for selecting this solution, detail
it below.

The development team decided on three total designs for the solutions,
where the first two are illustrated in figures 1, 2, 3 and 4,
respectively. The final design considers the project’s scope and
customer deliverability, ensuring and maximizing product neutrality. As
such, the project development team designed the following final
solution.

<img src="media/image6.png" style="width:4.57233in;height:1.95741in"
alt="A screenshot of a computer screen Description automatically generated" />

Figure 5: Main user interface page for the final solution.

<img src="media/image7.png" style="width:4.55281in;height:1.93738in"
alt="A screenshot of a computer screen Description automatically generated" />

Figure 6: Withdraw page for the final solution.

The development team decided to approach selecting the best solution
according to both the qualitative and quantitative methodologies. The
selection process begun with outlining the pros and cons for all three
proposed solutions. The conceptualized findings were recorded in a table
illustrated below.

<img src="media/image8.png" style="width:4.98995in;height:2.28813in"
alt="A table with text and images Description automatically generated with medium confidence" />

Figure 7: Pros and Cons for each solution.

Due to the fact that the pros and cons chart, alone, is a superficial
qualitative approach, the following decisive decision matrix was created
with the attempt to quantity the findings from figure 7 where decisive
categories were created and assigned weight. The weightage of the
categories helped the development team prioritize the most important
aspects of the minimal viable product (MVP) from both the development
and user perspectives.

<img src="media/image9.png" style="width:5.33306in;height:2.43748in"
alt="A table with numbers and equations Description automatically generated" />

Figure 8: quantitatively grading each solution.

This comparative approach grades the solution according to the
categories outlined in the left most column of figure 8, where value to
customers and ease of use hold the maximum weightage of 5, and the
development teams believes them to be the most important factions given
the primary purpose of this simulator. While the final solution scores
lower in terms of features as a database is not implemented in it, it
totals high in value to customer and out scores the other solutions in
Environmental factors and ease of use. Even the lack of a database is a
security and safety asset in the sense that entered user information
will never be stored on a server and is instead destroyed after the
session is closed. Furthermore, the final solution design utilizes
neutral colours and presents the simplest graphical user interface
(comparatively). Especially where the options in the main page are
purposefully centered to immediately catch the target audience focus,
drawing attention. Whereas in the other solutions, the user interface is
convoluted and offers a complex presentation due to the extra features.
In addition, a left-to-right design approach was implemented in the
withdraw page as most of the targeted audience in Canada scans content
from the left. In the final design, first, the amount available in each
account are presented and later the input field prompts the user to
enter a value. After which a button specific to the account can be
pressed to confirm the withdrawal.

### Components

What components you used in the solution? What is the main purpose of
using individual component? Provide a block diagram (with a numbered
caption, such as Fig. 1) representing the connectivity and interaction
between all the components.

### Features

Give an account of all the features your solution has. These features
may be tabulated (with a title) for improved comprehension.

### Environmental, Societal, Safety, and Economic Considerations

Explain how your engineering design took into account environmental,
societal, economic and other constraints into consideration. It may
include how your design has positive contributions to the environment
and society? What type of economic decisions you made? How did you make
sure that the design is reliable and safe to use?

### Test Cases and results

What test suits did you design to test your prototype? How did you
execute the test cases to test the prototype?

When the first version of the product was programmed, the development
team began the software testing phase. The first testing suit was
composed of unit tests that spanned and covered all branches for each
method. As the factory design pattern was used, this meant that unit
testing was practiced for all classes that implemented the “Plans”
interface. This included the following classes: Basic.java,
Student.java, and Kids.java. This is represented in table 2 where for
version 1, test cases 1-23 were executed.

A second version of the product was created with the creation and
addition of the Tuple class that allows the methods to return two
values: a Boolean, and result description. As such Regression Testing
was performed for all of the Basic, Student, and Kids classes, where
test cases 1-21 were modified to accommodate the return type from
Boolean to Tuple. Integration testing was then carried out in using the
Code Coverage feature through the IntelliJ framework. The Code Coverage
Testing was performed on the FactoryPlanController.java that makes use
of the SimulatorGUI.java class to drive the application. The product was
then tested against the specifications using the Robust Boundary Value
Analysis (BVA).

A few test cases from the BVA resulted in a failure where the expected
result did not match with he actual results. This was particularly in
the test cases with negative withdrawals and deposits. The Integration
testing using Code Coverage had also highlighted some dead code methods.
As such a third version of the product was created that handled the
discrepancies from the BVA and Code Coverage. Once again, the regression
and Integration testing were executed again with the additional test
cases 24-28 as shown in table 2. Lastly, BVA, State Transition and Use
Case Testing, were executed to test against the specifications.

Table 1 from the appendix demonstrates all the test cases method
signatures in detail that are present in the three aforementioned
classes. The following table summarized the test suits that were
designed to test the prototype for each version of the software:

<table>
<colgroup>
<col style="width: 16%" />
<col style="width: 21%" />
<col style="width: 62%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Software Version</strong></th>
<th><strong>Testings</strong></th>
<th><strong>Test Suit with Test Cases</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Version 1</td>
<td>Unit</td>
<td>T<sub>1</sub> = { t<sub>1</sub>, t<sub>2</sub>, t<sub>3</sub>,
t<sub>4</sub>, t<sub>5</sub>, t<sub>6</sub>, t<sub>7</sub>,
t<sub>8</sub>, t<sub>9</sub>, t<sub>10</sub>, t<sub>11</sub>,
t<sub>12</sub>, t<sub>13</sub>, t<sub>14</sub>, t<sub>15</sub>,
t<sub>16</sub>, t<sub>17</sub>, t<sub>18</sub>, t<sub>19</sub>,
t<sub>20</sub>, t<sub>21</sub>, t<sub>22</sub>, t<sub>23</sub>}</td>
</tr>
<tr class="even">
<td>Version 2</td>
<td><p>Regression</p>
<p>Integration</p>
<p>BVA</p></td>
<td>T<sub>2</sub> = { t<sub>1</sub>’, t<sub>2</sub>’, t<sub>3</sub>’,
t<sub>4</sub>’, t<sub>5</sub>’, t<sub>6</sub>’, t<sub>7</sub>’,
t<sub>8</sub>’, t<sub>9</sub>’, t<sub>10</sub>’, t<sub>11</sub>’,
t<sub>12</sub>’, t<sub>13</sub>’, t<sub>14</sub>’, t<sub>15</sub>’,
t<sub>16</sub>’, t<sub>17</sub>’, t<sub>18</sub>’, t<sub>19</sub>’,
t<sub>20</sub>’, t<sub>21</sub>’, t<sub>22</sub>, t<sub>23</sub>}</td>
</tr>
<tr class="odd">
<td>Version 3</td>
<td><p>Regression</p>
<p>Integration</p>
<p>State Transition</p>
<p>Use Case</p>
<p>BVA</p></td>
<td>T<sub>3</sub> = { t<sub>1</sub>’, t<sub>2</sub>’, t<sub>3</sub>’,
t<sub>4</sub>’, t<sub>5</sub>’, t<sub>6</sub>’, t<sub>7</sub>’,
t<sub>8</sub>’, t<sub>9</sub>’, t<sub>10</sub>’, t<sub>11</sub>’,
t<sub>12</sub>’, t<sub>13</sub>’, t<sub>14</sub>’, t<sub>15</sub>’,
t<sub>16</sub>’, t<sub>17</sub>’, t<sub>18</sub>’, t<sub>19</sub>’,
t<sub>20</sub>’, t<sub>21</sub>’, t<sub>24</sub>, t<sub>25</sub>,
t<sub>26</sub>, t<sub>27</sub>, t<sub>28</sub>}</td>
</tr>
</tbody>
</table>

Table 2: Shows all the test suits with all the test cases.

### Limitations

Every product has some limitations, and so is the case with your design
product. Highlight some of the limitations of your solution here.

# Team Work

Since this is a group project, you must have a fair distribution of
tasks among yourselves. To this end, you must hold meetings to discuss
the distribution of tasks and to keep a track of the project progress.

## Meeting 1 

## **Time:** May 23, 2024 9:30 pm to 11:45 pm

**Agenda:** Discuss and decide on Project Topic, Create link for project
on github, Email Prof GitHub link of project

<table>
<colgroup>
<col style="width: 21%" />
<col style="width: 21%" />
<col style="width: 22%" />
<col style="width: 34%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Team Member</strong></th>
<th><strong>Previous Task</strong></th>
<th><strong>Completion State</strong></th>
<th><strong>Next Task</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Brooklyn Coulson</td>
<td>Brainstorm project ideas</td>
<td>100%</td>
<td><p>Project Idea</p>
<p>Email prof the GitHub link of the project</p></td>
</tr>
<tr class="even">
<td>Quinn Maloney</td>
<td>Brainstorm project ideas</td>
<td>100%</td>
<td>Potential Restrictions</td>
</tr>
<tr class="odd">
<td>Shahzil Siddiqui</td>
<td>Brainstorm project ideas</td>
<td>100%</td>
<td><p>Project Motivation</p>
<p>Create Project GitHub</p></td>
</tr>
</tbody>
</table>

## Meeting 2 

## **Time:** May 29, 2024 4:00 pm to 5:30 pm

**Agenda:** Discuss design requirements (functions, objectives,
constraints)

<table>
<colgroup>
<col style="width: 21%" />
<col style="width: 21%" />
<col style="width: 22%" />
<col style="width: 34%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Team Member</strong></th>
<th><strong>Previous Task</strong></th>
<th><strong>Completion State</strong></th>
<th><strong>Next Task</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Brooklyn Coulson</td>
<td><p>Project Idea</p>
<p>Email prof the GitHub link of the project</p></td>
<td><p>100%</p>
<p>100%</p></td>
<td>Design Requirements</td>
</tr>
<tr class="even">
<td>Quinn Maloney</td>
<td>Potential Restrictions</td>
<td>100%</td>
<td><p>Design Requirements</p>
<p>Update the Report template and push to GitHub</p></td>
</tr>
<tr class="odd">
<td>Shahzil Siddiqui</td>
<td><p>Project Motivation</p>
<p>Create Project GitHub</p></td>
<td><p>100%</p>
<p>100%</p></td>
<td><p>Design Requirements</p>
<p>Clarify some questions with the prof</p></td>
</tr>
</tbody>
</table>

## Meeting 3

**Time:** June 15, 2024 10:32 am to 11:30 am

**Agenda:** Discuss Project Solutions 1, 2, 3

<table>
<colgroup>
<col style="width: 21%" />
<col style="width: 21%" />
<col style="width: 22%" />
<col style="width: 34%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Team Member</strong></th>
<th><strong>Previous Task</strong></th>
<th><strong>Completion State</strong></th>
<th><strong>Next Task</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Brooklyn Coulson</td>
<td>Design Requirements</td>
<td>100%</td>
<td>Final Solution</td>
</tr>
<tr class="even">
<td>Quinn Maloney</td>
<td><p>Design Requirements</p>
<p>Update the Report template and push to GitHub</p></td>
<td><p>100%</p>
<p>100%</p></td>
<td>Second Solution</td>
</tr>
<tr class="odd">
<td>Shahzil Siddiqui</td>
<td><p>Design Requirements</p>
<p>Clarify some questions with the prof</p></td>
<td><p>100%</p>
<p>100%</p></td>
<td>First Solution</td>
</tr>
</tbody>
</table>

## Meeting 4

**Time:** June 20, 2024 5:05 pm

**Agenda:** Finalize Solutions

<table>
<colgroup>
<col style="width: 21%" />
<col style="width: 21%" />
<col style="width: 22%" />
<col style="width: 34%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Team Member</strong></th>
<th><strong>Previous Task</strong></th>
<th><strong>Completion State</strong></th>
<th><strong>Next Task</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Brooklyn Coulson</td>
<td>Final Solution</td>
<td>100%</td>
<td>Finalize Solutions</td>
</tr>
<tr class="even">
<td>Quinn Maloney</td>
<td>Second Solution</td>
<td>100%</td>
<td>Finalize Solutions</td>
</tr>
<tr class="odd">
<td>Shahzil Siddiqui</td>
<td>First Solution</td>
<td>100%</td>
<td>Finalize Solutions</td>
</tr>
</tbody>
</table>

# Project Management

Provide a Gantt chart showing the progress of your work here. Mention
all the tasks along with their predecessors. Provide the slack time of
each task and identify the critical path.

# Conclusion and Future Work

- A summary of what you achieved. Mention all the design functions and
  objectives that you achieved while satisfying the constrains?

- While keeping the limitations of your solution, provide
  recommendations for future design improvements.

# References

- Use the IEEE reference style.

- Do not put any reference if it is not cited in the text.

# Appendix

> If you want to provide an additional information, use this appendix.

<table>
<colgroup>
<col style="width: 19%" />
<col style="width: 80%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Test Case</strong></th>
<th><strong>Test Method Signature</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>t1, t1’</td>
<td>test_Constructor_AccountHolderInfo</td>
</tr>
<tr class="even">
<td>t2, t2’</td>
<td>test_Constructor_Chequing_Balance</td>
</tr>
<tr class="odd">
<td>t3, t3’</td>
<td>test_Constructor_Chequing_AccNum</td>
</tr>
<tr class="even">
<td>t4, t4’</td>
<td>test_Constructor_Chequing_AccType</td>
</tr>
<tr class="odd">
<td>t5, t5’</td>
<td>test_Constructor_publicVars_WithdrawCount</td>
</tr>
<tr class="even">
<td>t6, t6’</td>
<td>test_Constructor_publicVars_TransActionCount</td>
</tr>
<tr class="odd">
<td>t7, t7’</td>
<td>test_Withdraw_Success</td>
</tr>
<tr class="even">
<td>t8, t8’</td>
<td>test_Withdraw_Failure_notEnoughBalance</td>
</tr>
<tr class="odd">
<td>t9, t9’</td>
<td>test_Withdraw_Failure_exceedsWithdrawLimit</td>
</tr>
<tr class="even">
<td>t10, t10’</td>
<td>test_Withdraw_Failure_exceedsTotalWithdrawLimit</td>
</tr>
<tr class="odd">
<td>t11, t11’</td>
<td>test_WithdrawBoundary_Success_DailyTransactionCount</td>
</tr>
<tr class="even">
<td>t12, t12’</td>
<td>test_Withdraw_Failure_ExceedsDailyTransactionCount</td>
</tr>
<tr class="odd">
<td>t13, t13’</td>
<td>test_Deposit_Success</td>
</tr>
<tr class="even">
<td>t14, t14’</td>
<td>test_DepositBoundary_Success_</td>
</tr>
<tr class="odd">
<td>t15, t15’</td>
<td>test_Deposit_Failure_ExceedsTransctionLimit</td>
</tr>
<tr class="even">
<td>t16, t16’</td>
<td>test_ViewBalance_Success_Chequing</td>
</tr>
<tr class="odd">
<td>t17, t17’</td>
<td>test_ViewBalance_Success_Savings</td>
</tr>
<tr class="even">
<td>t18, t18’</td>
<td>test_TransferFunds_Success</td>
</tr>
<tr class="odd">
<td>t19, t19’</td>
<td>test_TransferFundsBoundary_Success</td>
</tr>
<tr class="even">
<td>t20, t20’</td>
<td>test_TransferFunds_Failure_ExceedsTransactionLimit</td>
</tr>
<tr class="odd">
<td>t21, t21’</td>
<td>test_TransferFunds_Failure_exceedsFunds</td>
</tr>
<tr class="even">
<td>t22</td>
<td>test_ResetCounter_Success_withdrawCount</td>
</tr>
<tr class="odd">
<td>t23</td>
<td>test_ResetCounter_Success_transactionCount</td>
</tr>
<tr class="even">
<td>t24</td>
<td>test_Withdraw_Failure_NegativedailyWithdrawCount</td>
</tr>
<tr class="odd">
<td>t25</td>
<td><u>test_Withdraw_Failure_NegativeWithdrawal</u></td>
</tr>
<tr class="even">
<td>t26</td>
<td>test_Withdraw_Failure_NegativeDailyTransactionCount</td>
</tr>
<tr class="odd">
<td>t27</td>
<td>test_Deposit_Failure_Negativedeposit</td>
</tr>
<tr class="even">
<td>t28</td>
<td>test_Deposit_Failure_NegativeDailyTransactionCount</td>
</tr>
</tbody>
</table>

Table 1: this table contains all the test cases.
