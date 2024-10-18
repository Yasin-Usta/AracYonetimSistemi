import java.util.ArrayList;
import java.util.List;

public class Kamyon extends Arac {
	private int tekerSayisi;
	private static List<Kamyon> satilanKamyonlar=new ArrayList<>(); //kamyon satılınca bu listeye eklenecek
	
	public Kamyon(String marka, double fiyat, int tekerSayisi) {
		super(marka, fiyat);
		this.tekerSayisi = tekerSayisi;
	}

	public int getTekerSayisi() {
		return tekerSayisi;
	}

	@Override
	public void aracSat() {
		if(satildiMi) {
			System.out.println("HATA!" +getMarka() + "markalı motosiklet satılmış olduğundan tekrar satamazsınız");
		}
		else {
			toplamKazanc+=getFiyat();
			System.out.println(getMarka() + " markalı " + getTekerSayisi() + " tekerli Kamyon "  + getFiyat() + " TL'ye satıldı.");
			satilanKamyonlar.add(this);
			this.setSatildiMi(true);
			satilanAracSayisi++;
			System.out.println("şuana kadar satılan araç sayısı: " + satilanAracSayisi);	
		}
			
	}
	
	@Override
	public void fiyatGuncelle(double yeniFiyat) {
		if(isSatildiMi()) {
			System.out.println("HATA-araç satılmış olduğundan fiyat güncellemesi yapamazsınız.");
		}
		else {
			System.out.println("Kamyonetin eski fiyat: " + getFiyat() + " TL. Yeni Fiyat: "+ yeniFiyat + " olarak güncellendi.");
			super.setFiyat(yeniFiyat);
		}		
	}
	
	

	
	public static void satilanAraclariListele() {
		System.out.println("---Satılan Kamyonlar---");
		for(Kamyon kamyon:satilanKamyonlar) {
			System.out.println(kamyon.getMarka() + " markalı " + kamyon.getTekerSayisi()  +" tekerli Kamyon" + " " +kamyon.getFiyat() + " TL'ye satıldı.");
		}		
	}

	
	
	
	
	
	
	
}
