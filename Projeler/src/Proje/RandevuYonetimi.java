package Proje;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Khalid ALmuanen
 *
 */
public class RandevuYonetimi implements IRandevuYonetimi  {
	/**
	 * <p>
	 *   Diş kilinik'te RandevuYonetimi 
	 * </p>
	 * @param ad Randevu almak isteyen hasta adı
	 * @param Soyad Randevu almak isteyen hasta soyadı
	 * @param telefon Hastanın telefon numarası
     * @param tarih Hasta aldığı randevu tarihi
	 */
	private List<String> randevuListesi = new ArrayList<>(); private int sonRandevuNumarasi = 0;
	
    @Override
    public void randevuAl(String ad, String soyad, String telefon, LocalDateTime tarih) {
	     // Randevu alındığında yapılacak işlemler burada gerçekleştirilir 
        /**
    	* @param randevu Hasta aldığı randevu 
         */
    	String randevu = ad + " " + soyad + " " + telefon + " " + tarih.toString(); randevuListesi.add(randevu);
        System.out.println("Randevu başarıyla alındı. Randevu numarası: " + (++sonRandevuNumarasi)); }

    @Override
    public void randevuIptalEt(int randevuNo) {
	     // randevuyu iptal etme işlemleri burada gerçekleştirilir
    	/**
    	* @param randevuNo Hastaya ait randevu no 
    	* @throws IllegalArgumentException Geçersiz randevu numarası girildiğinde fırlatılır
         */
    	if (randevuNo <= 0 || randevuNo > randevuListesi.size()) { System.out.println("Geçersiz randevu numarası!"); } 
    	else { randevuListesi.remove(randevuNo - 1); System.out.println("Randevu başarıyla iptal edildi."); } }
    /**
     * Mevcut randevu listesini konsola yazdırır.
     */
    @Override
    public void randevuListesi() {
    	 // randevuları listeleyen fonksiyon.	 
        System.out.println("Tüm randevular:");
        for (int i = 0; i < randevuListesi.size(); i++) 
        { System.out.println((i + 1) + ". " + randevuListesi.get(i)); } }
    /**
     * Belirtilen randevu numarasına sahip randevunun tarihini günceller.
     * Eğer belirtilen randevu numarası mevcut değilse veya geçersiz ise bir hata mesajı yazdırır.
     *
     * @param randevuNo Güncellenecek randevunun numarası
     * @param yeniTarih Randevunun güncellenecek yeni tarihi
     */
    @Override
    public void randevuGuncelle(int randevuNo, LocalDateTime yeniTarih) {   	
    	// randevuları gunceleyen fonksiyon.
    	if (randevuNo <= 0 || randevuNo > randevuListesi.size()) 
    	{  System.out.println("Geçersiz randevu numarası!"); }
    	else { String randevu = randevuListesi.get(randevuNo - 1);randevu = randevu.substring(0, randevu.lastIndexOf(' ') + 1) + yeniTarih.toString(); randevuListesi.set(randevuNo - 1, randevu); System.out.println("Randevu başarıyla güncellendi."); } }
    
    @Override
    public void randevuBilgisiGoster(int randevuNo) {   	
    	 // randevunun bilgileri gosteren fonksiyon.  	
        if (randevuNo <= 0 || randevuNo > randevuListesi.size()) 
        { System.out.println("Geçersiz randevu numarası!"); }  else { System.out.println("Randevu Bilgisi: " + randevuListesi.get(randevuNo - 1)); } }

    @Override
    public void randevuGecmisListesi(String hastaAdi) {	 
    	// randevu gecmis listeleyen fonksiyon. 	 
    	/**
    	*  Daha önce hasta aldığı randevular göster 
         */
    	System.out.println(hastaAdi + " için geçmiş randevular:");
        for (String randevu : randevuListesi) 
        { String[] randevuBilgileri = randevu.split(" "); if (randevuBilgileri[0].equals(hastaAdi)) { System.out.println(randevu);  } } }
    /**
     * Belirtilen hasta adına sahip hastanın randevularını arar ve ekrana yazdırır.
     * @param hastaAdi Aranacak hastanın adı
     */
    @Override
    public void randevuAra(String hastaAdi) { 	
    	 // randevuyu arayan fonksiyon.	 
    	 System.out.println(hastaAdi + " adlı hastanın randevuları:"); for (String randevu : randevuListesi) 
         { if (randevu.startsWith(hastaAdi + " ")) { System.out.println(randevu); } } }
    
    @Override
    public void enErkenRandevuyuBul() {  	  
    	 // en erken randevuyu bulan fonksiyon.
    	/**
    	* en erken randevu alan hastayı bulun 
         */   	 
    	if (randevuListesi.isEmpty()) 
    	{ System.out.println("Randevu bulunamadı. Liste boş."); return; } String enErkenRandevu = randevuListesi.get(0); LocalDateTime enErkenTarih = LocalDateTime.parse(enErkenRandevu.substring(enErkenRandevu.lastIndexOf(' ') + 1)); for (String randevu : randevuListesi) 
        { LocalDateTime tarih = LocalDateTime.parse(randevu.substring(randevu.lastIndexOf(' ') + 1)); if (tarih.isBefore(enErkenTarih)) { enErkenTarih = tarih;enErkenRandevu = randevu;}} System.out.println("En erken randevu: " + enErkenRandevu);}

    @Override
    public void enGecRandevuyuBul() {    	
    	 // en gec randevuyu bulan fonksiyon.
    	/**
    	* en geç randevu alan hastayı bulun 
         */
    	if (randevuListesi.isEmpty()) 
    	{ System.out.println("Randevu bulunamadı. Liste boş."); return; }
        String enGecRandevu = randevuListesi.get(0); LocalDateTime enGecTarih = LocalDateTime.parse(enGecRandevu.substring(enGecRandevu.lastIndexOf(' ') + 1)); for (String randevu : randevuListesi) 
        { LocalDateTime tarih = LocalDateTime.parse(randevu.substring(randevu.lastIndexOf(' ') + 1)); if (tarih.isAfter(enGecTarih))
            { enGecTarih = tarih; enGecRandevu = randevu; } } System.out.println("En geç randevu: " + enGecRandevu);}
    
    public String toplamRandevuSayisi() {
   	     // toplam Randevu Sayisi bulan fonksiyon.
    	/**
    	*  randevu alan toplam hasta sayısını bulun 
         */	
        return "toplam randevu sayisi: " + randevuListesi.size(); }	
}


