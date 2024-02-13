package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import beans.User;

public class UserDAO implements DAO<User> {

    @Override
    public boolean add(User t) {
        System.out.println("starting add User");
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String insert = "INSERT INTO auction.Users (firstName, lastName, email, password, city, region, phone, profileImage) VALUES (?,?,?,?,?,?,?,?);";
            ps = con.prepareStatement(insert);
            ps.setString(1, t.getFirstName());
            ps.setString(2, t.getLastName());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getPassword());
            ps.setString(5, t.getCity());
            ps.setString(6, t.getRegion());
            ps.setString(7, t.getPhone());
            ps.setString(8, t.getProfileImage());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
    public boolean update(User t) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String update = "UPDATE auction.Users SET firstName=?, lastName=?, email=?, password=?, city=?, region=?, phone=?, profileImage=? WHERE userID=?";
            ps = con.prepareStatement(update);
            ps.setString(1, t.getFirstName());
            ps.setString(2, t.getLastName());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getPassword());
            ps.setString(5, t.getCity());
            ps.setString(6, t.getRegion());
            ps.setString(7, t.getPhone());
            ps.setString(8, t.getProfileImage());
            ps.setInt(9, t.getUserID());
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
            String delete = "DELETE FROM auction.Users WHERE userID=?";
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
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM auction.Users";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCity(rs.getString("city"));
                user.setRegion(rs.getString("region"));
                user.setPhone(rs.getString("phone"));
                user.setProfileImage(rs.getString("profileImage"));
                users.add(user);
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
        return users;
    }

    @Override
    public User get(int id) {
        User user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM auction.Users WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCity(rs.getString("city"));
                user.setRegion(rs.getString("region"));
                user.setPhone(rs.getString("phone"));
                user.setUserStatus(rs.getString("userStatus"));
            	user.setRegistrationDate(new Date(rs.getDate("registrationDate").getTime()));
                user.setProfileImage(rs.getString("profileImage"));
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
        return user;
    }
    public User get(String email, String password) {
        User user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM auction.Users WHERE email=? and password=?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCity(rs.getString("city"));
                user.setRegion(rs.getString("region"));
                user.setPhone(rs.getString("phone"));
                user.setUserStatus(rs.getString("userStatus"));
            	user.setRegistrationDate(new Date(rs.getDate("registrationDate").getTime()));
                user.setProfileImage(rs.getString("profileImage"));
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
        return user;
    }
}
