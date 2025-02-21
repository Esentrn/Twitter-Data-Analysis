package proje3;

import org.json.JSONArray;

public class Kullanıcı {

    private String kullaniciAdi;
    private String tamAd;
    private int takipciSayisi;
    private int takipEdilenSayisi;
    private String dil;
    private String bolge;
    private JSONArray tweetler;
    private KullaniciLinkedList<String> takipciler;
    private KullaniciLinkedList<String> takipEdilenler;

    public Kullanıcı(String kullaniciAdi, String tamAd, int takipciSayisi, int takipEdilenSayisi,
                     String dil, String bolge, JSONArray tweetler) {
        this.kullaniciAdi = kullaniciAdi;
        this.tamAd = tamAd;
        this.takipciSayisi = takipciSayisi;
        this.takipEdilenSayisi = takipEdilenSayisi;
        this.dil = dil;
        this.bolge = bolge;
        this.tweetler = tweetler;
        this.takipciler = new KullaniciLinkedList<>();
        this.takipEdilenler = new KullaniciLinkedList<>();
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getTamAd() {
        return tamAd;
    }

    public void setTamAd(String tamAd) {
        this.tamAd = tamAd;
    }

    public int getTakipciSayisi() {
        return takipciSayisi;
    }

    public void setTakipciSayisi(int takipciSayisi) {
        this.takipciSayisi = takipciSayisi;
    }

    public int getTakipEdilenSayisi() {
        return takipEdilenSayisi;
    }

    public void setTakipEdilenSayisi(int takipEdilenSayisi) {
        this.takipEdilenSayisi = takipEdilenSayisi;
    }

    public String getDil() {
        return dil;
    }

    public void setDil(String dil) {
        this.dil = dil;
    }

    public String getBolge() {
        return bolge;
    }

    public void setBolge(String bolge) {
        this.bolge = bolge;
    }

    public JSONArray getTweetler() {
        return tweetler;
    }

    public void setTweetler(JSONArray tweetler) {
        this.tweetler = tweetler;
    }

    public KullaniciLinkedList<String> getTakipciler() {
        return takipciler;
    }

    public KullaniciLinkedList<String> getTakipEdilenler() {
        return takipEdilenler;
    }

    public void addTakipci(String takipci) {
        takipciler.add(takipci);
    }

    public void addTakipEdilen(String takipEdilen) {
        takipEdilenler.add(takipEdilen);
}
}