
import com.InputOutputServices.Readers.ReaderJson;

import com.Services.AbstractClasses.Manager;
import com.Services.AbstractClasses.Service;
import com.Services.StaffManagers.StaffManager;
import com.Services.StaffServices.StaffService;
import com.InputOutputServices.Writers.WriterJson;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        // implement fileReader/fileWriter to handle saving into only json
        Service service = new StaffService(new ReaderJson(), new WriterJson());
        // Using dependency injection to provide service to StaffManager
        Manager manager = new StaffManager(service);
        System.out.println("Welcome to Staff Management System");

        boolean isRunning = true;
        Scanner sc =new Scanner(System.in);

        while (isRunning) {
            displayCommands();
           String command=sc.nextLine();
            if(command.isEmpty()){
                continue;
            }
            if(command.equals("Save and Exit")){
                //saving current status of in memory database by using WriterJson service
                service.WriterJson.write(service.inMemoryDatabase);
               break;
            }

            manager.execute(command);
        }
        sc.close();
    }

    public static void displayCommands(){
        System.out.println("Add Employee");
        System.out.println("Edit with ID");
        System.out.println("Fire whit ID");
        System.out.println("List Employee");
        System.out.println("Search Employee");
        System.out.println("Save and Exit");

    }
}