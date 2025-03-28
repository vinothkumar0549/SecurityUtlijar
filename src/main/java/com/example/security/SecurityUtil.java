package com.example.security;

import com.example.pojo.*;
public class SecurityUtil {

    public static String encrypt(String password, int shift) {
        StringBuilder builder = new StringBuilder();

        for (char c : password.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                char base = Character.isUpperCase(c) ? 'A' : (Character.isLowerCase(c) ? 'a' : '0');
                int range = Character.isDigit(c) ? 10 : 26;
                builder.append((char) (base + (c - base + shift) % range));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void validation(User user, String password){
        if(user == null){
            throw new IllegalArgumentException("User Not Found");
        }
        if(! user.getEncryptedpassword().equals(password)){
            throw new SecurityException("Invalid Password");
        }
    }
    
}

