package chap09_instance_array;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int x = Integer.parseInt("1");
        System.out.println(x + 1);

        double y = Double.parseDouble("1.5");
        System.out.println(y + 1);

        // 입력 대화상자
        String name = JOptionPane.showInputDialog("이름을 입력하세요.");
        System.out.println(name);
        int age = Integer.parseInt(JOptionPane.showInputDialog("나1이를 입력하세요."));
        System.out.println(age);
    }
}
