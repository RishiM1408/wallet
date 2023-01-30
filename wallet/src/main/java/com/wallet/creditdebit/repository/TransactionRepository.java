package com.wallet.creditdebit.repository;
import com.wallet.creditdebit.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
