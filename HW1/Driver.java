
	public class Driver{

		public Driver(){
			Administrator admin = new Administrator();
			admin.addAdmin("Hatice Sevra", "Genç", "haticesevragenc@gmail.com", "123456");
		
			System.out.println("\nAdd Branch");
			admin.addBranch("Sarıyer ");
			admin.addBranch("Üsküdar ");
			admin.addBranch("Kadıköy ");
			admin.addBranch("Beşiktaş");
			admin.printBranchList();
			System.out.println("\nRemove Branch (2nd)");
			admin.removeBranch(2);
			System.out.println("\nremoved");
			admin.printBranchList();

			System.out.println("\nAdd Employee");
			admin.addEmployee("Beşiktaş", "Zeynep", "Kartal", "8500", "zkartal@gmail.com", "333333");
			admin.addEmployee("Sarıyer ", "Barış ", "Tatar ", "8000", "baristatar@gmail.com", "888666");
			admin.addEmployee("Üsküdar ", "Mehmet", "Gündüz", "8300", "mgunduz@gmail.com", "999444");
			admin.addEmployee("Kadıköy ", "Elif  ", "Boz   ", "8300", "elifboz@gmail.com", "111555");
			admin.printEmployeeInformation();
			System.out.println("\nRemove Employee 	(2nd)");
			admin.removeEmployee(2);
			System.out.println("removed");
			admin.printEmployeeInformation();

			System.out.println("\nInquire stocks (polymorphism)");
			admin.inquireStocks(admin);


			System.out.println("\nAdd Product");
			Employee emp = new Employee();
			emp.add_OfficeChairs(1,1);
			emp.add_OfficeChairs(1,2);
			emp.add_OfficeChairs(1,3);
			emp.add_OfficeChairs(1,4);
			emp.add_OfficeChairs(2,2);
			emp.add_OfficeChairs(2,3);
			emp.add_OfficeChairs(2,4);
			emp.add_OfficeChairs(2,5);
			emp.add_OfficeChairs(3,3);
			emp.add_OfficeChairs(3,4);
			emp.add_OfficeChairs(3,5);
			emp.add_OfficeChairs(3,5);
			emp.add_OfficeChairs(3,4);
			emp.add_OfficeChairs(3,3);
			emp.add_OfficeChairs(4,1);
			emp.add_OfficeChairs(4,2);
			emp.add_OfficeChairs(4,3);
			emp.add_OfficeChairs(4,3);
			emp.add_OfficeChairs(4,4);
			emp.add_OfficeChairs(4,4);
			emp.add_OfficeChairs(4,5);
			emp.add_OfficeChairs(4,1);
			emp.add_OfficeChairs(4,4);
			emp.add_OfficeChairs(5,4);
			emp.add_OfficeChairs(5,3);
			emp.add_OfficeChairs(5,3);
			emp.add_OfficeChairs(5,4);
			emp.add_OfficeChairs(6,4);
			emp.add_OfficeChairs(6,5);
			emp.add_OfficeChairs(6,1);
			emp.add_OfficeChairs(6,1);
			emp.add_OfficeChairs(7,4);
			emp.add_OfficeChairs(7,4);
			emp.add_OfficeChairs(4,3);
			emp.add_OfficeChairs(7,3);
			emp.add_OfficeChairs(7,4);
			emp.add_OfficeChairs(7,4);
			emp.add_OfficeChairs(6,5);
			emp.add_OfficeChairs(5,1);
			emp.add_OfficeChairs(6,4);
			emp.add_OfficeChairs(6,4);
			
		//	emp.printChairs();

			emp.add_OfficeDesks(2,2);
			emp.add_OfficeDesks(3,2);

			emp.add_OfficeDesks(3,1);
			emp.add_OfficeDesks(2,2);
			emp.add_OfficeDesks(2,2);
			emp.add_OfficeDesks(5,4);
			emp.add_OfficeDesks(2,2);
			emp.add_OfficeDesks(4,4);
			emp.add_OfficeDesks(4,4);
			emp.add_OfficeDesks(1,2);
			emp.add_OfficeDesks(1,2);
			emp.add_OfficeDesks(1,3);
			emp.add_OfficeDesks(1,1);
			emp.add_OfficeDesks(1,2);
			emp.add_OfficeDesks(1,4);
			emp.add_OfficeDesks(2,3);
			emp.add_OfficeDesks(5,3);
			emp.add_OfficeDesks(5,2);
			emp.add_OfficeDesks(5,1);
			emp.add_OfficeDesks(5,1);
			emp.add_OfficeDesks(4,4);
			emp.add_OfficeDesks(4,2);
			emp.add_OfficeDesks(4,2);
			emp.add_OfficeDesks(5,3);
			emp.add_OfficeDesks(5,1);
			emp.add_OfficeDesks(1,2);
			emp.add_OfficeDesks(2,2);
			emp.add_OfficeDesks(1,3);
			emp.add_OfficeDesks(1,3);

		//	emp.printDesks();

			emp.add_MeetingTables(10,4);
			emp.add_MeetingTables(10,4);
			emp.add_MeetingTables(9,2);
			emp.add_MeetingTables(9,4);
			emp.add_MeetingTables(1,4);
			emp.add_MeetingTables(1,4);
			emp.add_MeetingTables(10,3);
			emp.add_MeetingTables(10,1);
			emp.add_MeetingTables(3,3);
			emp.add_MeetingTables(3,1);
			emp.add_MeetingTables(1,1);
			emp.add_MeetingTables(2,1);
			emp.add_MeetingTables(3,1);
			emp.add_MeetingTables(4,1);
			emp.add_MeetingTables(5,1);
			emp.add_MeetingTables(6,1);
			emp.add_MeetingTables(7,1);
			emp.add_MeetingTables(8,1);
			emp.add_MeetingTables(9,1);
			emp.add_MeetingTables(10,1);
			emp.add_MeetingTables(10,2);
			emp.add_MeetingTables(1,4);
			emp.add_MeetingTables(1,1);
			emp.add_MeetingTables(10,4);
			emp.add_MeetingTables(7,4);
			emp.add_MeetingTables(7,3);
			emp.add_MeetingTables(7,1);
			emp.add_MeetingTables(6,4);
			emp.add_MeetingTables(5,3);
			emp.add_MeetingTables(5,4);
			emp.add_MeetingTables(4,4);
			emp.add_MeetingTables(5,2);
			emp.add_MeetingTables(8,2);
			emp.add_MeetingTables(2,4);
			emp.add_MeetingTables(6,2);
			emp.add_MeetingTables(1,2);
			emp.add_MeetingTables(1,2);
			emp.add_MeetingTables(2,2);
			emp.add_MeetingTables(3,2);
			emp.add_MeetingTables(1,2);
			emp.add_MeetingTables(6,2);
			emp.add_MeetingTables(10,4);

			//emp.printTables();

			emp.add_Bookcases(1);
			emp.add_Bookcases(2);
			emp.add_Bookcases(1);
			emp.add_Bookcases(1);
			emp.add_Bookcases(3);
			emp.add_Bookcases(3);
			emp.add_Bookcases(3);
			emp.add_Bookcases(6);
			emp.add_Bookcases(9);
			emp.add_Bookcases(12);
			emp.add_Bookcases(11);
			emp.add_Bookcases(7);
			emp.add_Bookcases(6);
			emp.add_Bookcases(5);

			//emp.printBookcases();

			emp.add_OfficeCabinets(1);
			emp.add_OfficeCabinets(3);
			emp.add_OfficeCabinets(3);
			emp.add_OfficeCabinets(3);
			emp.add_OfficeCabinets(5);
			emp.add_OfficeCabinets(8);
			emp.add_OfficeCabinets(12);
			emp.add_OfficeCabinets(11);
			emp.add_OfficeCabinets(7);
			emp.add_OfficeCabinets(6);
			emp.add_OfficeCabinets(6);
			emp.add_OfficeCabinets(9);
			emp.add_OfficeCabinets(10);
			emp.add_OfficeCabinets(10);

			emp.printAllProducts();
			
			System.out.println("\n\nRemove Product Test");
			emp.printCabinets();
			System.out.println("\nRemove Office Cabinet (12th) ");
			emp.remove_OfficeCabinets(12);
			emp.printCabinets();
			

			
			System.out.println("\nCustomer sign up");

			emp.signUp("Ceyda", "Özbey", "ceydaozbey@gmail.com", "999888");
			emp.signUp("Selin", "Aksoy", "selinaksoy@gmail.com", "555444");
			emp.signUp("Fatih", "Keklik", "fatihkeklik@gmail.com", "456789");
			emp.signUp("Gökhan", "Yıldız", "gokhanyildiz@gmail.com", "123456");

			emp.printCustomerList();

			emp.logIn("selinaksoy@gmail.com", "555444");
			emp.logIn("gokhanyildiz@gmail.com", "111111");

			emp.listProducts();

			emp.productDetails(3);

			//emp.productDetails(5);

			emp.to_order(3, 3, emp.get_CustomerNumber(2),"5077652521", 
				"Arnavutköy Mahallesi Dikilitaş Sokak No:7/4 Beşiktaş/İSTANBUL");

			emp.to_order(2, 11, emp.get_CustomerNumber(2),"5077652521", 
				"Arnavutköy Mahallesi Dikilitaş Sokak No:7/4 Beşiktaş/İSTANBUL");

			emp.to_order(4, 1, emp.get_CustomerNumber(1),"5356869898", 
				"Talatpaşa Mahallesi Süzgün Sokak No:5/1 Kartal/İSTANBUL      ");

			emp.printOrderList();

			emp.previousOrders(emp.get_CustomerInformation(2,0));


			System.out.println("Aradığınız üründen " + emp.search_withColor("Office Chair", "Model 4", "Brown")
					+" adet bulunmaktadır.");



			emp.printOrderList();

			emp.inquirePreviousOrders(emp.get_CustomerInformation(2,0));



			Customers customer = new Customers();
			customer.defaultCustomer();
			System.out.println("SIGN UP AND LOG IN TEST - customer (named Ayşenur Kılıç)");

			customer.signUp("Ayşenur", "Kılıç", "aysenurkilic@gmail.com", "123421" );
			customer.logIn("aysenurkilic@gmail.com", "123421" );

			System.out.println("\nLIST PRODUCTS (Chairs)");
			customer.list_OfficeChairs();

			System.out.println("\nSEARCH PRODUCT (Bookcase - Model 1)");
			System.out.println("There are '" + customer.search_withoutColor("Bookcase", "Model 1") + "' Model 1 Bookcase.");

			System.out.println("\nSEARCH PRODUCT (Office Desk - Model 3 - White)");
			System.out.println("There are '" + customer.search_withColor("Office Desk", "Model 3", "White") + "' White, Model 3 Office Desk");


			System.out.println("\n\nTO ORDER");
			customer.to_order(1, 17, customer.get_CustomerNumberWithMail("aysenurkilic@gmail.com"), 
				"5074325454", "Heybeli Caddesi Zeyrek Sokak No:1/3 Bakırköy/İstanbul");
			customer.previousOrders(customer.get_CustomerNumberWithMail("aysenurkilic@gmail.com"));

		}

	}