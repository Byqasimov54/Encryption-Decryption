package com.example.loginsqlite;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


public class EncryptionManager{
    private static EncryptionManager instance = null;
    private final static String TOKEN_KEY = "123456781234567812345678";
    MessageDigest digest = null;
    String hash;


    private EncryptionManager(){
    }


    public static EncryptionManager getInstance() {
        if (instance == null) {
            instance = new EncryptionManager();
        }
        return instance;
    }

    private static byte[] getCombinedArray(byte[] one, byte[] two) {
        byte[] combined = new byte[one.length + two.length];
        for (int i=0; i < combined.length; ++i) {
            combined[i] = i < one.length ? one[i] :two[i - one.length];
        }
        return combined;
    }

    private static String bytesToHecString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString( 0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    String encodeBase64(String data){
        try{
            return Base64.encodeToString(data.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    String decodeBase64(String data) {
        try {
            return new String(Base64.decode(data, Base64.DEFAULT),StandardCharsets.UTF_8);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}










