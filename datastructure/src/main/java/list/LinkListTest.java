package list;

public class LinkListTest {

    private Link link;


    public void insert(Link links){
        if(links == null) {
            throw new NullPointerException();
        }
        // 原来的对象
        links.next = link;
        link = links;
    }

    public Link getLink(){
        Link olink = link;
        link =link.next;
        return olink;
    }

    public void display(){
        if(link == null){
            return;
        }
        link.toString();

    }

    public static void main(String[] args) {
        LinkListTest linkListTest = new LinkListTest();
        linkListTest.insert(new Link(9.0,null));
        linkListTest.insert(new Link(8.0,null));
        System.out.println(linkListTest.toString());
        Link oo = linkListTest.getLink();
        System.out.println(oo);






    }

}
