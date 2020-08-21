package com.server.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.server.entity.Customer;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Customer customer) {
		entityManager.merge(customer);
	}

	@Override
	public Customer findById(int id) {
		return entityManager.find(Customer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {
		return entityManager.createNamedQuery("fetch-all").getResultList();
	}

	@Override
	public boolean isCustomerPresent(String email) {
		return ((Number)entityManager.createNamedQuery("is-present")
				.setParameter("em", email)
				.getSingleResult()).intValue()== 1? true:false;
	}

	@Override
	public int findByUsernamePassword(String email, String password) {
		return (int) entityManager.createNamedQuery("fetch-login").setParameter("email", email)
				.setParameter("password", password).getSingleResult();
	}
}