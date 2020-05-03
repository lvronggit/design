package list;

public class LinkList {

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
        LinkList linkList = new LinkList();
        linkList.insert(new Link(9.0,null));
        linkList.insert(new Link(8.0,null));
        System.out.println(linkList.toString());
        Link oo = linkList.getLink();
        System.out.println(oo);






    }

}
