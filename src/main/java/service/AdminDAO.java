package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Admin;

public class AdminDAO implements DAO<Admin> {

    @Override
    public boolean add(Admin admin) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String insert = "INSERT INTO auction.Admin (firstName, lastName, role, email, password) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(insert);
            ps.setString(1, admin.getFirstName());
            ps.setString(2, admin.getLastName());
            ps.setString(3, admin.getRole());
            ps.setString(4, admin.getEmail());
            ps.setString(5, admin.getPassword());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result == 1;
    }

    @Override
    public boolean update(Admin admin) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String update = "UPDATE auction.Admin SET firstName=?, lastName=?, role=?, email=?, password=? WHERE adminID=?";
            ps = con.prepareStatement(update);
            ps.setString(1, admin.getFirstName());
            ps.setString(2, admin.getLastName());
            ps.setString(3, admin.getRole());
            ps.setString(4, admin.getEmail());
            ps.setString(5, admin.getPassword());
            ps.setInt(6, admin.getAdminID());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result == 1;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String delete = "DELETE FROM auction.Admin WHERE adminID=?";
            ps = con.prepareStatement(delete);
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result == 1;
    }

    @Override
    public List<Admin> getAll() {
        List<Admin> admins = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM auction.Admin";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setAdminID(rs.getInt("adminID"));
                admin.setFirstName(rs.getString("firstName"));
                admin.setLastName(rs.getString("lastName"));
                admin.setRole(rs.getString("role"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                admin.setRegisteredDate(new Date(rs.getDate("registrationDate").getTime()));
                admin.setPicture(rs.getString("picture"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return admins;
    }

    @Override
    public Admin get(int id) {
        Admin admin = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM auction.Admin WHERE adminID=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                admin = new Admin();
                admin.setAdminID(rs.getInt("adminID"));
                admin.setFirstName(rs.getString("firstName"));
                admin.setLastName(rs.getString("lastName"));
                admin.setRole(rs.getString("role"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                admin.setPicture(rs.getString("picture"));
                admin.setRegisteredDate(new Date(rs.getDate("registrationDate").getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return admin;
    }

    public static Admin getAdminByEmail(String Email) throws SQLException{
        AdminDAO curr = new AdminDAO();
        List<Admin>ad = curr.getAll();
        Admin ret = new Admin();
        for (Admin a : ad){
            System.out.println(a.getEmail() + a.getEmail().equals(Email) + "email: " + Email);
            if (a.getEmail().equals(Email)){

                ret = a;
                break;
            }
        }
        return ret;
    }

    public Integer updateprofileImage(Admin ad, String path){
        Integer Status = 0;
        try{
            Connection con = DBService.openConnection();
            String query = "UPDATE  auction.Admin SET picture = ? WHERE adminID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, path);
            ps.setInt(2, ad.getAdminID()); 
            Status = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return Status;
    }
}
