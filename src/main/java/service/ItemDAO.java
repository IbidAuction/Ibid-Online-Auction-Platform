package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Item;
import beans.User;

public class ItemDAO implements DAO<Item> {

    @Override
    public boolean add(Item t) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String insert = "INSERT INTO auction.Items (title, description, itemImage, itemCondition, minIncrement, category, startPrice, seller_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(insert);
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setString(3, t.getItemImage());
            ps.setString(4, t.getItemCondition());
            ps.setInt(5, t.getMinIncrement());
            ps.setString(6, t.getCategory());
            ps.setInt(7, t.getStartPrice());
            ps.setInt(8, t.getSeller().getUserID());
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
    public boolean update(Item t) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            String update = "UPDATE auction.Items SET title=?, description=?, itemImage=?, itemState=?, itemCondition=?, minIncrement=?, category=?, startPrice=?, isSold=?, soldDate=?, seller_id=?, buyer_id=? WHERE itemID=?";
            ps = con.prepareStatement(update);
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setString(3, t.getItemImage());
            ps.setString(4, t.getItemState());
            ps.setString(5, t.getItemCondition());
            ps.setInt(6, t.getMinIncrement());
            ps.setString(7, t.getCategory());
            ps.setInt(8, t.getStartPrice());
            ps.setBoolean(9, t.isSold());
            ps.setDate(10, t.getSoldDate() != null ? new java.sql.Date(t.getSoldDate().getTime()) : null);
            ps.setInt(11, t.getSeller().getUserID());
            ps.setInt(12, t.getBuyer() != null ? t.getBuyer().getUserID() : 0);
            ps.setInt(13, t.getItemID());
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
            String delete = "DELETE FROM auction.Items WHERE itemID=?";
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
    public List<Item> getAll() {
        List<Item> items = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM auction.Items";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setItemID(rs.getInt("itemID"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setItemImage(rs.getString("itemImage"));
                item.setItemState(rs.getString("itemState"));
                item.setItemCondition(rs.getString("itemCondition"));
                item.setMinIncrement(rs.getInt("minIncrement"));
                item.setCategory(rs.getString("category"));
                item.setStartPrice(rs.getInt("startPrice"));
                item.setSold(rs.getBoolean("isSold"));
                item.setRegisteredDate(new Date(rs.getDate("registeredDate").getTime()));
                item.setSoldDate(rs.getDate("soldDate") != null ? new Date(rs.getDate("soldDate").getTime()) : null);
                // Set seller and buyer information
                User seller = new User();
                seller.setUserID(rs.getInt("seller_id"));
                item.setSeller(seller);
                int buyerId = rs.getInt("buyer_id");
                if (buyerId != 0) {
                    item.setBuyer(new UserDAO().get(buyerId));
                }
                items.add(item);
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
        return items;
    }

    @Override
    public Item get(int id) {
        Item item = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            String query = "SELECT * FROM auction.Items WHERE itemID=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                item = new Item();
                item.setItemID(rs.getInt("itemID"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setItemImage(rs.getString("itemImage"));
                item.setItemState(rs.getString("itemState"));
                item.setItemCondition(rs.getString("itemCondition"));
                item.setMinIncrement(rs.getInt("minIncrement"));
                item.setCategory(rs.getString("category"));
                item.setStartPrice(rs.getInt("startPrice"));
                item.setSold(rs.getBoolean("isSold"));
                item.setRegisteredDate(new Date(rs.getDate("registeredDate").getTime()));
                item.setSoldDate(rs.getDate("soldDate") != null ? new Date(rs.getDate("soldDate").getTime()) : null);
                // Set seller and buyer information
                User seller = new User();
                seller.setUserID(rs.getInt("seller_id"));
                item.setSeller(seller);
                int buyerId = rs.getInt("buyer_id");
                if (buyerId != 0) {
                    User buyer = new User();
                    buyer.setUserID(buyerId);
                    item.setBuyer(buyer);
                }
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
        return item;
    }
}
