package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.*;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    PriorityQueue <mail> inboxQ = new LinkedList<>();
    PriorityQuueue<mail> trashQ = new LinkedList<>();



    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already
        mail m = new mail(date,sender,message);
        if(inboxQ.size()==inboxCapacity)
        {
            mail t= inboxQ.peek();
            trashQ.offer(t);
            inboxQ.poll();
            inboxQ.offer(m);
        }
        else
           inboxQ.offer(m);
    }

    public void deleteMail(String message){

        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inboxQ.isEmpty()) return null;
        else
            return inboxQ.peek(message);
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inboxQ.size()==0) return null;
        else {
           return inboxQ.peek(message);
        }

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

    }

    public int getInboxSize(){
        // Return number of mails in inbox
         return inboxQ.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trashQ.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trashQ.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }
}
class mail{
    Date date;
    String senderId;
    String massage;
    mail(Date date, String senderId, String massage)
    {
        this.date=date;
        this.senderId=senderId;
        this.massage=massage;
    }

}

