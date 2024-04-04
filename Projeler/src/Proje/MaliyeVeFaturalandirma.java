package Proje;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaliyeVeFaturalandirma implements IMaliyeVeFaturalandirma {
	 private Map<Integer, Fatura> faturaListesi;
	    private Map<String, String> sigortaBilgileri;
	    private List<SigortaTalebi> sigortaTalepleri;

	    public MaliyeVeFaturalandirma() {
	        this.faturaListesi = new HashMap<>();
	        this.sigortaBilgileri = new HashMap<>();
	        this.sigortaTalepleri = new ArrayList<>();
	    }

	    @Override
	    public void faturaOlustur(String hastaAdi, double miktar) {
	        int faturaNo = faturaListesi.size() + 1;
	        Fatura fatura = new Fatura(faturaNo, hastaAdi, miktar);
	        faturaListesi.put(faturaNo, fatura);
	        System.out.println("Fatura oluşturuldu: " + fatura);
	    }

	    @Override
	    public void faturaIptalEt(int faturaNo) {
	        if (faturaListesi.containsKey(faturaNo)) {
	            faturaListesi.remove(faturaNo);
	            System.out.println("Fatura iptal edildi: Fatura No - " + faturaNo);
	        } else {
	            System.out.println("Geçersiz fatura numarası!");
	        }
	    }

	    @Override
	    public List<String> faturaGecmisiGoster(String hastaAdi) {
	        List<String> gecmisFaturalar = new ArrayList<>();
	        for (Fatura fatura : faturaListesi.values()) {
	            if (fatura.getHastaAdi().equals(hastaAdi)) {
	                gecmisFaturalar.add(fatura.toString());
	            }
	        }
	        return gecmisFaturalar;
	    }

	    @Override
	    public void odemeKaydet(int faturaNo, double odemeMiktari) {
	        if (faturaListesi.containsKey(faturaNo)) {
	            Fatura fatura = faturaListesi.get(faturaNo);
	            fatura.odemeEkle(odemeMiktari);
	            System.out.println("Ödeme kaydedildi: " + odemeMiktari + " TL - Fatura No " + faturaNo);
	        } else {
	            System.out.println("Geçersiz fatura numarası!");
	        }
	    }

	    @Override
	    public double kalanBorc(int faturaNo) {
	        if (faturaListesi.containsKey(faturaNo)) {
	            return faturaListesi.get(faturaNo).getKalanBorc();
	        } else {
	            System.out.println("Geçersiz fatura numarası!");
	            return -1;
	        }
	    }

	    @Override
	    public void sigortaBilgisiKaydet(String hastaAdi, String sigortaSirketi, String poliçeNo) {
	        sigortaBilgileri.put(hastaAdi, "Sigorta Şirketi: " + sigortaSirketi + ", Poliçe No: " + poliçeNo);
	        System.out.println("Sigorta bilgileri kaydedildi: " + hastaAdi);
	    }

	    @Override
	    public String sigortaBilgisiGetir(String hastaAdi) {
	        return sigortaBilgileri.getOrDefault(hastaAdi, "Sigorta bilgisi bulunamadı.");
	    }

	    @Override
	    public void sigortaTalebiOlustur(String hastaAdi, double talepMiktari) {
	        SigortaTalebi talep = new SigortaTalebi(hastaAdi, talepMiktari);
	        sigortaTalepleri.add(talep);
	        System.out.println("Sigorta talebi oluşturuldu: " + talep);
	    }
	}

