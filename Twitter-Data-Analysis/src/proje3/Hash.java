package proje3;

public class Hash {
    private static final int TABLO_BOYUTU = 100;
    private KullaniciLinkedList[] tablo;
    private ZiyaretEdilenSet ziyaretEdilen;

    public Hash() {
        tablo = new KullaniciLinkedList[TABLO_BOYUTU];
        for (int i = 0; i < TABLO_BOYUTU; i++) {
            tablo[i] = new KullaniciLinkedList();
            ziyaretEdilen = new ZiyaretEdilenSet();
        }
    }

    public void put(Kullanıcı kullanici) {
        int key = KeyOlustur(kullanici.getKullaniciAdi());
        int index = key % TABLO_BOYUTU;
        tablo[index].add(kullanici);

        // Takipçi bilgilerini eklediğimiz kısım
        for (String takipci : kullanici.getTakipciler()) {
            Kullanıcı takipciKullanici = get(takipci);
            if (takipciKullanici != null) {
                takipciKullanici.addTakipEdilen(kullanici.getKullaniciAdi());
            }
        }

        // Takip edilen bilgilerini eklediğimiz kısım
        for (String takipEdilen : kullanici.getTakipEdilenler()) {
            Kullanıcı takipEdilenKullanici = get(takipEdilen);
            if (takipEdilenKullanici != null) {
                takipEdilenKullanici.addTakipci(kullanici.getKullaniciAdi());
            }
        }
    }

    public Kullanıcı get(String kullaniciAdi) {
        int key = KeyOlustur(kullaniciAdi);
        int index = key % TABLO_BOYUTU;
        KullaniciLinkedList altliste = tablo[index];

        for (int i = 0; i < altliste.size(); i++) {
            Kullanıcı kullanici = (Kullanıcı) altliste.get(i);
            if (kullanici.getKullaniciAdi().equals(kullaniciAdi)) {
                return kullanici;
            }
        }

        return null;
    }
    
    public Kullanıcı get1(Kullanıcı kullanıcı)
    {
        
        return kullanıcı;
    }

    private int KeyOlustur(String str) {
    if (str == null) {
        return 0;  
    }

    int key = 0;
    for (int i = 0; i < str.length(); i++) {
        key += (int) str.charAt(i);
    }
    return key;
}
    boolean contains(Kullanıcı kullanici, Hash hashTable) {
    KullaniciLinkedList[] table = hashTable.getTablo();

    for (int i = 0; i < table.length; i++) {
        KullaniciLinkedList bucket = table[i];

        for (int j = 0; j < bucket.size(); j++) {
            Kullanıcı existingUser = (Kullanıcı) bucket.get(j);
            if (existingUser.equals(kullanici)) {
                return true;
            }
        }
    }
    return false;
}

   

    public KullaniciLinkedList[] getTablo() {
        return tablo;
}
    //BFS KISMI 
    public void bfs(Kullanıcı startNode) {
        Kuyruk<Kullanıcı> kuyruk = new Kuyruk<>();

        kuyruk.ekle(startNode);
        ziyaretEdilen.add(startNode.getKullaniciAdi());

        while (!kuyruk.isEmpty()) {
            Kullanıcı current = kuyruk.cikar();
            System.out.println(current);

            KullaniciLinkedList<String> takipciler = current.getTakipciler();

            for (String takipci : takipciler) {
                if (!ziyaretEdilen.contains(takipci)) {
                    Kullanıcı takipciKullanici = get(takipci);
                    if (takipciKullanici != null) {
                        kuyruk.ekle(takipciKullanici);
                        ziyaretEdilen.add(takipci);
                    }
                }
            }
        }
    }


}

class ZiyaretEdilenSet {
    private KullaniciLinkedList<String> ziyaretEdilenListe;

    public ZiyaretEdilenSet() {
        ziyaretEdilenListe = new KullaniciLinkedList<>();
    }

    public boolean contains(String kullaniciAdi) {
        for (String ziyaretEdilen : ziyaretEdilenListe) {
            if (ziyaretEdilen.equals(kullaniciAdi)) {
                return true;
            }
        }
        return false;
    }

    public void add(String kullaniciAdi) {
        if (!contains(kullaniciAdi)) {
            ziyaretEdilenListe.add(kullaniciAdi);
 }
}
    
    
   
}