package Proje;

import java.util.List;

public interface IMaliyeVeFaturalandirma {
	    
	    // Hasta faturası oluşturma ve yönetme işlevleri
	    void faturaOlustur(String hastaAdi, double miktar);
	    void faturaIptalEt(int faturaNo);
	    List<String> faturaGecmisiGoster(String hastaAdi);
	    
	    // Ödeme işlevleri
	    void odemeKaydet(int faturaNo, double odemeMiktari);
	    double kalanBorc(int faturaNo);
	    
	    // Sigorta bilgilerini yönetme işlevleri
	    void sigortaBilgisiKaydet(String hastaAdi, String sigortaSirketi, String poliçeNo);
	    String sigortaBilgisiGetir(String hastaAdi);
	    
	    // Sigorta taleplerini yönetme işlevleri
	    void sigortaTalebiOlustur(String hastaAdi, double talepMiktari);
	    
	}

