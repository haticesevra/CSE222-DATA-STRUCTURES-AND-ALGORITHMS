
	public class Employee extends Customers implements CompanySystem{
		public String[][] employeeInformations;
		public int employeeCounter=0;
		private String[] outOf = new String[1];
		private int size_outOf=0;

		


		/**	Increase number of office chairs using super class's functions. **/
		public void add_OfficeChairs(int x, int y){
			set_OfficeChairs(x-1,y-1,1);
		}


		/**	Decrase number of office chairs using super class's functions. */
		public void remove_OfficeChairs(int x, int y){
			if(get_OfficeChairs(x-1,y-1)>0)
				set_OfficeChairs(x-1, y-1, -1);
			else
				System.out.println("There is no product to remove");
		}

		
		/**	Increase number of office desks using super class's functions. **/
		public void add_OfficeDesks(int x, int y){
				set_OfficeDesks(x-1, y-1, 1);			
		}


		/**	Decrease number of office desks using super class's functions. **/
		public void remove_OfficeDesks(int x, int y){
			if(get_OfficeDesks(x-1,y-1)>0)
				set_OfficeDesks(x-1, y-1, -1);
			else
				System.out.println("There is no product to remove");
		}

		
		/**	Increase number of meeting tables using super class's functions. **/
		public void add_MeetingTables(int x, int y){
			set_MeetingTables(x-1, y-1, 1);
		}

		
		/**	Decrase number of meeting tables using super class's functions. **/
		public void remove_MeetingTables(int x, int y){
			if(get_MeetingTables(x-1,y-1)>0)
				set_MeetingTables(x-1, y-1, -1);
			else
				System.out.println("There is no product to remove");
		}

		
		/**	Increase number of bookcases using super class's functions. **/
		public void add_Bookcases(int x){
			set_Bookcases(x-1, 1);
		}

		
		/**	Decrase number of bookcases using super class's functions. **/
		public void remove_Bookcases(int x){
			if(get_Bookcases(x-1)>0)
				set_Bookcases(x-1, -1);
			else
				System.out.println("There is no product to remove");	
		}

		
		/**	Increase number of office cabinets using super class's functions. **/
		public void add_OfficeCabinets(int x){
			set_OfficeCabinets(x-1, 1);
		}

		
		/**	Decrase number of office cabinets using super class's functions. **/
		public void remove_OfficeCabinets(int x){
			if(get_OfficeCabinets(x-1)>0)
				set_OfficeCabinets(x-1, -1);
			else
				System.out.println("There is no product to remove");
		}


		@Override
		public boolean logIn(String mail, String password){
			int flag=0;
			for(int i=0; i<employeeCounter; i++){
				if(employeeInformations[i][3].equals(mail) && employeeInformations[i][4].equals(password)){
 					System.out.println("\nWELCOME " + employeeInformations[i][1]);
 					flag=1;
 					return true;
			}}
			//if(flag==0)
				//System.out.println("Entered informations is incorrect.");
		
			return false;
		}

		/**	Notifies the manager of the consumed products. **/
		public String[] inform_OutOfStock(){	
			outOf = new String[1];
			size_outOf =0;	
			String x, y;
			for(int i=0; i<7; i++){
				for(int j=0; j<5; j++){
					if(get_OfficeChairs(i,j) == 0){
						x = returnModel(i);
						y = returnColor(j);
						addOutOf(x+y+" Office Chair");
			}}}
			for(int i=0; i<5; i++){
				for(int j=0; j<4; j++){
					if(get_OfficeDesks(i,j) == 0){
						x = returnModel(i);
						y = returnColor(j);
						addOutOf(x+y+" Office Desk");
			}}}
			for(int i=0; i<10; i++){
				for(int j=0; j<4; j++){
					if(get_MeetingTables(i,j) == 0){
						x = returnModel(i);
						y = returnColor(j);
						addOutOf(x+y+" Meeting Table");
			}}}
			for(int i=0; i<12; i++){
				if(get_Bookcases(i) == 0){
					x = returnModel(i);		
					addOutOf(x+"  Bookcase");
			}}
			for(int i=0; i<12; i++){
				if(get_OfficeCabinets(i) == 0){
					x = returnModel(i);
					addOutOf(x+"  Office Cabinet");
			}}
			return outOf;
		}


		/*	Adds new product to sold out list. */
		public void addOutOf(String add){
			if(size_outOf == 0){
				outOf = new String[1];	
				outOf[0] = add;
				size_outOf++;
			}
			else{
				String[] temp = new String[size_outOf+1];
				for(int i=0; i<size_outOf; i++)
					temp[i] = outOf[i];
				temp[size_outOf] = add;
				size_outOf++;
				outOf = new String[size_outOf];
				for(int i=0; i<size_outOf; i++)
					outOf[i] = temp[i];
			}
		}


		/**	Prints the  sold out list. **/
		public void printOutOfStock(){
			System.out.println("\nOUT OF PRODUCTS LIST");
			for(int i=0; i<size_outOf; i++)
				System.out.println(outOf[i]);
			System.out.println("\n"+ size_outOf + " products in total must be supplied." );
		}

		
		/**	Returns model of the product as String. **/
		public String returnModel(int i){
			String x;
			if(i==0) x = "Model 1 - "; 		
			else if(i==1) x = "Model 2 - ";
			else if(i==2) x = "Model 3 - "; 		
			else if(i==3) x = "Model 4 - ";
			else if(i==4) x = "Model 5 - "; 		
			else if(i==5) x = "Model 6 - ";
			else if(i==6) x = "Model 7 - "; 		
			else if(i==7) x = "Model 8 - ";
			else if(i==8) x = "Model 9 - "; 		
			else if(i==9) x = "Model10 - ";
			else if(i==10) x = "Model11 - ";		
			else x = "Model12 - "; 
			return x;
		}


		/**	Returns color of the product as String. **/
		public String returnColor(int j){
			String y;
			if(j==0) y = "Black "; 			
			else if(j==1) y = "White ";
			else if(j==2) y = "Brown "; 			
			else if(j==3) y = "Grey "; 			
			else y = "Red ";
			return y;
		}


		/**	Prints Office Chairs list. **/
		@Override
		public void printChairs(){
			System.out.println("\nOFFICE CHAIRS STOCK");
			int k=0;
			for(int i=0; i<7; i++){
				for(int j=0; j<5; j++){
					System.out.print((k+1) +"- ");	
					printModel(i);
					printColor(j);
					System.out.print("->"+get_OfficeChairs(i,j) + "|");
					k++;
			}System.out.println();}
		}


		/**	Prints Office Desks list. **/
		@Override
		public void printDesks(){
			System.out.println("\nOFFICE DESKS STOCK");
			int k=0;
			for(int i=0; i<5; i++){
				for(int j=0; j<4; j++){
					System.out.print((k+1) +"- ");	
					printModel(i);
					printColor(j);
					System.out.print("->"+get_OfficeDesks(i,j) + "|");
					k++;
				}System.out.println();}
		}

		
		/**	Prints Meeting Tables list. **/
		@Override
		public void printTables(){
			System.out.println("\nMEETING TABLES STOCK");
			int k=0;
			for(int i=0; i<10; i++){
				for(int j=0; j<4; j++){
					System.out.print((k+1) +"- ");	
					printModel(i);
					printColor(j);
					System.out.print("->"+get_MeetingTables(i,j) + "|");
					k++;
				}System.out.println();}
		}


		/**	Prints Bookcases list. **/
		@Override
		public void printBookcases(){
			int k=0;
			  System.out.println("\nBOOKCASES STOCK");
			for(int i=0; i<12; i++){
				System.out.print((k+1) +"- ");	
				printModel(i);
				System.out.print("->"+get_Bookcases(i) +"|");
				k++;			
			}
		}


		/**	Prints Office Cabinets list. **/
		@Override
		public void printCabinets(){
			System.out.println("\nOFFICE CABINETS STOCK");
			int k=0;
			for(int i=0; i<12; i++){
				System.out.print(+(k+1) +"- ");	
				printModel(i);
				System.out.print("->"+get_OfficeCabinets(i) +"|");
				k++;			
			}
		}


		/**	Prints all products list. **/
		public void printAllProducts(){
			this.printChairs();
			this.printDesks();
			this.printTables();
			this.printBookcases();
			this.printCabinets();
		}


		/**	Creates an order by getting customer number from employee. **/
		public void to_order_byEmployee(String customerNumber, int listNumber, int index, String phone, String address){
			to_order(listNumber, index, customerNumber, phone , address );
		}


		/**	Inquire previous order of customer using customer number. **/
		public void inquirePreviousOrders(String customerNumber){
			previousOrders(customerNumber);
		}
	

		/**	Creates employee by default to test easier. **/
		public void defaultEmployee(){
			addProductDefault();
			addCustomerDefault();
			addOrderDefault();
		}

	}