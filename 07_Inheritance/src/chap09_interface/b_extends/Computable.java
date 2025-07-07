package chap09_interface.b_extends;

public interface Computable extends ElectronicProduct{
    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    int div(int a, int b);
    int mod(int a, int b);
}
