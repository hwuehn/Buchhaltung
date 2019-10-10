package de.company.accounting.application;

public class AccountingRecordIDCounter {

    private static Integer counter = 0;

    public AccountingRecordIDCounter() {
        counter++;
    }

    public Integer getCounter() {
        return counter;
    }

}
