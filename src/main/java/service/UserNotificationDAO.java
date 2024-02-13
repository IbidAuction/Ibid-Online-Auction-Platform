package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.User;
import beans.UserNotification;

public class UserNotificationDAO implements DAO<UserNotification> {

    @Override
    public boolean add(UserNotification notification) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String insert = "INSERT INTO UserNotification (message, userId) VALUES (?, ?)";
            ps = con.prepareStatement(insert);
            ps.setString(1, notification.getMessage());
            ps.setInt(2, notification.getUser().getUserID());
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
    public boolean update(UserNotification notification) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String update = "UPDATE UserNotification SET message=?, notificationTime=?, userId=? WHERE notificationId=?";
            ps = con.prepareStatement(update);
            ps.setString(1, notification.getMessage());
            ps.setTimestamp(2, new java.sql.Timestamp(notification.getNotificationTime().getTime()));
            ps.setInt(3, notification.getUser().getUserID());
            ps.setInt(4, notification.getNotificationId());
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
            String delete = "DELETE FROM UserNotification WHERE notificationId=?";
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
    public List<UserNotification> getAll() {
        List<UserNotification> notifications = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM UserNotification";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserNotification notification = new UserNotification();
                notification.setNotificationId(rs.getInt("notificationId"));
                notification.setMessage(rs.getString("message"));
                notification.setNotificationTime(rs.getTimestamp("notificationTime"));
                // Retrieve user information and set it in the notification object
                int userId = rs.getInt("userId");
                User user = new UserDAO().get(userId);
                notification.setUser(user);
                notifications.add(notification);
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
        return notifications;
    }

    @Override
    public UserNotification get(int id) {
        UserNotification notification = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM UserNotification WHERE notificationID=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                notification = new UserNotification();
                notification.setNotificationId(rs.getInt("notificationID"));
                notification.setMessage(rs.getString("message"));
                notification.setNotificationTime(rs.getTimestamp("notificationTime"));
                // Retrieve user information and set it in the notification object
                int userId = rs.getInt("userId");
                User user = new UserDAO().get(userId);
                notification.setUser(user);
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
        return notification;
    }
}
