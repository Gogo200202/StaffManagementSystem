package com.Services.AbstractClasses;

import com.DataBase.Entetys.Employee;
import com.Services.interfaces.Managerble;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class  Manager implements Managerble {

   private Service service;
   public Manager(Service Service){

      this.service=Service;
   }

   public void execute(String command){

      String[]SplitCommands=command.split(" ");
      if(SplitCommands[0].equals("Add")){



         System.out.println("Enter employee data");
         Scanner sc=new Scanner(System.in);
         String[] employeeData=sc.nextLine().split(", ");
         // data validation if the given input matches the requirements input
         if(employeeData.length>5){
            System.out.println("Wrong input");
            return;
         }

         String Id=employeeData[0];
            // data validation for not valid numbers or empty spots
         try {
            Integer.parseInt(Id);
            if(Id.isEmpty()){
               System.out.println("Wrong input Id");
               return;
            }
            if(service.inMemoryDatabase.containsKey(Id)){
               System.out.println("Wrong input Id");
               return;
            }
         } catch(NumberFormatException e){
            System.out.println("Wrong input Id");
            return;
         }


         String name=employeeData[1];

         if(name.isEmpty()){
            System.out.println("Wrong input name");
            return;
         }


         String department=employeeData[2];

         if(department.isEmpty()){
            System.out.println("Wrong input department");
            return;
         }


         String role=employeeData[3];

         if(role.isEmpty()){
            System.out.println("Wrong input role");
            return;
         }

         String salary=employeeData[4];

         try {
            Double.parseDouble(salary);
            if(salary.isEmpty()){
               System.out.println("Wrong input salary");
               return;
            }
         } catch(NumberFormatException e){
            System.out.println("Wrong input salary");
            return;
         }

         Employee employee =new Employee();
         employee.setId(Id);
         employee.setName(name);
         employee.setDepartment(department);
         employee.setRole(role);
         employee.setSalary(Double.parseDouble(salary));

         this.service.inMemoryDatabase.put(Id,employee);


      }else if(SplitCommands[0].equals("Fire")){
         Scanner sc=new Scanner(System.in);
         // data validation if the given input matches the requirements input
         if(SplitCommands.length==1){
            System.out.println("Wrong input");
            return;
         }

         String Id=SplitCommands[1];
         // data validation for not valid numbers or empty spots
         try {
            Integer.parseInt(Id);
            if(Id.isEmpty()){
               System.out.println("Wrong input Id");
               return;
            }
            if(!service.inMemoryDatabase.containsKey(Id)){
               System.out.println("Wrong input Id");
               return;
            }
         } catch(NumberFormatException e){
            System.out.println("Wrong input Id");
            return;
         }
         this.service.inMemoryDatabase.remove(Id);



      }else if(SplitCommands[0].equals("Edit")){
         System.out.println("Enter employee data");
         // data validation if the given input matches the requirements input
            if(SplitCommands.length==1){
               System.out.println("Wrong input");
               return;
            }

         String oldId=SplitCommands[1];

         // data validation for not valid numbers or empty spots
         try {
            Integer.parseInt(oldId);
            if(oldId.isEmpty()){
               System.out.println("Wrong input Id for Edit");
               return;
            }
            if(!this.service.inMemoryDatabase.containsKey(oldId)){
               System.out.println("Wrong input Id for Edit");
               return;
            }

         } catch(NumberFormatException e){
            System.out.println("Wrong input Id for Edit");
            return;
         }

         Scanner sc=new Scanner(System.in);
         String[] employeeData=sc.nextLine().split(", ");

         String Id=employeeData[0];

         try {
            Integer.parseInt(Id);
            if(Id.isEmpty()){
               System.out.println("Wrong input Id");
               return;
            }

         } catch(NumberFormatException e){
            System.out.println("Wrong input");
            return;
         }


         String name=employeeData[1];

         if(name.isEmpty()){
            System.out.println("Wrong input name");
            return;
         }


         String department=employeeData[2];

         if(department.isEmpty()){
            System.out.println("Wrong input department");
            return;
         }


         String role=employeeData[3];

         if(role.isEmpty()){
            System.out.println("Wrong input role");
            return;
         }

         String salary=employeeData[4];

         try {
            Double.parseDouble(salary);
            if(salary.isEmpty()){
               System.out.println("Wrong input salary");
               return;
            }
         } catch(NumberFormatException e){
            System.out.println("Wrong input salary");
            return;
         }

         Employee employee =new Employee();
         employee.setId(Id);
         employee.setName(name);
         employee.setDepartment(department);
         employee.setRole(role);
         employee.setSalary(Double.parseDouble(salary));

         this.service.inMemoryDatabase.put(oldId,employee);


      }else if(SplitCommands[0].equals("List")){

         for (var employ:this.service.inMemoryDatabase.entrySet()) {
            System.out.println(employ.getValue().getId()+" "+employ.getValue().getName()+" "+employ.getValue().getRole()+" "+employ.getValue().getDepartment()+" "+employ.getValue().getSalary());
         }

      }else if(SplitCommands[0].equals("Search")){

         Map<String,Employee> resolt=new HashMap<>();

         // if the data is not found print nothing
         // if data is not valid print nothing
         try {

            if(SplitCommands[1].equals("Id")){
               Employee resoltEmployee=this.service.inMemoryDatabase.get(SplitCommands[2]);
               System.out.println(resoltEmployee.getId()+" "+resoltEmployee.getName()+" "+resoltEmployee.getRole()+" "+resoltEmployee.getDepartment()+" "+resoltEmployee.getSalary());

            }else if(SplitCommands[1].equals("Department")){
               resolt=this.service.inMemoryDatabase.entrySet()
                       .stream().filter(x->x.getValue().getDepartment().equals(SplitCommands[2]))
                       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            }  if(SplitCommands[1].equals("Name")){
               resolt=this.service.inMemoryDatabase.entrySet()
                       .stream().filter(x->x.getValue().getName().contains(SplitCommands[2]))
                       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            }
            for (var employ:resolt.entrySet()) {
               System.out.println(employ.getValue().getId()+" "+employ.getValue().getName()+" "+employ.getValue().getRole()+" "+employ.getValue().getDepartment()+" "+employ.getValue().getSalary());
            }
         }catch (NullPointerException e){
            System.out.println("Wrong input");
         }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Wrong input for Search");
         }



      }else {
         System.out.println("Wrong input for commands");
      }

   }
}
