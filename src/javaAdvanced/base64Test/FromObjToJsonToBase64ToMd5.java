package javaAdvanced.base64Test;

import com.google.gson.Gson;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class FromObjToJsonToBase64ToMd5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        //Obj
        Teacher tc = new Teacher();
        tc.setName("MyApple");
        tc.setHomeTown("Hell Town");
        tc.setSkill("Math n English");

        //To Json
        Gson gson = new Gson();
        String gsonstr = gson.toJson(tc);
        System.out.println(gsonstr);

        //To base64 String
        String base64str =Base64.getEncoder().encodeToString(gsonstr.getBytes());
        System.out.println("base64str:"+base64str);

        //To MD5
        MessageDigest mg =MessageDigest.getInstance("MD5");
        mg.digest(base64str.getBytes());
        mg.toString();
        System.out.println(mg.toString());

        //To base64 byte[]
        byte[] base64byte =Base64.getEncoder().encode(gsonstr.getBytes());
        String base64byteToStr = new String(base64byte); //Notice Point!!!!


        //MD5 Test2
        String password = "ILoveJava";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());  // Different!!!
        byte[] digest = md.digest();     // Different!!!
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        System.out.println("myHash:  "+myHash);

        //MD5 Test3
        String password2 = "ILoveJava";
        MessageDigest md2 = MessageDigest.getInstance("MD5");

        byte[] digest2 = md2.digest(password2.getBytes());  // Different!!!

        String myHash2 = DatatypeConverter.printHexBinary(digest2).toUpperCase();
        System.out.println("myHash2: "+myHash2);

        //Make sure the difference between MD5 Test2 and MD5 Test3

    }
}

class Teacher{
    String name;
    String skill;
    String homeTown;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }
}
