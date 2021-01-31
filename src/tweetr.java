import twitter4j.*;

import java.util.Scanner;

public class tweetr {
    public static void main(String[] args) {
        Scanner stream = new Scanner(System.in);
        boolean dm = false;

        System.out.print("Is this a direct message?: ");                            //input
        String type = stream.nextLine();
        if(type.contains("yes")){
            dm = true;
            System.out.print("Who do you want to message: ");
            String message = stream.nextLine();
            System.out.print("What do you want to say?: ");
            String recipient = stream.nextLine();
            make(recipient, message, dm);                                           //calls the make function, giving message and recipient, if applicable
        }
        else{
            System.out.print("What do you want to tweet?: ");
            String message = stream.nextLine();
            make(message, "", dm);
        }
    }

    public static void make(String message, String recipient, boolean dm){
        Twitter twitter = TwitterFactory.getSingleton();                            //instantiate
        try{                                                                        //need a try catch for for bad inputs
            if(dm){
                DirectMessage ms = twitter.sendDirectMessage(recipient, message);   //sends direct message given recipient, message
                System.out.println("Message has been sent!");
            }
            else{
                Status status = twitter.updateStatus(message);                      //sends status message given message
                System.out.println("Tweet has been sent!");
            }
        }
        catch (TwitterException e){
            e.printStackTrace();
        }
    }
}
