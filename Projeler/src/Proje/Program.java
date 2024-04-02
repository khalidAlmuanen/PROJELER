package Proje;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
   
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
        LocalDateTime now = LocalDateTime.now(); // Şu anki tarihi ve saati alır

	
	 RandevuYonetimi r = new RandevuYonetimi();
	
	 r.randevuAl("Khalid", "Ali", "881827", now);
	 r.randevuAl("Umut", "Ahmet", "88929", now);
	 r.randevuAl("Nezar", "Yildirim", "38272", now);
	 /* r.randevuBilgisiGoster(2);
	 r.randevuGecmisListesi("Khalid");
	 r.randevuIptalEt(2);*/
	 System.out.println(r.toplamRandevuSayisi());
	 
	 
	 String dosyaYolu = "A.java";
     int javadocSatirSayisi = 0;
     int yorumSatirSayisi = 0;
     int kodSatirSayisi = 0;
     int fonksiyonSayisi = 0;

     try {
         BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu));
         String satir;

         while ((satir = reader.readLine()) != null) {
             satir = satir.trim();
             if (satir.startsWith("/**") || satir.startsWith("*")) {
                 javadocSatirSayisi++;
             } else if (satir.startsWith("//")) {
                 yorumSatirSayisi++;
             } else if (!satir.isEmpty()) {
                 kodSatirSayisi++;
             }

             if (satir.contains("(") && satir.contains(")") && satir.endsWith("{")) {
                 fonksiyonSayisi++;
             }
         }

         reader.close();
     } catch (IOException e) {
         e.printStackTrace();
     }

     int LOC = javadocSatirSayisi + yorumSatirSayisi + kodSatirSayisi;
     double yorumSapmaYuzdesi = ((double) yorumSatirSayisi / LOC) * 100;

     System.out.println("Sınıf: " + dosyaYolu);
     System.out.println("Javadoc Satır Sayısı: " + javadocSatirSayisi);
     System.out.println("Yorum Satır Sayısı: " + yorumSatirSayisi);
     System.out.println("Kod Satır Sayısı: " + kodSatirSayisi);
     System.out.println("LOC: " + LOC);
     System.out.println("Fonksiyon Sayısı: " + fonksiyonSayisi);
     System.out.printf("Yorum Sapma Yüzdesi: %.2f%%\n", yorumSapmaYuzdesi);
   }
}
	

