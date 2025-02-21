package proje3;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    private KullaniciGrafi kullaniciGrafi;
    private String kullaniciAdi;

    public GraphPanel(KullaniciGrafi kullaniciGrafi, String kullaniciAdi) {
        this.kullaniciGrafi = kullaniciGrafi;
        this.kullaniciAdi = kullaniciAdi;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Sadece belirli kullanıcı için grafı çizme kısmı
        KullaniciGrafi.KullaniciDugumu dugum = kullaniciGrafi.getKullaniciDugumu(kullaniciAdi);

        if (dugum != null) {
            
            
            int daireBoyut = 80; 
            int x = getWidth() / 2 - daireBoyut / 2;
            int y = getHeight() / 2 - daireBoyut / 2;
            
            int daireMerkeziX = x + daireBoyut / 2;
            int daireMerkeziY = y + daireBoyut / 2;

           
            int a=0,b=0;
            for (KullaniciGrafi.KullaniciDugumu takipci : dugum.getTakipciler()) { 
                drawLineToCenter(g, daireMerkeziX, daireMerkeziY, takipci,true);
                a++;
            }
            
            for (KullaniciGrafi.KullaniciDugumu takipEdilen : dugum.getTakipEdilenler()) {
                drawLineToCenter(g, daireMerkeziX, daireMerkeziY, takipEdilen,false);
                b++;
            }
            g.setColor(Color.BLACK);
            g.fillOval(x, y, daireBoyut, daireBoyut);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Kullanıcı: " + dugum.getKullanici().getKullaniciAdi(),x-700,y-00);
            g.setColor(Color.CYAN);
            g.setFont(new Font("Arial", Font.PLAIN, 14));
            g.drawString("Takipçi: " + a, x + 600, y + 20);
            g.setColor(Color.blue);
            g.drawString("Takip Edilen: " + b, x + 600, y + 40);
        }
    }

    private void drawLineToCenter(Graphics g, int centerX, int centerY, KullaniciGrafi.KullaniciDugumu node,boolean a) {
    int distance = 300; 

    int nodeX = getWidth() / 2 - 500 + (int) (Math.random() * 1000); 
    int nodeY = getHeight() / 2 - 350 + (int) (Math.random() * 700); 

    
    if(a==true){
        g.setColor(Color.BLACK);
        g.drawLine(centerX, centerY, nodeX, nodeY);
        g.setColor(Color.CYAN);
        g.fillOval(nodeX - 10, nodeY - 10, 20, 20);
        g.setColor(Color.BLACK);
        g.drawOval(nodeX - 10, nodeY - 10, 20, 20); 
    }
    
    if(a==false){
        g.setColor(Color.BLACK);
        g.drawLine(centerX, centerY, nodeX, nodeY);
        g.setColor(Color.blue);
        g.fillOval(nodeX - 10, nodeY - 10, 20, 20);
        g.setColor(Color.BLACK);
        g.drawOval(nodeX - 10, nodeY - 10, 20,20);
}
}
}