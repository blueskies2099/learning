public interface  AbstructClass {

    static void me(){

    }
    default void v(){
        System.out.println("xxx");
    };
}


class S implements  AbstructClass{
    @Override
    public void v() {
        String
    }

    public static void main(String[] args) {
        new S().v();
    }
}

