package com.khan.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.security.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
