
package listeners;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import service.DBService;

@WebListener()
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext app = sce.getServletContext();
        DBService.DRIVER = app.getInitParameter("db.driver");
        DBService.URL = app.getInitParameter("db.url");
        DBService.USER = app.getInitParameter("db.user");
        DBService.PASSWORD = app.getInitParameter("db.password");
        Connection connection = DBService.openConnection();
        if (connection != null) {
            try {
                System.out.println("Connected to : " + connection.getCatalog());
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Cannot connect to database");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("The web app has been shut down");
    }
}