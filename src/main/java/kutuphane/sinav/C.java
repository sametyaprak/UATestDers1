package kutuphane.sinav;

class C extends B {

    public static void main(String[] args) {

        C c = new C();
        B b = new C();

        A a = new C();

        B t = (B) a;
        C s = (C) b;

        B yeni = c;
        A yeni2 = b;




    }
    @Override
    public void odevYap() {
    }

    @Override
    void tezBitir() {
    }
}
