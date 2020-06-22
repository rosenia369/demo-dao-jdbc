package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("===== Test 1: Department  findById  ===== ");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("===== Test 2: Department   INSERT  ===== ");
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("===== Test 3: Department   UPDATE  ===== ");
		department = departmentDao.findById(2);
		department.setName("Finance");
		departmentDao.update(department);
		System.out.println("Update Completed");
		
		System.out.println("===== Test 4: Department  DELETE  ===== ");
		System.out.println("Enter id for delete: ");
		int id = sc.nextInt();
		departmentDao.deleteByID(id);
		System.out.println("Delete Completed");
		
		System.out.println("\n===== Test 5: Department  findAll  ===== ");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		sc.close();
	}
	

}
