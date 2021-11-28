package com.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.member.bean.MemberVO;
import com.member.common.JDBCUtil;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String M_INSERT = "insert into member(userid, password, username, email, photo, detail) values (?,sha1(?), ?, ?, ?, ?)";
	private final String M_UPDATE = "update member set username=?, email=?, photo=?, detail=? where sid=?";
	private final String M_DELETE = "delete from member where sid=?";
	private final String M_SELECT = "select * from member where sid=?";
	private final String M_LIST = "select * from member order by regdate desc";

	public int insertMember(MemberVO data) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(M_INSERT);
			pstmt.setString(1, data.getUserid());
			pstmt.setString(2, data.getPassword());
			pstmt.setString(3, data.getUsername());
			pstmt.setString(4, data.getEmail());
			pstmt.setString(5, data.getPhoto());
			pstmt.setString(6, data.getDetail());
			result = pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public MemberVO getOne(int sid) {
		MemberVO one = null;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(M_SELECT);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				one = new MemberVO(rs.getInt("sid"), rs.getString("userid"), rs.getString("username"),
						rs.getString("email"), rs.getString("photo"), rs.getString("detail"), rs.getDate("regdate"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return one;
	}

	public ArrayList<MemberVO> getList() {
		ArrayList<MemberVO> list = null;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(M_LIST);
			rs = pstmt.executeQuery();
			list = new ArrayList<MemberVO>();
			MemberVO one;
			while (rs.next()) {
				one = new MemberVO(rs.getInt("sid"), rs.getString("userid"), rs.getString("username"),
						rs.getString("email"), rs.getString("photo"), rs.getString("detail"), rs.getDate("regdate"));
				list.add(one);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int deleteOne(int sid) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(M_DELETE);
			pstmt.setInt(1, sid);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateMember(MemberVO data) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(M_UPDATE);
			pstmt.setString(1, data.getUsername());
			pstmt.setString(2, data.getEmail());
			pstmt.setString(3, data.getPhoto());
			pstmt.setString(4, data.getDetail());
			pstmt.setInt(5, data.getSid());
			result = pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
