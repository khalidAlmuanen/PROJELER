package Proje;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * RandevuYonetimi sınıfı, randevuları yönetmek için gerekli işlevleri sağlar.
 * 
 * @author Khalid ALmuanen
 */
public class RandevuYonetimi implements IRandevuYonetimi {

    private List<String> randevuListesi = new ArrayList<>();
    private int sonRandevuNumarasi = 0;

    /**
     * Randevu alındığında yapılacak işlemler burada gerçekleştirilir.
     * 
     * @param ad      Randevu almak isteyen hasta adı
     * @param soyad   Randevu almak isteyen hasta soyadı
     * @param telefon Hastanın telefon numarası
     * @param tarih   Hasta aldığı randevu tarihi
     */
    @Override
    public void randevuAl(String ad, String soyad, String telefon, LocalDateTime tarih) {
        String randevu = ad + " " + soyad + " " + telefon + " " + tarih.toString();
        randevuListesi.add(randevu);
        System.out.println("Randevu başarıyla alındı. Randevu numarası: " + (++sonRandevuNumarasi));
    }

    /**
     * Belirtilen randevu numarasına sahip randevuyu iptal eder.
     * 
     * @param randevuNo İptal edilecek randevunun numarası
     * @throws IllegalArgumentException Geçersiz randevu numarası girildiğinde fırlatılır
     */
    @Override
    public void randevuIptalEt(int randevuNo) {
        if (randevuNo <= 0 || randevuNo > randevuListesi.size()) {
            System.out.println("Geçersiz randevu numarası!");
        } else {
            randevuListesi.remove(randevuNo - 1);
            System.out.println("Randevu başarıyla iptal edildi.");
        }
    }

    /**
     * Mevcut randevu listesini konsola yazdırır.
     */
    @Override
    public void randevuListesi() {
        System.out.println("Tüm randevular:");
        for (int i = 0; i < randevuListesi.size(); i++) {
            System.out.println((i + 1) + ". " + randevuListesi.get(i));
        }
    }

    /**
     * Belirtilen randevu numarasına sahip randevunun tarihini günceller.
     * 
     * @param randevuNo Güncellenecek randevunun numarası
     * @param yeniTarih Randevunun güncellenecek yeni tarihi
     */
    @Override
    public void randevuGuncelle(int randevuNo, LocalDateTime yeniTarih) {
        if (randevuNo <= 0 || randevuNo > randevuListesi.size()) {
            System.out.println("Geçersiz randevu numarası!");
        } else {
            String randevu = randevuListesi.get(randevuNo - 1);
            randevu = randevu.substring(0, randevu.lastIndexOf(' ') + 1) + yeniTarih.toString();
            randevuListesi.set(randevuNo - 1, randevu);
            System.out.println("Randevu başarıyla güncellendi.");
        }
    }

    /**
     * Belirtilen hasta adına sahip hastanın randevularını arar ve ekrana yazdırır.
     * 
     * @param hastaAdi Aranacak hastanın adı
     */
    @Override
    public void randevuAra(String hastaAdi) {
        System.out.println(hastaAdi + " adlı hastanın randevuları:");
        for (String randevu : randevuListesi) {
            if (randevu.startsWith(hastaAdi + " ")) {
                System.out.println(randevu);
            }
        }
    }

    /**
     * En erken randevuyu bulur ve ekrana yazdırır.
     */
    @Override
    public void enErkenRandevuyuBul() {
        if (randevuListesi.isEmpty()) {
            System.out.println("Randevu bulunamadı. Liste boş.");
            return;
        }
        String enErkenRandevu = randevuListesi.get(0);
        LocalDateTime enErkenTarih = LocalDateTime.parse(enErkenRandevu.substring(enErkenRandevu.lastIndexOf(' ') + 1));
        for (String randevu : randevuListesi) {
            LocalDateTime tarih = LocalDateTime.parse(randevu.substring(randevu.lastIndexOf(' ') + 1));
            if (tarih.isBefore(enErkenTarih)) {
                enErkenTarih = tarih;
                enErkenRandevu = randevu;
            }
        }
        System.out.println("En erken randevu: " + enErkenRandevu);
    }

    /**
     * En geç randevuyu bulur ve ekrana yazdırır.
     */
    @Override
    public void enGecRandevuyuBul() {
        if (randevuListesi.isEmpty()) {
            System.out.println("Randevu bulunamadı. Liste boş.");
            return;
        }
        String enGecRandevu = randevuListesi.get(0);
        LocalDateTime enGecTarih = LocalDateTime.parse(enGecRandevu.substring(enGecRandevu.lastIndexOf(' ') + 1));
        for (String randevu : randevuListesi) {
            LocalDateTime tarih = LocalDateTime.parse(randevu.substring(randevu.lastIndexOf(' ') + 1));
            if (tarih.isAfter(enGecTarih)) {
                enGecTarih = tarih;
                enGecRandevu = randevu;
            }
        }
        System.out.println("En geç randevu: " + enGecRandevu);
    }

    /**
     * Toplam randevu sayısını döndürür.
     * 
     * @return Toplam randevu sayısı
     */
    public int toplamRandevuSayisi() {
        return randevuListesi.size();
    }

	@Override
	public void randevuBilgisiGoster(int randevuNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void randevuGecmisListesi(String hastaAdi) {
		// TODO Auto-generated method stub
		
	}
}

