

	public class Administrator extends Employee  implements CompanySystem{
		private String[][] adminInformations;
		private String[] branchList;
		private int branchCounter=0;
		private int adminCounter=0;

		/** Registers someone as admin in the system **/
		public void addAdmin(String name, String surname, String mail, String password){
			String[] newAdmin = new String[4];
			newAdmin[0] = name;
			newAdmin[1] = surname;
			newAdmin[2] = mail;
			newAdmin[3] = password;
			if(adminCounter == 0){
				adminInformations = new String[1][4];
				for(int i=0; i<4; i++)
					adminInformations[0][i] = newAdmin[i];
				adminCounter++;
			}
			else{
				String[][] temp = new String[adminCounter+1][4];
 				for(int i=0; i<adminCounter; i++)
 					for(int j=0; j<4; j++)
 						temp[i][j] = adminInformations[i][j];
 		
				for(int i=0; i<5; i++)
					temp[adminCounter][i] = newAdmin[i];
 				adminCounter++;
 				adminInformations = new String[adminCounter][5];
 				for(int i=0; i<adminCounter; i++)
 					for(int j=0; j<5; j++)
 						adminInformations[i][j] = temp[i][j];
			}
		}


		/** Logging into the system as an administrator. **/
		@Override
		public boolean logIn(String mail, String password){
			for(int i=0; i<adminCounter; i++){
				if(adminInformations[i][2].equals(mail) && adminInformations[i][3].equals(password)){
					System.out.println("\nWELCOME " +adminInformations[i][0]);
					return true;
			}}
			return false;
		}


		/** Registers new employees to the system. **/
		public void addEmployee(String branch, String name, String surname, String salary, String mail, String password){
			String[] newEmp = new String[6];
			newEmp[0]=branch;	newEmp[1]=name;
			newEmp[2]=surname;	newEmp[3]=salary;
			newEmp[4]=mail;		newEmp[5]=password;

			if(employeeCounter == 0){
				employeeInformations = new String[1][6];
				for(int i=0; i<6; i++)
					employeeInformations[0][i] = newEmp[i];
				employeeCounter++;
			}
			else{	//adding new element to array by copying
				String[][] temp = new String[employeeCounter+1][6];
			 	for(int i=0; i<employeeCounter; i++)
			 		for(int j=0; j<6; j++)
			 			temp[i][j] = employeeInformations[i][j];
			
				for(int i=0; i<6; i++)
					temp[employeeCounter][i] = newEmp[i];
				employeeCounter++;
		 		employeeInformations = new String[employeeCounter][6];
				for(int i=0; i<employeeCounter; i++)
					for(int j=0; j<6; j++)
						employeeInformations[i][j] = temp[i][j];
			}
		}


		/**	Removes the employee from the system. **/
		public void removeEmployee(int index){
			index=index-1; //array starts with 0
			String[][] temp = new String[employeeCounter-1][6];
			int k=0;
			for(int i=0; i<employeeCounter;i++){
				for(int j=0; j<6; j++){
					if(i == index){
						i++;
						temp[k][j] = employeeInformations[i][j];
					}else
					  temp[k][j] = employeeInformations[i][j];
			}k++;}

			employeeCounter--;
			employeeInformations= new String[employeeCounter][6];
			for(int i=0; i<employeeCounter; i++)
				for(int j=0; j<6;j++)
					employeeInformations[i][j] = temp[i][j];
		}


		/**	Prints the employee informations.**/
		public void printEmployeeInformation(){
			System.out.println("\nEMPLOYEE LIST");
			System.out.println("No\tBranch\t\tName\t\tSurname\t\tSalary\t\tMail  ");
			for(int i=0; i<employeeCounter; i++){
				System.out.print((i+1) + "  \t");
				for(int j=0; j<5; j++)
					System.out.print(employeeInformations[i][j] + "  \t");
				System.out.println();
			}
		}



		/**	Adds a new branch to the system.**/
		public void addBranch(String newBranch){
			int flag=0;
			for(int i=0; i<branchCounter; i++)
				if(branchList[i] == newBranch)
					flag=1;

			if(flag==1)
				System.out.println("This branch is already been");
			else{
				if(branchCounter==0){
					branchList = new String[1];
					branchList[0]=newBranch;
					branchCounter++;
				}else{
					String[] temp = new String[branchCounter+1];
					for(int i=0; i<branchCounter; i++)
						temp[i] = branchList[i];

					temp[branchCounter] = newBranch;
					branchCounter++;
					branchList = new String[branchCounter];
					for(int i=0; i<branchCounter; i++)
						branchList[i] = temp[i];
			}}
		}


		/**	Removes a new branch from the system.**/
		public void removeBranch(int index){
			index=index-1; //array starts with 0
			String[] temp = new String[branchCounter-1];
			int k=0;
			for(int i=0; i<branchCounter;i++){
				if(i == index){
					i++;
					temp[k] = branchList[i];
				}else
					  temp[k] = branchList[i];
			k++;}
			branchCounter--;
			branchList = new String[branchCounter];
			for(int i=0; i<branchCounter; i++)
				branchList[i] = temp[i];
		}

		
		/**	Prints branch list **/
		public void printBranchList(){
			System.out.println("BRANCH LIST");
			for(int i=0; i<branchCounter; i++)
				System.out.println((i+1)+"- " + branchList[i]);
		}


		/**	Checks whether there is a consumed product.**/
		public void inquireStocks(Employee e){
			e.inform_OutOfStock();
			e.printOutOfStock();
		}


		/**	Creates admin as default. **/
		public void defaultAdmin(){
			addEmployee("Beşiktaş", "Zeynep", "Kartal", "8500", "zkartal@gmail.com", "333333");
			addEmployee("Sarıyer ", "Barış ", "Tatar ", "8000", "baristatar@gmail.com", "888666");
			addEmployee("Üsküdar ", "Mehmet", "Gündüz", "8300", "mgunduz@gmail.com", "999444");
			//addEmployee("Kadıköy ", "Elif  ", "Boz   ", "8300", "elifboz@gmail.com", "111555");

			addBranch("Sarıyer ");
			addBranch("Üsküdar ");
			addBranch("Kadıköy ");
			addBranch("Beşiktaş");
		}

	}