package com.wipro.complaint.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import com.wipro.complaint.bean.ComplaintBean;
import com.wipro.complaint.util.DBUtil;

public class ComplaintDAO {

    public String createRecord(ComplaintBean bean) {

        try {
            Connection con = DBUtil.getDBConnection();

            String query = "INSERT INTO COMPLAINT_TB VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, bean.getComplaintId());
            ps.setString(2, bean.getComplainant());
            ps.setString(3, bean.getTitle());
            ps.setString(4, bean.getDepartment());
            ps.setDate(5, new java.sql.Date(bean.getComplaintDate().getTime()));
            ps.setString(6, bean.getStatus());
            ps.setString(7, bean.getRemarks());

            int rows = ps.executeUpdate();

            if (rows > 0)
                return bean.getComplaintId();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "FAIL";
    }

    public boolean recordExists(String title, Date date) {

        try {
            Connection con = DBUtil.getDBConnection();

            String query = "SELECT * FROM COMPLAINT_TB WHERE TITLE=? AND COMPLAINTDATE=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, title);
            ps.setDate(2, new java.sql.Date(date.getTime()));

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public String generateComplaintID(String title, Date complaintDate) {

        try {
            Connection con = DBUtil.getDBConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COMPLAINT_SEQ.NEXTVAL FROM DUAL");

            rs.next();
            int seq = rs.getInt(1);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String datePart = sdf.format(complaintDate);

            String titlePart = title.substring(0, 2).toUpperCase();

            return datePart + titlePart + seq;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ComplaintBean fetchRecord(String title, Date date) {

        ComplaintBean bean = null;

        try {
            Connection con = DBUtil.getDBConnection();

            String query = "SELECT * FROM COMPLAINT_TB WHERE TITLE=? AND COMPLAINTDATE=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, title);
            ps.setDate(2, new java.sql.Date(date.getTime()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                bean = new ComplaintBean();
                bean.setComplaintId(rs.getString(1));
                bean.setComplainant(rs.getString(2));
                bean.setTitle(rs.getString(3));
                bean.setDepartment(rs.getString(4));
                bean.setComplaintDate(rs.getDate(5));
                bean.setStatus(rs.getString(6));
                bean.setRemarks(rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    public List<ComplaintBean> fetchAllRecords() {

        List<ComplaintBean> list = new ArrayList<>();

        try {
            Connection con = DBUtil.getDBConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM COMPLAINT_TB");

            while (rs.next()) {

                ComplaintBean bean = new ComplaintBean();

                bean.setComplaintId(rs.getString(1));
                bean.setComplainant(rs.getString(2));
                bean.setTitle(rs.getString(3));
                bean.setDepartment(rs.getString(4));
                bean.setComplaintDate(rs.getDate(5));
                bean.setStatus(rs.getString(6));
                bean.setRemarks(rs.getString(7));

                list.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
