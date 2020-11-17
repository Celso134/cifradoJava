/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimbo;

import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;

import javax.crypto.Cipher;
import sun.misc.BASE64Encoder;
import java.util.Base64;

public class Jimbo {
        public String desJimbo(String texto, String llave){
            Cipher cifrado;
            try{
                cifrado = Cipher.getInstance("AES");
                SecretKeySpec key = new SecretKeySpec(llave.getBytes(), "AES");
                cifrado.init(Cipher.DECRYPT_MODE,key);
                byte[] mensajeDecifrado = cifrado.doFinal(Base64.getDecoder().decode(texto));
                return new String(mensajeDecifrado);
            }catch(Exception e){
                return null;
            }
        }
        public String jimbo(String texto, String llave){
            Cipher cifrado;
            try{
                cifrado = Cipher.getInstance("AES");
                SecretKeySpec key = new SecretKeySpec(llave.getBytes(), "AES");
                cifrado.init(Cipher.ENCRYPT_MODE, key);
                byte[] campoCifrado = cifrado.doFinal(texto.getBytes());
                return new BASE64Encoder().encode(campoCifrado);
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }
}
