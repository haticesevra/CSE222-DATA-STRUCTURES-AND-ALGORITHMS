import java.util.Scanner;


	public class Interactive {

		/** No parameter constructor. **/
		public Interactive(){
			Scanner input = new Scanner(System.in);							
				System.out.println("\nTEST MENU");
				System.out.println("1- Admin Test");
				System.out.println("2- Employee Test");
				System.out.println("3- Customer Test");
				System.out.print("Choose one of them... ");
				int choose = input.nextInt();

				if(choose == 1){
					Administrator admin = new Administrator();
					admin.defaultAdmin();
					admin.defaultEmployee();
					adminTest(admin);
				}
				else if (choose == 2) {
					Employee emp = new Employee();
					emp.defaultEmployee();
					employeeTest(emp);	
				}
				else if (choose == 3) {
					Customers customer = new Customers();
					customer.defaultCustomer();
					customerTest(customer);
				}
		}


		/**	Test the system as admin. **/
		public void adminTest(Administrator admin){
			Scanner input = new Scanner(System.in);							
			String name, surname, mail, password, branch, salary;
			int index;

			System.out.println("\nEnter Admin Informations");
			System.out.print("Name: ");
			name = input.nextLine();
			System.out.print("Surname: ");
			surname = input.nextLine();
			System.out.print("E-mail: ");
			mail = input.nextLine();
			System.out.print("Password: ");
			password = input.nextLine();

			admin.addAdmin(name,surname, mail, password);

			System.out.println("\nEnter informations requested below to log in as Administrator");
			System.out.print("e-mail:  ");  mail = input.nextLine();  	
 		   	System.out.print("password:  ");  password = input.nextLine();

			if(admin.logIn(mail, password)){
				int choose;
				do{
				System.out.println("\nMENU");
				System.out.println("1- Add Employee");
				System.out.println("2- Remove Employee");
				System.out.println("3- Add Branch");
				System.out.println("4- Remove Branch");
				System.out.println("5- View Employee List");
				System.out.println("6- View Branch List");
				System.out.println("7- Products Need to be Supplied");
				System.out.println("8- Exit");
				System.out.print("Choose one of them... ");
				choose = input.nextInt();

					if(choose == 1){
						System.out.println("Enter Employee Informations");
						input.nextLine(); // Discard the rest of the line.
						System.out.print("Branch: ");
						branch = input.nextLine();			
						System.out.print("Name: ");
						name = input.nextLine();
						System.out.print("Surname: ");
						surname = input.nextLine();
						System.out.print("Salary: ");
						salary = input.nextLine();
						System.out.print("E-mail: ");
						mail = input.nextLine();
						System.out.print("Password: ");
						password = input.nextLine();
						admin.addEmployee(branch, name, surname, salary, mail, password);

						System.out.println("\n-Updated-");
						admin.printEmployeeInformation();

					}
					else if(choose == 2){
						admin.printEmployeeInformation();
						System.out.println("Enter the index of employee you want to remove from the list...");
						index = input.nextInt();
						admin.removeEmployee(index);
	
						System.out.println("\n-Updated-");
						admin.printEmployeeInformation();
					}
					else if(choose == 3){
						System.out.println("Enter the branch name you want to add...");
						input.nextLine(); // Discard the rest of the line.
						String branchName = input.nextLine();
						admin.addBranch(branchName);

						System.out.println("\n-Updated-");
						admin.printBranchList();
					}
					else if(choose == 4){
						admin.printBranchList();
						System.out.println("Enter the index of branch you want to remove from the list...");
						index = input.nextInt();
						admin.removeBranch(index);

						System.out.println("\n-Updated-");
						admin.printBranchList();
					}
					else if(choose == 5){
						System.out.println();
						admin.printEmployeeInformation();
					}
					else if(choose == 6){
						System.out.println();
						admin.printBranchList();
					}
					else if(choose == 7)
						admin.inquireStocks(admin);
				}while(choose!=8);
			}
			else
				System.out.println("\nInvalid mail or password");

		}


		/**	Test system as employee.**/
		public void employeeTest(Employee emp){
			Scanner input = new Scanner(System.in);							
			int choose, select, model, color, index=0, listNumber;
			String phone, address, custNumb, mail, password;
/*
			System.out.println("\nEnter informations requested below to log in as Employee");
			System.out.print("e-mail:  ");  mail = input.nextLine();  	
 		   	System.out.print("password:  ");  password = input.nextLine();
*/
//			if(emp.logIn(mail, password)){
			do{
				System.out.println("\nMENU");
				System.out.println("1- Add Product");
				System.out.println("2- Remove Product");
				System.out.println("3- View Stocks");
				System.out.println("4- Inform Out of Stock");
				System.out.println("5- To Order by Customer Number");
				System.out.println("6- View Previous Orders by Customer Number");
				System.out.println("7- View Customer List");	
				System.out.println("8- Exit");
				System.out.print("Choose one of them... ");
				choose = input.nextInt();

				if(choose == 1){
					System.out.println("\nPRODUCT MENU");
					System.out.println("1- Office Chairs");
					System.out.println("2- Office Desks");
					System.out.println("3- Meeting Tables");
					System.out.println("4- Bookcases");
					System.out.println("5- Office Cabinets");
					System.out.print("Choose one of them... ");
					select = input.nextInt();

					switch(select){
						case 1: 
							System.out.println("\nChoose Model");
							for(int i=0; i<7;i++)
								System.out.println((i+1) + "- "+ emp.returnModel(i));
							model = input.nextInt();

							System.out.println("\nChoose Color");
							for(int i=0; i<5;i++)
								System.out.println( (i+1) + "- "+ emp.returnColor(i));
							color = input.nextInt();

							emp.add_OfficeChairs(model,color);
							emp.printChairs();
								break;

						case 2: 
							System.out.println("\nChoose Model");
							for(int i=0; i<5;i++)
								System.out.println((i+1) + "- "+ emp.returnModel(i));
							model = input.nextInt();

							System.out.println("\nChoose Color");
							for(int i=0; i<4;i++)
								System.out.println( (i+1) + "- "+ emp.returnColor(i));
							color = input.nextInt();

							emp.add_OfficeDesks(model,color);
							emp.printDesks();
								break;
	
						case 3: 
							System.out.println("\nChoose Model");
							for(int i=0; i<10;i++)
								System.out.println((i+1) + "- "+ emp.returnModel(i));
							model = input.nextInt();

							System.out.println("\nChoose Color");
							for(int i=0; i<4;i++)
								System.out.println( (i+1) + "- "+ emp.returnColor(i));
							color = input.nextInt();

							emp.add_MeetingTables(model,color);
							emp.printTables();
								break;

						case 4: 
							System.out.println("\nChoose Model");
							for(int i=0; i<12;i++)
								System.out.println((i+1) + "- "+ emp.returnModel(i));
							model = input.nextInt();

							emp.add_Bookcases(model);
							emp.printBookcases();
								break;

						case 5: 
							System.out.println("\nChoose Model");
							for(int i=0; i<12;i++)
								System.out.println((i+1) + "- "+ emp.returnModel(i));
							model = input.nextInt();

							emp.add_OfficeCabinets(model);
							emp.printCabinets();
								break;

						default: System.out.println("Invalid choose");
					}
				}
				else if(choose == 2){
					System.out.println("\nPRODUCT MENU");
					System.out.println("1- Office Chairs");
					System.out.println("2- Office Desks");
					System.out.println("3- Meeting Tables");
					System.out.println("4- Bookcases");
					System.out.println("5- Office Cabinets");
					System.out.print("Choose one of them... ");
					select = input.nextInt();

					switch(select){
						case 1: 
							System.out.println("\nChoose Model");
							for(int i=0; i<7;i++)
								System.out.println((i+1) + "- "+ emp.returnModel(i));
							model = input.nextInt();

							System.out.println("\nChoose Color");
							for(int i=0; i<5;i++)
								System.out.println( (i+1) + "- "+ emp.returnColor(i));
							color = input.nextInt();

							emp.remove_OfficeChairs(model,color);
							emp.printChairs();
								break;

						case 2: 
							System.out.println("\nChoose Model");
							for(int i=0; i<5;i++)
								System.out.println((i+1) + "- "+ emp.returnModel(i));
							model = input.nextInt();

							System.out.println("\nChoose Color");
							for(int i=0; i<4;i++)
								System.out.println( (i+1) + "- "+ emp.returnColor(i));
							color = input.nextInt();

							emp.remove_OfficeDesks(model,color);
							emp.printDesks();
								break;
	
						case 3: 
							System.out.println("\nChoose Model");
							for(int i=0; i<10;i++)
								System.out.println((i+1) + "- "+ emp.returnModel(i));
							model = input.nextInt();

							System.out.println("\nChoose Color");
							for(int i=0; i<4;i++)
								System.out.println( (i+1) + "- "+ emp.returnColor(i));
							color = input.nextInt();

							emp.remove_MeetingTables(model,color);
							emp.printTables();
								break;

						case 4: 
							System.out.println("\nChoose Model");
							for(int i=0; i<12;i++)
								System.out.println((i+1) + "- "+ emp.returnModel(i));
							model = input.nextInt();

							emp.remove_Bookcases(model);
							emp.printBookcases();
								break;

						case 5: 
							System.out.println("\nChoose Model");
							for(int i=0; i<12;i++)
								System.out.println((i+1) + "- "+ emp.returnModel(i));
							model = input.nextInt();

							emp.remove_OfficeCabinets(model);
							emp.printCabinets();
								break;

						default: System.out.println("Invalid choose");
					}
				}
				else if(choose == 3){
					System.out.println();
					emp.printAllProducts();	
				}
				else if(choose == 4){
					emp.inform_OutOfStock();
					emp.printOutOfStock();
				}
				else if(choose == 5){
					emp.printCustomerList();
					System.out.println("Enter the customer number you want to create new order...");
					input.nextLine();
					custNumb = input.nextLine();
					
					System.out.println("\nPRODUCT MENU");
					System.out.println("1- Office Chairs");
					System.out.println("2- Office Desks");
					System.out.println("3- Meeting Tables");
					System.out.println("4- Bookcases");
					System.out.println("5- Office Cabinets");
					System.out.print("Choose one of them... ");
					listNumber = input.nextInt();
					if(listNumber == 1){
						emp.printChairs();
						System.out.println("Enter the index you want to order...");
						index = input.nextInt();
					}
					else if(listNumber == 2){
						emp.printDesks();
						System.out.println("Enter the index you want to order...");
						index = input.nextInt();
					}
					else if(listNumber ==3){
						emp.printTables();
						System.out.println("Enter the index you want to order...");
						index = input.nextInt();
					}
					else if(listNumber==4){
						emp.printBookcases();
						System.out.println("Enter the index you want to order...");
						index = input.nextInt();
					}
					else if(listNumber == 5){
						emp.printCabinets();
						System.out.println("Enter the index you want to order...");
						index = input.nextInt();
					}
					else
						System.out.println("Invalid choose");
					
					System.out.println("Enter the phone number of customer ...");
					input.nextLine();
					phone = input.nextLine();
					System.out.println("Enter the address of customer...");
					address = input.nextLine();	
					emp.to_order_byEmployee(custNumb, listNumber, index, phone, address);
				}
				else if(choose == 6){
					emp.printCustomerList();
					System.out.println("Enter the customer number...(enter 3rd customer's number if you see the result)");
					input.nextLine();
					custNumb = input.nextLine();	
					emp.inquirePreviousOrders(custNumb);
				}				
				else if(choose == 7){
					emp.printCustomerList();
				}
				else
					System.out.println("Invalid choose");	
			}while(choose!=8);	
			//}
			//else 	
			//		System.out.println("Invalid mail or password");	
		}


		/**	Test the system as customer. **/
		public void customerTest(Customers customer){
			Scanner input = new Scanner(System.in);
			int choose, select, list, choose2, index;
			String name, surname, mail, password, phone, address, model, color;
			do{
				System.out.println("\nMENU");
				System.out.println("1- Log in");
				System.out.println("2- Sign Up");
				System.out.println("3- Exit");
				System.out.print("Choose one of them... ");
				choose = input.nextInt();

				if(choose == 1){
					System.out.println("\nPlease enter the information requested below for LOG IN");
					System.out.print("e-mail:  "); 
					input.nextLine();  	
					mail = input.nextLine();  	
	 		   		System.out.print("password:  ");  password = input.nextLine();
	 		   		if(customer.logIn(mail,password)){
	 		   			do{
		 		   			System.out.println("\nCUSTOMER MENU");
							System.out.println("1- Shop Online");
							System.out.println("2- View My Previous Orders");
							System.out.println("3- Exit");
							System.out.print("Choose one of them... ");
							select = input.nextInt();

							if(select == 1){
								System.out.println("\n1- List Products");
								System.out.println("2- Search Product");
								System.out.print("Choose one of them... ");
								choose2 = input.nextInt(); 
								if(choose2 == 1){
									customer.listProducts();
									System.out.print("Choose one of them... ");
									list = input.nextInt();
									customer.productDetails(list);
									System.out.print("Enter the index of product you want to buy...");
									index = input.nextInt();

									System.out.println("Enter the phone number of customer ...");
									input.nextLine();
									phone = input.nextLine();
									System.out.println("Enter the address of customer...");
									address = input.nextLine();	

									customer.to_order(list, index, customer.get_CustomerNumberWithMail(mail), phone, address);
								
								}
								else if(choose2 == 2){
									System.out.println("Enter the name of the product...");
									input.nextLine();
									name = input.nextLine();
									System.out.println("Enter the model of the product...");
									model = input.nextLine();

									if(name.equals("Office Cabinet") || name.equals("Bookcase"))
									System.out.println("Aradığınız üründen " + customer.search_withColor("Office Chair", "Model 4", "Brown")
									+" adet bulunmaktadır.");
									else{
										System.out.println("Enter the color of the product...");
										color = input.nextLine();	
										customer.search_withColor(name, model, color);	
									}
								}
							}
							else if (select == 2) {
								customer.previousOrders(customer.get_CustomerNumberWithMail(mail));
							}
				
							else {
								System.out.println("Invalid choice");
							}


						}while(select!=5);	
	 		   		}

				}

				else if(choose == 2){
					System.out.println("\nPlease enter the information requested below for SIGN UP");
					System.out.print("Name:  "); 
					input.nextLine();  	
					name = input.nextLine();  
					System.out.print("Surname:  ");  surname = input.nextLine();  
		    		System.out.print("e-mail:  ");  mail = input.nextLine();  	
		    		do{
		 		   		System.out.print("password:  ");  password = input.nextLine();
		    			if(password.length()<6)
							System.out.println("Password must be longer than 5.");
		    		}while(password.length()<6);
		    		customer.signUp(name,surname, mail, password);
				}
				else
					System.out.println("Invalid choice");
			
			}while(choose!=3);
		}


	}