package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("===== Test 1: Seller  findById  ===== ");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);

		System.out.println("\n===== Test 2: Seller  findByDepartment  ===== ");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===== Test 3: Seller  findAll  ===== ");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n===== Test 4: Seller  INSERT  ===== ");
		Seller newSeller = new Seller(null, "Maria Joao", "maria@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("\n===== Test 5: Seller  UPDATE  ===== ");
		seller = sellerDao.findById(5);
		seller.setName("Amanda Blue");
		seller.setEmail("blue@gmail.com");

		sellerDao.update(seller);
		System.out.println("Update Completed");
	}

}
