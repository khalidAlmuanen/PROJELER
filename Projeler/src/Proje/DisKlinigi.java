package Proje;

import java.time.LocalDateTime;

/**
 * 
 * @author Khalid ALmuanen
 *
 */
public class DisKlinigi {
	/**
	 * <p>
	 *   Diş kilinik'te RandevuYonetimi 
	 * </p>
	 * @param hastaAdi Randevu almak isteyen hasta adı
	 * @param hastaSoyadi Randevu almak isteyen hasta soyadı
	 * @param randevuTarihi Hasta aldığı randevu tarihi
     * @param doktorAdi Hasta aldığı randevu tarihi
     * @param randevuId Hastaya ait randevuId
     * @param yeniTarih Hasta aldığı yeni tarih
     * @param reddetmeNedeni randevuyu raddetme nedeni
     * @param acilTarih en yakın zamanda alınabilecek randevu
     * @param randevuTarihi Hasta aldığı randevu tarihi
     * @param randevuTarihi Hasta aldığı randevu tarihi
	 * @return Para çekme işleminin başarılımı geçtiğini döndürür.
	 */
	
	public class RandevuYonetimi  {

	    public void randevuAl(String hastaAdi, String hastaSoyadi, LocalDateTime randevuTarihi, String doktorAdi , int randevuId) {
	        // Randevu alındığında yapılacak işlemler burada gerçekleştirilir
	        
	        System.out.println("Hasta Adı: " + hastaAdi);
	        System.out.println("Hasta Soyadı: " + hastaSoyadi);
	        System.out.println("Randevu Tarihi: " + randevuTarihi);
	        System.out.println("Doktor Adı: " + doktorAdi);
	        System.out.println("Randevu alındı:");
	      }
  
	    public void randevuIptalEt(int randevuId) {
        // Veritabanından randevuyu iptal etme işlemleri burada gerçekleştirilir
          }
	
	    public void randevuYenidenPlanla(int randevuId, LocalDateTime yeniTarih) {
            // Randevuyu yeni bir tarihe yeniden planlama işlemleri burada gerçekleştirilir
           }
	    
	    public void randevuOnayla(int randevuId) {
        // Randevuyu onaylama işlemleri burada gerçekleştirilir
         }
	    
	    public void randevuReddet(int randevuId, String reddetmeNedeni) {
	        // Randevuyu reddetme işlemleri burada gerçekleştirilir
	      }
	    
	    public void oncelikliRandevuTalebi(Hasta hasta, LocalDateTime acilTarih) {
	        // Acil durum için öncelikli randevu talebi oluşturma işlemleri burada gerçekleştirilir
	      }
	    
	    public void randevuHatirlatmaVeDogrulama(Hasta hasta, LocalDateTime randevuTarihi) {
	        // Hastaya hatırlatma ve doğrulama mesajları gönderme işlemleri burada gerçekleştirilir
	      }
	 
	    public void randevuDurumunuGuncelle(int randevuId, String yeniDurum) {
	        // Randevunun durumunu güncelleme işlemleri burada gerçekleştirilir
	      }
	    
	    public void gecmisRandevulariGoruntule(Hasta hasta) {
	        // Hastanın geçmiş randevularını görüntüleme işlemleri burada gerçekleştirilir
	     }
	    
	    public void gecmisRandevulariGoruntule(Doktor doktor) {
	        // Doktorun geçmiş randevularını görüntüleme işlemleri burada gerçekleştirilir
	      }
	 
  }
}