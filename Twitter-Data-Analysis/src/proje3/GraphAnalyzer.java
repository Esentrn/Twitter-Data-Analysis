package proje3;

public class GraphAnalyzer {
    private KullaniciGrafi kullaniciGrafi;
    private Hash dilHash;
    private Hash bolgeHash;
    private Hash takipciHash;
    private Hash takipEdilenHash;

    public GraphAnalyzer(KullaniciGrafi kullaniciGrafi) {
        this.kullaniciGrafi = kullaniciGrafi;
        this.dilHash = new Hash();
        this.bolgeHash = new Hash();
        this.takipciHash = new Hash();
        this.takipEdilenHash = new Hash();
    }

    public void findAndStoreSimilarUsers(String kullaniciAdi) {
        KullaniciGrafi.KullaniciDugumu baslangicDugumu = kullaniciGrafi.getKullaniciDugumu(kullaniciAdi);

        if (baslangicDugumu != null) {
            Kuyruk<KullaniciGrafi.KullaniciDugumu> kuyruk = new Kuyruk<>();
            KullaniciLinkedList<String> visited = new KullaniciLinkedList<>();

            bfsTraversalForSimilarUsers(baslangicDugumu, visited, kuyruk);

        } else {
            System.out.println("Başlangıç düğümü bulunamadı.");
        }
    }

    private void bfsTraversalForSimilarUsers(KullaniciGrafi.KullaniciDugumu baslangicDugumu,KullaniciLinkedList<String> visited,Kuyruk<KullaniciGrafi.KullaniciDugumu> kuyruk) {
    
    kuyruk.ekle(baslangicDugumu);
    visited.add(baslangicDugumu.getKullanici().getKullaniciAdi());

    while (!kuyruk.isEmpty()) {
        KullaniciGrafi.KullaniciDugumu current = kuyruk.cikar();
        System.out.println("Ziyaret edilen kullanıcı: " + current.getKullanici().getKullaniciAdi());

        
        for (KullaniciGrafi.KullaniciDugumu komsuDugum : current.getTakipciler()) {
            processNeighbor(current, komsuDugum, visited, kuyruk);
        }

        for (KullaniciGrafi.KullaniciDugumu komsuDugum : current.getTakipEdilenler()) {
            processNeighbor(current, komsuDugum, visited, kuyruk);
        }
    }
}

private void processNeighbor(
        KullaniciGrafi.KullaniciDugumu current,
        KullaniciGrafi.KullaniciDugumu komsuDugum,
        KullaniciLinkedList<String> visited,
        Kuyruk<KullaniciGrafi.KullaniciDugumu> kuyruk
) {
    if (!visited.contains(komsuDugum.getKullanici().getKullaniciAdi())) {
        kuyruk.ekle(komsuDugum);
        visited.add(komsuDugum.getKullanici().getKullaniciAdi());

        // Dil kontrolü yaptığımız yer
        if (current.getKullanici().getDil().equals(komsuDugum.getKullanici().getDil())) {
            dilHash.put(komsuDugum.getKullanici());
        }
        // Bölge kontrolü yaptığımız yer
        if (current.getKullanici().getBolge().equals(komsuDugum.getKullanici().getBolge())) {
            bolgeHash.put(komsuDugum.getKullanici());
        }
        // Takipçi sayısı kontrolü yaptığımız yer
        if (current.getKullanici().getTakipciSayisi() == komsuDugum.getKullanici().getTakipciSayisi()) {
            takipciHash.put(komsuDugum.getKullanici());
        }
        // Takip edilen sayısı kontrolü yaptığımız yer
        if (current.getKullanici().getTakipEdilenSayisi() == komsuDugum.getKullanici().getTakipEdilenSayisi()) {
            takipEdilenHash.put(komsuDugum.getKullanici());
        }
        
    }
}



    public Hash getDilHash() {
        return dilHash;
    }

    public Hash getBolgeHash() {
        return bolgeHash;
    }

    public Hash getTakipciHash() {
        return takipciHash;
    }

    public Hash getTakipEdilenHash() {
        return takipEdilenHash;
    }

    public static void printHashTableContents(Hash hashTable) {
        KullaniciLinkedList[] tablo = hashTable.getTablo();

        for (int i = 0; i < tablo.length; i++) {
            System.out.print("Bucket " + i + ": ");
            KullaniciLinkedList bucket = tablo[i];
            printBucketContents(bucket);
        }
    }

    private static void printBucketContents(KullaniciLinkedList bucket) {
        for (int i = 0; i < bucket.size(); i++) {
            Kullanıcı kullanici = (Kullanıcı) bucket.get(i);
            System.out.print(kullanici.getKullaniciAdi() + " -> ");
        }
        System.out.println("null");
}
}