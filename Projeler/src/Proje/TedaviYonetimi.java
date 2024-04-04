package Proje;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TedaviYonetimi, ITedaviYonetimi arabirimini uygulayan bir sınıftır.
 */

public class TedaviYonetimi implements ITedaviYonetimi {
	
        // Diş sağlığı kayıtlarını tutacak olan Map
        private Map<Integer, Map<String, Object>> disSagligiKayitlari = new HashMap<>();
        // Tedavi planlarını tutacak olan Map
	    private Map<Integer, String> tedaviPlanlari;
	    // Tedavi geçmişini tutacak olan Map
	    private Map<Integer, List<String>> tedaviGecmisi;
	    // Tedavi belgelerini tutacak olan Map
	    private Map<Integer, List<String>> tedaviBelgeleri;
	    // Tedavi notlarını tutacak olan Map
	    private Map<Integer, List<String>> tedaviNotlari;
	    // Tedavi adımlarını tutacak olan Map
	    private Map<Integer, List<String>> tedaviAdimlari = new HashMap<>();

	    // Kurucu method
	    public TedaviYonetimi()
	    {
	        this.disSagligiKayitlari = new HashMap<>();
	        this.tedaviPlanlari = new HashMap<>();
	        this.tedaviGecmisi = new HashMap<>();
	        this.tedaviBelgeleri = new HashMap<>();
	        this.tedaviNotlari = new HashMap<>();
	    }

	    /**
	     * Hasta için yeni bir diş sağlığı kaydı oluşturur.
	     * 
	     * @param hastaId Hasta kimliği
	     * @param bilgi Diş sağlığı bilgileri
	     * @param olusturmaTarihi Kaydın oluşturulduğu tarih
         * @param kaydedenKullanici Kaydı oluşturan kullanıcı
	     */
	    @Override
	    public void disSagligiKaydiOlustur(int hastaId, String bilgi, LocalDateTime olusturmaTarihi, String kaydedenKullanici) {
	        // Diş sağlığı kaydını oluştururken ek özelliklerle birlikte kaydedebiliriz
	        Map<String, Object> disSagligiKaydi = new HashMap<>();
	        disSagligiKaydi.put("bilgi", bilgi);
	        disSagligiKaydi.put("olusturmaTarihi", olusturmaTarihi);
	        disSagligiKaydi.put("kaydedenKullanici", kaydedenKullanici);
	        
	        disSagligiKayitlari.put(hastaId, disSagligiKaydi);
	        System.out.println("Hasta için diş sağlığı kaydı oluşturuldu.");
	    }
	    
	    /**
	     * Belirli bir hastanın diş sağlığı bilgilerini getirir.
	     * 
	     * @param hastaId Hasta kimliği
	     * @return Diş sağlığı bilgileri
	     */
	    @Override
	    public String disSagligiBilgisiGetir(int hastaId) {
	    	// Diş sağlığı kaydı eklemek için
	        Map<String, Object> hastaBilgileri = disSagligiKayitlari.get(hastaId);
	        if (hastaBilgileri != null) 
	        {
	        	// Diş sağlığı bilgisini getirmek için

	            Object bilgi = hastaBilgileri.get("disSagligiBilgisi");
	            if (bilgi instanceof String) 
	            {
	                return (String) bilgi;
	            }
	        }
	        return "Bu hasta için diş sağlığı kaydı bulunamadı.";
	    }

	    /**
	     * Hasta için yeni bir tedavi planı oluşturur veya mevcut planı günceller.
	     * 
	     * @param hastaId Hasta kimliği
	     * @param plan Yeni tedavi planı
	     */
	    
	    @Override
	    public void tedaviPlaniOlustur(int hastaId, String plan) {
	        // Tedavi planını hasta kimliğiyle eşleştirerek kaydediyoruz
	        tedaviPlanlari.put(hastaId, plan);
	        // Kullanıcıya bilgi vermek için bir mesaj yazdırıyoruz
	        System.out.println("Hasta için yeni tedavi planı oluşturuldu.");
	    }

	    /**
	     * Belirli bir hastanın tedavi planını günceller.
	     * 
	     * @param hastaId Hasta kimliği
	     * @param yeniPlan Güncellenmiş tedavi planı
	     */
	    
	    @Override
	    public void tedaviPlaniGuncelle(int hastaId, String yeniPlan) {
	        // Hasta kimliğiyle ilişkilendirilmiş olan mevcut tedavi planını güncelliyoruz
	        tedaviPlanlari.put(hastaId, yeniPlan);
	        // Kullanıcıya güncelleme hakkında bilgi vermek için bir mesaj yazdırıyoruz
	        System.out.println("Hasta için tedavi planı güncellendi.");
	    }

	    /**
	     * Hasta için tedavi geçmişini kaydeder.
	     * 
	     * @param hastaId Hasta kimliği
	     * @param gecmis Tedavi geçmişi
	     */
	    
	    @Override
	    public void tedaviGecmisiKaydet(int hastaId, List<String> gecmis) {
	        // Hasta kimliğiyle ilişkilendirilmiş olan tedavi geçmişini kaydediyoruz
	        tedaviGecmisi.put(hastaId, gecmis);
	        // Kullanıcıya işlemin başarıyla gerçekleştirildiğine dair bir mesaj yazdırıyoruz
	        System.out.println("Hasta için tedavi geçmişi kaydedildi.");
	    }

	    public void tedaviAdimiEkle(int hastaId, String adim) {
	        // Eğer hasta için henüz bir tedavi adımı listesi oluşturulmamışsa, yeni bir liste oluşturur
	        if (!tedaviAdimlari.containsKey(hastaId)) 
	        {
	            tedaviAdimlari.put(hastaId, new ArrayList<>());
	        }
	        // Hasta için tedavi adımları listesine yeni adımı ekler
	        tedaviAdimlari.get(hastaId).add(adim);
	        // Kullanıcıya işlemin başarıyla gerçekleştirildiğine dair bir mesaj yazdırır
	        System.out.println("Hasta için yeni tedavi adımı eklendi.");
	    }

	    /**
	     * Belirli bir hastanın tedavi geçmişini getirir.
	     * 
	     * @param hastaId Hasta kimliği
	     * @return Tedavi geçmişi
	     */
	    
	    public List<String> tedaviGecmisiGetir(int hastaId) {
	        // Geri dönecek olan tedavi geçmişi bilgilerini tutacak liste
	        List<String> gecmisBilgileri = new ArrayList<>();
	        // Hastaya ait tedavi geçmişini ve adımlarını alır, eğer bulunamazsa boş listeler oluşturur
	        List<String> gecmis = tedaviGecmisi.getOrDefault(hastaId, new ArrayList<>());
	        List<String> adimlar = tedaviAdimlari.getOrDefault(hastaId, new ArrayList<>());

	        // Eğer hastanın bir tedavi geçmişi varsa
	        if (!gecmis.isEmpty()) 
	        {
	            // "Tedavi Geçmişi:" başlığıyla birlikte her bir geçmiş adımını listeye ekler
	            gecmisBilgileri.add("Tedavi Geçmişi:");
	            for (String gecmisAdim : gecmis) 
	            {
	                gecmisBilgileri.add(gecmisAdim);
	            }
	        }
            // Eğer hastanın tedavi geçmişi yoksa, uygun bir mesaj ekler
	        else 
	        {
	            gecmisBilgileri.add("Bu hasta için tedavi geçmişi bulunamadı.");
	        }
	        // Eğer hastanın bir tedavi adımı varsa
	        if (!adimlar.isEmpty()) 
	        {
	            // "Tedavi Adımları:" başlığıyla birlikte her bir adımı listeye ekler
	            gecmisBilgileri.add("Tedavi Adımları:");
	            for (String adim : adimlar) 
	            {
	                gecmisBilgileri.add(adim);
	            }
	        }
            // Eğer hastanın tedavi adımı yoksa, uygun bir mesaj ekler
	        else 
	        {
	            gecmisBilgileri.add("Bu hasta için tedavi adımı bulunamadı.");
	        }
	        // Oluşturulan bilgiler listesini geri döndürür
	        return gecmisBilgileri;
	    }

	    /**
	     * Hasta için tedavi süreçlerini belgelerle destekler.
	     * 
	     * @param hastaId Hasta kimliği
	     * @param belgeler Tedavi belgeleri
	     */
	    
	    @Override
	    public void tedaviBelgeleriKaydet(int hastaId, List<String> belgeler) {
	        tedaviBelgeleri.put(hastaId, belgeler);
	        System.out.println("Hasta için tedavi belgeleri kaydedildi.");
	    }

	    /**
	     * Hasta için tedaviye ilişkin notlar ve ilaç reçetelerini kaydeder.
	     * 
	     * @param hastaId Hasta kimliği
	     * @param notlar Notlar ve ilaç reçeteleri
	     */
	    
	    @Override
	    public void tedaviNotlariKaydet(int hastaId, String yeniNot) {
	        if (tedaviNotlari.containsKey(hastaId)) 
	        {
	            // Eğer hastanın notları zaten varsa, mevcut notların sonuna yeni notu ekleyelim
	            List<String> mevcutNotlar = tedaviNotlari.get(hastaId);
	            mevcutNotlar.add(yeniNot);
	            tedaviNotlari.put(hastaId, mevcutNotlar);
	        }
	        else 
	        {
	            // Eğer hastanın notları yoksa, yeni notları direkt olarak kaydedelim
	            tedaviNotlari.put(hastaId, List.of(yeniNot));
	        }
	        System.out.println("Hasta için yeni tedavi notu kaydedildi.");
	    }

	    /**
	     * Belirli bir hastanın tedavi notlarını ve ilaç reçetelerini getirir.
	     * 
	     * @param hastaId Hasta kimliği
	     * @return Notlar ve ilaç reçeteleri
	     */
	    
	    @Override
	    public List<String> tedaviNotlariGetir(int hastaId) {
	        List<String> hastaNotlari = tedaviNotlari.getOrDefault(hastaId, new ArrayList<>());
	        if (hastaNotlari.isEmpty()) 
	        {
	            System.out.println("Hasta için tedavi notu bulunamadı.");
	        }
	        return hastaNotlari;
	    }	
}
