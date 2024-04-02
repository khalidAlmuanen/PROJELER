package Proje;

import java.time.LocalDateTime;

public class Randevu {

	    private String ad;
	    private String soyad;
	    private String telefon;
	    private LocalDateTime tarih;

	    public Randevu(String ad, String soyad, String telefon, LocalDateTime tarih) {
	        this.ad = ad;
	        this.soyad = soyad;
	        this.telefon = telefon;
	        this.tarih = tarih;
	    }

	    public String getAd() {
	        return ad;
	    }

	    public void setAd(String ad) {
	        this.ad = ad;
	    }

	    public String getSoyad() {
	        return soyad;
	    }

	    public void setSoyad(String soyad) {
	        this.soyad = soyad;
	    }

	    public String getTelefon() {
	        return telefon;
	    }

	    public void setTelefon(String telefon) {
	        this.telefon = telefon;
	    }

	    public LocalDateTime getTarih() {
	        return tarih;
	    }

	    public void setTarih(LocalDateTime tarih) {
	        this.tarih = tarih;
	    }

	    public String toString() {
	        return ad + " " + soyad + ", Telefon: " + telefon + ", Tarih: " + tarih;
	    }
	}

