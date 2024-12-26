package com.codingbox.shop.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.codingbox.shop.domain.Order;
import com.codingbox.shop.domain.OrderStatus;
import com.codingbox.shop.domain.QMember;
import com.codingbox.shop.domain.QOrder;
import com.codingbox.shop.dto.OrderSearch;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
	private final EntityManager em;

	public void save(Order order) {
		em.persist(order);
	}
	
	public Order findOne(Long orderId) {
		return em.find(Order.class, orderId);
	}

	// 검색어가 null이 없는 경우 -> 반드시 검색조건이 존재하는 경우 / JPQL
//	public List<Order> findAll(OrderSearch orderSearch) {
//		List<Order> resultList = em.createQuery("select o from Order o join o.member m "
//												+ "where o.status = :status and m.name like :name", Order.class)
//												.setParameter("status", orderSearch.getOrderStatus())
//												.setParameter("name", orderSearch.getMemberName())
//												.setFirstResult(100)
//												.setMaxResults(10)
//												.getResultList();
//		return resultList;
//	}
	
	// queryDSL
	public List<Order> findAll(OrderSearch orderSearch){
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		QOrder order = QOrder.order;
		QMember member = QMember.member;
		
		return query.select(order)
					.from(order)
					.join(order.member, member)
//					.where(order.status.eq(orderSearch.getOrderStatus()),
//							member.name.like(orderSearch.getMemberName()))
					.where(statusEq(orderSearch.getOrderStatus()),
							nameLike(orderSearch.getMemberName()))
					.fetch();
	}
	
	private BooleanExpression statusEq(OrderStatus orderStatus) {
		if(orderStatus == null) {
			return null;
		}
		return QOrder.order.status.eq(orderStatus);
	}
	
	private BooleanExpression nameLike(String memberName) {
		if(memberName == null) {
			return null;
		}
		return QMember.member.name.contains(memberName);
	}
}