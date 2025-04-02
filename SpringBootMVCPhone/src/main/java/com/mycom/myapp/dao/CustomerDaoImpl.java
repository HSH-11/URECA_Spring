package com.mycom.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.myapp.dto.CustomerDTO;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private final DataSource dataSource;
	
	public CustomerDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerList = new ArrayList<>();
        String query = "SELECT * FROM Customers";
        
        try (Connection con = dataSource.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                int customerId = rs.getInt("customer_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
     

                customerList.add(new CustomerDTO(customerId, name, email, phone, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return customerList;
    }

	@Override
	public boolean deleteCustomer(int customerId) {
		String updateStockQuery = "UPDATE Products SET stock_quantity = stock_quantity + ? WHERE product_id = ?";
        String deleteCustomerQuery = "DELETE FROM Customers WHERE customer_id = ?"; 
        String deleteCouponsQuery = "DELETE FROM CustomerCoupons WHERE customer_id = ?";
        
        try (Connection con = dataSource.getConnection()) {
            con.setAutoCommit(false);  // 트랜잭션 시작

            // 고객 보유 쿠폰 삭제 추가
            try (PreparedStatement pstmtDeleteCoupons = con.prepareStatement(deleteCouponsQuery)) {
                pstmtDeleteCoupons.setInt(1, customerId);
                pstmtDeleteCoupons.executeUpdate();
            }

            // 기존 제품 재고 복원 로직 유지
//            try (PreparedStatement pstmtGetOrderItems = con.prepareStatement(getOrderItemsQuery)) {
//                pstmtGetOrderItems.setInt(1, customerId);
//                ResultSet rs = pstmtGetOrderItems.executeQuery();
//
//                while (rs.next()) {
//                    int productId = rs.getInt("product_id");
//                    int quantity = rs.getInt("quantity");
//
//                    try (PreparedStatement pstmtUpdateStock = con.prepareStatement(updateStockQuery)) {
//                        pstmtUpdateStock.setInt(1, quantity);
//                        pstmtUpdateStock.setInt(2, productId);
//                        pstmtUpdateStock.executeUpdate();
//                    }
//                }
//            }

            // 고객 삭제
            try (PreparedStatement pstmtDeleteCustomer = con.prepareStatement(deleteCustomerQuery)) {
                pstmtDeleteCustomer.setInt(1, customerId);
                int result = pstmtDeleteCustomer.executeUpdate();

                if (result > 0) {
                    con.commit();  // 성공 시 커밋
                    return true;
                }
            }

            con.rollback();  // 실패 시 롤백
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
	}

	@Override
	public boolean updateCustomer(CustomerDTO customer) {
        String query = "UPDATE Customers SET name = ?, email = ?, phone = ?, address = ? WHERE customer_id = ?";
        
        try (Connection con = dataSource.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
             
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getEmail());
            pstmt.setString(3, customer.getPhone());
            pstmt.setString(4, customer.getAddress());
            pstmt.setInt(5, customer.getCustomerId());

            int result = pstmt.executeUpdate();
            return result > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public CustomerDTO findCustomer(String name, String phone) {
		String query = "SELECT * FROM Customers WHERE name = ? AND phone = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, name);
            ps.setString(2, phone);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new CustomerDTO(
                    rs.getInt("customer_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public CustomerDTO findOrCreateCustomer(String name, String email, String phone, String address) {
		CustomerDTO customer = findCustomer(name, phone);  

        if (customer == null) {
            
            String insertQuery = "INSERT INTO Customers (name, email, phone, address) VALUES (?, ?, ?, ?)";
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, phone);
                ps.setString(4, address);
                ps.executeUpdate();

                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int customerId = generatedKeys.getInt(1);
                    customer = new CustomerDTO(customerId, name, email, phone, address);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return customer;
	}
	
	
}
