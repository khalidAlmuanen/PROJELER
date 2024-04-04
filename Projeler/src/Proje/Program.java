package Proje;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
   
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
        LocalDateTime now = LocalDateTime.now(); // Şu anki tarihi ve saati alır

	
	 RandevuYonetimi r = new RandevuYonetimi();
	
	// r.randevuAl("Khalid", "Ali", "881827", now);
	//r.randevuAl("Umut", "Ahmet", "88929", now);
	 //r.randevuAl("Nezar", "Yildirim", "38272", now);
	 /* r.randevuBilgisiGoster(2);
	 r.randevuGecmisListesi("Khalid");
	 r.randevuIptalEt(2);*/
	 //System.out.println(r.toplamRandevuSayisi());
	/* TedaviYonetimi t = new TedaviYonetimi();
	 t.disSagligiKaydiOlustur(1, "Düzenli diş fırçalama yapılmalıdır.", LocalDateTime.now(), "Admin");
	 t.disSagligiKaydiOlustur(2, "Düzenli diş fırçalama yapılmalıdır.", LocalDateTime.now(), "Admin");
	 t.disSagligiKaydiOlustur(3, "Düzenli diş fırçalama yapılmalıdır.", LocalDateTime.now(), "Admin");
	 t.disSagligiKaydiOlustur(4, "Düzenli diş fırçalama yapılmalıdır.", LocalDateTime.now(), "Admin");

	 String bilgi = t1.disSagligiBilgisiGetir(1);
	 System.out.println("Hasta 1 için diş sağlığı bilgisi: \"" + bilgi + "\""); */
	 
	 
	 
	 String dosyaYolu = "https://raw.githubusercontent.com/khalidAlmuanen/PROJELER/master/Projeler/src/Proje/TedaviYonetimi.java";
     int javadocSatirSayisi = 0;
     int yorumSatirSayisi = 0;
     int kodSatirSayisi = 0;
     int fonksiyonSayisi = 0;
 
     try {
         URL url = new URL(dosyaYolu);
         BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
         String satir;
         
	        
         while ((satir = reader.readLine()) != null) {
             satir = satir.trim();
 	        boolean javadocModu = false;

 	       if (satir.contains("*") && (!satir.equals("/**")  && !satir.equals("*/"))) {
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
     double YG = ((javadocSatirSayisi + yorumSatirSayisi)*0.8)/fonksiyonSayisi;
     double YH = (kodSatirSayisi/fonksiyonSayisi)*0.3;
     double yorumSapmaYuzdesi =  ((100*YG))/YH-100;

     System.out.println("Sınıf: " + "A.java");
     System.out.println("Javadoc Satır Sayısı: " + javadocSatirSayisi);
     System.out.println("Yorum Satır Sayısı: " + yorumSatirSayisi);
     System.out.println("Kod Satır Sayısı: " + kodSatirSayisi);
     System.out.println("LOC: " + LOC);
     System.out.println("Fonksiyon Sayısı: " + fonksiyonSayisi);
     System.out.printf("Yorum Sapma Yüzdesi: %.2f%%\n", yorumSapmaYuzdesi);
 } 

}
	

