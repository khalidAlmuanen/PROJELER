package Proje;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ITedaviYonetimi {
	
	void disSagligiKaydiOlustur(int hastaId, String bilgi, LocalDateTime olusturmaTarihi, String kaydedenKullanici);

    
    String disSagligiBilgisiGetir(int hastaId);

    
	void tedaviPlaniOlustur(int hastaId, String plan);

    
    void tedaviPlaniGuncelle(int hastaId, String yeniPlan);

    
    void tedaviGecmisiKaydet(int hastaId, List<String> gecmis);

    
    List<String> tedaviGecmisiGetir(int hastaId);

    
    void tedaviBelgeleriKaydet(int hastaId, List<String> belgeler);
    
    void tedaviNotlariKaydet(int hastaId, String yeniNot);

    List<String> tedaviNotlariGetir(int hastaId);



}



