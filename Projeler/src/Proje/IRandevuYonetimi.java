package Proje;

import java.time.LocalDateTime;

public interface IRandevuYonetimi {
	void randevuAl(String ad, String soyad, String telefon, LocalDateTime tarih);
    void randevuIptalEt(int randevuNo);
    void randevuListesi();
    void randevuGuncelle(int randevuNo, LocalDateTime yeniTarih);
    void randevuBilgisiGoster(int randevuNo);
    void randevuGecmisListesi(String hastaAdi);
    void randevuAra(String hastaAdi);
    void enErkenRandevuyuBul();
    void enGecRandevuyuBul();
}
