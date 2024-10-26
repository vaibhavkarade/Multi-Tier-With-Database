package com.example.bankapp;

import com.example.bankapp.service.BankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankappApplicationTests {

    @Autowired
    private BankService bankService;

    @Test
    void contextLoads() {
        assertNotNull(bankService, "Bank service should not be null if context loads correctly");
    }

    @Test
    void testBalanceCheck() {
        // Assuming initial balance setup in the service or database is zero for a new account
        int accountId = 1; // Replace with an actual test account ID
        double balance = bankService.getBalance(accountId);
        assertEquals(0.0, balance, "New account should have a balance of zero");
    }

    @Test
    void testDeposit() {
        int accountId = 1; // Replace with an actual test account ID
        double depositAmount = 100.0;
        
        bankService.deposit(accountId, depositAmount);
        double updatedBalance = bankService.getBalance(accountId);

        assertEquals(100.0, updatedBalance, "Balance should reflect deposited amount");
    }
}
