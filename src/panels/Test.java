package panels;

/**
 * Created by Win7uX32 on 2015/8/4.
 */
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends JFrame {
    //同步变量
    public static Boolean continueThread = false;

    public Test() {
        Container container = getContentPane();
        JButton btn = new JButton("主线程继续");

        //按钮要添加监听，来控制共享数据continueThread
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                continueThread = !continueThread;
            }
        });
        container.add(btn);
    }

    public static void main(String[] args) {
        start();
    }
    public static void start(){
        Test frame = new Test();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        frame.setVisible(true);

        System.out.println("1");

// 这里时要求的代码，要求主线程在这里悬停，直到我按下“主线程继续”按钮，然后才输出“2”
        synchronized (continueThread) {
            //如果继续线程为false，则执行循环
            while (continueThread == false) {
            }
        }
        System.out.println("2");
    }
}
