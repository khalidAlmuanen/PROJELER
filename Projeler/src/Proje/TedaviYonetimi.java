package Proje;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TedaviYonetimi , TedaviYonetimi arabirimini uygulayan bir sınıftır.
 */

public class TedaviYonetimi implements ITedaviYonetimi {
	
    private Map<Integer, Map<String, Object>> disSagligiKayitlari = new HashMap<>();
    
	    private Map<Integer, String> tedaviPlanlari;
	    private Map<Integer, List<String>> tedaviGecmisi;
	    private Map<Integer, List<String>> tedaviBelgeleri;
	    private Map<Integer, List<String>> tedaviNotlari;
	    private Map<Integer, List<String>> tedaviAdimlari = new HashMap<>();

	    
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
	        tedaviPlanlari.put(hastaId, plan);
	        System.out.println("Hasta için yeni tedavi planı oluşturuldu.");
	    }

	    /**
	     * Belirli bir hastanın tedavi planını günceller.
	     * 
	     * @param hastaId Hasta kimliği
	     * @param yeniPlan Güncellenmiş tedavi planı
	     */
	    
	    @Override
	    public void tedaviPlaniGuncelle(int hastaId, String yeniPlan)
	    {
	        tedaviPlanlari.put(hastaId, yeniPlan);
	        System.out.println("Hasta için tedavi planı güncellendi.");
	    }

	    /**
	     * Hasta için tedavi geçmişini kaydeder.
	     * 
	     * @param hastaId Hasta kimliği
	     * @param gecmis Tedavi geçmişi
	     */
	    
	    @Override
	    public void tedaviGecmisiKaydet(int hastaId, List<String> gecmis) 
	    {
	        tedaviGecmisi.put(hastaId, gecmis);
	        System.out.println("Hasta için tedavi geçmişi kaydedildi.");
	    }

	    public void tedaviAdimiEkle(int hastaId, String adim) 
	    {
	        if (!tedaviAdimlari.containsKey(hastaId)) 
	        {
	            tedaviAdimlari.put(hastaId, new ArrayList<>());
	        }
	        
	        tedaviAdimlari.get(hastaId).add(adim);
	        System.out.println("Hasta için yeni tedavi adımı eklendi.");
	    }

	    /**
	     * Belirli bir hastanın tedavi geçmişini getirir.
	     * 
	     * @param hastaId Hasta kimliği
	     * @return Tedavi geçmişi
	     */
	    
	    public List<String> tedaviGecmisiGetir(int hastaId) 
	    {
	        List<String> gecmisBilgileri = new ArrayList<>();
	        List<String> gecmis = tedaviGecmisi.getOrDefault(hastaId, new ArrayList<>());
	        List<String> adimlar = tedaviAdimlari.getOrDefault(hastaId, new ArrayList<>());

	        if (!gecmis.isEmpty()) 
	        {
	            gecmisBilgileri.add("Tedavi Geçmişi:");
	            for (String gecmisAdim : gecmis) 
	            {
	                gecmisBilgileri.add(gecmisAdim);
	            }
	        }
	        
	        else 
	        {
	            gecmisBilgileri.add("Bu hasta için tedavi geçmişi bulunamadı.");
	        }

	        if (!adimlar.isEmpty()) 
	        {
	            gecmisBilgileri.add("Tedavi Adımları:");
	            for (String adim : adimlar) 
	            {
	                gecmisBilgileri.add(adim);
	            }
	        }
	        
	        else 
	        {
	            gecmisBilgileri.add("Bu hasta için tedavi adımı bulunamadı.");
	        }

	        return gecmisBilgileri;
	    }

	    /**
	     * Hasta için tedavi süreçlerini belgelerle destekler.
	     * 
	     * @param hastaId Hasta kimliği
	     * @param belgeler Tedavi belgeleri
	     */
	    
	    @Override
	    public void tedaviBelgeleriKaydet(int hastaId, List<String> belgeler) 
	    {
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
	    public void tedaviNotlariKaydet(int hastaId, String yeniNot) 
	    {
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
	    public List<String> tedaviNotlariGetir(int hastaId) 
	    {
	        List<String> hastaNotlari = tedaviNotlari.getOrDefault(hastaId, new ArrayList<>());
	        if (hastaNotlari.isEmpty()) 
	        {
	            System.out.println("Hasta için tedavi notu bulunamadı.");
	        }
	        return hastaNotlari;
	    }	
}
