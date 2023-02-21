package com.driver;

public class Email {

    private String emailId;
    private String password;

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        int len=0;
        int upper=0;
        int lower=0,dig=0,spchar=0;
        int size=newPassword.length();

        if(this.password==oldPassword)
        {
            if(size<8) return;
            for(int i=-0; i<newPassword.length(); i++)
            {
                len=1;
                char ch = newPassword.charAt(i);
                if(ch>64 && ch<91 ) upper=1;
                if(ch>96 && ch <123) lower=1;
                if((ch>=32 && ch <=47) || (ch>= 58 && ch<=64) || (ch>=91 && ch<=96) ||(ch <=123 && ch>=126))
                     spchar=1;
                if(ch>=48 && ch <=57)  dig = 1;

                if(len==1 && upper==1 && lower==1 && dig==1 && spchar==1 &&  size>=8)
                {
                    this.password=newPassword;
                }

            }

        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
