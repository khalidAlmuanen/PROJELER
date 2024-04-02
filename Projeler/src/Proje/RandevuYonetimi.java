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
	private List<Randevu> randevuListesi = new ArrayList<>();
	private int sonRandevuNumarasi = 0;
	
 
    @Override
    public void randevuAl(String ad, String soyad, String telefon, LocalDateTime tarih) {
        Randevu randevu = new Randevu(ad, soyad, telefon, tarih);
        randevuListesi.add(randevu);
        System.out.println("Randevu başarıyla alındı. Randevu numarası: " + (++sonRandevuNumarasi));
    }

    @Override
    public void randevuIptalEt(int randevuNo) {
        if (randevuNo <= 0 || randevuNo > randevuListesi.size()) {
            System.out.println("Geçersiz randevu numarası!");
        } else {
            randevuListesi.remove(randevuNo - 1);
            System.out.println("Randevu başarıyla iptal edildi.");
        }
    }

    @Override
    public void randevuListesi() {
        System.out.println("Tüm randevular:");
        for (int i = 0; i < randevuListesi.size(); i++) {
            System.out.println((i + 1) + ". " + randevuListesi.get(i));
        }
    }

    @Override
    public void randevuGuncelle(int randevuNo, LocalDateTime yeniTarih) {
        if (randevuNo <= 0 || randevuNo > randevuListesi.size()) {
            System.out.println("Geçersiz randevu numarası!");
        } else {
            randevuListesi.get(randevuNo - 1).setTarih(yeniTarih);
            System.out.println("Randevu başarıyla güncellendi.");
        }
    }

    @Override
    public void randevuBilgisiGoster(int randevuNo) {
        if (randevuNo <= 0 || randevuNo > randevuListesi.size()) {
            System.out.println("Geçersiz randevu numarası!");
        } else {
            System.out.println("Randevu Bilgisi: " + randevuListesi.get(randevuNo - 1));
        }
    }

    @Override
    public void randevuGecmisListesi(String hastaAdi) {
        System.out.println(hastaAdi + " için geçmiş randevular:");
        for (Randevu randevu : randevuListesi) {
            if (randevu.getAd().equals(hastaAdi)) {
                System.out.println(randevu);
            }
        }
    }
   
    @Override
    public void randevuAra(String hastaAdi) {
        System.out.println(hastaAdi + " adlı hastanın randevuları:");
        for (Randevu randevu : randevuListesi) {
            if (randevu.getAd().equalsIgnoreCase(hastaAdi)) {
                System.out.println(randevu);
            }
        }
    }

    @Override
    public void enErkenRandevuyuBul() {
        if (randevuListesi.isEmpty()) {
            System.out.println("Randevu bulunamadı. Liste boş.");
            return;
        }
        Randevu enErkenRandevu = randevuListesi.get(0);
        for (Randevu randevu : randevuListesi) {
            if (randevu.getTarih().isBefore(enErkenRandevu.getTarih())) {
                enErkenRandevu = randevu;
            }
        }
        System.out.println("En erken randevu: " + enErkenRandevu);
    }

    @Override
    public void enGecRandevuyuBul() {
        if (randevuListesi.isEmpty()) {
            System.out.println("Randevu bulunamadı. Liste boş.");
            return;
        }
        Randevu enGecRandevu = randevuListesi.get(0);
        for (Randevu randevu : randevuListesi) {
            if (randevu.getTarih().isAfter(enGecRandevu.getTarih())) {
                enGecRandevu = randevu;
            }
        }
        System.out.println("En geç randevu: " + enGecRandevu);
    }
    public String toplamRandevuSayisi() {
        return "toplam randevu sayisi: " + randevuListesi.size();
    }
	
}


