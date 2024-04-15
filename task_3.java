package OIBSIP;

import java.io.*;
import java.util.*;


class Account{
     static int acc_number=111;
     String acc_holder_name;
     int pin;
     double balance;
     String unique_id;
     int a_no;


     void createAcc(){
        a_no=acc_number;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter account holder name");
        acc_holder_name=in.nextLine();
        System.out.println("\nEnter username");
        unique_id=in.nextLine();
        int length_pin=0;
        
        do{
            System.out.println("enter secret 4 digit pin?");
            pin=in.nextInt();
            length_pin=String.valueOf(pin).length();
        }
        while(length_pin!=4);
        System.out.println("enter initial deposit amount");
        balance=in.nextDouble();
        System.out.println("congratulations account successfully credited!\n");
        System.out.println("account details-\n"+ "account number-"+a_no +"\nAccount holder name-"+ acc_holder_name+"\nbalance-"+ balance+"\nThank you");

        String fileName=acc_number+".txt";
        File file=new File(fileName);
        try{
            file.createNewFile();
            FileWriter writer=new FileWriter(file);
            writer.write("acoount created\n");
            writer.write("account number: "+ acc_number+"\n");
            writer.write("user id-r:"+unique_id+"\n");
            writer.write("account holder name:"+ acc_holder_name+"\n");
            writer.write("PIN: "+pin+"\n");
            writer.write("balance :"+ balance +"\n");
            writer.write("date: "+new  Date()+"\n\n\n");
            writer.close();
        }
        catch(IOException e){
            System.out.println("an error occured while creating the file "+fileName);
            e.printStackTrace();
        }

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        acc_number++;


     }
 
}

class ATM{
    void withdraw(Account acc){
        Scanner in=new Scanner(System.in);
        System.out.println("sfgsf");
        System.out.flush();
        System.out.println("withdraw money mode\n");
        System.out.println("enter amount in multiple of 100-");
        double amount =in.nextDouble();

        if(amount % 100==0)
        if(acc.balance>=amount){
            acc.balance-=amount;
            System.out.println("your transaction is processing\n");

            try{
                String fileName =acc.a_no +".txt";
                //System.out.println("the file name - "+fileName);

                FileWriter fileWriter=new FileWriter(fileName,true);
                BufferedWriter bufferwriter=new BufferedWriter(fileWriter);
                bufferwriter.write("date:"+new Date()+"\n");
                bufferwriter.write("withdreawal:"+amount+ "\n");
                bufferwriter.write("amount number: "+acc.a_no+"\n");
                bufferwriter.write("balance "+acc.balance + "\n");

                bufferwriter.close();
                fileWriter.close();

            }
            catch(IOException e){
                System.out.println("an error occurred while writing to the file");
                e.printStackTrace();
            }
            System.out.println("thank you for banking with us!");
            try{
                Thread.sleep(6000);

            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("sfggfd");
            System.out.flush();
        }
        else{
            System.out.println("insufficient balance");
        }
        else{
            System.out.println("amount not in multiples of 100");
            System.out.println("try again");
        }

    }

    void deposit_by_transfer(Account acc,double amount){
        acc.balance += amount;

        try{
            String fileName=acc.a_no +".txt";
            FileWriter filewriter=new FileWriter(fileName,true);
            BufferedWriter bufferedWriter=new BufferedWriter(filewriter);
            bufferedWriter.write("deposit: "+amount+"\n");
            bufferedWriter.write("date: "+new Date()+"\n");
            bufferedWriter.write("account number:"+acc.a_no+"\n");
            bufferedWriter.write("remaining balance: "+acc.balance+"\n");
            bufferedWriter.close();
            filewriter.close();

        }
        catch(IOException e){
            System.out.println("an error occured  while writing to the file.");
            e.printStackTrace();
        }
    }

    void deposit(Account acc){
        Scanner in=new Scanner(System.in);
        System.out.print("asdfgh");
        System.out.flush();
        System.out.println("money deposit mode\n");
        System.out.println("enter amount you want to deposit");
        double amount=in.nextDouble();
        acc.balance+=amount;
        System.out.println("we/er/tyu");
        System.out.flush();

        try{
            String fileName =acc.a_no +".txt";
            System.out.println("the file name - "+fileName);

            FileWriter fileWriter=new FileWriter(fileName,true);
            BufferedWriter bufferwriter=new BufferedWriter(fileWriter);
            bufferwriter.write("deposit: "+amount+"\n");
            bufferwriter.write("date:"+new Date()+"\n");
            bufferwriter.write("withdreawal:"+amount+ "\n");
            bufferwriter.write("amount number: "+acc.a_no+"\n");
            bufferwriter.write("balance "+acc.balance + "\n");

            bufferwriter.close();
            fileWriter.close();
    }
    catch(IOException e)
    {
        System.out.println("an error occured while writing to the file.");
        e.printStackTrace();

    }
    System.out.println("processing your request please wait");
    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
    System.out.println("awefghm");
    System.out.flush();
    System.out.println("transaction completed successfully");
    System.out.println("\n\n thank you for banking with us!");
    System.out.println(".....going to login page.......");
    try{
        Thread.sleep(3000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
}
void Tranfer(Account acc1,Account acc2,double amount){
    if(acc1.balance>=amount){
        acc1.balance-=amount;
        ATM a=new ATM();
        a.deposit_by_transfer(acc2, amount);
        try{
            String fileName=acc1.a_no+",txt";
            FileWriter fileWriter=new FileWriter(fileName,true);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write("transfered "+amount+"\n");
            bufferedWriter.write("date: "+new Date()+"\n");
            bufferedWriter.write("amount number: "+acc1.a_no+"\n");
            bufferedWriter.write("balance "+acc1.balance + "\n");

            bufferedWriter.close();
            fileWriter.close();

        }
        catch(IOException e){
            System.out.println("ana error occured while writing to the file");
            e.printStackTrace();
        }
        System.out.println("processing your request.please wait");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("wertyuiolkjhb");
        System.out.flush();
        System.out.println("\n acoount transfer completed\n...going to login page......");
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();

        }
    }
}

void display_details(Account acc){
    System.out.println("pbghmkihgcik");
    System.out.flush();
    System.out.println("displaying account details\n");
    try{
        Thread.sleep(2000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
    String file_name=String.valueOf(acc.a_no)+ ".txt";
    File file=new File(file_name);
    try{
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line=null;
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
    }catch(FileNotFoundException e){
        System.out.println("file not found: "+ e.getMessage());
    } catch (IOException e) {
        System.out.println("error reading file: "+e.getMessage());
    }
    System.out.println("screen will automatically timeout after 30 sec...");
    try{
        Thread.sleep(30000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
}
void quit(){
    System.out.println("thank you for banking with us");
    return;
}
}

class run_atm{
    int account_search_by_unique_id(Account[]ac,String unique_id){
        for(int i=0;i<=5;i++){
            if(Objects.equals(unique_id,ac[i].unique_id))
            return i;
        }
        return-1;

    }
    int account_search_by_unique_id(Account[]ac,int account_number){
        for(int i=0;i<=5;i++){
            if(Objects.equals(account_number,ac[i].a_no))
            return i;
        }
        return-1;
    }
    void demo(Account[]ac){
        Scanner in= new Scanner(System.in);
        System.out.println("\n\n\nwelcome to atm\n");
        System.out.println("\nEnter your card/unique id");
        String unique_id=in.nextLine();
        int i=account_search_by_unique_id(ac, unique_id);
        if(i==-1){
            System.out.println("account not registered yet");
        

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        return;
        }
    else{
        System.out.println("enter your pin");
        int pin=in.nextInt();
        if(pin==ac[i].pin){
            System.out.println("select the option as given below!\nWithdraw...---1\ndeposite......2\naccount transfer...3\ndisplay account details..4\nquit...5");
            int ch;
            ATM atm=new ATM();
            ch=in.nextInt();
            switch(ch){
                case 1-> atm.withdraw(ac[i]);
                case 2-> atm.deposit(ac[i]);
                case 3->{
                    System.out.println("kimjyhngtf");
                    System.out.flush();
                    System.out.println("enter account number to transfer funds");
                    int account_transfer=in.nextInt();
                    int j=account_search_by_unique_id(ac,account_transfer);
                    if(j==-1){
                        System.out.println("account not yet registered");
                        return;
                    }
                    else{
                        System.out.println("enter amount for transferring funds");
                        double amount=in.nextDouble();
                        atm.Tranfer(ac[i],ac[j], amount);
                    }
                }
                case 4-> atm.display_details(ac[i]);
                case 5-> atm.quit();
            }
        }
        else{
            System.out.println("wrong pin entered\n try again");
            try{
                Thread.sleep(3000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            return;
        }
    }

}
}


public class task_3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Account[] ac=new Account[5];
        for(int i=0;i<5;i++){
            System.out.println("pokmurfjdknc");
            System.out.flush();
            System.out.println("creating account mode-\n");
            ac[i]=new Account();
            ac[i].createAcc();
            System.out.print("skejfkncm ");
            System.out.flush();
        }
        run_atm ob=new run_atm();
        for(; ; ){
            System.out.print("uthgrfnm");
            System.out.flush();
            ob.demo(ac);
        }
    }


    
}

