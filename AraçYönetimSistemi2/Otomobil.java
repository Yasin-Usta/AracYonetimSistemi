import java.awt.JobAttributes.DefaultSelectionType;
import java.util.ArrayList;
import java.util.List;

public class Otomobil extends Arac {
	private String ozellik;
	private static List<Otomobil> satilanOtomobiller = new ArrayList<>();

	public Otomobil(String marka, double fiyat, String ozellik) {
		super(marka, fiyat);
		this.ozellik = ozellik;
	}

	public String getOzellik() {
		return ozellik;
	}
	
	

	@Override
	public void aracSat() {
		
		toplamKazanc+=getFiyat();
		System.out.println(getMarka() + " markalı " + getOzellik() + " araç " + getFiyat() + " TL'ye satıldı.");
		satilanOtomobiller.add(this);
		this.setSatildiMi(true);
		satilanAracSayisi++;
		System.out.println("şuana kadar satılan araç sayısı: " + satilanAracSayisi);
		
	}
	
	
	

	public static void satilanAraclariListele() {
		int i=1;
		System.out.println("---Satılan Otomobiller---");
		for(Otomobil otomobil:satilanOtomobiller) {
			System.out.println(i + " " +otomobil.getMarka() + " markalı " + otomobil.getOzellik() + " otomobil " + otomobil.getFiyat() + " TL'ye satıldı.");
		++i;
		}
	}

	@Override
	public void fiyatGuncelle(double yeniFiyat) {
		if(isSatildiMi()) {
			System.out.println("HATA-araç satılmış olduğundan fiyat güncellemesi yapamazsınız.");
		}
		else {
			System.out.println("eski fiyat: " + getFiyat() + " TL. Yeni Fiyat: "+ yeniFiyat + " olarak güncellendi.");
			super.setFiyat(yeniFiyat);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
