package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Subscription;
import beans.User;

public class SubscriptionDAO implements DAO<Subscription> {

    @Override
    public boolean add(Subscription subscription) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String insert = "INSERT INTO auction.Subscription (userID, subscriptionName, startDate, endDate, price) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(insert);
            ps.setInt(1, subscription.getUser().getUserID());
            ps.setString(2, subscription.getSubscriptionName());
            ps.setDate(3, new java.sql.Date(subscription.getStartDate().getTime()));
            ps.setDate(4, new java.sql.Date(subscription.getEndDate().getTime()));
            ps.setInt(5, subscription.getPrice());
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
    public boolean update(Subscription subscription) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String update = "UPDATE auction.Subscription SET user_id=?, subscriptionName=?, startDate=?, endDate=?, price=?, isActive=? WHERE subscriptionId=?";
            ps = con.prepareStatement(update);
            ps.setInt(1, subscription.getUser().getUserID());
            ps.setString(2, subscription.getSubscriptionName());
            ps.setDate(3, new java.sql.Date(subscription.getStartDate().getTime()));
            ps.setDate(4, new java.sql.Date(subscription.getEndDate().getTime()));
            ps.setInt(5, subscription.getPrice());
            ps.setBoolean(6, subscription.isActive());
            ps.setInt(7, subscription.getSubscriptionId());
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
            String delete = "DELETE FROM auction.Subscription WHERE subscriptionID=?";
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
    public List<Subscription> getAll() {
        List<Subscription> subscriptions = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM auction.Subscription";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Subscription subscription = new Subscription();
                subscription.setSubscriptionId(rs.getInt("subscriptionID"));
                // Retrieve user information and set it in the subscription object
                int userId = rs.getInt("user_id");
                User user = new UserDAO().get(userId);
                subscription.setUser(user);
                subscription.setSubscriptionName(rs.getString("subscriptionName"));
                subscription.setStartDate(rs.getDate("startDate"));
                subscription.setEndDate(rs.getDate("endDate"));
                subscription.setPrice(rs.getInt("price"));
                subscription.setActive(rs.getBoolean("isActive"));
                subscriptions.add(subscription);
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
        return subscriptions;
    }

    @Override
    public Subscription get(int id) {
        Subscription subscription = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM auction.Subscription WHERE subscriptionID=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                subscription = new Subscription();
                subscription.setSubscriptionId(rs.getInt("subscriptionId"));
                // Retrieve user information and set it in the subscription object
                int userId = rs.getInt("user_id");
                User user = new UserDAO().get(userId);
                subscription.setUser(user);
                subscription.setSubscriptionName(rs.getString("subscriptionName"));
                subscription.setStartDate(rs.getDate("startDate"));
                subscription.setEndDate(rs.getDate("endDate"));
                subscription.setPrice(rs.getInt("price"));
                subscription.setActive(rs.getBoolean("isActive"));
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
        return subscription;
    }
}
