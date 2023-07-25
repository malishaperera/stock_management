import java.util.*;
class main{
	public static Scanner input = new Scanner(System.in);
	
	public static String login[] ={"malisha","1234"};
	
	public static String[][] supplier = new String[0][2];
	
	public static String[] item_category =new String[0];
	
	public static String[][] item_code = new String[0][6];
	
	public static int numbers;
	
	public static char yesnoAnswers ;
	
	public static String desc;
	
	public static String spplier_informations;
		
	public static void main(String args[]){
		
		login_Page();
	}
	
	public static void login_Page(){
		
		System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
		System.out.printf("|                     					 LOGIN PAGE                                          		 	    |%n");
		System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
		
		L1:
		do{
			System.out.print("\nUser Name  : ");
			spplier_informations=input.next();
				
			if(spplier_informations.equals(login[0])){		
				L2:	
				do{	
					System.out.print("\nPassword  : ");
					spplier_informations=input.next();
						
						if(spplier_informations.equals(login[1])){
							System.out.println("login sucsess");
								clearConsole();
								homepage();
						}else{
							System.out.println("password is incorrect.please try again!");
								continue L2;
						}
					}while(true);
										
			}else{
				System.out.println("user name is invalid.please try again!\n");
					continue L1;
			}
		}while(true);
	}
				
	public static void homepage(){
		
		L1:
		do{
			System.out.printf("\n+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     			 WELCOME TO PIGEON SERVICE STOCK MANAGEMENT SYSTEM                                          |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
			
			System.out.println("(1)Change the Credentials\t"+"(2)Supplier Manage"+"\n\n(3)Stock Manage\t\t"+"\t(4)Log out\n"+"\n(5)Exit the system");
		
			System.out.print("\nEnter an option to continue >");
			numbers=input.nextInt();
				
			switch(numbers){
				
					case 1:	
					credential:
					do{
						clearConsole();
						System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
						System.out.printf("|                     					CREDENTIAL MANAGE                                          		    |%n");
						System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
			
				L2:	do{	
						System.out.print("please enter the user name to verify it's you:");
						spplier_informations=input.next();
						
						if(spplier_informations.equals(login[0])){
							System.out.println("hey "+spplier_informations+"\n");
									
					L3:	do { System.out.print("Enter your current password:");
							spplier_informations=input.next();
										
								if(spplier_informations.equals(login[1])){
									System.out.print("Enter your new password:");
									login[1]=input.next();
									System.out.print("\nPassword changed succssfully! "+"do you want to go home page (y/n):");
									yesnoAnswers =input.next().charAt(0);
											
										if(yesnoAnswers=='y'){
											clearConsole();
											continue L1;
										}else{
											continue credential;
										}	
								}else{
									System.out.println("incorrect password. try again!\n");	
									continue L3;
								}	
							}while(true);
						}else{
							System.out.println("invalid user name. try again!\n");
							continue L2;
						}
					}while(true);
				}while(true);
					
				case 2:
					clearConsole();
					supplierManage();
					break;
								
				case 3:	
					clearConsole();
					stockmanagement();
					break;
						
				case 4:
					clearConsole();
					login_Page();
					break;	
							
				case 5:	
					 clearConsole();
					 System.exit(0);
	
				default :
					System.out.println("There is no such option here, open your eyes and select the option");
					continue L1;
				}		
		}while(true);
	}
	
	public static void supplierManage(){
		
		L1:	
		do{	
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					SUPPLIER MANAGE                                          		    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
			
			System.out.println("(1)Add Supplier\t\t"+"\t(2)Update Supplier"+"\n\n(3)Delete Supplier\t\t"+"(4)View Suppliers\n"+"\n(5)Search Supplier\t\t"+"(6)Home page\n");
				
			System.out.print("Enter an option to continue >");
			numbers=input.nextInt();
			
			switch(numbers){
				
					case 1:
						clearConsole();
						addsupplier();
						break;
					
					case 2:
						clearConsole();
						update();
						break;
						
					case 3:
						clearConsole();	
						delete();	
						break;
						
					case 4:
						clearConsole();
						viewSuppliers();
						break;
					
					case 5:	
						clearConsole();
						searchSupplier();
						break;
					
					case 6:	
						clearConsole();
						homepage();
						break;
					
					default:
						System.out.println("There is no such option here, open your eyes and select the option\n");
						continue L1;
			}	
		}while(true);
	}
				
	public static void addsupplier(){
		
		L1:
		do {
		
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					Add SUPPLIER                                         		            |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
		
			L2:
			do{
				System.out.print("\nSupplier ID: ");
				spplier_informations=input.next();

				for (int i = 0, j = 0; i < supplier.length; i++) {
					if (spplier_informations.equals(supplier[i][j])) {
						System.out.println("Supplier ID already exists. Please try another ID!");
						continue L2;  
					}
				}
				System.out.print("Supplier Name: ");
				String name =input.next();
			   
				supplier = grow();
				supplier[supplier.length - 1][0] = spplier_informations;
				supplier[supplier.length - 1][1] = name;
				
				System.out.print("add successfully! do you want to another supplier add (y/n):");
				yesnoAnswers =input.next().charAt(0);
				
				if(yesnoAnswers=='y'){
					clearConsole();
					continue L1;
				}else{
					System.out.println("ok fine");
					clearConsole();
					supplierManage();
				}
			}while(true);
		} while (true);
    }
		
	public static String[][] grow() {
        String[][] temp = new String[supplier.length + 1][2];

        for (int i = 0; i < supplier.length; i++) {
            for (int j = 0; j < supplier[i].length; j++) {
                temp[i][j] = supplier[i][j];
            }
        }

        return temp;
    }	
			
	public static void update(){
		
		L1: 
		do {
			clearConsole();
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					UPDATE SUPPLIER                                         		    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
				
			if(supplier.length==0){
			System.out.println("OOPS! It seems that you don't have any spplier in the system.\n");
			System.out.print("Do you want to add a new supplier?(y/n)");
			yesnoAnswers =input.next().charAt(0);
				if(yesnoAnswers=='y'){
					clearConsole();
					addsupplier();
				}else{
					clearConsole();
					continue L1;
				}
			}						
			L2:
			do{
				System.out.print("\nSupplier ID : ");
				spplier_informations=input.next();
		
				for (int i = 0; i < supplier.length; i++) {
					if (spplier_informations.equals(supplier[i][0])) {
						System.out.println("Supplier Name  : " + supplier[i][1]+"\n");
						System.out.print("Enter the new supplier name: ");
						spplier_informations=input.next();
						supplier[i][1] =spplier_informations;
						System.out.print("Updated Successfully! Do you want to update another supplier? (y/n): ");
						yesnoAnswers =input.next().charAt(0);

						if (yesnoAnswers=='y') {
							clearConsole();
							continue L1;
						} else {
							clearConsole();
							supplierManage();
						}
					}
				}
				System.out.println("cannot find supplier id. try again!");
				continue L2;
			}while(true);
            
        } while (true);
    }
		
	public static void delete(){
		
		L1:	
		do{	
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					DELETE SUPPLIER                                         		    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
					
			if(supplier.length==0){
			System.out.println("OOPS! It seems that you don't have any spplier in the system.\n");
			System.out.print("Do you want to add a new supplier?(y/n)");
			yesnoAnswers =input.next().charAt(0);
				if(yesnoAnswers=='y'){
					clearConsole();
					addsupplier();
				}else{
					clearConsole();
					continue L1;
				}
			}							
			L2:
			do{
				System.out.print("Supplier ID :");
				spplier_informations=input.next();
				
				for (int i = 0; i < supplier.length; i++){
					if(spplier_informations.equals(supplier[i][0])){
						int delete =i;
						supplier= cheakdelete(delete);
						System.out.print("deleted successfully! Do you want to delete another?(y/n) :");
						yesnoAnswers =input.next().charAt(0);
							if(yesnoAnswers=='y'){
								clearConsole();
								continue L1;
							}else{
								clearConsole();
								supplierManage();
							}
					}
				}
				System.out.println("cant't find supplier id. try again!\n");
				continue L2;
				
			}while(true);	
		}while(true);
	}
			 
	public static String[][]  cheakdelete( int delete){
		String[][] temp = new String[supplier.length - 1][2];
			for (int i = 0,k=0; i < supplier.length; i++,k++) {
					if(delete==i){
						k--;
						continue;
					}
				for (int j = 0; j < supplier[i].length; j++) {	
					temp[k][j] = supplier[i][j];
				}
			}
			return temp;
	}
	
	public static void viewSuppliers(){
		
		L1: 
		do{
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					VIEW SUPPLIER                                         		            |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
						
			System.out.printf("+-----------------------------------------------+%n");
			System.out.printf("| %15s\t|  \t%-8s \t|%n", "SUPLIER ID", "SUPPLIER NAME");
			System.out.printf("+-----------------------------------------------+%n");
		
			for (int i = 0; i < supplier.length; i++){
				System.out.printf("| \t%-8s\t| \t%-15s |%n",supplier[i][0],supplier[i][1]);		
			}
			System.out.printf("+-----------------------------------------------+%n");
		
			System.out.print("Do you want to go supplier manage page(y/n) ?");
			yesnoAnswers =input.next().charAt(0);
		
			if(yesnoAnswers=='y'){
				clearConsole();
				supplierManage();
			}
			clearConsole();
			continue L1;
		
		}while(true);
		
	}
		
	public static void searchSupplier(){
		
		L1:
		do{
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					SEARCH SUPPLIER                                         		    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");	
			
			if(supplier.length==0){
			System.out.println("OOPS! It seems that you don't have any spplier in the system.\n");
			System.out.print("Do you want to add a new supplier?(y/n)");
			yesnoAnswers =input.next().charAt(0);
				if(yesnoAnswers=='y'){
					clearConsole();
					addsupplier();
				}else{
					clearConsole();
					continue L1;
				}
			}	
			L2:	
			do{		
				System.out.print("\nSupplier ID :");
				spplier_informations=input.next();
		
				for (int i = 0; i < supplier.length; i++){
					if(spplier_informations.equals(supplier[i][0])){
						System.out.println("Supplie Name :"+supplier[i][1]);
						System.out.print("search successfully! Do you want to add another find(y/n)?");
						yesnoAnswers =input.next().charAt(0);
				
						if(yesnoAnswers=='y'){
							clearConsole();
							continue L1;
						}
						clearConsole();
						supplierManage();
					}	
				}
				System.out.println("Can't find supplier id. try again!");
				continue L2;
			}while(true);
		}while(true);
	}

	public static void stockmanagement(){
		
		L1:	
		do{
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					STOCK MANAGEMENT                                        		    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
		
			System.out.println("(1)Manage Item Categories\t\t"+"(2)Add Item"+"\n\n(3)Get Items Supplier wise\t\t"+"(4)View Items\n"+"\n(5)Rank Items Per Unit Price\t\t"+"(6)Home Page");
		
			System.out.print("\nEnter an option to continue >");
			numbers=input.nextInt();
		
			switch(numbers){
			
				case 1:
					clearConsole();
					manageItemCategory();
						break;
			
				case 2:	
					clearConsole();
					addItem();
					break;
					
				case 3:	
					clearConsole();
					search_ItemSupplerWise();
					break;
					
				case 4:
					clearConsole();
					viewItems();
					break;
			
				case 5:
					clearConsole();
					rankUnitprice();
					break;
					
				case 6:
					clearConsole();
					homepage();
					break;
	
				default:
					clearConsole();
					continue L1;
			}
		
			//break L1;
		}while(true);		
	}
	
	public static void manageItemCategory(){
		L1:
		do{
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					MANAGE ITEM CATEGORY                                        		    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
			
			System.out.println("\n(1)Add New Item Category\t\t"+"(2)Delete Item Category"+"\n\n(3)Update Item Category\t\t"+"\t(4)Stock Management\n");
			
			System.out.print("\nEnter an option to continue >");
			numbers=input.nextInt();
			
			switch(numbers){
				
				case 1:
					clearConsole();
					additemCategory();
					break;
					
				case 2: 
					clearConsole();
					deleteitemCategory();
					break;
					
				case 3:
					clearConsole();
					updateitemCategory();
					break;
				
				case 4:	
					clearConsole();
					stockmanagement();
					break;
		
				default :
					clearConsole();
					continue L1;
			}
		}while(true);			
	}
	
	public static void additemCategory(){
	
		L1:
		do{	
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					ADD ITEM CATEGORY                                        		    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
		
			System.out.print("\nEnter the item category:");
			String items =input.next();
			
			item_category=growitem();
			item_category[item_category.length-1]=items; 
			System.out.print("added successfully! Do you want to add another category(y/n)?");
			yesnoAnswers =input.next().charAt(0);
			
			if(yesnoAnswers=='y'){
				clearConsole();
				continue L1;
			}else{
				clearConsole();
				stockmanagement();
			}
			
		}while(true);
	}
		
	public static String[] 	growitem(){
		String [] temps = new String [item_category.length+1];
		for (int i = 0; i <item_category.length; i++){
			temps[i] =item_category[i];
		}
			return temps;
	}
		
	public static void deleteitemCategory(){
		
		redelete:
		do{
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					DELETE ITEM CATEGORY                                        		    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
			
			if(item_category .length==0){
			System.out.println("OOPS! It seems that you don't have any item category  in the system.\n");
			System.out.print("Do you want to add a new item category ?(y/n)");
			yesnoAnswers =input.next().charAt(0);
				if(yesnoAnswers=='y'){
					clearConsole();
					additemCategory();
				}else{
					clearConsole();
					continue redelete;
				}
			}			
			L1:
			do{
			
				System.out.print("\nEnter the delete item category:");
				String deleteitem =input.next();
			
				for (int i = 0; i <item_category.length; i++){
					if(deleteitem.equals(item_category[i])){
						int deleteindex=i;
					
						item_category =deletearr(deleteindex);
						System.out.print("item deleted successfully! Do you want to delete another?(y/n) :");
						yesnoAnswers =input.next().charAt(0);
					
						if(yesnoAnswers=='y'){
							clearConsole();
							continue redelete;
						}else{
							clearConsole();
							manageItemCategory();
						}
					}
				}
				System.out.println("cant't find item category. try again!\n");
				continue L1;
			}while(true);
		}while(true);
	}

	public static String[] deletearr(int deletetindex){
		String [] temps =new String [item_category.length-1];
		for (int i = 0,j=0; i < item_category.length; i++,j++){
			if(deletetindex==i){
				j--;
				continue;
			}
			temps[j] = item_category[i];
		}
		return temps;
	}
			
	public static void updateitemCategory(){
		
		reupdate:
		do{
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					UPDATE ITEM CATEGORY                                        		    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
		
			if(item_category .length==0){
			System.out.println("OOPS! It seems that you don't have any item category  in the system.\n");
			System.out.print("Do you want to add a new item category ?(y/n)");
			yesnoAnswers =input.next().charAt(0);
				if(yesnoAnswers=='y'){
					clearConsole();
					additemCategory();
				}else{
					clearConsole();
					continue reupdate;
				}
			}
			L1:
			do{
				System.out.print("\nEnter Update Item Cateory");
				String updateitem = input.next();
				
				for (int i = 0; i <item_category.length; i++){
					if(updateitem.equals(item_category[i])){
						System.out.println("Item Category :"+item_category[i]);
						System.out.print("Ente the new Cateogory name :");
						String catogoryname =input.next();
		
						item_category[i] =catogoryname;
						System.out.print("Upadate succeuss! Do you want to update another item category (y/n):");
						yesnoAnswers =input.next().charAt(0);
					
						if(yesnoAnswers=='y'){
							clearConsole();
							continue reupdate;
						}else{
							clearConsole();
							manageItemCategory();
						}	
					}	
				}
				System.out.println("cannot find item category. try again!");
				continue L1;
			}while(true);
		}while(true);
	}	
	
	public static void addItem(){
		
		L1:
		do{
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					ADD ITEM                                        		            |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
			
			if(item_category.length==0){
				System.out.println("OOPS! It seems that you don't have any item categories in the system.\n");
				System.out.print("Do you want to add a new item category?(y/n)");
				yesnoAnswers =input.next().charAt(0);
				
				if(yesnoAnswers=='y'){
					clearConsole();
					additemCategory();
				}else{
					clearConsole();
					stockmanagement();
				}
			 }
				 
			if(supplier.length==0){
				System.out.println("OOPS! It seems that you don't have any suppliers categories in the system.\n");
				System.out.print("Do you want to add a new item category?(y/n)");
				yesnoAnswers =input.next().charAt(0);
				
				if(yesnoAnswers=='y'){
					clearConsole();
					addsupplier();
				}else{
					clearConsole();
					stockmanagement();
				}
			}
			
			L2:
			do{	
				System.out.print("Item Code:");
				String itemecode =input.next();
				
				for (int i = 0; i < item_code.length; i++){
					if(item_code[i][0].equals(itemecode)){
						System.out.println("already added. try another item code!\n");
						continue L2;
					}
				}
				
				item_code=growItem_code();
				for (int i = 0; i < item_code.length;i++){
					item_code[item_code.length-1][0]=itemecode;
						break;
				}
				
				System.out.println("\nSuppliers list :");
				
				System.out.printf("+---------------------------------------------------------------+%n");
				System.out.printf("|  \t%-8s |  \t%-16s |  \t%-15s |%n", "#", "Supplier ID", "Supplier Name");
				System.out.printf("+---------------------------------------------------------------+%n");
			
				for (int i = 0; i <supplier.length ; i++){
					System.out.printf("|  \t%-8d | \t%-16s | \t%-15s |%n", (i+1),  supplier[i][0], supplier[i][1]);
					System.out.printf("+---------------------------------------------------------------+%n");
				}
				
				System.out.print("Enter the supplier number >");
				numbers =input.nextInt();
				
				for (int i = 0; i < item_code.length ; i++){
					item_code[ item_code.length-1][1]= supplier[numbers-1][0];
				}
			
				System.out.println("\nItem Categories:");
				
				System.out.printf("+----------------------------------------+%n");
				System.out.printf("|  \t%-8s |  \t%-16s |%n", "#", "CATEGORY NAME ");
				System.out.printf("+----------------------------------------+%n");

				for (int i = 0; i < item_category.length; i++){
					System.out.printf("|  \t%-8d | \t%-16s |%n", (i+1), item_category[i]);
					System.out.printf("+----------------------------------------+%n");
				}
				
				System.out.print("\nEnter the category number >");
				numbers =input.nextInt();
			
				for (int i = 0; i < item_code.length; i++){
					item_code[ item_code.length-1][2]= item_category[numbers-1];
				}
			
				System.out.print("\nDescriptin : >");
				desc = input.next();
				item_code[item_code.length-1][3] = desc;
			
				System.out.print("Unit price :  >");
				desc = input.next();
				item_code[item_code.length-1][4] =	desc;
			
				System.out.print("Qty on hand :  >");
				desc = input.next();
				item_code[item_code.length-1][5] =desc;
			
				System.out.print("added successfully! Do you want to add another Item(y/n)?");
				yesnoAnswers =input.next().charAt(0);
			
				if(yesnoAnswers=='y'){
					clearConsole();
					continue L1;
				}else{
					clearConsole();
					stockmanagement();
				}
			}while(true);
		}while(true);
	}
	
	public static String [][] growItem_code(){	
		String [][] tempcode = new String[item_code.length+1][6];
		for (int i = 0; i < item_code.length; i++){
			for (int j = 0; j < item_code[i].length;j++){
				 tempcode[i][j] = item_code[i][j]; 
			}
		}
			return tempcode;
	}
					
	public static void search_ItemSupplerWise(){
		
		L1: 
		do{	
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					SEARCH ITEMS SUPPLIER WISE                                       	    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
		
			L2:
			do{
				System.out.print("Enter Supplier Id:");
				spplier_informations=input.next();
				
				for (int i = 0; i <supplier.length; i++){
					if(spplier_informations.equals(supplier[i][0])){
						System.out.println("name:"+supplier[i][1]);
						System.out.printf("+-------------------------------------------------------------------------------------------------------------------------+%n");
						System.out.printf("|  \t%-16s |  \t%-16s | \t%-16s | \t%-16s |\t%-17s |%n", "ITEM CODE", "DESCRIPTION","UNIT PRIC","QTY ON HAND","CATEGORY");
						System.out.printf("+-------------------------------------------------------------------------------------------------------------------------+%n");	
				
						for (int j = 0; j <item_code.length ; j++){
							if(spplier_informations.equals(item_code[j][1])){
								System.out.printf("| \t%-16s |  \t%-16s | \t%6s.0\t | %10s\t\t | \t%-17s |%n", item_code[j][0], item_code[j][3], item_code[j][4], item_code[j][5], item_code[j][2]);
								System.out.printf("+-------------------------------------------------------------------------------------------------------------------------+%n");
							}
						}
						System.out.print("search successfully! Do you want to another search?(y/n)");
						yesnoAnswers =input.next().charAt(0);
						
						if(yesnoAnswers=='y'){
							clearConsole();
							continue L1;
						}else{
							clearConsole();
							stockmanagement();
						}
					}
				}
				System.out.println("can't find supplier id.try again\n");
				continue L2;
			}while(true);
		
		}while(true);	
	}
	
	public static void viewItems(){
		
		L1:	
		do{	
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     					VIEW ITEMS                                       	    		    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
			
			for (int i = 0; i <item_category.length ; i++){
				System.out.println("\n"+item_category[i]+":\n");
				System.out.printf("+--------------------------------------------------------------------------------------------------------------------------------+%n");
				System.out.printf("|  \t%-12s |  \t%-12s | \t%15s\t\t\t | \t%12s\t  \t|\t%-9s \b|%n", "SID", "CODE","DESC","PRICE","QTY");
				System.out.printf("+--------------------------------------------------------------------------------------------------------------------------------+%n");
				for (int j = 0; j <item_code.length ; j++){
					if(item_category[i].equals(item_code[j][2])){
						System.out.printf("| \t%-12s | \t\t%-12s | \t\t%-10s\t\t | %16s.0\t\t\b |%9s \t |%n",item_code[j][1], item_code[j][0], item_code[j][3],item_code[j][4], item_code[j][5]);
						System.out.printf("+--------------------------------------------------------------------------------------------------------------------------------+%n");
					}
				}
			}
			System.out.print("Do you want to go stock manage page?(y/n)");
			yesnoAnswers =input.next().charAt(0);
			if(yesnoAnswers=='y'){
				clearConsole();
				stockmanagement();
			}else{
				clearConsole();
				continue L1;
			}
		}while(true);
	}		
			
	public static void rankUnitprice(){
		
		L1:	
		do{
			
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|                     				  RANKED UNIT PRICE                                      	    		    |%n");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------+%n\n\n");
			
			int tempery[]  =new int[item_code.length];
			
			for (int i = 0; i < item_code .length; i++){
				int number =Integer.parseInt(item_code[i][4]);
				tempery[i] =number;
			}
				
			for (int i = 0; i <tempery .length - 1; i++) {
				for (int j = 0; j < tempery.length - 1; j++) {
					if(tempery[j] > tempery[j+1]) {
						int temp = tempery[j];
						tempery[j] = tempery[j+1];
						tempery[j+1] = temp;
					}	
				}
			}
		
			System.out.printf("+-------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("|  \t%-12s |  \t%-12s | \t%15s\t\t\t | \t%12s\t  \t|\t%-9s \b | \t%8s\t|%n", "SID", "CODE","DESC","PRICE","QTY","CAT");
			System.out.printf("+-------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
			
			for (int i = 0; i <item_code.length; i++){
				String tope =Integer.toString(tempery[i]);
				for (int j = 0; j < item_code.length; j++){
					if(tope.equals(item_code[j][4])){
						System.out.printf("| \t%-12s | \t\t%-12s | \t\t%-10s\t\t | %16s.0\t\t\b |%10s\t  | \t %-10s\t|%n",item_code[j][1] , item_code[j][0], item_code[j][3],item_code[j][4], item_code[j][5],item_code[j][2]);
						System.out.printf("+-------------------------------------------------------------------------------------------------------------------------------------------------------+%n");		
					}
				}
			}
			System.out.print("Do you want to go stock manage page?(y/n)");
			yesnoAnswers =input.next().charAt(0);
			
				if(yesnoAnswers=='y'){
					clearConsole();
					stockmanagement();
				}else{
					clearConsole();
					continue L1;
				}
					
		}while(true);		
	}	
	
	private final static void clearConsole() {
		
		final String os = System.getProperty("os.name");
		try {
				if (os.equals("Linux")) {
					System.out.print("\033\143");
				} else if (os.equals("Windows")) {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} else {
					System.out.print("\033[H\033[2J");
					System.out.flush();
				}
			} catch (final Exception e) {
		//handle the exception
		System.err.println(e.getMessage());
		}
	}
}	
		















	
	



























































	
	

	
	
	
	
	
	
	
	
				
				
				
	
	
