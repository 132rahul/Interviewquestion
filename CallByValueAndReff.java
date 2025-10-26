class CallByValueAndReffaaaa {
    public static void main(String[] args) {
        int a = 5;
        changeValue(a);
        System.out.println("outSide Method : " + a);
        System.out.println();


        Myobject obj = new Myobject(10);
        changeValueObj(obj);
        System.out.println("outSide Method Obj : " + obj.value);
        System.out.println();

        Myobject obj2 = new Myobject(10);
        changeValueObj2(obj2);
        System.out.println("outSide Method Obj2 : " + obj2.value);
        System.out.println();


    }

    private static void changeValue(int a) {
        a = 100;
        System.out.println("Inside Method : " + a);
    }

    private static void changeValueObj(Myobject obj) {
        obj.value = 30;
        System.out.println("outSide Method Obj : " + obj.value);
    }

    private static void changeValueObj2(Myobject obj2) {
        obj2 = new Myobject(100);
        System.out.println("outSide Method Obj2 : " + obj2.value);
    }

    static class Myobject {
        int value;

        Myobject(int value) {
            this.value = value;
        }
    }
}
