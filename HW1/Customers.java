import java.util.Random;

	public class Customers implements CompanySystem{
		private String[][] customerInformations;	
		private String[][] orders;
		private int[][] officeChairs = new int[7][5];
		private int[][] officeDesks = new int[5][4];
		private int[][] meetingTables = new int[10][4];
		private int[] bookcases = new int[12];
		private int[] officeCabinets = new int[12];
		private int customerCounter=0;
		private int orderCounter=0;

		/** Returns the customer's information using index. **/
		public String get_CustomerInformation(int x, int y){
			return customerInformations[x][y];
		}


		/** Returns the customer number using index. **/
		public String get_CustomerNumber(int i){	
			return customerInformations[i][0];
		}


		/** Returns the customer's information using mail address of customer. **/
		public String get_CustomerNumberWithMail(String mail){	
			for(int i=0; i<customerCounter; i++)
				if(mail.equals(customerInformations[i][3]))
					return customerInformations[i][0];	 
			return "not found";
		}


		/** Sets number of Office Chairs. **/
		public void set_OfficeChairs(int x, int y, int number){	
			officeChairs[x][y] += number;
		}


		/** Gets number of Office Chairs. **/
		public int get_OfficeChairs(int x, int y){
			return officeChairs[x][y];
		}


		/** Sets number of Office Desks. **/
		public void set_OfficeDesks(int x, int y, int number){
			officeDesks[x][y] += number;
		}


		/** Gets number of Office Desks. **/
		public int get_OfficeDesks(int x, int y){
			return officeDesks[x][y];
		}


		/** Sets number of Meeting Tables. **/
		public void set_MeetingTables(int x, int y, int number){
			meetingTables[x][y] += number;
		}


		/** Gets number of Meeting Tables. **/
		public int get_MeetingTables(int x, int y){
			return meetingTables[x][y];
		}


		/** Sets number of Bookcases. **/
		public void set_Bookcases(int x, int number){
			bookcases[x] += number;
		}

	
		/** Gets number of Bookcases. **/
		public int get_Bookcases(int x){
			return bookcases[x];
		}

		
		/** Sets number of Office Cabinets. **/
		public void set_OfficeCabinets(int x, int number){
			officeCabinets[x] += number;
		}

		
		/** Gets number of Office Cabinets. **/
		public int get_OfficeCabinets(int x){
			return officeCabinets[x];
		}


		/** Sign up for new customers.  **/
		public void signUp(String name, String surname, String mail, String password){
			String customerNumber = newCustomerNumber();
			String[] newCustomer = new String[5];
			newCustomer[0] = customerNumber;
			newCustomer[1] = name;
			newCustomer[2] = surname;
			newCustomer[3] = mail;
			newCustomer[4] = password;

			if(customerCounter == 0){
				customerInformations = new String[1][5];
				for(int i=0; i<5; i++)
					customerInformations[0][i] = newCustomer[i];
 				customerCounter++;
			}
 			else{ //copy operations
 				String[][] temp = new String[customerCounter+1][5];

 				for(int i=0; i<customerCounter; i++)
 					for(int j=0; j<5; j++)
 						temp[i][j] = customerInformations[i][j];
 		
				for(int i=0; i<5; i++)
					temp[customerCounter][i] = newCustomer[i];

 				customerCounter++;
 				customerInformations = new String[customerCounter][5];
 				for(int i=0; i<customerCounter; i++)
 					for(int j=0; j<5; j++)
 						customerInformations[i][j] = temp[i][j];
 			}
		}

  
  		/**	Allows registered customers to enter the system.	**/
		public boolean logIn(String mail, String password){
			int flag=0;
			for(int i=0; i<customerCounter; i++){
				if(customerInformations[i][3].equals(mail) && customerInformations[i][4].equals(password)){
 					System.out.println("\nWELCOME " + customerInformations[i][1]);
 					flag=1;
 					return true;
			}}
			//if(flag==0)
				//System.out.println("Entered informations is incorrect.");
		
			return false;
		}


		/**	Assigns new customer number for each customer. **/
		public String newCustomerNumber(){
			Random random = new Random(); 
			String customerNumber;
			customerNumber = String.format("%04d", random.nextInt(10000));
    		for(int i=0; i<customerCounter; i++)
    			if(customerInformations[i][0].equals(customerNumber))
    				customerNumber = newCustomerNumber();

    		return customerNumber;
		}


		/**	Lists product types. **/
		public void listProducts(){
			System.out.println("\nPRODUCTS");
			System.out.println("1- Office Chairs");
			System.out.println("2- Office Desks");
			System.out.println("3- Meeting Tables");
			System.out.println("4- Bookcases");
			System.out.println("5- Office Cabinets");	
		}


		/**	Lists products with details according to the user's choice. **/
		public void productDetails(int index){
			switch(index){
				case 1: list_OfficeChairs();	break;
				case 2: list_OfficeDesks(); 	break;
				case 3: list_MeetingTables();	break;
				case 4: list_Bookcases();		break;
				case 5: list_OfficeCabinets();	break;
			}
		}


		/**	Lists Office Chairs. **/
		public void list_OfficeChairs(){		
			System.out.println("\nCHAIR MODELS");
			System.out.println("No\tModel\t\tColor");
			System.out.println("--\t------\t\t-----");
			int k=0;
			for(int i=0; i<7; i++){
				for(int j=0; j<5; j++){
					if(officeChairs[i][j] != 0){
						System.out.print((k+1) +"\t");
						printModel(i); System.out.print("\t");
						printColor(j);
						k++;
					System.out.println();
			}}}
		}


		/**	Lists Office Desks **/
		public void list_OfficeDesks(){
			System.out.println("\nOFFICE DESK MODELS");
			System.out.println("No\tModel\t\tColor");
			System.out.println("--\t------\t\t-----");
			int k=0;
			for(int i=0; i<5; i++){
				for(int j=0; j<4; j++){
					if(officeDesks[i][j] != 0){
						System.out.print((k+1) +"\t");
						printModel(i); System.out.print("\t");
						printColor(j);
						k++;
					System.out.println();
			}}}
		}


		/**	Lists Meeting Tables. **/
		public void list_MeetingTables(){
			System.out.println("\nMEETING TABLE MODELS");
			System.out.println("No\tModel\t\tColor");
			System.out.println("--\t------\t\t-----");
			int k=0;
			for(int i=0; i<10; i++){
				for(int j=0; j<4; j++){
					if(meetingTables[i][j] != 0){
						System.out.print((k+1) +"\t");
						printModel(i); System.out.print("\t");
						printColor(j);
						k++;
					System.out.println();
			}}}
		}


		/**	Lists Bookcases. **/
		public void list_Bookcases(){
			System.out.println("\nBOOKCASE MODELS");
			System.out.println("No\tModel");
			System.out.println("--\t------");
			int k=0;
			for(int i=0; i<12; i++){
				if(bookcases[i] != 0){
					System.out.print((k+1) +"\t");
					printModel(i); System.out.print("\t");
					k++;
				System.out.println();
			}}
		}


		/**	Lists Office Cabinets. **/
		public void list_OfficeCabinets(){
			System.out.println("\nOFFICE CABINET MODELS");
			System.out.println("No\tModel");
			System.out.println("--\t------");
			int k=0;
			for(int i=0; i<12; i++){
				if(officeCabinets[i] != 0){
					System.out.print((k+1) +"\t");
					printModel(i); System.out.print("\t");
					k++;
				System.out.println();
			}}
		}


		/**	Creates order by taking the information.  **/
		public void to_order(int listNumber, int index, String customerNumber, String phone, String address){
			String[] newOrder = new String[4];
			newOrder[0] = customerNumber;
			newOrder[1] = phone;
			newOrder[2] = address;
			newOrder[3] = ( returnProduct(listNumber, index));

			if(orderCounter == 0){
				orders = new String[1][4];
				for(int i=0; i<4; i++)
					orders[0][i] = newOrder[i];
				orderCounter++;
			}else{
				String[][] temp = new String[orderCounter+1][4];
			 	for(int i=0; i<orderCounter; i++)
			 		for(int j=0; j<4; j++)
			 			temp[i][j] = orders[i][j];
			
				for(int i=0; i<4; i++)
					temp[orderCounter][i] = newOrder[i];

				orderCounter++;
		 		orders = new String[orderCounter][4];
				for(int i=0; i<orderCounter; i++)
					for(int j=0; j<4; j++)
						orders[i][j] = temp[i][j];
			}
		}


		/**	Prints Order List.  **/
		public void printOrderList(){
			System.out.println("ORDER LIST");
			System.out.println("C.Number   Phone\tAddress\t\t\t\t\t\t\t\t  Product");
			for(int i=0; i<orderCounter; i++){
				for(int j=0; j<4; j++)
					System.out.print(orders[i][j] +"  |  ");
				System.out.println();
			}
		}


		/**	Lists previous orders using customer number.  **/
		public void previousOrders(String customerNumber){
			System.out.println("\nPrevious orders");
			for(int i=0; i<orderCounter; i++){
				if(customerNumber.equals(orders[i][0]))
					for(int j=0; j<4; j++)
						System.out.print(orders[i][j] +"\t");
				System.out.println();
			}
		}

		
		/**	Search product with input for Office Chair/Desk, Meeting Tables  **/
		public int search_withColor(String kind, String model, String color){
			int index1 = furnitureList(kind);
			int index2 = modelListStr(model);
			int index3 = colorListStr(color);
			if(index1 ==0)
				return officeChairs[index2][index3];
			else if(index1 == 1)
				return officeDesks[index2][index3];
			else 
				return meetingTables[index2][index3];
		}

		
		/**	Search product with input for Bookcases, Office Cabinets  **/
		public int search_withoutColor(String kind, String model){
			int index1 = furnitureList(kind);
			int index2 = modelListStr(model);	
			if(index1==3)
				return bookcases[index2];
			else
				return officeCabinets[index2];
		}


		/**	Returns product with name/model/color.  **/
		public String returnProduct(int listNumber, int index){
			int count=0;
			if(listNumber==1){
				for(int i=0; i<7; i++){
					for(int j=0; j<5; j++){
						if(officeChairs[i][j] != 0)
							count++;
						if(count == index)
							return ("Office Chair - "+ modelListInt(i) + " - " + colorListInt(j));
			}}}
			else if(listNumber == 2){
				for(int i=0; i<5; i++){
					for(int j=0; j<4; j++){
						if(officeDesks[i][j] != 0)
							count++;
						if(count == index)
							return ("Office Desk - " + modelListInt(i) + " - " + colorListInt(j));
			}}}
			else if(listNumber == 3){
				for(int i=0; i<10; i++){
					for(int j=0; j<4; j++){
						if(meetingTables[i][j] != 0)
							count++;
						if(count == index)
							return ("Meeting Table  - " + modelListInt(i) + " - " + colorListInt(j));
			}}}
			else if(listNumber == 4){
				for(int i=0; i<12; i++){
						if(bookcases[i] != 0)
							count++;
						if(count == index)
							return ("Bookcase - " + modelListInt(i) + " - ");
			}}
			else if(listNumber == 5){
				for(int i=0; i<12; i++){
						if(officeCabinets[i] != 0)
							count++;
						if(count == index)
							return ("Office Cabinet - " + modelListInt(i) + " - " );
			  }}

			return "not found";
		}


		/**	Prints Customer List.  **/
		public void printCustomerList(){
			System.out.println("No\tName\tSurname\tMail");
			for(int i=0; i<customerCounter; i++){
				for(int j=0; j<4; j++)
					System.out.print(customerInformations[i][j] + "\t");
			System.out.println("\n");
			}
		}


		/**	Prints Model **/
		public void printModel(int i){
			if(i==0) System.out.print("Model 1\t");
			else if(i==1) System.out.print("Model 2\t");
			else if(i==2) System.out.print("Model 3\t"); 
			else if(i==3) System.out.print("Model 4\t");
			else if(i==4) System.out.print("Model 5\t");
			else if(i==5) System.out.print("Model 6\t");
			else if(i==6) System.out.print("Model 7\t");
			else if(i==7) System.out.print("Model 8\t");
			else if(i==8) System.out.print("Model 9\t");
			else if(i==9) System.out.print("Model10\t");
			else if(i==10) System.out.print("Model11\t");
			else  System.out.print("Model12\t");
		}

		
		/**	Prints Color **/
		public void printColor(int j){
			if(j==0) System.out.print("Black "); 
			else if(j==1) System.out.print("White ");
			else if(j==2) System.out.print("Brown "); 
			else if(j==3) System.out.print("Grey  ");
			else System.out.print("Red   ");
		}


		/**	Returns index of the model **/
		public int modelListStr(String i){
			if(i=="Model 1") return 0;
			else if(i=="Model 2") return 1;
			else if(i=="Model 3") return 2; 
			else if(i=="Model 4") return 3;
			else if(i=="Model 5") return 4;
			else if(i=="Model 6") return 5;
			else if(i=="Model 7") return 6;
			else if(i=="Model 8") return 7;
			else if(i=="Model 9") return 8;
			else if(i=="Model 10") return 9;
			else if(i=="Model 11") return 10;
			else  return 11;
		}

		
		/**	Returns index of the furniture **/
		public int furnitureList(String i){
			if(i=="Office Chair") return 0;
			else if(i=="Office Desk") return 1;
			else if(i=="Meeting Table") return 2;
			else if(i=="Bookcase") return 3;
			else return 4;
		}


		/**	Return Model **/
		public String modelListInt(int i){
			if(i==0) return ("Model 1");
			else if(i==1) return ("Model 2");
			else if(i==2) return ("Model 3"); 
			else if(i==3) return ("Model 4");
			else if(i==4) return ("Model 5");
			else if(i==5) return ("Model 6");
			else if(i==6) return ("Model 7");
			else if(i==7) return ("Model 8");
			else if(i==8) return ("Model 9");
			else if(i==9) return ("Model10");
			else if(i==10) return ("Model11");
			else  return("Model12");
		}


		/**	Return index of the color **/
		public int colorListStr(String j){
			if(j=="Black") return 0; 
			else if(j=="White") return 1;
			else if(j=="Brown") return 2; 
			else if(j=="Grey") return 3;
			else return 4;
		}


		/**	Returns color name **/
		public String colorListInt(int j){
			if(j==0) return("Black "); 
			else if(j==1) return("White ");
			else if(j==2) return("Brown "); 
			else if(j==3) return("Grey  ");
			else return("Red   ");
		}


		/**	Create default customer. **/
		public void defaultCustomer(){
			addProductDefault();
		}


		/**	Create default product. **/
		public void addProductDefault(){
			for(int i=0; i<7; i++)
				for(int j=1; j<5; j++)
					set_OfficeChairs(i,j,1);

			for(int i=0; i<5; i++)
				for(int j=0; j<4; j++)
					set_OfficeDesks(i,j,1);
			
			for(int i=0; i<10; i++)
				for(int j=0; j<4; j++)
					set_MeetingTables(i,j,1);
			
			for(int i=0; i<12; i++)
					set_Bookcases(i,1);			
				
			for(int i=0; i<12; i++)
					set_OfficeCabinets(i,1);

					set_OfficeDesks(2,1,1);
					set_OfficeDesks(2,1,1);
					set_OfficeDesks(2,1,1);

		}


		/**	Create default customer. **/
		public void addCustomerDefault(){
			signUp("Ceyda", "Özbey", "ceydaozbey@gmail.com", "999888");
			signUp("Selin", "Aksoy", "selinaksoy@gmail.com", "555444");
			signUp("Fatih", "Keklik", "fatihkeklik@gmail.com", "456789");
			signUp("Gökhan", "Yıldız", "gokhanyildiz@gmail.com", "123456");
			signUp("Elif", "Ceyhan", "elifceyhan@gmail.com", "333535");
		}

		
		/**	Create default order. **/
		public void addOrderDefault(){
			to_order(3, 3, this.get_CustomerNumber(2),"5077652521", 
				"Arnavutköy Mahallesi Dikilitaş Sokak No:7/4 Beşiktaş/İSTANBUL");
			to_order(2, 11, this.get_CustomerNumber(2),"5077652521", 
				"Arnavutköy Mahallesi Dikilitaş Sokak No:7/4 Beşiktaş/İSTANBUL");
			to_order(4, 1, this.get_CustomerNumber(1),"5356869898", 
				"Talatpaşa Mahallesi Süzgün Sokak No:5/1 Kartal/İSTANBUL      ");
		}
		


		/**	Prints Office Chairs list. **/
		public void printChairs(){
			System.out.println("\nOFFICE CHAIRS STOCK");
			int k=0;
			for(int i=0; i<7; i++){
				for(int j=0; j<5; j++){
					System.out.print((k+1) +"- ");	
					printModel(i);
					printColor(j);
					System.out.print("|\t");
					k++;
			}System.out.println();}
		}


		/**	Prints Office Desks list. **/
		public void printDesks(){
			System.out.println("\nOFFICE DESKS STOCK");
			int k=0;
			for(int i=0; i<5; i++){
				for(int j=0; j<4; j++){
					System.out.print((k+1) +"- ");	
					printModel(i);
					printColor(j);
					System.out.print("|\t");
					k++;
				}System.out.println();}
		}

		
		/**	Prints Meeting Tables list. **/
		public void printTables(){
			System.out.println("\nMEETING TABLES STOCK");
			int k=0;
			for(int i=0; i<10; i++){
				for(int j=0; j<4; j++){
					System.out.print((k+1) +"- ");	
					printModel(i);
					printColor(j);
					System.out.print("|\t");
					k++;
				}System.out.println();}
		}


		/**	Prints Bookcases list. **/
		public void printBookcases(){
			int k=0;
			  System.out.println("\nBOOKCASES STOCK");
			for(int i=0; i<12; i++){
				System.out.print((k+1) +"- ");	
				printModel(i);
				System.out.print("|\t");
				k++;			
			}
		}


		/**	Prints Office Cabinets list. **/
		public void printCabinets(){
			System.out.println("\nOFFICE CABINETS STOCK");
			int k=0;
			for(int i=0; i<12; i++){
				System.out.print((k+1) +"- ");	
				printModel(i);
				System.out.print("|\t");
				k++;			
			}
		}


	}