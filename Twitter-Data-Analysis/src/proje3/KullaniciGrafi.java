package proje3;


public class KullaniciGrafi {
    private Hash2<String, KullaniciDugumu> kullaniciDugumleri;

    public KullaniciGrafi(Hash kullaniciHashTablosu) {
        kullaniciDugumleri = new Hash2<>();

        // Hash tablosundaki her kullanıcı için grafa ekleme yap
        for (KullaniciLinkedList<Kullanıcı> altliste : kullaniciHashTablosu.getTablo()) {
            for (int i = 0; i < altliste.size(); i++) {
                Kullanıcı kullanici = altliste.get(i);
                dugumEkle(kullanici);
                kenarEkle(kullanici);
            }
        }
    }
    
    public Hash2<String, KullaniciDugumu> getKullaniciDugumleri() {
        return kullaniciDugumleri;
    }
    
    public KullaniciDugumu getKullaniciDugumu(String kullaniciAdi) {
        return kullaniciDugumleri.get(kullaniciAdi);
    }

    public void dugumEkle(Kullanıcı kullanici) {
        if (!kullaniciDugumleri.containsKey(kullanici.getKullaniciAdi())) {
            KullaniciDugumu dugum = new KullaniciDugumu(kullanici);
            kullaniciDugumleri.put(kullanici.getKullaniciAdi(), dugum);
        }
    }
    
    
    
    public void kenarEkle(Kullanıcı kullanici){
        // Takipçi ve takip edilen listelerini güncelle
        for (String takipci : kullanici.getTakipciler()) {
            KullaniciDugumu takipciDugumu = kullaniciDugumleri.get(takipci);
            if (takipciDugumu != null) {
                kullaniciDugumleri.get(kullanici.getKullaniciAdi()).takipEt(takipciDugumu);
            }
        }

        for (String takipEdilen : kullanici.getTakipEdilenler()) {
            KullaniciDugumu takipEdilenDugumu = kullaniciDugumleri.get(takipEdilen);
            if (takipEdilenDugumu != null) {
                takipEdilenDugumu.takipEt(kullaniciDugumleri.get(kullanici.getKullaniciAdi()));
            }
        }
    }

    public void takipEt(String takipciAdi, String takipEdilenAdi) {
        if (kullaniciDugumleri.containsKey(takipciAdi) && kullaniciDugumleri.containsKey(takipEdilenAdi)) {
            KullaniciDugumu takipci = kullaniciDugumleri.get(takipciAdi);
            KullaniciDugumu takipEdilen = kullaniciDugumleri.get(takipEdilenAdi);
            takipci.takipEt(takipEdilen);
        }
    }
    
    public void kullaniciGrafiYazdir(String kullaniciAdi) {
        KullaniciDugumu dugum = kullaniciDugumleri.get(kullaniciAdi);
        if (dugum != null) {
            System.out.println("Kullanıcı: " + dugum.getKullanici().getKullaniciAdi());
            System.out.print("Takipçiler: ");
            yazdirListe(dugum.getTakipciler());
            System.out.println("");
            System.out.print("Takip Edilenler: ");
            yazdirListe(dugum.getTakipEdilenler());
        } else {
            System.out.println("Kullanıcı bulunamadı.");
        }
    }
    
    public void grafiYazdir() {
    for (Hash2.Entry<String, KullaniciDugumu> entry : kullaniciDugumleri.entrySet()) {
        KullaniciDugumu dugum = entry.getValue();
        System.out.println("Kullanıcı: " + dugum.getKullanici().getKullaniciAdi());
        System.out.println("Takipçi Sayısı: " + dugum.getKullanici().getTakipciSayisi());
        System.out.println("Bölge: " + dugum.getKullanici().getBolge());
        System.out.println("Dil: " + dugum.getKullanici().getDil());
        System.out.print("Takipçiler: ");
        yazdirListe(dugum.getTakipciler());
        System.out.println("");
        System.out.print("Takip Edilenler: ");
        yazdirListe(dugum.getTakipEdilenler());
        System.out.println("-------------------------------------------------------");
    }
}
    int c=0;
    private void yazdirListe(KullaniciLinkedList<KullaniciDugumu> liste) {
        System.out.print("[");
        for (KullaniciDugumu dugum : liste) {
            Kullanıcı kullanici = dugum.getKullanici();
            System.out.print(kullanici.getKullaniciAdi() + ", ");
            c++;
        }
        System.out.println("]");
        //System.out.println(c);
    }

    

    public class KullaniciDugumu {
        private Kullanıcı kullanici;
        private KullaniciLinkedList<KullaniciDugumu> takipciler;
        private KullaniciLinkedList<KullaniciDugumu> takipEdilenler;
        

        public KullaniciDugumu(Kullanıcı kullanici) {
            this.kullanici = kullanici;
            this.takipciler = new KullaniciLinkedList<>();
            this.takipEdilenler = new KullaniciLinkedList<>();
            
        }

        public Kullanıcı getKullanici() {
            return kullanici;
        }

        public KullaniciLinkedList<KullaniciDugumu> getTakipciler() {
            return takipciler;
        }
        
    
        public KullaniciLinkedList<KullaniciDugumu> getTakipEdilenler() {
            return takipEdilenler;
        }

        public void takipEt(KullaniciDugumu takipEdilen) {
            this.takipciler.add(takipEdilen);
            takipEdilen.takipEdilenler.add(this);
        }
        
       
}


}