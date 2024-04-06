package Proje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program 
{
   
    public static void main(String [] args) 
    {
        LocalDateTime now = LocalDateTime.now(); 

   
        String 
        A_java = "https://raw.githubusercontent.com/khalidAlmuanen/PROJELER/master/Projeler/src/Proje/RandevuYonetimi.java";
        
        int javadocSatirSayisiA = 0;         
        int yorumSatirSayisiA = 0;        
        int kodSatirSayisiA = 0;       
        int fonksiyonSayisiA = 0;        
        int boslukSatirSayisiA = 0;
        
        Pattern 
        fonksiyonPatternA = Pattern.compile("\\(.*\\)\\s*\\{");
        Pattern 
        javadocPatternA = Pattern.compile("^\\s*/\\*{2}.*?\\*/\\s*$");
        Pattern 
        yorumPatternA = Pattern.compile("^\\s*//.*");
        Pattern 
        kodDeseniPatternA = Pattern.compile("\\S");
        Pattern 
        boslukDeseniPatternA = Pattern.compile("^\\s*$");
        
        try 
        {
            URL url = new URL(A_java);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String satir;

            while ((satir = reader.readLine()) != null) {
                satir = satir.trim();

                Matcher 
                yorumMatcherA = yorumPatternA.matcher(satir);
                Matcher 
                fonksiyonMatcherA = fonksiyonPatternA.matcher(satir);
                Matcher
                kodDeseniMatcherA = kodDeseniPatternA.matcher(satir);
                Matcher 
                boslukDeseniMatcherA = boslukDeseniPatternA.matcher(satir);
                
                if (satir.contains("*") && (!satir.equals("/**")  && !satir.equals("*/"))) 
                {
                    javadocSatirSayisiA++;
                } 
                else if (yorumMatcherA.matches()) 
                {
                    yorumSatirSayisiA++;
                } 
                else if (!satir.isEmpty()) 
                {
                    kodSatirSayisiA++;
                }
                else if (satir.trim().isEmpty()) 
                { 
                    boslukSatirSayisiA++;
                }

                if (satir.contains("(") && satir.contains(")") && satir.endsWith("{")) {
                    fonksiyonSayisiA++;
                }
            }

            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        int LOC_A = 
        		javadocSatirSayisiA + yorumSatirSayisiA + kodSatirSayisiA + boslukSatirSayisiA;
        double YG_A = 
        		((javadocSatirSayisiA + yorumSatirSayisiA) * 0.8) / fonksiyonSayisiA;
        double YH_A = 
        		(kodSatirSayisiA / fonksiyonSayisiA) * 0.3;
        double yorumSapmaYuzdesiA = 
        		(((100 * YG_A)) / YH_A) - 100;


        System.out.println("Sınıf: " + "A.java");
        System.out.println("Javadoc Satır Sayısı: " + javadocSatirSayisiA);
        System.out.println("Yorum Satır Sayısı: " + yorumSatirSayisiA);
        System.out.println("Kod Satır Sayısı: " + kodSatirSayisiA);
        System.out.println("LOC: " + LOC_A);
        System.out.println("Fonksiyon Sayısı: " + fonksiyonSayisiA);
        System.out.printf("Yorum Sapma Yüzdesi: %.2f%%", yorumSapmaYuzdesiA);
        System.out.printf("\n----------------------------\n");

        String B_java = "https://raw.githubusercontent.com/khalidAlmuanen/PROJELER/master/Projeler/src/Proje/TedaviYonetimi.java";
        
        int javadocSatirSayisiB = 0;
        int yorumSatirSayisiB = 0;
        int kodSatirSayisiB = 0;
        int fonksiyonSayisiB = 0;
        int boslukSatirSayisiB = 0;

        Pattern 
        yorumPatternB = Pattern.compile("^\\s*//.*");
        Pattern 
        fonksiyonPatternB = Pattern.compile("\\(.*\\)\\s*\\{");
        Pattern 
        kodDeseniPatternB = Pattern.compile("\\S");
        Pattern 
        boslukDeseniPatternB = Pattern.compile("^\\s*$");
        
        try 
        {
            URL url = new URL(B_java);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String satir;

            while ((satir = reader.readLine()) != null)  {
                satir = satir.trim();
                
                Matcher 
                yorumMatcherB = yorumPatternB.matcher(satir);
                Matcher 
                fonksiyonMatcherB = fonksiyonPatternB.matcher(satir);
                Matcher 
                kodDeseniMatcherB = kodDeseniPatternB.matcher(satir);
                Matcher 
                boslukDeseniMatcherB = boslukDeseniPatternB.matcher(satir);
             
                if (satir.contains("*") && (!satir.equals("/**")  && !satir.equals("*/"))) 
                {
                    javadocSatirSayisiB++;
                } 
                else if (satir.startsWith("//")) 
                {
                    yorumSatirSayisiB++;
                } 
                else if (!satir.isEmpty()) 
                {
                    kodSatirSayisiB++;
                }
                else if (satir.trim().isEmpty()) 
                { 
                    boslukSatirSayisiB++;
                }

                if (satir.contains("(") && satir.contains(")") && satir.endsWith("{")) 
                {
                    fonksiyonSayisiB++;
                }
            }

            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        int LOC_B = 
        		javadocSatirSayisiB + yorumSatirSayisiB + kodSatirSayisiB + boslukSatirSayisiB;
        double YG_B = 
        		((javadocSatirSayisiB + yorumSatirSayisiB)*0.8)/fonksiyonSayisiB;
        double YH_B = 
        		(kodSatirSayisiB/fonksiyonSayisiB)*0.3;
        double yorumSapmaYuzdesiB =  
        		((100*YG_B))/YH_B-100;


        System.out.println("Sınıf: " + "B.java");
      
        System.out.println("Javadoc Satır Sayısı: " + javadocSatirSayisiB);
        
        System.out.println("Yorum Satır Sayısı: " + yorumSatirSayisiB);
       
        System.out.println("Kod Satır Sayısı: " + kodSatirSayisiB);
       
        System.out.println("LOC: " + LOC_B);
       
        System.out.println("Fonksiyon Sayısı: " + fonksiyonSayisiB);
       
        System.out.printf("Yorum Sapma Yüzdesi: %.2f%%", yorumSapmaYuzdesiB);
       
        System.out.printf("\n----------------------------\n");

        String C_java = "https://raw.githubusercontent.com/khalidAlmuanen/PROJELER/master/Projeler/src/Proje/Program.java";

        int javadocSatirSayisiC = 0;
        int yorumSatirSayisiC = 0;
        int kodSatirSayisiC = 0;
        int fonksiyonSayisiC = 0;
        int boslukSatirSayisiC = 0;

        Pattern 
        javadocPatternC = Pattern.compile("^\\s*/\\*{2}.*?\\*/\\s*$");
        Pattern 
        yorumPatternC = Pattern.compile("^\\s*//.*");
        Pattern 
        kodDeseniPatternC = Pattern.compile("\\S");
        Pattern 
        boslukDeseniPatternC = Pattern.compile("^\\s*$");

        try {
            URL url = new URL(C_java);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String satir;
            while ((satir = reader.readLine()) != null) {
                satir = satir.trim();

                Matcher 
                javadocMatcherC = javadocPatternC.matcher(satir);
                Matcher 
                yorumMatcherC = yorumPatternC.matcher(satir);
                Matcher 
                kodDeseniMatcherC = kodDeseniPatternC.matcher(satir);
                Matcher 
                boslukDeseniMatcherC = boslukDeseniPatternC.matcher(satir);

                if (javadocMatcherC.matches())
                {
                    javadocSatirSayisiC++;
                } 
                else if (yorumMatcherC.matches()) 
                {
                    yorumSatirSayisiC++;
                } 
                else if (!satir.isEmpty()) 
                {
                    kodSatirSayisiC++;
                } 
                else if (satir.trim().isEmpty()) 
                {
                    boslukSatirSayisiC++;
                }

                if (satir.contains("(") && satir.contains(")") && satir.endsWith("{")) {
                    fonksiyonSayisiC++;
                }
            }

            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        int 
        LOC_C = javadocSatirSayisiC + yorumSatirSayisiC + kodSatirSayisiC + boslukSatirSayisiC;
        double 
        YG_C = ((javadocSatirSayisiC + yorumSatirSayisiC) * 0.8) / fonksiyonSayisiC;
        double YH_C = 
        		(kodSatirSayisiC / fonksiyonSayisiC) * 0.3;
        double yorumSapmaYuzdesiC = 
        		((100 * YG_C)) / YH_C - 100;

        System.out.println("Sınıf: " + "C.java");
        System.out.println("Javadoc Satır Sayısı: " + javadocSatirSayisiC);
        System.out.println("Yorum Satır Sayısı: " + yorumSatirSayisiC);
        System.out.println("Kod Satır Sayısı: " + kodSatirSayisiC);
        System.out.println("LOC: " + LOC_C);
        System.out.println("Fonksiyon Sayısı: " + fonksiyonSayisiC);
        System.out.printf("Yorum Sapma Yüzdesi: %.2f%%", yorumSapmaYuzdesiC);
    }
}
