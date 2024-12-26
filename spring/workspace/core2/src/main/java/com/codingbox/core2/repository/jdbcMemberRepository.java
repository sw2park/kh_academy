package com.codingbox.core2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.codingbox.core2.dto.Member;

//@Repository
public class jdbcMemberRepository implements MemberRepository {

	private final DataSource dataSource;

	public jdbcMemberRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Member save(Member member) {
		String sql = "INSERT INTO \"MEMBER\" VALUES (member_seq.nextval, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String generatedColumns[] = { "ID" };
			pstmt = conn.prepareStatement(sql, generatedColumns);
			pstmt.setString(1, member.getName());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				member.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}

	@Override
	public List<Member> findAll() {
		String sql = "SELECT * FROM \"MEMBER\" m";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> members = new ArrayList<>();

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				members.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return members;
	}
}
