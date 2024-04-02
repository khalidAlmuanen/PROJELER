package Proje;

import java.time.LocalDateTime;

public  class TedaviPlanlamaVeKayıt implements IRandevuYonetimi {

	
	
	private int randevuId;

	@Override
	   public boolean find(int randevuId) {
			return this.randevuId == randevuId;
}

	@Override
	public void randevuAl(String hastaAdi, String hastaSoyadi, LocalDateTime randevuTarihi, String doktorAdi,
			int randevuId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void randevuIptalEt(int randevuId) {
		// TODO Auto-generated method stub
		
	}
