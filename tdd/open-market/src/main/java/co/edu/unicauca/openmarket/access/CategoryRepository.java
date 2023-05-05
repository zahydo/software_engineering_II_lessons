/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.edu.unicauca.openmarket.domain.Category;

/**
 *
 * @author william
 */
public class CategoryRepository implements ICategoryRepository {
    private Connection conn;
    
    public CategoryRepository() {
        initDatabase();
    }
    
    @Override
    public boolean saveC(Category newCategory) {

        try {
            
            //Validate product
            if (newCategory == null || newCategory.getName().isBlank()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO categories ( name ) "
                    + "VALUES ( ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newCategory.getName());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Category> findAllC() {
        List<Category> categories = new ArrayList<>();
        try {

            String sql = "SELECT * FROM categories";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Category newCategory = new Category();
                newCategory.setCategoryId(rs.getLong("categoryId"));
                newCategory.setName(rs.getString("name"));

                categories.add(newCategory);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS categories (\n"
                + "	categoryId integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./myDatabase.db"; //Para Linux/Mac
        //String url = "jdbc:sqlite:C:/sqlite/db/myDatabase.db"; //Para Windows
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public boolean editC(Long categoryid, Category category) {
        try {
            //Validate product
            if (categoryid <= 0 || category == null) {
                return false;
            }
            //this.connect();

            String sql = "UPDATE  categories "
                    + "SET name=?"
                    + "WHERE categoryId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category.getName());
            pstmt.setLong(2, categoryid);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteC(Long idC) {
        try {
            //Validate product
            if (idC <= 0) {
                return false;
            }
            //this.connect();

            String sql = "DELETE FROM categories "
                    + "WHERE categoryId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, idC);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Category findByIdC(Long categoryId) {
        try {

            String sql = "SELECT * FROM categories   "
                    + "WHERE categoryId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, categoryId);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Category category = new Category();
                category.setCategoryId(res.getLong("categoryId"));
                category.setName(res.getString("name"));
                return category;
            } else {
                return null;
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Category findByNameC (String name){
        try {

            String sql = "SELECT * FROM categories  "
                    + "WHERE name LIKE ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Category category = new Category();
                category.setCategoryId(res.getLong("categoryId"));
                category.setName(res.getString("name"));
                return category;
            } else {
                return null;
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
