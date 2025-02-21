
package proje3;


public class Graph {
    private KullaniciLinkedList<Node> nodes;

    public Graph(Hash kullaniciHashTablosu) {
        this.nodes = new KullaniciLinkedList<>();
        for (KullaniciLinkedList<Kullanıcı> altliste : kullaniciHashTablosu.getTablo()) {
            for (int i = 0; i < altliste.size(); i++) {
                Kullanıcı kullanici = altliste.get(i);
                addUserNode(kullanici);
            
                for (String takipci : kullanici.getTakipciler()) {
                    addEdge(kullanici.getKullaniciAdi(), takipci);
                }

                for (String takipEdilen : kullanici.getTakipEdilenler()) {
                    addEdge(kullanici.getKullaniciAdi(), takipEdilen);
                }
            
            
        }

       }
        
}

    public void addUserNode(Kullanıcı user) {
        Node node = new Node(user);
        nodes.add(node);
    }

    private Node findNodeByUsername(String username) {
    for (Node node : nodes) {
        if (node.getUser().getKullaniciAdi().equals(username)) {
            return node;
        }
    }
    System.out.println("HATA: Kullanıcı bulunamadı: " + username);
    return null;
}

public void addEdge(String follower, String following) {
    Node followerNode = findNodeByUsername(follower);
    Node followingNode = findNodeByUsername(following);

    if (followerNode != null && followingNode != null) {
        followerNode.addFollowing(followingNode);
        followingNode.addFollower(followerNode);
    } else {
        System.out.println("HATA: Kullanıcı bulunamadı: " + follower + " veya " + following);
    }
}

    public void printGraph() {
    for (Node node : nodes) {
        System.out.println("Kullanıcı Adı: " + node.getUser().getKullaniciAdi());

        System.out.print("Takipçiler: ");
        for (Node follower : node.getFollowers()) {
            if (follower != null && follower.getUser() != null) {
                System.out.print(follower.getUser().getKullaniciAdi() + " ");
            }
        }
        System.out.println();

        System.out.print("Takip Edilenler: ");
        for (Node following : node.getFollowing()) {
            if (following != null && following.getUser() != null) {
                System.out.print(following.getUser().getKullaniciAdi() + " ");
            }
        }
        System.out.println("\n-----------");
    }
}

    private class Node {
        private Kullanıcı user;
        private KullaniciLinkedList<Node> followers;
        private KullaniciLinkedList<Node> following;

        public Node(Kullanıcı user) {
    if (user == null) {
        throw new IllegalArgumentException("Kullanıcı nesnesi null olamaz.");
    }
    this.user = user;
    this.followers = new KullaniciLinkedList<>();
    this.following = new KullaniciLinkedList<>();
}

        public Kullanıcı getUser() {
            return user;
        }

        public void addFollower(Node follower) {
            followers.add(follower);
        }

        public void addFollowing(Node followingNode) {
            following.add(followingNode);
        }

        public KullaniciLinkedList<Node> getFollowers() {
            return followers;
        }

        public KullaniciLinkedList<Node> getFollowing() {
            return following;
 }
}
}