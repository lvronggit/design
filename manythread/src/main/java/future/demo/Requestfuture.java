package future.demo;

public class Requestfuture {


    private Response response;

    private String reslut;

    private String id;

    public Response get(){
        synchronized (this){

            if(reslut == null){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        return response;
    }

    public void receive(String reslut,String id){
        this.reslut = reslut;
        this.id = id;
        response = new Response(reslut,id);

        synchronized (this){
            notify();
        }
    }

    public Requestfuture() {
    }

    public Requestfuture(Response response) {
        this.response = response;
    }
}
