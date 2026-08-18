package util;

import model.Account;

public class StatementFormatter {

    public static String buildStatement(Account account) {

        StringBuilder builder = new StringBuilder();

        builder.append("===== Account Statement =====\n");
        builder.append("Account Number: ").append(account.getAccountNumber()).append("\n");
        builder.append("Owner Name: ").append(account.getOwnerName()).append("\n");
        builder.append("Balance: ").append(account.getBalance()).append("\n");
        builder.append("Active: ").append(account.isActive()).append("\n");

        return builder.toString();
    }
}
