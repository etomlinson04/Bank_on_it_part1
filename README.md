# Bank Project (Part 1)

A bank program in Java. That allows you to do the basic functions of what a bank does.

## How to run

```
make testCustomer
```

Test login: user name `Alice`, PIN `0000`.

## UML Class Diagram

```mermaid
classDiagram
    class HasMenu {
        <<interface>>
        +Scanner IN
        +menu() String
        +start() void
    }

    class CheckingAccount {
        -double balance
        +CheckingAccount()
        +CheckingAccount(double balance)
        +getBalance() double
        +getBalanceString() String
        +setBalance(double balance) void
        +checkBalance() void
        -getDouble() double
        +makeDeposit() void
        +makeWithdrawal() void
        +menu() String
        +start() void
        +main(String[] args)$ void
    }

    class SavingsAccount {
        -double interestRate
        +getInterestRate() double
        +setInterestRate(double interestRate) void
        +calcInterest() void
        +main(String[] args)$ void
    }

    class User {
        <<abstract>>
        -String userName
        -String PIN
        +User()
        +login() boolean
        +login(String userName, String PIN) boolean
        +setUserName(String userName) void
        +getUserName() String
        +setPIN(String PIN) void
        +getPIN() String
        +getReport()* String
    }

    class Customer {
        -CheckingAccount checking
        -SavingsAccount savings
        +Customer()
        +Customer(String userName, String PIN)
        +changePin() void
        +getReport() String
        +menu() String
        +start() void
        +main(String[] args)$ void
    }

    HasMenu <|.. CheckingAccount : implements
    HasMenu <|.. User : implements
    CheckingAccount <|-- SavingsAccount : extends
    User <|-- Customer : extends
    Customer *-- CheckingAccount : has one
    Customer *-- SavingsAccount : has one
```

## Algorithm

### Customer main

```
create a Customer (Alice, PIN 0000)
if login() succeeds
    start the customer menu
else
    end the program
```

### login()

```
ask for user name
ask for PIN
if user name and PIN both match the customer's
    print "Login Successful"
    return true
else
    print "Login Failed"
    return false
```

### Customer start()

```
keepGoing = true
while keepGoing
    show the customer menu and read response
    if response is 0
        keepGoing = false
    else if response is 1
        run the checking account menu
    else if response is 2
        run the savings account menu
    else if response is 3
        change the PIN
    else
        print an error message
```

### Account start() (checking and savings)

```
keepGoing = true
while keepGoing
    show the account menu and read response
    if response is 0
        keepGoing = false
    else if response is 1
        print the current balance
    else if response is 2
        read an amount
        add it to the balance
        print the new balance
    else if response is 3
        read an amount
        subtract it from the balance
        print the new balance
    else
        print an error message
```

### getDouble()

```
try to convert the user's input to a double
if the input is not a number
    print an error message
    return 0
else
    return the number
```

