/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author utilisateur
 */
public class OrderDAO extends DAO<Order>{

    public OrderDAO(Connection cnx) {
        super(cnx);
    }
    @Override
    public boolean create(Order x) {
       String req = "INSERT INTO orders "+
                    "VALUES ()";
       Statement stm = null;
       try 
       {
            stm = cnx.createStatement(); 
            int n= stm.executeUpdate(req);
            if (n>0)
            {
                stm.close();
                return true;
            }
       }
       catch (SQLException exp)
       {}
       finally
       {
            if (stm!=null)
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }			
       }
       return false;
    }
    @Override
    public boolean update(Order x) {
        String req = "UPDATE orders SET "
                +"confirmed = "+ x.getConfirmed() 
                +", ready = "+ x.getReady();

        Statement stm = null;
        try 
        {
            stm = cnx.createStatement(); 
            int n= stm.executeUpdate(req);
            if (n>0)
            {
                stm.close();
                return true;
            }
        }
        catch (SQLException exp)
        {}
        finally
        {
            if (stm!=null)
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }			
        }
        return false;
    }
    @Override
    public boolean deleteById(int id) {
        String req = "DELETE 1 FROM orders WHERE id = "+id;
        //System.out.println("REQUETE "+req);
        Statement stm = null;
        try{
            stm = cnx.createStatement(); 
            int n= stm.executeUpdate(req);
            if (n>0) {
                stm.close();
                return true;
            }
        }
        catch (SQLException exp) 
        {}
        finally
        {
            if (stm!=null)
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }			
        }
        return false;
    }
    
    public void addOrder(Array items, ){
        
    }
}
