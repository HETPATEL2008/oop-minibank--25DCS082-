# com.het.minibank.MiniBank — Project Structure

```
com.het.minibank.MiniBank
└── src
    ├── (default package)
    │   ├── com.het.minibank.MiniBank.java
    │   ├── com.het.minibank.BankInfo.java
    │   └── com.het.minibank.MenuOption.java
    │
    ├── model
    │   ├── Account.java
    │   ├── SavingsAccount.java
    │   ├── CurrentAccount.java
    │   ├── FixedDepositAccount.java
    │   ├── Customer.java
    │   ├── TransactionType.java
    │   ├── Command.java
    │   ├── Transactable.java
    │   ├── InterestBearing.java
    │   ├── WithdrawRule.java
    │   └── Premium.java
    │
    ├── model.annotation
    │   ├── Id.java
    │   ├── Positive.java
    │   └── MaxLength.java
    │
    ├── util
    │   ├── Validator.java
    │   ├── CommandParser.java
    │   ├── StatementFormatter.java
    │   └── AnnotationValidator.java
    │
    ├── exception
    │   ├── BankException.java
    │   ├── InsufficientFundsException.java
    │   ├── AccountNotFoundException.java
    │   └── InvalidAmountException.java
    │
    ├── service
    │   ├── AccountWorker.java
    │   ├── TransactionProcessor.java
    │   ├── AccountStore.java
    │   ├── Repository.java
    │   └── BankService.java
    │
    └── persistence
        ├── StatePersister.java
        ├── TransactionLog.java
        └── ReportGenerator.java

test
└── service
    └── BankServiceTest.java
```